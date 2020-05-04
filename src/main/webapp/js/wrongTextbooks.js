$(document).ready(function () {
    layui.use('layer', function () {
        var $ = layui.jquery
            , layer = layui.layer //
    });

    $("#wrongbook").click(function () {
        alert("错题本详情");
        window.location.href="question.html";
        // layer.open({
        //     type: 1,
        //     title: '错题本内容',
        //     offset: 'auto',
        //     skin: 'layui-layer-molv',
        //     area: ['500px', '300px'],
        //     closeBtn: 1,
        //     shadeClose: true,
        //     content: '<h1>hello,world</h1>'
        // });

    });
})