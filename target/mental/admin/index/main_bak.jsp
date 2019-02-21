<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-wrapper" class="gray-bg dashbard-1">
  <div class="row border-bottom">
    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
      <div class="navbar-header">
        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary" href="#">
          <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
        </a>
      </div>
      <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
          <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
            <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
          </a>
          <ul class="dropdown-menu dropdown-messages">
            <li class="m-t-xs">
              <div class="dropdown-messages-box">
                <a href="#" class="pull-left">
                  <img alt="image" class="img-circle" src="${path}/public/img/a7.jpg">
                </a>
                <div class="media-body">
                  <small class="pull-right">46小时前</small>
                  <strong>小四</strong> 内容1
                  <br>
                  <small class="text-muted">3天前 2014.11.8</small>
                </div>
              </div>
            </li>
            <li class="divider"></li>
            <li>
              <div class="dropdown-messages-box">
                <a href="#" class="pull-left">
                  <img alt="image" class="img-circle" src="${path}/public/img/a4.jpg">
                </a>
                <div class="media-body ">
                  <small class="pull-right text-navy">25小时前</small>
                  <strong>张三</strong> 内容2
                  <br>
                  <small class="text-muted">昨天</small>
                </div>
              </div>
            </li>
            <li class="divider"></li>
            <li>
              <div class="text-center link-block">
                <a class="J_menuItem" href="#">
                  <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                </a>
              </div>
            </li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle count-info" data-toggle="dropdown" href="">
            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
          </a>
          <ul class="dropdown-menu dropdown-alerts">
            <li>
              <a href="#">
                <div>
                  <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                  <span class="pull-right text-muted small">4分钟前</span>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <i class="fa fa-qq fa-fw"></i> 3条新回复
                  <span class="pull-right text-muted small">12分钟钱</span>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <div class="text-center link-block">
                <a class="J_menuItem" href="">
                  <strong>查看所有 </strong>
                  <i class="fa fa-angle-right"></i>
                </a>
              </div>
            </li>
          </ul>
        </li>
        <li class="dropdown hidden-xs">
          <a class="right-sidebar-toggle" aria-expanded="false"><i class="fa fa-tasks"></i>主题</a>
        </li>
      </ul>
    </nav>
  </div>
  <div class="row content-tabs">
    <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
    </button>
    <nav class="page-tabs J_menuTabs">
      <div class="page-tabs-content">
        <a href="javascript:void(0)" class="active J_menuTab" data-id="${path}/views/index/welcome.jsp">首页</a>
      </div>
    </nav>
    <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
    </button>
    <div class="btn-group roll-nav roll-right">
      <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
      </button>
      <ul role="menu" class="dropdown-menu dropdown-menu-right">
        <li class="J_tabShowActive"><a>定位当前选项卡</a></li>
        <li class="divider"></li><li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
        <li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
      </ul>
    </div>
    <a href="${path}/login/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
  </div>
  <div class="row J_mainContent" id="content-main">
    <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="" frameborder="0" data-id="#" seamless></iframe>
  </div>
  <!--
  <div class="footer fixed">
    <div class="pull-right">&copy; 2014-2015 <a href="#" target="_blank">welcome</a>
    </div>
  </div>
  -->
</div>

