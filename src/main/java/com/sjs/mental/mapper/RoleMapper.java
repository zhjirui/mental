package com.sjs.mental.mapper;

import com.sjs.mental.common.BaseCommonMapper;
import com.sjs.mental.model.Menu;
import com.sjs.mental.model.Role;

import java.util.List;

/**
 *
 */
public interface RoleMapper extends BaseCommonMapper<Role>{

    List<Menu> getRoleMenus(String id);

}
