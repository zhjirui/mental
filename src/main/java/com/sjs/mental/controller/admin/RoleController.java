package com.sjs.mental.controller.admin;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.PageBeanDataTables;
import com.sjs.mental.common.util.RequestUtil;
import com.sjs.mental.model.Menu;
import com.sjs.mental.model.Role;
import com.sjs.mental.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("admin/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @RequestMapping(value ="index",method = RequestMethod.GET)
    public String index(){
        return "/admin/role/index.jsp";
    }

    @RequestMapping(value ="toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "/admin/role/toAdd.jsp";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(HttpServletRequest request){
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            return roleService.add(input);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("id") String id){
        try{
            return roleService.delete(id);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value = "/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") String id,ModelMap modelMap){
        try{
            Role role = roleService.findById(id);
            modelMap.put("role",role);
            return "/admin/role/toUpdate.jsp";
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return "redirect:/admin/index/error";
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> update(HttpServletRequest request){
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            return roleService.update(input);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ResponseBody
    public PageBeanDataTables findAll() {
        try{
            List<Role> data = roleService.findAll();
            return new PageBeanDataTables(data,(long)data.size());
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new PageBeanDataTables();
        }
    }

    @RequestMapping(value ="toRoleMenus/{id}",method = RequestMethod.GET)
    public String toRoleMenus(@PathVariable("id") String id,ModelMap modelMap){
        Role role = roleService.findById(id);
        modelMap.put("role",role);
        return "/admin/role/toRoleMenus.jsp";
    }

    @RequestMapping(value = "getRoleMenus/{id}")
    @ResponseBody
    public List<Map<String,Object>> getRoleMenus(@PathVariable("id") String id){
        try{
            return roleService.getRoleMenus(id);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "saveRoleMenus",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveRoleMenus(@RequestBody Map<String,Object> input){
        try{
            return roleService.saveRoleMenus(input);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

}
