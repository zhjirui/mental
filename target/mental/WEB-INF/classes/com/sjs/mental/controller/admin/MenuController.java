package com.sjs.mental.controller.admin;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.util.RequestUtil;
import com.sjs.mental.model.Menu;
import com.sjs.mental.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("admin/menu")
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public String index(){
        return "/admin/menu/index.jsp";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> save(HttpServletRequest request) throws Exception{
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            Menu menu = menuService.save(input);
            return GlobalConst.successMap(menu);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("id") String id) throws Exception{
        try{
            return menuService.delete(id);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findById(@PathVariable("id") String id) throws Exception{
        try{
            Menu menu = menuService.findById(id);
            return GlobalConst.successMap(menu);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping("/getTree")
    @ResponseBody
    public List<Map<String,Object>> getTree() throws Exception{
        try{
            return menuService.getTree();
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new ArrayList<>();
        }
    }

}
