package com.sjs.mental.mapper;

import com.sjs.mental.common.BaseCommonMapper;
import com.sjs.mental.dto.UserDto;
import com.sjs.mental.model.Menu;
import com.sjs.mental.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface UserMapper extends BaseCommonMapper<User>{

    User findByUsername(@Param("username") String username);

    List<UserDto> list(Map<String,String> input);

    List<Menu> listUserMenus(String id);

}
