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
function initDataTables(){
    table1 = $('#table1').DataTable({
        paging:true,
        ordering: true,
        //pagingType: "full_numbers",
        lengthMenu:[[10,50,100,999999999], [10, 50, 100,"全部"]],
        displayLength : 10,
        displayStart : 0, //定义表格初始化时显示的页数
        searching: false,
        processing: true,
        serverSide: true,  //serverSide=false->过滤、分页、排序的处理都在浏览器中进行
        stateSave:true, //刷新后停留在当前页
        deferRender:true,//延迟渲染
        ajax:{
            url: path + '/admin/user/page',
            type:'post',
            data :function(params){
                params["queryString"] = $("#queryString").val() ;
            }
        },
        columns: [
            { data: "department.name"},
            { data: "role.name"},
            { data: "username"},
            { data: "name"},
            { data: "birthday"},
            { data: "gender",
                "render" : function (data, type, full, meta) {
                    return data =="1" ? "男":"女"
                }
            },
            { data: "status",
                "render" : function (data, type, full, meta) {
                    return data =="Y" ? "有效":"无效"
                }
            },
            { data: "id",
                orderable: false,
                "render" : function (data, type, full, meta) {
                    if(data != "1"){
                        var html ="<a href='javascript:void(0)' onclick='toUpdate("+data+")'>[编辑]</a>&nbsp;&nbsp;";
                        html += "<a href='javascript:void(0)' onclick='resetPassword("+data+")'>[重置密码]</a>&nbsp;&nbsp;";
                        return html;
                    }else{
                        return "";
                    }
                }
            }
        ],
        dom: '<l<\'#top\'>f>rt<ip><"clear">',
        scrollY: '50%',
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
    var url = path + "/admin/user/toAdd";
    var index = layer.open({
        id:'add',
        title:'增加用户',
        area: ['80%', '80%'],
        type: 2,
        maxmin: true,
        closeBtn:1,
        content: url
    });
}
function toUpdate(id) {
    var url = path + "/admin/user/toUpdate/"+id;
    var index = layer.open({
        id:'update',
        title:'修改用户',
        area: ['80%', '80%'],
        type: 2,
        maxmin: true,
        closeBtn:1,
        content: url
    });
}
function resetPassword(id) {
    if(confirm("确定重置密码?")){
        var url = path + "/admin/user/resetPassword/"+id;
        base.submit("GET",url,null,function callback(data){
            if(data.code == 1){
                layer.confirm("请记住新密码:"+data.data,{btn:["记住了"]});
            }else{
                alert(data.msg);
            }
        });
    }
}