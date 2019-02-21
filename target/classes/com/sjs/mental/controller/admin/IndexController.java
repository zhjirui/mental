package com.sjs.mental.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("admin/index")
public class IndexController {

    @RequestMapping(value = {"index","/"})
    public String index(){
        return "/admin/index/index.jsp";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "/admin/index/welcome.jsp";
    }

    @RequestMapping("error")
    public String error(){
        return "/admin/index/error.jsp";
    }

}
