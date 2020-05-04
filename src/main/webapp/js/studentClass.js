$(document).ready(function(){
    $("#btnAddClass").click(function(){
        layui.use(['layer','form'],function(){
            var layer = layui.layer;
            layer.prompt({
                formType: 0,   
                title: '请输入班级码：',
                value:'', 
                area: ['500px', '150px'], 
                btn: ['确定', '取消'], 
                /*
                btn2: function(index, elem){
                        // 得到value
                        var value = layui.jquery('#layui-layer'+index + " .layui-layer-input").val();
            　　　　　alert(value);
                        if (!value) {
            　　　　　　　　return false;　　// 如果value为空，停止继续执行
                    　  }
                    　 layer.close(index);
                },*/
                btnAlign: 'c',    // 设置按钮位置
            }, function(value, index, elem){
                alert(value); 
                layer.close(index);
            });    
        });
    });

    layui.use('layer', function () {
            var $ = layui.jquery
                , layer = layui.layer //
        });

    $("#class1").click(function(){
        alert("课程详情");
        //window.location.href="classInformation.html";
       layer.open({
            type:1,
            title: '已批改作业详情',
            offset:'auto',
            skin:'layui-layer-molv',
            area:['500px','300px'],
            closeBtn:1,
            shadeClose:true,
            content: '<h1>hello,world</h1>'
        });     

    });
})

/*
layui.use('element',function(){
    var element = layui.element();
});

*/