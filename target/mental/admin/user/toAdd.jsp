<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/admin/common.jsp" %>
<!DOCTYPE HTML>
<html lang="zh-cn" style="margin: 0;height: 100%">
<head>
    <title>增加用户</title>
    <script type="text/javascript">
        $(function () {
            validateForm();
            initDepartmentTree();
            initRoleSelect();
        });
        function validateForm(){
            $("#form1").validate({submitHandler:function(){add();}});
        }
        function add(){
            if($("#password").val() != $("#confirmPassword").val()){
                base.alert("二次密码不一致");
                return;
            }
            var url =  path +"/admin/user/add";
            base.submitForm("form1",url,function callback(data){
                if(data.code == "1"){
                    base.alert("增加用户成功");
                    window.parent.location.reload();
                }else {
                    base.alert(data.msg);
                }
            });
        }
        /*******************************部门树**************************/
        function showDepartmentTree() {
            var obj = $("#departmentName");
            var offset = obj.offset();
            $("#departmentTreeDiv").css({left:offset.left + "px", top:offset.top + obj.outerHeight() + "px"}).slideDown("fast");
            $("body").bind("mousedown", onBodyDown);
            base.getZTree("tree1").expandAll(true);
        }
        function hideDepartmentTree() {
            $("#departmentTreeDiv").fadeOut("fast");
            $("body").unbind("mousedown", onBodyDown);
        }
        function onBodyDown(event) {
            if (!(event.target.id == "departmentTreeLink" || event.target.id == "departmentTreeDiv" || $(event.target).parents("#departmentTreeDiv").length>0)) {
                hideDepartmentTree();
            }
        }
        function initDepartmentTree() {
            var setting = {
                data: {simpleData: {enable: true}},
                async: {enable: true, url: path+"/admin/department/getTree"},
                callback: {onClick: selectDepartment}
            };
            base.initZTree("tree1", setting);
        }
        function selectDepartment(event, treeId, treeNode, clickFlag){
            if(treeNode.id !="0"){
                base.setValue("departmentId", treeNode.id);
                base.setValue("departmentName", treeNode.name);
                hideDepartmentTree();
            }else{
                base.setValue("departmentId", "");
                base.setValue("departmentName","");
            }
        }
        /*******************************角色**************************/
        function  initRoleSelect() {
            base.submit("POST",path+"/admin/role/findAll",null,function callback(data) {
                var roles = data.data;
                var roleSelect = $("#roleId");
                for(var i=0;i<roles.length;i++){
                    roleSelect.append("<option value='"+roles[i].id+"'>"+roles[i].name+"</option>");
                }
            });
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default" style="margin-top: 10px;height: 100%">
        <div class="panel-body" style="height: 90%;overflow-y: scroll">
            <form id="form1" name="form1" role="form" class="form-horizontal">
                <div class="row form-group">
                    <label class="col-sm-2 control-label">部门</label>
                    <div class="col-sm-4">
                        <div class="input-group">
                            <input type="hidden" id="departmentId"  name="departmentId"/>
                            <input type="text" id="departmentName" name="departmentName" class="form-control" readonly required/>
                            <a id="departmentTreeLink" href="javascript:showDepartmentTree()" class="input-group-addon">[点击选择]</a>
                        </div>
                    </div>
                    <label class="col-sm-2 control-label">角色</label>
                    <div class="col-sm-4">
                        <select id="roleId" name="roleId" class="form-control">
                            <option value="">--全部--</option>
                        </select>
                    </div>
                </div>
                <div class="row form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-4">
                        <input type="text" id="username" name="username"  maxlength="32" class="form-control" required/>
                    </div>
                    <label class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-4">
                        <input type="text" id="name" name="name"  maxlength="32" class="form-control" required/>
                    </div>
                </div>
                <div class="row form-group">
                    <label class="col-sm-2 control-label">密码(5-16位)</label>
                    <div class="col-sm-4">
                        <input type="password" id="password" name="password"  minlength="5" maxlength="16" class="form-control" required/>
                    </div>
                    <label class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-4">
                        <input type="password" id="confirmPassword" name="confirmPassword"  minlength="5" maxlength="16" class="form-control" required/>
                    </div>
                </div>
                <div class="row form-group">
                    <label class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-4">
                        <input type="text" id="phone" name="phone"  maxlength="32" class="form-control"/>
                    </div>
                    <label class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-4">
                        <input type="date" id="birthday" name="birthday"  maxlength="32" class="form-control"/>
                    </div>
                </div>
                <div class="row form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-4">
                        <select id="gender" name="gender" class="form-control" style="width: 100%">
                            <option value="">--全部--</option>
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-12 text-center" role="toolbar">
                        <button type="submit" class="btn btn-success">保存</button>&nbsp;&nbsp;
                        <button type="button" class="btn btn-primary" onclick="base.closeLayer('add')">关闭</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="departmentTreeDiv" style="display:none; position: absolute;z-index: 999;background-color:lightgray">
    <ul id="tree1" class="ztree"  style="margin-top:0;width: 400px"></ul>
</div>
</body>
</html>