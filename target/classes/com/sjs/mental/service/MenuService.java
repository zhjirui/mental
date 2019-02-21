package com.sjs.mental.service;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.util.IDUtil;
import com.sjs.mental.common.util.ValidationUtil;
import com.sjs.mental.mapper.MenuMapper;
import com.sjs.mental.model.Menu;
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
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public Menu save(Map<String,String> input) throws Exception{
        Menu menu = null;
        try{
            if(ValidationUtil.isEmptyOrNull(input.get("id"))){
                menu = new Menu();
                menu.setId(IDUtil.id());
                menu.setParentId(input.get("parentId"));
                menu.setName(input.get("name"));
                menu.setIcon(input.get("icon"));
                menu.setUrl(input.get("url"));
                menu.setRank(  Double.valueOf(input.get("rank")));
                menu.setStatus(input.get("status"));
                menuMapper.insert(menu);
            }else{
                menu = menuMapper.selectByPrimaryKey(input.get("id"));
                menu.setParentId(input.get("parentId"));
                menu.setName(input.get("name"));
                menu.setIcon(input.get("icon"));
                menu.setUrl(input.get("url"));
                menu.setRank(  Double.valueOf(input.get("rank")));
                menu.setStatus(input.get("status"));
                menuMapper.updateByPrimaryKey(menu);
            }
            return menu;
        }catch (Exception e){
            throw e;
        }
    }

    public Map<String, Object> delete(String id) throws Exception{
        try{
            Example example =new Example(Menu.class);
            example.createCriteria().andEqualTo("parentId",id);
            List<Menu> children = menuMapper.selectByExample(example);
            if(children!=null && !children.isEmpty()){
                return GlobalConst.failMap("请先删除子菜单!");
            }
            menuMapper.deleteByPrimaryKey(id);
            return GlobalConst.successMap();
        }catch (Exception e){
            throw e;
        }
    }

    public Menu findById(String id) throws Exception{
        try{
            Menu menu = menuMapper.selectByPrimaryKey(id);
            return menu;
        }catch (Exception e){
            throw e;
        }
    }

    public List<Map<String,Object>> getTree(){
        List<Map<String,Object>> result = new ArrayList<>();
        Map<String, Object> root = new HashMap<String,Object>();
        root.put("id","0");
        root.put("name","菜单");
        root.put("open","true");
        result.add(root);
        Example example = new Example(Menu.class);
        example.setOrderByClause("rank asc");
        List<Menu> menuList = menuMapper.selectByExample(example);
        for(Menu menu : menuList){
            Map<String,Object> item = new HashMap<>();
            item.put("id",menu.getId());
            item.put("pId",menu.getParentId());
            item.put("name",menu.getName());
            result.add(item);
        }
        return result;
    }

}
