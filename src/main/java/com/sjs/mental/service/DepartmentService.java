package com.sjs.mental.service;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.util.IDUtil;
import com.sjs.mental.common.util.ValidationUtil;
import com.sjs.mental.mapper.DepartmentMapper;
import com.sjs.mental.mapper.UserMapper;
import com.sjs.mental.model.Department;
import com.sjs.mental.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;

    public Department save(Map<String,String> input) throws Exception{
        Department department = null;
        try{
            if(ValidationUtil.isEmptyOrNull(input.get("id"))){
                department = new Department();
                department.setId(IDUtil.id());
                department.setParentId(input.get("parentId"));
                department.setName(input.get("name"));
                department.setCode(input.get("code"));
                department.setRemark(input.get("remark"));
                departmentMapper.insert(department);
            }else{
                department = departmentMapper.selectByPrimaryKey(input.get("id"));
                department.setName(input.get("name"));
                department.setCode(input.get("code"));
                department.setRemark(input.get("remark"));
                departmentMapper.updateByPrimaryKey(department);
            }
            return department;
        }catch (Exception e){
            throw e;
        }
    }

    public Map<String, Object> delete(String id) throws Exception{
        try{
            Department  department = departmentMapper.selectByPrimaryKey(id);
            if(department ==null){
                return GlobalConst.failMap("部门不存在!");
            }
            //判断子部门
            Example example =new Example(Department.class);
            example.createCriteria().andEqualTo("parentId",department.getId());
            List<Department> children = departmentMapper.selectByExample(example);
            if(children!=null && !children.isEmpty()){
                return GlobalConst.failMap("请先删除子部门!");
            }
            //判断部门下的人员
            Example example2 =new Example(User.class);
            example2.createCriteria().andEqualTo("departmentId",department.getId());
            List<User> userList = userMapper.selectByExample(example2);
            if(userList!=null && !userList.isEmpty()){
                return GlobalConst.failMap("部门下存在人员");
            }
            departmentMapper.deleteByPrimaryKey(id);
            return GlobalConst.successMap();
        }catch (Exception e){
            throw e;
        }
    }

    public Department findById(String id) throws Exception{
        try{
            Department department = departmentMapper.selectByPrimaryKey(id);
            return department;
        }catch (Exception e){
            throw e;
        }
    }

    public List<Map<String,Object>> getTree(){
        List<Map<String,Object>> result = new ArrayList<>();
        Map<String, Object> root = new HashMap<String,Object>();
        root.put("id","0");
        root.put("name","部门");
        root.put("open","true");
        result.add(root);
        Example example = new Example(Department.class);
        example.setOrderByClause("code asc");
        List<Department> departmentList = departmentMapper.selectByExample(example);
        for(Department department : departmentList){
            Map<String,Object> item = new HashMap<>();
            item.put("id",department.getId());
            item.put("pId",department.getParentId());
            item.put("name",department.getName());
            result.add(item);
        }
        return result;
    }

}
