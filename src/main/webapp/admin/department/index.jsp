<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/admin/common.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>部门管理</title>
  <script type="text/javascript" src="${path}/public/sys/department.js"></script>
</head>
<body>
<div class="row">
  <div class="col-md-2">
    <ul id="tree1" class="ztree" style="width: 100%"></ul>
  </div>
  <div class="col-md-10">
    <form id="form1" name="form1" class="form-horizontal" role="form">
      <fieldset>
        <legend>部门信息</legend>
        <div class="form-group" style="margin-bottom:5px">
          <label for="parentName" class="col-sm-2 control-label">上级部门<font color="#8b0000">*</font></label>
          <div class="col-sm-4">
            <input type="hidden" id="parentId" name="parentId">
            <input type="text" id="parentName" name="parentName" class="form-control" readonly="readonly" required>
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="name" class="col-sm-2 control-label">部门名称<font color="#8b0000">*</font></label>
          <div class="col-sm-4">
            <input type="hidden" id="id" name="id" class="form-control">
            <input type="text" id="name" name="name" class="form-control" maxlength="32" required>
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="name" class="col-sm-2 control-label">部门编号<font color="#8b0000">*</font></label>
          <div class="col-sm-4">
            <input type="text" id="code" name="code" class="form-control" maxlength="32" required>
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="remark" class="col-sm-2 control-label">备注</label>
          <div class="col-sm-8">
            <input type="text" id="remark" name="remark" class="form-control" maxlength="255">
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <div class="col-sm-offset-2 col-sm-4">
            <button type="submit" class="btn btn-primary">保存</button>
          </div>
        </div>
      </fieldset>
    </form>
  </div>
</div>
</body>
</html>