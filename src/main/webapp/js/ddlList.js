$(document).ready(function(){

    $.ajax({
        type:"POST",
        async:false,
        url:"http://localhost:8080/stuHw/getDDL",
        success:function (msg) {
            var insertHTML="";
            for(var i=0;i<msg.length;i++)
            {
                var courseName=msg[i].courseName;
                var teacherName=msg[i].teacherName;
                var homeworkId=msg[i].homeworkID;
                var title=msg[i].homeworkTitle;
                var introduce=msg[i].homeworkIntroduce;
                var ddl=msg[i].homeworkDDL;
                var warn=msg[i].warn;
                var homeworkSpareTime=msg[i].homeworkSpareTime;

                var hwMsg={"homeworkID":homeworkId};
                var StriMsg=JSON.stringify(hwMsg);

                /*insertHTML+="<div class='layui-card'>"+
                    "<div class='layui-card-header' style='height: auto;font-size: 24px'>"+
                    courseName+teacherName+
                    "<br/>"+
                    title+
                    "<div style='float: right;margin-right: 20px'>"+
                    "<i class='layui-icon layui-icon-tips' style='color: red'></i>"+
                    "</div></div><div class='layui-card-body'>"+
                    "<label>"+
                    introduce+
                    "</label></div>"+
                    "<div class='layui-card-body'>"+
                    "<i class='layui-icon layui-icon-about' style='color: green'></i>"+
                    "<label>"+warn+"</label></div>"+
                    "<div class='layui-card-body'>"+
                    "<label><i class='layui-icon layui-icon-date'></i>截止日期:"+
                    ddl+
                    "</label>"+
                    "<label><i class='layui-icon layui-icon-tips' style='color: red'></i>距离截止日期还有"+
                    homeworkSpareTime+
                    "天</label>"+
                    "<a href='' id='homeworkJump' style='float: right;margin-right: 20px'><i class='layui-icon layui-icon-next'></i> 前往完成 </a>"+
                    "</div></div>"
                document.getElementById("homeworkJump").href="question.html?homeworkId="+homeworkId;*/
                insertHTML+='<div class="layui-card">'+
                    '<div class="layui-card-header" style="height: auto;font-size: 24px">'+
                    courseName+'     '+teacherName+
                    '<br/>'+
                    title+
                    '<div style="float: right;margin-right: 20px">'+
                    '<i class="layui-icon layui-icon-tips" style="color: red"></i>'+
                    '</div></div><div class="layui-card-body">'+
                    '<label>'+
                    introduce+
                    '</label></div>'+
                    '<div class="layui-card-body">'+
                    '<i class="layui-icon layui-icon-about" style="color: green"></i>'+
                    '<label>'+warn+'</label></div>'+
                    '<div class="layui-card-body">'+
                    '<label><i class="layui-icon layui-icon-date"></i>截止日期:'+
                    ddl+
                    '</label>'+
                    '<label><i class="layui-icon layui-icon-tips" style="color: red"></i>距离截止日期还有'+
                    homeworkSpareTime+
                    '天</label>'+
                    '<a href="SubmitHomework.html?Homework='+window.encodeURIComponent(StriMsg)+'" id="homeworkJump" style="float: right;margin-right: 20px"><i class="layui-icon layui-icon-next"></i> 前往完成 </a>'+
                    /*'<a href="question.html?homeworkId='+homeworkId+'" id="homeworkJump" style="float: right;margin-right: 20px"><i class="layui-icon layui-icon-next"></i> 前往完成 </a>'+*/
                    '</div></div>'
            }
            $("#ddlContainer").append(insertHTML);
        }
    });


    /*layui.use('element', function(){
        var element = layui.element;

        //事件监听
        element.on('tab(homework-resource)', function(data){
            console.log(data);
        });
    });*/
})