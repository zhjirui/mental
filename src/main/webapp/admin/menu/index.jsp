<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/admin/common.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>菜单管理</title>
  <script type="text/javascript" src="${path}/public/sys/menu.js?<%=Math.random()%>"></script>
</head>
<body>
<div class="row">
  <div class="col-md-2">
    <ul id="tree1" class="ztree" style="width: 100%"></ul>
  </div>
  <div class="col-md-10">
    <form id="form1" name="form1" class="form-horizontal" role="form">
      <fieldset>
        <legend>菜单信息</legend>
        <div class="form-group" style="margin-bottom:5px">
          <label for="parentName" class="col-sm-2 control-label">上级菜单<font color="#8b0000">*</font></label>
          <div class="col-sm-4">
            <input type="hidden" id="parentId" name="parentId">
            <input type="text" id="parentName" name="parentName" class="form-control" readonly="readonly">
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="name" class="col-sm-2 control-label">菜单名称<font color="#8b0000">*</font></label>
          <div class="col-sm-4">
            <input type="hidden" id="id" name="id" class="form-control">
            <input type="text" id="name" name="name" class="form-control" maxlength="32" required>
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="name" class="col-sm-2 control-label">图片路径</label>
          <div class="col-sm-4">
            <input type="text" id="icon" name="icon" class="form-control" maxlength="32">
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="path" class="col-sm-2 control-label">URL地址</label>
          <div class="col-sm-4">
            <input type="text" id="path" name="path" class="form-control" maxlength="32">
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="rank" class="col-sm-2 control-label">排序(整数或小数)</label>
          <div class="col-sm-4">
            <input type="number" id="rank" name="rank" class="form-control" maxlength="10">
          </div>
        </div>
        <div class="form-group" style="margin-bottom:5px">
          <label for="status" class="col-sm-2 control-label">状态<font color="#8b0000">*</font></label>
          <div class="col-sm-4">
            <select id="status" name="status" class="form-control" required>
              <option value="">-请选择-</option>
              <option value="Y">有效</option>
              <option value="N">无效</option>
            </select>
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