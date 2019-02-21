<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/admin/common.jsp"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <title>角色管理</title>
    <script src="${path}/public/sys/role.js?<%=Math.random()%>"></script>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default" style="margin-top: 10px">
        <!--
        <div class="panel-heading">
            角色管理
        </div>
        -->
        <div class="panel-body">
            <table id="table1" class="table table-striped table-bordered table-hover table-condensed" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th width="30%">名称</th>
                    <th width="30%">编号</th>
                    <th width="40%">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<div class="clear" id="wrapper"></div>
</body>
</html>