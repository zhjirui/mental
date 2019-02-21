<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/admin/common.jsp" %>
<!DOCTYPE HTML>
<html lang="zh-cn" style="margin: 0;height: 100%">
<head>
    <title>角色菜单</title>
    <script type="text/javascript">
        $(function () {
            initTree();
            validateForm();
        });
        function validateForm(){
            $("#form1").validate({submitHandler:function(){saveRoleMenus();}});
        }
        function initTree() {
            var url = path + "/admin/role/getRoleMenus/"+$("#id").val();
            var setting = {
                check: {enable: true},
                data: { simpleData: {enable: true}},
                async: {enable: true,url:url}
            };
            base.initZTree("tree1",setting);
        }
        function saveRoleMenus() {
            var roleId = $("#id").val();
            var tree1 = base.getZTree("tree1");
            var checkedNodes = tree1.getCheckedNodes();
            var data ={};
            var menuIds = [];
            $.each(checkedNodes,function(index,item){
                menuIds.push(item["id"]);
            });
            data.roleId = roleId;
            data.menuIds = menuIds;
            var dataString = JSON.stringify(data);
            var url = path + "/admin/role/saveRoleMenus";
            base.submitJson(url,dataString,function callback(data) {
                if(data.code == 1){
                    base.alert("角色菜单保存成功");
                }else{
                    base.alert(data.msg);
                }
            });
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-body" style="height: 90%;overflow-y: scroll">
            <form id="form1">
            <input type="hidden" id="id" value="${role.id}">
            <div class="row">
                <label class="col-sm-2 control-label">角色名称</label>
                <div class="col-sm-2">${role.name}</div>
                <label class="col-sm-2 control-label">角色编号</label>
                <div class="col-sm-2">${role.code}</div>
            </div>
            <div class="row">
                <ul id="tree1" class="ztree" style="width: 100%;height: 50%;border:1px"></ul>
            </div>
            <div class="row form-group">
                <div class="col-sm-12 text-center" role="toolbar">
                    <button type="submit" class="btn btn-success">保存</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-primary" onclick="base.closeLayer('roleMenus')">关闭</button>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>