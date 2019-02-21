var base = {};
base.setValue = function(id,value){
    var obj = $("#"+id);
    if(!obj){
        return ;
    }
    obj.val(value) ;
};
base.setValues = function(data) {
    for(var key in data){
        base.setValue(key,data[key]);
    }
};
base.getValue = function (id) {
    return $("#"+id).val();
};
base.setReadonly = function(id) {
    var obj = $("#"+id);
    if(!obj){
        return ;
    }
    obj.attr("readonly","readonly");
};
base.setDisabled = function (id){
    var obj = $("#"+id);
    if(!obj){
        return ;
    }
    obj.attr("disabled","disabled");
};
base.setEnable = function (id){
    $("#"+id).removeAttribute("disabled");
    $("#"+id).removeAttribute("readonly");
};
base.setHidden = function (id){
    $("#"+id).css("display","none");
};
base.setDisplay = function (id){
    $("#"+id).css("display","");
};
base.setFocus = function (id){
    $("#"+id).focus();
};
base.alert = function(message){
    //layer.msg(message,{time:3000,btn: ['确定']});
    layer.alert(message, {
        icon: 7,  //1 成功  2:失败  3: 问号 4：锁定  5:伤心表情  6微笑表情 7:感叹号
        time:3000
    })
};
base.closeLayer = function (layerId) {
    parent.layer.close(parent.layer.getFrameIndex(layerId));
};
base.msg = function(message){
    //layer.msg(message,{time:3000,btn: ['确定']});
    layer.msg(message, {
        icon: 7,  //1 成功  2:失败  3: 问号 4：锁定  5:伤心表情  6微笑表情 7:感叹号
        time:3000
    })
};
base.getElementById = function(id){
    return $("#"+id);
};
base.resetForm = function(formId){
	$("#"+formId)[0].reset();
};
base.clearForm = function(formId){
	$("#"+formId).clearForm(true);
};
/*
* 1.    dialogHeight:  
2.    dialogWidth:    
3.    dialogLeft:   
4.    dialogTop:    
5.    center:          { yes | no | 1 | 0 } 
6.    help:             {yes | no | 1 | 0 }
7.    resizable:       {yes | no | 1 | 0 } 
8.    status:          {yes | no | 1 | 0 } 
9.    scroll:            { yes | no | 1 | 0 | on | off }
 var obj = new Object();
          obj.name="51js";
window.showModalDialog("modal.htm",obj,"dialogWidth=200px;dialogHeight=100px");
*/
base.showModalDialog = function(url,dialogWidth,dialogHeight,params,features){
    var s =   " dialogWidth="+dialogWidth+";dialogHeight="+dialogHeight + ";" ;
    if(features){
        s = s + features ;
    }
    if(params){
        url = url + "?" + params;
    }
    url = encodeURI(url);
    return  window.showModalDialog(url,window,s);
}
//window.open ('page.html','newwindow','height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')
base.openWindow = function (url,name,width,height,params,windowParameters){
    var iLeft = (window.screen.availWidth-10-width)/2; 
    var iTop = (window.screen.availHeight-30-height)/2;
    if(params){
        url = url + "?" + params;
    }
    var s = "width="+width + "," +"height="+height +"," + "left=" + iLeft + "," + "top="+iTop + ",";
    if(windowParameters){
        s = s + windowParameters ;
    }
    url = encodeURI(url);
    return window.open (url,name,s);
};
base.closeWindow = function(){
    window.close();
};
base.submitForm = function(formId, url,callback){
    var data =  $("#"+formId).serialize();
    jQuery.ajax({
        type:'POST',
        url: url,
        dataType : 'json',
        async: false,
        data: data ,
        success:function(data,textStatus){
            callback(data);
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(errorThrown);
        }
    });
};
base.submitJson = function(url,dataString,callback){
    jQuery.ajax({
        type:'POST',
        url: url,
        dataType : 'json',
        contentType: "application/json",
        async: false,
        data: dataString ,
        success:function(data,textStatus){
            callback(data);
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(errorThrown);
        }
    });
};
base.submit = function(type,url,data,callback){
    jQuery.ajax({
        type:type,
        url: url,
        dataType : 'json',
        async: false,
        data: data ,
        success:function(data,textStatus){
            callback(data);
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            alert("error:"+errorThrown);
        }
    });
};
base.initZTree = function(treeId,setting,nodes){
    if(nodes){
        return $.fn.zTree.init($("#"+treeId),setting,nodes);
    }else{
        return $.fn.zTree.init($("#"+treeId),setting);
    }
};
base.getZTree = function(treeId){
    return $.fn.zTree.getZTreeObj(treeId);
};

base.DataTableCN  = {
    "sProcessing": "处理中...",
        "sLengthMenu": "显示 _MENU_ 项结果",
        "sZeroRecords": "没有匹配结果",
        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix": "",
        "sSearch": "搜索:",
        "sUrl": "",
        "sEmptyTable": "表中数据为空",
        "sLoadingRecords": "载入中...",
        "sInfoThousands": ",",
        "oPaginate": {
        "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
    },
    "oAria": {
        "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
    }
};



