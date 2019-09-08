// table.render({
//     elem: '#data_grid'
//     //,width: 900
//     //,height: 274
//     ,cols: [[ //标题栏
//         {field: 'id', title: '用户ID', width: 80, sort: true}
//         ,{field: 'username', title:'用户名',width: 100} //空列
//         ,{field: 'logindate', title: '登陆时间', width: 120}
//         ,{fixed: 'right', width: 215,align:'center', toolbar: '#barDemo'}
//     ]]
//     ,url:url
//     ,skin: 'row' //表格风格
//     ,even: true
//     ,page: true //是否显示分页
//     ,limits: [3,5,10]
//     ,limit: 5 //每页默认显示的数量
//     ,done:function(res){
//         userPage.data = res.data;
//     }
//     //,loading: false //请求数据时，是否显示loading
// });
//
// $('#sub_query_form').on('click',function () {
//     var queryPo = page.formToJson($('#query_form').serialize());
//     var table = layui.table;
//     table.reload('data_grid', {
//         url: '/getUserList.action',
//         page:{
//             curr:1  //从第一页开始
//         },
//
//         method:'post',
//         where:{
//             queryStr:queryPo
//         },
//         done:function (res) {
//             userPage.data = res.data;
//         }
//     });
// });