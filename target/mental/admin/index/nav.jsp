<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-static-side" role="navigation">
  <div class="nav-close"><i class="fa fa-times-circle"></i></div>
  <div class="sidebar-collapse">
    <ul class="nav" id="side-menu">
      <li class="nav-header">
        <div>
          <a href="javascript:void(0)">
            <span class="clear">
              <span class="block m-t-xs">欢迎您:<strong class="font-bold">${sessionScope.user.name}</strong></span>
            </span>
          </a>
        </div>
      </li>
      <li>
      <li><a class="J_menuItem" data-index="0" href="${path}/admin/index/welcome"><i class="fa fa-home"></i><span class="nav-label">首页</span></a></li>
    </ul>
  </div>
</nav>
