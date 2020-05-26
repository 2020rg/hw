/*
/!*
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
})*!/

$(document).ready(function () {

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
                    insertHtml+='<div class="layui-row">'+
                        '<div class="layui-col-md3">'+
                        '<div class="wrongbook-panel pn">'+
                        '<div id="wrongbook-show">'+
                        '<h3></h3>'+
                        '</div>'+
                        '<div id="'+msg[i].courseId+'" class="wrongbook wrongbook-show centered">'+
                        '<p>'+
                        msg[i].courseName+
                        '</p>'+
                        '</div>'+
                        '</div>'+
                        '</div>';
                }else if(i%3===1){
                    insertHtml+='<div class="layui-col-md3">'+
                        '<div class="wrongbook-panel pn">'+
                        '<div id="wrongbook-show">'+
                        '<h3></h3>'+
                        '</div>'+
                        '<div id="'+msg[i].courseId+'" class="wrongbook wrongbook-show centered">'+
                        '<p>'+
                        msg[i].courseName+
                        '</p>'+
                        '</div>'+
                        '</div>'+
                        '</div>';
                }else if(i%3===2){
                    insertHtml+='<div class="layui-col-md3">'+
                        '<div class="wrongbook-panel pn">'+
                        '<div id="wrongbook-show">'+
                        '<h3></h3>'+
                        '</div>'+
                        '<div id="'+msg[i].courseId+'" class="wrongbook wrongbook-show centered">'+
                        '<p>'+
                        msg[i].courseName+
                        '</p>'+
                        '</div>'+
                        '</div>'+
                        '</div>'+
                        '</div>';
                }else{
                    alert("出现错误");
                }
                i++;
            }
            if((i-1)%3!==0){
                insertHtml +="</div>";
            }
            $("#wrongContainer").append(insertHtml);
        },
        error:function () {
            alert("获取课堂失败");
        }
    });

    layui.use('layer', function () {
        var $ = layui.jquery
            , layer = layui.layer //
    });

    $(".wrongbook").click(function () {
        //var code=document.getElementById("class-code").innerText;
        //alert(code);
        //window.location.href="wrongQuestion.html?courseId="+code;

        var id=$(this).attr("id");
        window.location.href="wrongQuestion.html?courseId="+id;
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

    $("#class-code").click(function () {
        var code=document.getElementById("class-code").innerText;
        //alert(code);
        window.location.href="wrongQuestion.html?courseId="+code;
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
*/


$(document).ready(function () {

    $.ajax({
        type:"POST",
        url:"http://localhost:8080/note/getNote",
        async:false,
        success:function (msg) {
            //alert(msg);
            console.log(JSON.stringify(msg));
            var insertHtml="";
            var length=msg.noteList.length;
            var i=0;
            while(i<length){
                if(i%3===0){
                    insertHtml+=" <div class=\"layui-row\">\n" +
                        "                <div class=\"layui-col-md3\">\n" +
                        "                    <div class=\"wrongbook-panel pn\">\n" +
                        "                        <div id=\"wrongbook-show\">\n" +
                        "                            <h3></h3>\n" +
                        "                        </div>\n" +
                        "                        <div id=\"wrongbook\" class=\"wrongbook-show centered intoBook\">\n" +
                        "                            <p id=\""+msg.noteList[i].noteId+"\">"+msg.noteList[i].noteName+"</p>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>";
                }else if(i%3===1){
                    insertHtml+="<div class=\"layui-col-md3\">\n" +
                        "                    <div class=\"wrongbook-panel pn\">\n" +
                        "                        <div id=\"wrongbook-show\">\n" +
                        "                            <h3></h3>\n" +
                        "                        </div>\n" +
                        "                        <div id=\"wrongbook\" class=\"wrongbook-show centered intoBook\">\n" +
                        "                            <p id=\""+msg.noteList[i].noteId+"\">"+msg.noteList[i].noteName+"</p>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>";
                }else if(i%3===2){
                    insertHtml+="<div class=\"layui-col-md3\">\n" +
                        "                    <div class=\"wrongbook-panel pn\">\n" +
                        "                        <div id=\"wrongbook-show\">\n" +
                        "                            <h3></h3>\n" +
                        "                        </div>\n" +
                        "                        <div id=\"wrongbook\" class=\"wrongbook-show centered intoBook\">\n" +
                        "                            <p id=\""+msg.noteList[i].noteId+"\">"+msg.noteList[i].noteName+"</p>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>";

                }else{
                    alert("出现错误");
                }
                i++;
            }
            if((i-1)%3!==0){
                insertHtml +="</div>";
            }
            $("#wrongContainer").append(insertHtml);
        },
        error:function () {
            alert("获取课堂失败");
        }
    });

    layui.use('layer', function () {
        var $ = layui.jquery
            , layer = layui.layer //
    });

    $(".wrongbook-show.centered.intoBook").click(function () {

        alert("进入错题本");
        var code=$(this).children("p").attr("id");
        var hwMsg={"noteBookId":code};
        var StriMsg=JSON.stringify(hwMsg);
        console.log(JSON.stringify(StriMsg));
        window.location.href="wrongQuestion.html?wrongBook="+window.encodeURIComponent(StriMsg);
        //alert(code);
        //window.location.href="wrongQuestion.html?courseId="+code;
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
    //
    // $(".class-code").click(function () {
    //     var code=document.getElementById("class-code").innerText;
    //     //alert(code);
    //     window.location.href="wrongQuestion.html?noteBookId="+code;
    //
    // });
})