<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/admin/common.jsp" %>
<!DOCTYPE HTML>
<html lang="zh-cn" style="margin: 0;height: 100%">
<head>
    <title>增加角色</title>
    <script type="text/javascript">
        $(function () {
            validateForm();
        });
        function validateForm(){
            $("#form1").validate({submitHandler:function(){add();}});
        }
        function add(){
            var url =  path +"/admin/role/add";
            base.submitForm("form1",url,function callback(data){
                if(data.code == "1"){
                    base.alert("角色增加成功");
                    window.parent.location.reload();
                    base.closeLayer('add');
                }else {
                    base.alert(data.msg);
                }
            });
        }
    </script>
</head>
<body>
<div class="container-fluid" style="height: 90%;">
    <div class="panel panel-default" style="margin-top: 10px;height: 100%">
        <div class="panel-body" style="height: 90%;overflow-y: scroll">
            <form id="form1" name="form1" role="form" class="form-horizontal">
                <div class="row form-group">
                    <label class="col-sm-2 control-label">名称</label>
                    <div class="col-sm-6">
                        <input type="text" id="name" name="name"  maxlength="32" class="form-control" required/>
                    </div>
                </div>
                <div class="row form-group">
                    <label class="col-sm-2 control-label">编号</label>
                    <div class="col-sm-6">
                        <input type="text" id="code" name="code"  maxlength="32" class="form-control" required/>
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
</body>
</html>