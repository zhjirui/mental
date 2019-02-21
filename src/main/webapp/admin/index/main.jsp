<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-wrapper" class="gray-bg">
  <div class="row content-tabs">
    <div class="roll-nav">
      <a class="navbar-minimalize btn btn-default " href="#" style="margin-top: 5px;">
        <i class="fa fa-bars"></i>
      </a>
    </div>
    <button class="roll-nav roll-left J_tabLeft" style="left: 4%"><i class="fa fa-backward"></i></button>
    <nav class="page-tabs J_menuTabs" style="margin-left: 7%">
      <div class="page-tabs-content">
        <a href="javascript:void (0);" class="active J_menuTab" data-id="${path}/admin/index/welcome">首页</a>
      </div>
    </nav>
    <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i></button>
    <div class="btn-group roll-nav roll-right">
      <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span></button>
      <ul role="menu" class="dropdown-menu dropdown-menu-right">
        <li class="J_tabShowActive"><a>定位当前选项卡</a>
        </li>
        <li class="divider"></li>
        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
        </li>
        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
        </li>
      </ul>
    </div>
    <a href="javascript:void(0)" class="roll-nav roll-right J_tabExit" onclick="logout()"><i class="fa fa fa-sign-out"></i> 退出</a>
  </div>
  <div class="row J_mainContent" style="height: 90%">
    <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${path}/admin/index/welcome" frameborder="0" data-id="${path}/admin/index/welcome"></iframe>
  </div>
  <div class="footer fixed">
    <div class="pull-right">&copy; 2018- <a href="#" target="_blank">welcome</a>
    </div>
  </div>
</div>

