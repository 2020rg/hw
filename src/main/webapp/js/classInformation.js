/*
$(document).ready(function(){
    layui.use('element', function(){
        var element = layui.element;
        
        //事件监听
        element.on('tab(homework-resource)', function(data){
          console.log(data);
        });
      });
})*/

/*
$(document).ready(function(){

    var courseId=GetQueryString("courseId");
    //alert(courseId);
    function  GetQueryString(name) {
        //构造一个含有目标参数的正则表达式对象
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        //匹配目标参数
        var r = window.location.search.substr(1).match(reg);
        //返回参数值
        if (r != null) return unescape(r[2]);
        //不存在时返回null
        return null;
    }

    $.ajax({
        type:"POST",
        async:false,
        url:"http://localhost:8080/course/queryCourseByCourseId",
        data:{"courseId":courseId},
        success:function (msg) {
            //alert(msg);
            var insertHTML="";
            var teacherName=msg.teacherName;
            var courseName=msg.courseName;
            var homeworkList=msg.homeworkList;
            for(var i=0;i<homeworkList.length;i++)
            {
                var homeworkId=homeworkList[i].homeworkId;
                var title=homeworkList[i].title;
                var introduce=homeworkList[i].introduce;
                var ddl=homeworkList[i].ddl;
                insertHTML+="<div class='layui-card'>"+
                    "<div class='layui-card-header'>"+
                    title+
                    "</div>"+
                    "<div class=''layui-card-body'>"+
                    introduce+
                    "<br>"+
                    "<h7>截至日期" +
                    ddl+
                    "</h7></div></div>"
            }
            document.getElementById("courseName").innerText=courseName;
            document.getElementById("teacherName").innerText="任课教师"+teacherName;
            $("#homeworkContainer").append(insertHTML);
        },
        error:function () {
            alert("获取课堂信息失败");
        }

    });


    layui.use('element', function(){
        var element = layui.element;

        //事件监听
        element.on('tab(homework-resource)', function(data){
            console.log(data);
        });
    });
})*/


$(document).ready(function(){

    var courseId=GetQueryString("courseId");
    //alert(courseId);
    function  GetQueryString(name) {
        //构造一个含有目标参数的正则表达式对象
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        //匹配目标参数
        var r = window.location.search.substr(1).match(reg);
        //返回参数值
        if (r != null) return unescape(r[2]);
        //不存在时返回null
        return null;
    }

    $.ajax({
        type:"POST",
        async:false,
        url:"http://localhost:8080/course/queryCourseByCourseId",
        data:{"courseId":courseId},
        success:function (msg) {
            //alert(msg);
            var insertHTML="";
            var insertResource="";
            var teacherName=msg.teacherName;
            var courseName=msg.courseName;
            var homeworkList=msg.homeworkList;
            var resourceList=msg.resourceList;
            for(var i=0;i<homeworkList.length;i++)
            {
                var homeworkId=homeworkList[i].homeworkId;
                var title=homeworkList[i].title;
                var introduce=homeworkList[i].introduce;
                var ddl=homeworkList[i].ddl;
                insertHTML+="<div class='layui-card'>"+
                    "<div class='layui-card-header'>"+
                    title+
                    "</div>"+
                    "<div class=''layui-card-body'>"+
                    introduce+
                    "<br>"+
                    "<h7>截至日期" +
                    ddl+
                    "</h7></div></div>";
                var resourceId=resourceList[i].resourceId;
                var uploadTime=resourceList[i].uploadTime;
                var resourceName=resourceList[i].resourceName;
                var resourceFilepath=resourceList[i].resourceFilepath;
                insertResource+='<div class="layui-card"><div class="layui-card-header">'+
                    resourceName+
                    '</div>'+
                    '<div class="layui-card-body rsFp" id="'+resourceId+'">'+
                    resourceFilepath+
                    '<i class="layui-icon layui-icon-download-circle"></i>'+
                    '</div></div>';
            }
            document.getElementById("courseName").innerText=courseName;
            document.getElementById("teacherName").innerText="任课教师："+teacherName;
            $("#homeworkContainer").append(insertHTML);
            $("#resourceContainer").append(insertResource);

            $(".rsFp").click(function () {
                var id=$(this).attr("id");
                $.ajax({
                    url:"http://localhost:8080/resource/download",
                    async:false,
                    type:"POST",
                    data:{"resourceId":id},
                    success:function (msg) {
                        if(msg.flag==0)
                            alert("准备下载资源");
                        else
                            alert("下载失败");
                    },
                    error:function () {
                        alert("下载失败");
                    }
                });
            });
        },
        error:function () {
            alert("获取课堂信息失败");
        }

    });


    layui.use('element', function(){
        var element = layui.element;

        //事件监听
        element.on('tab(homework-resource)', function(data){
            console.log(data);
        });
    });
})
