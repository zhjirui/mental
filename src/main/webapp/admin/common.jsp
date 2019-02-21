<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%
  String contextPath = request.getContextPath();
  String path = request.getScheme() + "://" +request.getServerName() +":"+request.getServerPort()+ contextPath;
  request.setAttribute("path", path);
  response.setHeader("Pragma","No-cache");
  response.setHeader("Cache-Control","no-cache");
  response.setDateHeader("Expires", 0);
%>
<link rel="shortcut icon" href="${path}/public/hplus/img/favicon.ico">
<!--jquery and base js-->
<script src="${path}/public/hplus/jquery-2.1.4.min.js"></script>
<script src="${path}/public/sys/base.js"></script>
<script src="${path}/public/form/jquery.form.js"></script>
<script type="text/javascript" src="${path}/public/jquery-validation-1.15.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="${path}/public/jquery-validation-1.15.0/localization/messages_zh.min.js"></script>
<!--dataTables  first: jquery.dataTables.min.js ,then:dataTables.bootstrap.min.js -->
<script src="${path}/public/DataTables-1.10.15/media/js/jquery.dataTables.min.js"></script>
<link  href="${path}/public/DataTables-1.10.15/media/css/jquery.dataTables.min.css" rel="stylesheet">
<link  href="${path}/public/DataTables-1.10.15/media/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script src="${path}/public/DataTables-1.10.15/media/js/dataTables.bootstrap.min.js"></script>
<!--DataTables buttons-->
<script src="${path}/public/DataTables-1.10.15/extensions/Buttons/js/dataTables.buttons.min.js"></script>
<script src="${path}/public/DataTables-1.10.15/extensions/Buttons/js/buttons.flash.min.js"></script>
<script src="${path}/public/DataTables-1.10.15/extensions/Buttons/js/buttons.html5.min.js"></script>
<script src="${path}/public/DataTables-1.10.15/extensions/Buttons/js/buttons.print.min.js"></script>
<link href="${path}/public/DataTables-1.10.15/extensions/Buttons/css/buttons.dataTables.min.css" rel="stylesheet">
<!--bootstrap-->
<link href="${path}/public/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="${path}/public/bootstrap-3.3.6/js/bootstrap.min.js"></script>
<!--datatimepicker-->
<link href="${path}/public/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" >
<script src="${path}/public/My97DatePicker/WdatePicker.js"></script>
<script src="${path}/public/moment/moment.js"></script>
<!--zTree-->
<link rel="stylesheet" href="${path}/public/zTree/zTreeStyle/zTreeStyle.css" >
<script type="text/javascript" src="${path}/public/zTree/jquery.ztree.all-3.5.min.js"></script>
<!--layer-->
<script src="${path}/public/layer-3.1.1/layer.js"></script>
<!--hplus and depends-->
<link href="${path}/public/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${path}/public/hplus/style.css" rel="stylesheet">
<link href="${path}/public/hplus/additional.css" rel="stylesheet">
<script src="${path}/public/pace/pace.min.js"></script><!--进度条-->
<script src="${path}/public/slimscroll/jquery.slimscroll.min.js"></script><!--滚动条-->
<script src="${path}/public/metisMenu/jquery.metisMenu.js"></script><!--菜单-->
<script src="${path}/public/hplus/contabs.min.js?t=<%=Math.random()%>"></script>
<script src="${path}/public/hplus/hplus.min.js"></script>
<script type="text/javascript">
  var path = "${path}";
  function logout() {
    window.location.href=path + "/admin/login/logout";
  }
</script>