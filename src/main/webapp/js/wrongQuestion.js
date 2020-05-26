/*
$(document).ready(function(){

    var courseId=GetQueryString("courseId");
    var totalNum=0;
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

    initLayPage();

    function initLayPage(pageConf) {
        alert("init函数");
        if (!pageConf) {
            pageConf = {};
            pageConf.pageSize = 1;
            pageConf.currentPage = 1;

        }
        alert("准备ajax");
        $.ajax({
            url:"",
            async:false,
            type:"POST",
            data:{"courseId":courseId},
            success:function (data,pageConf) {
                alert("ajax");
                layui.use('laypage', function () {
                    data = {"noteName": 3333, "noteContent": 2222};
                    alert(data);
                    var page = layui.laypage;
                    page.render({
                        elem: 'test1',
                        count: data.length,
                        curr: pageConf.currentPage,
                        limit: pageConf.pageSize,
                        first: "首页",
                        last: "尾页",
                        pre: "上一题",
                        next: "下一题",
                        jump: function (obj, first) {
                            if (!first) {
                                pageConf.currentPage = obj.curr;
                                pageConf.pageSize = obj.limit;
                                initLayPage(pageConf);
                            }
                        }
                    });
                    fillTable(data, (pageConf.currentPage - 1) * pageConf.pageSize); //页面填充
                })
            }
        });
        /!*$.post("", pageConf, function (data) {
            alert("post函数");
            layui.use('laypage', function () {
                data={"noteName":3333,"noteContent":2222};
                alert(data);
                var page = layui.laypage;
                page.render({
                    elem: 'test1',
                    count: data.length,
                    curr: pageConf.currentPage,
                    limit: pageConf.pageSize,
                    first: "首页",
                    last: "尾页",
                    pre:"上一题",
                    next:"下一题",
                    jump: function (obj, first) {
                        if (!first) {
                            pageConf.currentPage = obj.curr;
                            pageConf.pageSize = obj.limit;
                            initLayPage(pageConf);
                        }
                    }
                });
                fillTable(data, (pageConf.currentPage - 1) * pageConf.pageSize); //页面填充
            })
        });*!/
    }


    function fillTable(data, num) {
        alert("fill函数");
        $("#qContainer").html('');
        $.each(data, function (index, obj) {
            // id 很多时候并不是连续的，如果为了显示比较连续的记录数，可以这样根据当前页和每页条数动态的计算记录序号
            index = index + num + 1;
            var info = '';

            info+='<div class="left-content">'+
                '<h2 id="qTitle">题目'+
                index+
                '</h2><br>'+
                '<p id="qContent">'+
                obj.noteName+
                '</p></div>'+
                '<div class="right-content">'+
                '<h2><i class="layui-icon layui-icon-edit">我的笔记</i></h2>'+
                '<br>'+
                '<div class="layui-input-block" style="margin-left: 0;">'+
                '<textarea id="myNote" placeholder="请输入笔记" class="layui-textarea">'+
                obj.noteContent+
                '</textarea>'+
                '</div>'+
                '<i class="layui-icon layui-icon-"></i>'+
                '<div class="layui-btn-group" style="bottom:0; position:absolute">'+
                '<button type="button" class="layui-btn" id="btnSave">'+
                '<i class="layui-icon layui-icon-file"> 保存</i>'+
                '</button>'+
                '</div>'+
                '</div>';
            alert(info);
            $("#qContainer").append(info);

            $("#btnSave").click(function(){
                console.log("保存笔记");
                alert("保存");
            });
        });
    }

    /!*layui.use('laypage', function(){
        var laypage = layui.laypage;

        //这里需要数据渲染时动态添加

        //执行一个laypage实例
        laypage.render({
            elem: 'test1', //注意，这里的 test1 是 ID，不用加 # 号
            count: totalNum, //数据总数，从服务端得到
            pre:"上一题",
            next:"下一题",
            limit:1,
            jump:function(){
                var addhtml="";

            }
        });
    });*!/



    /!*$("#btnUpload").click(function(){
        console.log("上传文件");

    })
    $("btnHandin").click(function(){
        console.log("提交作业内容");
    })*!/

});

/!*
$.ajax({
    url:"",
    async:false,
    type:"POST",
    success:function(data){
        var sumNews = data.length;
        $('#sumNews').html(sumNews);

        //执行一个laypage实例
        laypage.render({
            elem: 'page', //注意，这里的 page 是 ID，不用加 # 号
            count: sumNews, //数据总数 从服务端得到
            curr:location.hash.replace('#!fenye=',''),
            hash:'funye',
            limit:10,
            jump:function(obj,first){   //当我点击跳转页面时会执行另一个ajax
                console.log(obj.curr)   //当前页数
                console.log(obj.limit)  //每页显示条数
                $.ajax({
                    url:'../diyfenye',
                    data:{
                        curr:obj.curr,
                        limit:obj.limit
                    },
                    type:'post',
                    success:function(data){
                        //向页面渲染后台传过来的数据
                    },
                    error:function(){
                        console.log('网络错误，通信失败');
                    }
                })
            }
        });


    },
    error:function(){
        console.log("网络错误，通信失败");
    }
})*!/
*/


$(document).ready(function(){



    var strmsg = decodeURIComponent(location.search.slice(1).split("=")[1]);
    var msg = JSON.parse(strmsg);
    var bookid=msg.noteBookId;

    console.log("本页面错题本的id是:" + bookid);
    console.log(bookid);
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/note/getANoteContent",
        async:false,
        data:{noteId:bookid},
        success:function (msg) {
            console.log(JSON.stringify(msg));
            initialPage(msg.note);
        },
        error:function () {
            alert("获取错题本数据失败");
        }
    });

    // function  GetQueryString(name) {
    //     //     //构造一个含有目标参数的正则表达式对象
    //     //     var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    //     //     //匹配目标参数
    //     //     var r = window.location.search.substr(1).match(reg);
    //     //     //返回参数值
    //     //     if (r != null) return unescape(r[2]);
    //     //     //不存在时返回null
    //     //     return null;
    //     // }

    //initLayPage();


});

function initialPage(Note){

    layui.use('laypage', function () {
        var laypage = layui.laypage;

        console.log("渲染分页");
        //这里需要数据渲染时动态添加

        //执行一个laypage实例
        laypage.render({
            elem: 'notespage', //注意，这里的 test1 是 ID，不用加 # 号
            count: Note.length, //数据总数，从服务端得到
            limit: 1,
            pre: "上一题",
            next: "下一题",
            curr: location.hash.replace('#!index=', ''),//获取hash值为fenye的当前页
            hash: 'index',//自定义hash值
            jump: function (obj) {
                console.log(obj.curr);
                var i = obj.curr - 1;
                var addhtml = fillContent(Note[i], i + 1);
                $("#qContainer").html(addhtml);
            }
        });

    });

}

function fillContent(onenote, index){
    console.log("填充一份数据");
    return "<div class=\"left-content\">\n" +
        "<h2>题目" + index + "</h2>\n" +
        "<br>\n" +
        "<p>" + onenote.questionContent + "</p>\n" +
        "</div>\n" +
        "<div class=\"right-content\">\n" +
        "<h2><i class=\"layui-icon layui-icon-edit\"></i>我的答案</h2> \n" +
        "<br>\n" +
        "<br>" +
        "<p>" + onenote.answer + "<\p>" +
        "<br>" +
        "<br>" +
        "<br>" +
        "<h2>错题笔记</h2>" +
        "<br>" +
        "<br>" +
        "<p>" + onenote.content + "</p>" +
        "</div>\n";
}

