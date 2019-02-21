var table1;
$(function(){
    initTable();
});
function query(){
    table1.ajax.reload();
}
function initTable(){
    table1 = $('#table1').DataTable({
        lengthMenu:[10,50,100,200],
        displayLength : 200,
        displayStart : 0,
        searching: false,
        processing: true,
        serverSide: true,
        stateSave:true, //刷新后停留在当前页
        deferRender:true,//延迟渲染
        ajax:{
            url:  path+'/admin/act/listProcdefs',
            type:'post'
        },
        columns: [
            { data: "id_" },
            { data: "name_"},
            { data: "key_"},
            { data: "version_"},
            { data: "resource_name_",
                "render" : function (data, type, full, meta) {
                    var url = path + "/admin/act/readFile?procdefId="+full["id_"]+"&type=xml" ;
                    return "<a target='_blank' href='"+url+"'>"+data+"</a>";
                }
            },
            { data: "dgrm_resource_name_",
                "render" : function (data, type, full, meta) {
                    var url = path + "/admin/act/readFile?procdefId="+full["id_"]+"&type=image" ;
                    return "<a target='_blank' href='"+url+"'>"+data+"</a>";
                }
            },
            { data: "reDeployment.deploy_time_" },
            { data: "suspension_state_"},
            { data: "id_",
                orderable: false,
                width:"15%",
                "render" : function (data, type, row, meta) {
                    var html ="";
                    var suspension_state_ = row["suspension_state_"];
                    if(suspension_state_ == "1"){
                        var opUpdateState = "updateState('"+data+"','2')";
                        html += "<a href='#' onclick="+opUpdateState+">[冻结]</a>&nbsp;&nbsp;";
                    }else{
                        var opUpdateState = "updateState('"+data+"','1')";
                        html += "<a href='#' onclick="+opUpdateState+">[激活]</a>&nbsp;&nbsp;";
                    }
                    //html += '<a href="#" onclick="deleteProc(\''+data+'\')" >[删除]</a>&nbsp;&nbsp;';
                    html += "<a href='#' onclick='deleteDeployment(\""+row["reDeployment"]["id_"]+"\")'>[删除]</a>&nbsp;&nbsp;";
                    return html;
                }
            }
        ],
        //scrollY: 300,
        language:base.DataTableCN
        //dom: '<lB<\'#topPlugin\'>f>rt<ip><"clear">',
        //initComplete:function(){
        //    var html ="<div class='btn-toolbar' role='toolbar'>";
        //    html +="<button id='btnAdd' class='btn btn-success'>新增</button>";
        //    html +="</div>"
        //    $("#topPlugin").append(html);//在表格上方topPlugin DIV中追加HTML
        //}
    });
}
function updateState(procdefId,state){
    if(confirm("确定操作")){
        var url = path + "/admin/act/updateState";
        jQuery.ajax({
            type:'POST',
            url: url,
            dataType : 'json',
            data: {"procdefId":procdefId,"state":state} ,
            success:function(data,textStatus){
                if(data["code"] == "-1"){
                    alert(data["msg"]);
                    return false;
                }
                window.location.reload();
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(errorThrown);
            }
        });
    }
}
function deleteDeployment(deploymentId){
    if(confirm("确定操作")){
        var url = path + "/admin/act/deleteProc";
        jQuery.ajax({
            type:'POST',
            url: url,
            dataType : 'json',
            data: {"deploymentId":deploymentId} ,
            success:function(data,textStatus){
                if(data["code"] == "-1"){
                    alert(data["msg"]);
                    return false;
                }
                window.location.reload();
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(errorThrown);
            }
        });
    }
}
function convertToModel(procdefId){



}