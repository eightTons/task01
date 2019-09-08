queryUser();

function queryUser() {
    $.ajax({
        url: "/listInfo",
        type: "get",
        dataType: "json",
        data: {page: 1},
        success: function (data) {
            if (data.success) {
                var body = "";
                for (var i = 0; i < data.dateList.length; i++) {
                    body += '<tr>' +
                        '<td>' + data.userId + '</td>' +
                        '<td>' + data.userName + '</td>' +
                        '<td>' + new Date(data.dateList[i]).Format("yyyy-MM-dd/hh:mm:ss") + '</td>'
                    '</tr>'
                }
                $('#userTbody').html(body);
            }


        }
    });

}

$(function () {

    $(window).resize(function () {
        $('#userTable').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })

    $('#userTable').bootstrapTable({
        method: 'get',
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        url: "/listinfo",
        height: tableHeight(),//高度调整
        striped: true, //是否显示行间隔色
        dataField: "res",
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        queryParamsType: 'limit',
        queryParams: queryParams,

    })

});

$('#form-submit').submit(function () {
    var oldpassword = document.getElementById("oldpassword").value;
    var newpassword = document.getElementById("newpassword").value;
    var repeatnewpassword = document.getElementById("repeatnewpassword").value;
    //判断旧密码
    $.ajax({
        url: "/checkpassword",
        type: "post",
        dataType: 'json',
        data: {
            password: oldpassword
        },
        success: function (data) {
            if (data.success) {
                // $.toast('');
                // window.location.href = "/login";
            } else {
                $.toast('密码错误！');
                document.getElementById("oldpassword").value = '';
                document.getElementById("newpassword").value = '';
                document.getElementById("repeatnewpassword").value = '';
            }
        }

    })
    if (newpassword === repeatnewpassword) {
        $.ajax({
            url: "/updatepassword",
            type: "post",
            dataType: "json",
            data: {
                newpassword: newpassword
            },
            success: function (data) {
                if (data.success) {
                    $.toast("修改成功！");
                } else {
                    $.toast("修改失败！");
                }
            }
        })
        return true;
    } else {
        alert("两次输入的密码不一致，请重新输入！");
        document.getElementById("newpassword").value = '';
        document.getElementById("repeatnewpassword").value = '';
        return false;
    }
});


function checkUser() {
    var oldpassword = document.getElementById("oldpassword").value;
    var newpassword = document.getElementById("newpassword").value;
    var repeatnewpassword = document.getElementById("repeatnewpassword").value;
    //判断旧密码
    $.ajax({
        url: "/checkpassword",
        type: "post",
        dataType: 'json',
        data: {
            password: oldpassword
        },
        success: function (data) {
            if (data.success) {
                // $.toast('');
                // window.location.href = "/login";
            } else {
                $.toast('密码错误！');
                document.getElementById("oldpassword").value = '';
                document.getElementById("newpassword").value = '';
                document.getElementById("repeatnewpassword").value = '';
            }
        }

    })
    if (newpassword === repeatnewpassword) {
        $.ajax({
            url: "/updatepassword",
            type: "post",
            dataType: "json",
            data: {
                newpassword: newpassword
            },
            success: function (data) {
                if (data.success) {
                    $.toast("修改成功！");
                } else {
                    $.toast("修改失败！");
                }
            }
        })
        return true;
    } else {
        alert("两次输入的密码不一致，请重新输入！");
        document.getElementById("newpassword").value = '';
        document.getElementById("repeatnewpassword").value = '';
        return false;
    }
}


