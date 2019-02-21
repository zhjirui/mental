package com.sjs.mental.service;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.util.IDUtil;
import com.sjs.mental.common.util.ValidationUtil;
import com.sjs.mental.mapper.RoleMapper;
import com.sjs.mental.mapper.RoleMenuMapper;
import com.sjs.mental.model.Menu;
import com.sjs.mental.model.Role;
import com.sjs.mental.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public Map<String,Object> add(Map<String,String> input) throws Exception{
        try{
            String name = input.get("name");
            String code = input.get("code");
            if(ValidationUtil.isEmptyOrNull(name)|| ValidationUtil.isEmptyOrNull(code)){
                return GlobalConst.failMap("id,name,code can not be empty");
            }
            Role role = new Role();
            role.setId(IDUtil.id());
            role.setName(name);
            role.setCode(code);
            roleMapper.insert(role);
            return GlobalConst.successMap(role);
        }catch (Exception e){
            throw e;
        }
    }

    public Map<String,Object> delete(String id) throws Exception{
        try{
            if("1".equals(id)){
                return GlobalConst.failMap("管理员角色不允许被删除");
            }
            Role role = roleMapper.selectByPrimaryKey(id);
            if(role == null){
                return GlobalConst.failMap("role not found");
            }
            roleMapper.delete(role);
            return GlobalConst.successMap();
        }catch (Exception e){
            throw e;
        }
    }

    public Map<String, Object> update(Map<String,String> input){
        try{
            String id = input.get("id");
            String name = input.get("name");
            String code = input.get("code");
            if(ValidationUtil.isEmptyOrNull(id)
                    ||ValidationUtil.isEmptyOrNull(name)
                    || ValidationUtil.isEmptyOrNull(code)){
                return GlobalConst.failMap("id,name,code can not be empty");
            }
            if("1".equals(id)){
                return GlobalConst.failMap("管理员角色不允许被修改");
            }
            Role role = roleMapper.selectByPrimaryKey(id);
            if(role == null){
                return GlobalConst.failMap("role not found");
            }
            role.setName(name);
            role.setCode(code);
            roleMapper.updateByPrimaryKey(role);
            return GlobalConst.successMap();
        }catch (Exception e){
            throw e;
        }
    }

    public Role findById(String id){
        return roleMapper.selectByPrimaryKey(id);
    }

    public List<Role> findAll(){
        Example example = new Example(Role.class);
        example.setOrderByClause("code asc");
        List<Role> roleList = roleMapper.selectByExample(example);
        return roleList;
    }

    public List<Map<String,Object>> getRoleMenus(String id){
        List<Map<String,Object>> menuTree = menuService.getTree();
        List<Menu> roleMenuList = roleMapper.getRoleMenus(id);
        for(Map<String,Object> item :menuTree){
            String menuId = (String) item.get("id");
            for(Menu menu:roleMenuList){
                if(menu.getId().equals(menuId)){
                    item.put("checked","true");
                    break;
                }
            }
        }
        return menuTree;
    }

    @Transactional
    public Map<String,Object> saveRoleMenus(Map<String,Object> input) throws Exception{
        try{
            String roleId = (String) input.get("roleId");
            List<String> menuIds = (List)input.get("menuIds");
            if("1".equals(roleId)){
                return GlobalConst.failMap("管理员有所有菜单权限");
            }
            //删除旧的菜单
            Example example = new Example(RoleMenu.class);
            example.createCriteria().andEqualTo("roleId",roleId);
            roleMenuMapper.deleteByExample(example);
            //增加新的菜单
            for(String menuId : menuIds){
                if(!"0".equals(menuId)){
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setId(IDUtil.id());
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(menuId);
                    roleMenuMapper.insert(roleMenu);
                }
            }
            return GlobalConst.successMap();
        }catch (Exception e){
            throw e;
        }
    }

}
