
$(function () {
    var loginUrl = "/logincheck";

    $('#submit').click(function () {
        var userName = $('#username').val();
        var password = $('#password').val();

        $.ajax({
            url: loginUrl,
            type: "post",
            dataType: 'json',
            data: {
                userName: userName,
                password: password
            },
            success: function (data) {
                if(data.success){
                    $.toast('登陆成功');
                    window.location.href = "/owner";   //*****************************
                }else {
                    $.toast('登录失败！');
                }
            }

        })
    })

})