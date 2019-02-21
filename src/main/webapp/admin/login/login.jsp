<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String contextPath = request.getContextPath();
    String path = request.getScheme() + "://" +request.getServerName() +":"+request.getServerPort()+ contextPath;
    request.setAttribute("path", path);
%>
<script type="text/javascript">
    var path = "${path}";
</script>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <link rel="shortcut icon" href="${path}/public/hplus/img/favicon.ico">
    <!--jquery-->
    <script type="text/javascript" src="${path}/public/hplus/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path}/public/form/jquery.form.js"></script>
    <script type="text/javascript" src="${path}/public/jquery-validation-1.15.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${path}/public/jquery-validation-1.15.0/localization/messages_zh.min.js"></script>
    <!--bootstrap-->
    <link href="${path}/public/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/public/bootstrap-3.3.6/js/bootstrap.min.js"></script>
    <!--font-awesome-->
    <link href="${path}/public/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!--hplus-->
    <link href="${path}/public/hplus/style.min.css" rel="stylesheet">
    <link href="${path}/public/hplus/login.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <script type="text/javascript" src="${path}/public/sys/login.js"></script>
</head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                <span class="logo-name" style="font-size: 100px">Mental</span>
            </div>
            <h3>后台登录</h3>
            <form id="form1" class="m-t" role="form">
                <div class="form-group">
                    <input type="text" id="username" name="username" class="form-control" placeholder="用户名" maxlength="32" required>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" class="form-control" placeholder="密码" maxlength="32" required>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登录</button>
                <p id="errorMsg" style="color: red"></p>
                <!--
                <p class="text-muted text-center"> <a href="#">
                    <small>忘记密码了？</small></a> | <a href="#">注册一个新账号</a>
                </p>
                -->
            </form>
        </div>
    </div>
</body>
</html>
