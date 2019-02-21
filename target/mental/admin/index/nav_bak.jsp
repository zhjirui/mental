<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-static-side" role="navigation">
  <div class="nav-close"><i class="fa fa-times-circle"></i></div>
  <div class="sidebar-collapse">
    <ul class="nav" id="side-menu">
      <li class="nav-header">
        <div>
          <!--<span><img alt="image" class="img-circle" src="${path}/public/img/profile_small.jpg" /></span>-->
          <a href="javascript:void(0)">
            <span class="clear">
              <span class="block m-t-xs">欢迎您:<strong class="font-bold">${sessionScope.user.name}</strong></span>
            </span>
          </a>
        </div>
      </li>
      <li>
      <li><a class="J_menuItem" data-index="0"><i class="fa fa-home"></i><span class="nav-label">首页</span></a></li>
      <li>
        <a href="#">
          <i class="fa fa-cog"></i><span class="nav-label">系统管理</span><span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li><a class="J_menuItem" href="${path}/admin/department/index">部门管理</a></li>
            <li><a class="J_menuItem" href="${path}/admin/role/index">角色管理</a></li>
            <li><a class="J_menuItem" href="${path}/admin/menu/index">菜单管理</a></li>
            <li><a class="J_menuItem" href="${path}/admin/user/index">用户管理</a></li>
            <li>
              <a href="#">
                <i class="fa fa-cog"></i><span class="nav-label">系统管理</span><span class="fa arrow"></span>
              </a>
              <ul class="nav nav-third-level">
                <li><a class="J_menuItem" href="${path}/admin/user/index">用户管理</a></li>
              </ul>
            </li>
          </ul>
      </li>
      <li><a class="J_menuItem" href="${path}/admin/user/index"><i class="fa fa-columns"></i> <span class="nav-label">布局</span></a></li>
      <li>
        <a href="#">
          <i class="fa fa fa-bar-chart-o"></i><span class="nav-label">统计图表</span><span class="fa arrow"></span></a>
        <ul class="nav nav-second-level">
          <li><a class="J_menuItem" href="#">百度ECharts</a></li>
          <li><a class="J_menuItem" href="#">Flot</a></li>
        </ul>
      </li>
      <li>
        <a href="#"><i class="fa fa-envelope"></i> <span class="nav-label">信箱</span><span class="label label-warning pull-right">16</span></a>
        <ul class="nav nav-second-level">
          <li><a class="J_menuItem" href="#">收件箱</a></li>
          <li><a class="J_menuItem" href="#">查看邮件</a></li>
          <li><a class="J_menuItem" href="#">写信</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
<script type="text/javascript">
  $("#")


</script>
