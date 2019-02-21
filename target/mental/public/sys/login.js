$(function () {
    validateForm1();
});
function validateForm1() {
    $('#form1').validate({
        submitHandler: function (form) {
             auth();
        }
    });
}
function auth() {
    var url = path + "/admin/login/auth";
    var data = $("#form1").serialize();
    var req = jQuery.ajax({
        type:'POST',
        url: url,
        dataType : 'json',
        async: false,
        data:data
    });
    req.success(function(data){
        if(data.code == 1){
            window.location.href = path+"/admin/index/index";
        }else {
            $("#errorMsg").html(data.msg);
        }
    });
    req.error(function(request, status, error){
        alert("error");
    });
}