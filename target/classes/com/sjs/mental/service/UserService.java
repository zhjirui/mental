package com.sjs.mental.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.PageBeanDataTables;
import com.sjs.mental.common.util.BeanUtil;
import com.sjs.mental.common.util.IDUtil;
import com.sjs.mental.common.util.SecurityUtil;
import com.sjs.mental.common.util.ValidationUtil;
import com.sjs.mental.dto.UserDto;
import com.sjs.mental.mapper.MenuMapper;
import com.sjs.mental.mapper.UserMapper;
import com.sjs.mental.model.Menu;
import com.sjs.mental.model.User;
import org.springframework.beans.BeanUtils;
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
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public Map<String,Object> auth(Map<String,String> input) throws Exception{
        try{
            String username = input.get("username");
            String password = input.get("password");
            if(ValidationUtil.isEmptyOrNull(username) || ValidationUtil.isEmptyOrNull(password)){
                return GlobalConst.failMap("用户名或密码不能为空");
            }
            User user = userMapper.findByUsername(username);
            if(user == null){
                return GlobalConst.failMap("用户名或密码错误");
            }
            if(!SecurityUtil.verifyMD5Salt(password,user.getPassword())){
                return GlobalConst.failMap("用户名或密码错误");
            }
            if(!"Y".equals(user.getStatus())){
                return GlobalConst.failMap("用户被禁用");
            }
            return GlobalConst.successMap(user);
        }catch (Exception e){
            throw e;
        }
    }

    public Map<String,Object> add(Map<String,String> input) throws Exception{
        try{
            String departmentId = input.get("departmentId");
            String roleId = input.get("roleId");
            String username = input.get("username");
            String password = input.get("password");
            String confirmPassword = input.get("confirmPassword");
            String name = input.get("name");
            String phone = input.get("phone");
            String birthday = input.get("birthday");
            String gender = input.get("gender");
            if(ValidationUtil.isEmptyOrNull(departmentId)
                    ||ValidationUtil.isEmptyOrNull(roleId)
                    ||ValidationUtil.isEmptyOrNull(username)
                    ||ValidationUtil.isEmptyOrNull(password)
                    ||ValidationUtil.isEmptyOrNull(name)
                    ){
                return GlobalConst.failMap("部门,角色,用户名,密码,姓名不能为空");
            }
            if(!password.equals(confirmPassword)){
                return GlobalConst.failMap("二次密码不一致");
            }
            if(userMapper.findByUsername(username)!=null){
                return GlobalConst.failMap("用户名已存在");
            }
            User user = new User();
            user.setId(IDUtil.id());
            user.setDepartmentId(departmentId);
            user.setRoleId(roleId);
            user.setUsername(username);
            user.setPassword(SecurityUtil.encAsMD5Salt(password));
            user.setName(name);
            user.setPhone(phone);
            user.setBirthday(birthday);
            user.setGender(gender);
            userMapper.insert(user);
            return GlobalConst.successMap(user);
        }catch (Exception e){
            throw e;
        }
    }

    public Map<String,Object> update(Map<String,String> input) throws Exception{
        try{
            String id = input.get("id");
            String departmentId = input.get("departmentId");
            String roleId = input.get("roleId");
            String username = input.get("username");
            String name = input.get("name");
            String phone = input.get("phone");
            String birthday = input.get("birthday");
            String gender = input.get("gender");
            String status = input.get("status");
            if(ValidationUtil.isEmptyOrNull(id)
                    ||ValidationUtil.isEmptyOrNull(departmentId)
                    ||ValidationUtil.isEmptyOrNull(roleId)
                    ||ValidationUtil.isEmptyOrNull(username)
                    ||ValidationUtil.isEmptyOrNull(name)
                    ||ValidationUtil.isEmptyOrNull(status)
                    ){
                return GlobalConst.failMap("ID,部门,角色,用户名,姓名,状态不能为空");
            }
            User user = userMapper.selectByPrimaryKey(id);
            if(!user.getUsername().equals(username)){
                User exist = userMapper.findByUsername(username);
                if(exist !=null){
                    return GlobalConst.failMap("用户名已存在");
                }
            }
            user.setDepartmentId(departmentId);
            user.setRoleId(roleId);
            user.setUsername(username);
            user.setName(name);
            user.setPhone(phone);
            user.setBirthday(birthday);
            user.setGender(gender);
            user.setStatus(status);
            userMapper.updateByPrimaryKey(user);
            return GlobalConst.successMap();
        }catch (Exception e){
            throw e;
        }
    }

    public Map<String,Object> resetPassword(String id) throws Exception{
        try{
            User user = userMapper.selectByPrimaryKey(id);
            String newPassword = String.valueOf(System.currentTimeMillis());
            user.setPassword(SecurityUtil.encAsMD5Salt(newPassword));
            userMapper.updateByPrimaryKey(user);
            return GlobalConst.successMap(newPassword);
        }catch (Exception e){
            throw e;
        }
    }

    public PageBeanDataTables page(Map<String,String> input){
        Integer start = Integer.parseInt(input.get("start"));
        Integer length = Integer.valueOf(input.get("length"));
        Integer pageNum = start/length + 1;
        Page page = PageHelper.startPage(pageNum,length);
        List userDtoList = userMapper.list(input);
        return new PageBeanDataTables(userDtoList,page.getTotal());
    }

    public UserDto findUserDtoById(String id){
        Map<String, String > input = new HashMap<String, String>(){{put("id",id);}};
        List<UserDto> userDtoList = userMapper.list(input);
        return userDtoList.get(0);
    }

    public Map<String,Object> listUserMenus(String id) throws Exception{
        try{
            User user = userMapper.selectByPrimaryKey(id);
            if("1".equals(user.getRoleId())){
                List<Menu> menuList = menuMapper.selectByExample(new Example(Menu.class) {{setOrderByClause("rank asc");}});
                return GlobalConst.successMap(getChildren("0",menuList));
            }else {
                List<Menu> menuList = userMapper.listUserMenus(id);
                return GlobalConst.successMap(getChildren("0",menuList));
            }
        }catch (Exception e){
            throw e;
        }
    }

    private List<Map<String,Object>> getChildren(String parentId,List<Menu> menuList){
        List<Map<String,Object>> result = new ArrayList<>();
        for(Menu menu : menuList){
            if(parentId.equals(menu.getParentId())){
                Map<String,Object> item = BeanUtil.bean2Map(menu);
                item.put("children",getChildren(menu.getId(),menuList));
                result.add(item);
            }
        }
        return result;
    }


}
