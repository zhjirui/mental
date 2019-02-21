package com.sjs.mental.common.interceptor;

import com.sjs.mental.common.util.RequestUtil;
import com.sjs.mental.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class LoginInterceptor  extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String uri =request.getServletPath(); //eg: /admin/user/info or /admin/user/info/
        uri = uri.endsWith("/") ? uri.substring(0,uri.length()-1) : uri;
        if(user!=null){
            if(!"Y".equals(user.getStatus())){
                request.getSession().removeAttribute("user");
                goToLogin(request,response);
                return false;
            }else{
                if(uri.equals("/admin/login/login")){
                    goToIndex(request,response);
                    return false;
                }
            }
        }else{
            if(uri.equals("/admin/login/login") || uri.equals("/admin/login/auth")){
                return true;
            }else {
                goToLogin(request,response);
                return false;
            }
        }
       return true;
    }

    private void goToIndex(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.sendRedirect(RequestUtil.getFullPath(request)+"/admin/index/index" );
    }

    private void goToLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String loginUrl = RequestUtil.getFullPath(request)+"/admin/login/login";
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('"+loginUrl+"','_top')");
        out.println("</script>");
        out.println("</html>");
    }

}
