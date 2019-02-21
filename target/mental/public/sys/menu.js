$(document).ready(function(){
    validateForm();
    base.initZTree("tree1",setting);
    //tree1.expandAll(true);
});
var setting = {
    data: { simpleData: {enable: true}},
    view :{addDiyDom: addDiyDom},
    async: {enable: true,url:path +"/admin/menu/getTree"},
    callback: {onClick: findById}
};
function findById(event, treeId, treeNode, clickFlag){
    base.clearForm("form1");
    if(treeNode.id == 0){
        return ;
    }
    var url = path +"/admin/menu/findById/"+treeNode.id;
    base.submit('GET',url,null,function callback(data){
        if(data.code == 1){
            base.setValue("parentId",treeNode.getParentNode().id);
            base.setValue("parentName",treeNode.getParentNode().name);
            base.setValues(data.data);
        }else{
            base.alert(data.msg);
        }
    });
}
function addDiyDom(treeId, treeNode) {
    var addImage = path  + "/public/zTree/zTreeStyle/img/diy/add.png";
    var deleteImage = path  + "/public/zTree/zTreeStyle/img/diy/delete.png";
    var aObj = $("#" + treeNode.tId + "_a");
    var editStr = "<span style='margin-left: 3px;cursor:pointer' id='addBtn_" +treeNode.id+ "' title='添加子菜单' onfocus='this.blur();'><img src= '"+addImage+"' align='center'></span>";
    editStr = editStr + "<span style='margin-left: 3px;cursor:pointer' id='deleteBtn_" +treeNode.id+ "' title='删除菜单' onfocus='this.blur();'><img src='"+deleteImage+"' align='center'></span>";
    aObj.after(editStr);
    var addBtn = $("#addBtn_"+treeNode.id);
    addBtn.click(function(){toAddChild(treeId,treeNode);});  //注册点击事件
    var deleteBtn = $("#deleteBtn_"+treeNode.id);
    deleteBtn.click(function(){deleteById(treeId,treeNode);});  //注册点击事件
}
function toAddChild(treeId,treeNode){
    base.clearForm("form1");
    base.setValue("parentId",treeNode.id);
    base.setValue("parentName",treeNode.name);
}
function deleteById(treeId,treeNode){
    if(treeNode.id !="0"){
        if(confirm("确定删除")){
            var url =path + "/admin/menu/delete/"+treeNode.id;
            base.submit("GET",url,null,function callback(data){
                if(data.code == 1){
                    base.alert("菜单删除成功");
                    base.clearForm("form1");
                    base.initZTree("tree1",setting);
                }else{
                    base.alert(data.msg);
                }
            });
        }
    }
}
function validateForm(){
    $("#form1").validate({
            submitHandler:function(){save();}
        }
    );
}
function save(){
    var url =  path +"/admin/menu/save";
    base.submitForm("form1",url,function callback(data){
        if(data.code == "1"){
            base.alert("菜单保存成功");
            base.initZTree("tree1",setting);
        }else {
            base.alert(data.msg);
        }
    });
}