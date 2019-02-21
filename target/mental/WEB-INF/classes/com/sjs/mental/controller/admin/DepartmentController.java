package com.sjs.mental.controller.admin;

import com.sjs.mental.common.GlobalConst;
import com.sjs.mental.common.util.RequestUtil;
import com.sjs.mental.model.Department;
import com.sjs.mental.service.DepartmentService;
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
@RequestMapping("admin/department")
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/index")
    public String index(){
        return "/admin/department/index.jsp";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> save(HttpServletRequest request) throws Exception{
        try{
            Map<String,String> input = RequestUtil.transRequestMap(request.getParameterMap());
            Department department = departmentService.save(input);
            return GlobalConst.successMap(department);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("id") String id) throws Exception{
        try{
            return departmentService.delete(id);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findById(@PathVariable("id") String id) throws Exception{
        try{
            Department department = departmentService.findById(id);
            return GlobalConst.successMap(department);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return GlobalConst.failMap(e.getMessage());
        }
    }

    @RequestMapping("/getTree")
    @ResponseBody
    public List<Map<String,Object>> getTree() throws Exception{
        try{
            return departmentService.getTree();
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new ArrayList<>();
        }
    }

}
