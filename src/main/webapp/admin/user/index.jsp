<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/admin/common.jsp"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <title>用户管理</title>
    <script src="${path}/public/sys/user.js?<%=Math.random()%>"></script>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default" style="margin-top: 10px">
        <form id="form1">
            <div class="row form-group" style="margin-top: 10px">
                <label class="control-label col-md-1 text-center">用户信息</label>
                <div class="col-md-2">
                    <input type="text" id="queryString" name="queryString"  class="form-control" maxlength="32"/>
                </div>
                <div class="col-md-2 text-center">
                    <button type="button" id="btnSearch" onclick="query()" class="btn btn-success">查询</button>
                    <button type="button" id="btnReset" onclick="base.clearForm('form1')" class="btn btn-warning">重置</button>
                </div>
            </div>
        </form>
        <div class="panel-body">
            <table id="table1" class="table table-striped table-bordered table-hover table-condensed" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th width="10%">部门</th>
                    <th width="10%">角色</th>
                    <th width="10%">账号</th>
                    <th width="10%">姓名</th>
                    <th width="10%">出生日期</th>
                    <th width="10%">性别</th>
                    <th width="10%">状态</th>
                    <th width="30%">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
</body>
</html>