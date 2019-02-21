<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/admin/common.jsp"%>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">
  <title>Mental</title>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
  <div id="wrapper">
    <%@ include file="/admin/index/nav.jsp"%>
    <%@ include file="/admin/index/main.jsp"%>
    <%@ include file="/admin/index/sidebar.jsp"%>
  </div>
</body>
<script type="text/javascript">
  $(function () {
    var url = path+"/admin/user/listUserMenus/"+${sessionScope.user.id};
    base.submit("GET",url,null,function callback(data) {
      if(data.code == "1"){
        var menus = data.data;
        initMenus(menus);
        initHplus();
        initHplus2();
        initContabs();
      }else{
        base.alert(data.msg);
      }
    });
  });
  function initMenus(menus ) {
    var sideMenu = $("#side-menu");
    for(var i=0;i<menus.length;i++){
      var html = "";
      var menu = menus[i];
      var children = menu.children;
      if(children.length >0 ){
        html += "<li>";
        html += "<a href='#'>";
        html += "<i class='"+menu.icon+"'></i><span class='nav-label'>"+menu.name+"</span><span class='fa arrow'></span>";
        html += "</a>";
        html += "<ul class='nav nav-second-level'>";
        for(var j=0;j<children.length;j++){
          var menu2 = children[j];
          var children2 = menu2.children;
          if(children2.length >0){
            html+="<li>";
            html+="<a href='#'>";
            html+="<span class='nav-label'>"+menu2.name+"</span><span class='fa arrow'></span>";
            html+="</a>";
            html+="<ul class='nav nav-third-level'>";
            for(var m=0;m<children2.length;m++){
              html+="<li><a class='J_menuItem' href='"+ (children2[m].url? (path+children2[m].url):'javascript:void(0)') +"'>"+children2[m].name+"</a></li>";
            }
            html+="</ul>";
            html+="</li>";
          }else{
            html += "<li><a class='J_menuItem' href='"+ (menu2.url? (path + menu2.url):'javascript:void(0)') +"'>"+menu2.name+"</a></li>";
          }
        }
        html += "</ul>";
        html += "</li>";
      }else{
        html += "<li>";
        html += "<a class='J_menuItem' href='"+(menu.url ? (path+menu.url):'javascript:void(0)') +"'>";
        html += "<i class='"+menu.icon+"'></i><span class='nav-label'>"+menu.name+"</span>";
        html += "</a>";
        html += "</li>";
      }
      sideMenu.append(html);
    }
  }
</script>
</html>
