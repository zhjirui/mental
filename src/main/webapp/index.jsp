<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
    String path = request.getScheme() + "://" +request.getServerName() +":"+request.getServerPort()+ contextPath;
    response.sendRedirect(path+"/admin/index/index");
%>