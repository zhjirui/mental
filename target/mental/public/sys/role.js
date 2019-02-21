var table1;
$(function(){
    initDataTables();
    $(document).delegate('#btnAdd','click',function() {
        toAdd();
    });
});
function query(){
    table1.ajax.reload();
}
function deleteById(id){
    if(confirm("确定删除")){
        var url = path+ "/admin/role/delete/"+id;
        base.submit("GET",url,null,function callback(data){
            base.alert("删除成功");
            query();
        });
    }
}
function initDataTables(){
    table1 = $('#table1').DataTable({
        paging:true,
        ordering: true,
        //pagingType: "full_numbers",
        lengthMenu:[ [10,50,100,-1], [10, 50, 100,"全部"] ],
        displayLength : 10,
        displayStart : 0, //定义表格初始化时显示的页数
        searching: false,
        processing: true,
        //serverSide: true,  //serverSide=false->过滤、分页、排序的处理都在浏览器中进行
        stateSave:true, //刷新后停留在当前页
        deferRender:true,//延迟渲染
        ajax:{
            url: path + '/admin/role/findAll',
            type:'post',
            data :function(params){
            }
        },
        columns: [
            { data: "name",height:'5px'},
            { data: "code"},
            { data: "id",
                orderable: false,
                "render" : function (data, type, full, meta) {
                    if(data != "1"){
                        var html ="<a href='javascript:void(0)' onclick='toUpdate("+data+")'>[编辑]</a>&nbsp;&nbsp;";
                        html += "<a href='javascript:void(0)' onclick='deleteById("+data+")'>[删除]</a>&nbsp;&nbsp;";
                        html += "<a href='javascript:void(0)' onclick='toRoleMenus("+data+")'>[分配菜单]</a>";
                        return html;
                    }else{
                        return "";
                    }
                }
            }
        ],
        dom: '<l<\'#top\'>f>rt<ip><"clear">',
        scrollY: '55%',
        //autoFill: true,
        language:base.DataTableCN,
        initComplete:function(){
            var html ="<div class='btn-toolbar' role='toolbar'>";
            html +="<button id='btnAdd' class='btn btn-success pull-right'>增加</button>";
            html +="</div>"
            $("#top").append(html);//在表格上方topPlugin DIV中追加HTML
        }
    });
}
function toAdd() {
    var url = path + "/admin/role/toAdd";
    var index = layer.open({
        id:'add',
        title:'增加角色',
        area: ['80%', '80%'],
        type: 2,
        maxmin: true,
        closeBtn:1,
        content: url
    });
}
function toUpdate(id) {
    var url = path + "/admin/role/toUpdate/"+id;
    var index = layer.open({
        id:'update',
        type: 2,
        title:'修改角色',
        area: ['80%', '80%'],
        maxmin: true,
        closeBtn:1,
        content: url
    });
}
function toRoleMenus(id) {
    var url = path + "/admin/role/toRoleMenus/"+id;
    var index = layer.open({
        id:'roleMenus',
        type: 2,
        title:'角色菜单',
        area: ['80%', '80%'],
        maxmin: true,
        closeBtn:1,
        content: url
    });
}
