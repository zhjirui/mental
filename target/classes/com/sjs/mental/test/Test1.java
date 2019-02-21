package com.sjs.mental.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sjs.mental.common.util.BeanUtil;
import com.sjs.mental.dto.UserDto;
import com.sjs.mental.mapper.MenuMapper;
import com.sjs.mental.mapper.UserMapper;
import com.sjs.mental.model.Menu;
import com.sjs.mental.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class Test1 {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test2() throws Exception{
        List<UserDto> list = userMapper.list(new HashMap<>());
        System.out.println(1);
    }

    @Test
    public void test1() throws Exception{
        List<Menu> menuList = menuMapper.selectByExample(new Example(Menu.class) {{setOrderByClause("rank asc");}});
        List<Map<String,Object>> list= getChildren("0",menuList);
        System.out.println(1);
    }

    private List<Map<String,Object>> getChildren(String parentId, List<Menu> menuList){
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
