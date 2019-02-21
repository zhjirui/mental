package com.sjs.mental.controller.admin;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.PageBeanDataTables;
import com.sjs.mental.common.util.RequestUtil;
import com.sjs.mental.model.User;
import com.sjs.mental.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("admin/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value ="index",method = RequestMethod.GET)
    public String index(){
        return "/admin/user/index.jsp";
    }

    @RequestMapping(value ="toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "/admin/user/toAdd.jsp";
    }

    @RequestMapping(value ="toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") String id, ModelMap modelMap){
        User user = userService.findUserDtoById(id);
        modelMap.put("user",user);
        return "/admin/user/toUpdate.jsp";
    }

    @RequestMapping(value ="add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(HttpServletRequest request){
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            return userService.add(input);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value ="update",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> update(HttpServletRequest request){
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            return userService.update(input);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value ="resetPassword/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> resetPassword(@PathVariable("id") String id){
        try{
            return userService.resetPassword(id);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value ="page",method = RequestMethod.POST)
    @ResponseBody
    public PageBeanDataTables page(HttpServletRequest request){
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            return userService.page(input);
        }catch (Exception e){
            return new PageBeanDataTables();
        }
    }

    @RequestMapping(value ="listUserMenus/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> listUserMenus(@PathVariable("id") String id){
        try{
            return userService.listUserMenus(id);
        }catch (Exception e){
            return GlobalConst.failMap(e.getMessage());
        }
    }

}
