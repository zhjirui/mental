package com.sjs.mental.controller.admin;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.util.RequestUtil;
import com.sjs.mental.model.User;
import com.sjs.mental.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping(value = "admin/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value ="login",method = RequestMethod.GET)
    public String index(){
        return "/admin/login/login.jsp";
    }

    @RequestMapping(value ="auth",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> auth(HttpServletRequest request){
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            Map<String,Object> output =  userService.auth(input);
            if(GlobalConst.SUCCESS_CODE .equals(output.get("code"))){
                User user = (User) output.get("data");
                request.getSession().setAttribute("user",user);
            }
            return output;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap();
        }
    }

    @RequestMapping(value ="logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:"+RequestUtil.getFullPath(request)+"/admin/login/login";
    }

}

