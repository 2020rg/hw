/*
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
                /!*
                btn2: function(index, elem){
                        // 得到value
                        var value = layui.jquery('#layui-layer'+index + " .layui-layer-input").val();
            　　　　　alert(value);
                        if (!value) {
            　　　　　　　　return false;　　// 如果value为空，停止继续执行
                    　  }
                    　 layer.close(index);
                },*!/
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

/!*
layui.use('element',function(){
    var element = layui.element();
});

*!/*/

$(document).ready(function(){
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/StuCourse/queryStudentAllCourse",
        async:false,
        success:function (msg) {
            //alert(msg);
            var insertHtml="";
            var length=msg.length;
            var i=0;
            while(i<length){
                if(i%3===0){
                    insertHtml+="<div class='layui-row'>"+
                        "<div class='layui-col-md3'>"+
                        "<div class='class-panel pn'>"+
                        "<div id='class-show'>"+
                        "<h3>"+msg[i].courseName+"</h3>"+
                        "</div>"+
                        '<div class="class1 class-show centered" id="'+msg[i].courseId+'">'+
                        "<p>查看课程详情</p>"+
                        "</div>"+
                        "</div>"+
                        " </div>";
                }else if(i%3===1){
                    insertHtml+="<div class='layui-col-md3'>"+
                        "<div class='class-panel pn'>"+
                        "<div id='class-show'>"+
                        "<h3>"+msg[i].courseName+"</h3>"+
                        "</div>"+
                        '<div class="class1 class-show centered" id="'+msg[i].courseId+'">'+
                        "<p>查看课程详情</p>"+
                        "</div>"+
                        "</div>"+
                        " </div>";
                }else if(i%3===2){
                    insertHtml+="<div class='layui-col-md3'>"+
                        "<div class='class-panel pn'>"+
                        "<div id='class-show'>"+
                        "<h3>"+msg[i].courseName+"</h3>"+
                        "</div>"+
                        '<div class="class1 class-show centered" id="'+msg[i].courseId+'">'+
                        "<p>查看课程详情</p>"+
                        "</div>"+
                        "</div>"+
                        "</div>"+
                        " </div>";
                }else{
                    alert("出现错误");
                }
                i++;
            }
            if((i-1)%3!==0){
                insertHtml +="</div>";
            }
            $("#myContainer").append(insertHtml);
        },
        error:function () {
            alert("获取课堂失败");
        }
    });

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
                //alert(value);
                $.ajax({
                    type:"POST",
                    url:"http://localhost:8080/StuCourse/joinCourse",
                    async:false,
                    data:{"inviteCode":value},
                    success:function (msg) {
                        var status=msg.status;
                        if(status===1)
                        {
                            alert("成功加入课堂！");
                            window.location.href="studentClass.html";
                        }
                        else
                        {
                            alert("加入课堂失败");
                        }
                    },
                    error:function () {
                        alert("加入课堂失败");
                    }
                });
                layer.close(index);
            });
        });
    });

    layui.use('layer', function () {
        var $ = layui.jquery
            , layer = layui.layer //
    });

    $(".class1").click(function(){
        //var code=document.getElementById("class-code").innerText;
        //alert(code);
        //window.location.href="classInformation.html?courseId="+code;

        var id=$(this).attr("id");
        //var hwMsg={"courseId":id};
        //var StriMsg=JSON.stringify(hwMsg);
        //console.log(StriMsg);
        window.location.href="classInformation.html?courseId="+id;
        /*layer.open({
            type:1,
            title: '已批改作业详情',
            offset:'auto',
            skin:'layui-layer-molv',
            area:['500px','300px'],
            closeBtn:1,
            shadeClose:true,
            content: '<h1>hello,world</h1>'
        });*/
    });
})

/*
layui.use('element',function(){
    var element = layui.element();
});

*/
