/*
$(document).ready(function(){
    layui.use('laypage', function(){
        var laypage = layui.laypage;

        //这里需要数据渲染时动态添加

        //执行一个laypage实例
        laypage.render({
            elem: 'test1', //注意，这里的 test1 是 ID，不用加 # 号
            count: 100, //数据总数，从服务端得到
            pre:"上一题",
            next:"下一题",
            limit:1,
            jump:function(){
                var addhtml="";

            }
        });
    });

    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
          elem: '#btnUpload' //绑定元素
          ,url: '/upload/' //上传接口
          ,done: function(res){
            //上传完毕回调
            //上传发送数据

            //添加元素 文件图标和名字
            /!*

            *!/

          }
          ,error: function(){
            //请求异常回调
          }
        });
      });

    $("#btnSave").click(function(){
        console.log("保存作业答案");
    })
    $("#btnUpload").click(function(){
        console.log("上传文件");

    })
    $("btnHandin").click(function(){
        console.log("提交作业内容");
    })

})

$.ajax({
    url:'../testdata',
    data:{

    },
    type:'post',
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
})*/

$(document).ready(function () {
    //解析本个作业的id
    console.log("hello");

    var strmsg = decodeURIComponent(location.search.slice(1).split("=")[1]);
    var msg = JSON.parse(strmsg);
    var strhwid=msg.homeworkID;
    // strhwid=strhwid.substr(0,strhwid.length-1);
    // strhwid=strhwid.substr(1,strhwid.length-1);

    var hwid=parseInt(strhwid);
    var flag=parseInt(msg.flag);
    alert("本页面作业的id是:" + hwid + "类型flag为："+flag);
    console.log(hwid);

    /*var homeworkId=GetQueryString("homeworkId");
    var flag=GetQueryString("flag");
    function  GetQueryString(name) {
        //构造一个含有目标参数的正则表达式对象
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        //匹配目标参数
        var r = window.location.search.substr(1).match(reg);
        //返回参数值
        if (r != null) return unescape(r[2]);
        //不存在时返回null
        return null;
    }*/

    //这里暂时这么存储，测试时仅进行声明，赋值操作在ajax中
    var questions;
    var length;
    // //answerList 未提交的答案信息列表
    // answerList=new Array(questions.length);
    //获取数据

    switch (flag) {
        case 1://待批改
            // $.post("http://localhost:8080/sq/querySubmitOk", {homeworkID: hwid})
            //             //     .done(function (data) {
            //             //         alert("Data Loaded: " + data);
            //             //         questions = data.questionList;
            //             //         initialPage(flag, questions);
            //             //     });
            $.ajax({
                type:"POST",
                url:"http://localhost:8080/sq/querySubmitOk",
                data:{homeworkId: strhwid},
                async:false,
                success:function (msg) {
                    questions = msg.questionList;
                    length=questions.length;
                    initialPage(flag, questions);
                    console.log(JSON.stringify(msg));
                },
                error:function () {
                    alert("获取作业数据失败");
                }
            });
            break;
        case 2://已批改
            // $.post("http://localhost:8080/sq/queryChecked", {homeworkID: hwid})
            //     .done(function (data) {
            //         alert("Data Loaded: " + data);
            //         questions = data.questionList;
            //         initialPage(flag, questions);
            //     });
            $.ajax({
                type:"POST",
                url:"http://localhost:8080/sq/queryChecked",
                data:{homeworkId: strhwid},
                async:false,
                success:function (msg) {
                    questions = msg.questionList;
                    length=questions.length;
                    initialPage(flag, questions);
                    console.log(JSON.stringify(msg));
                },
                error:function () {
                    alert("获取作业数据失败");
                }
            });
            break;
        default:
            alert("作业类型错误");
            break;
    }

});

var questionIndex = -1;


function initialPage(flag, questionList) {
    //这个数据从后台获取
    //获取作业类型
    //这里假设 flag=0s是未提交
    //flag=1 待批改
    //flag=2 已批改

    // //模拟渲染
    //
    //调用分页
    layui.use('laypage', function () {
        var laypage = layui.laypage;

        //这里需要数据渲染时动态添加

        //执行一个laypage实例
        laypage.render({
            elem: 'perpage', //注意，这里的 test1 是 ID，不用加 # 号
            count: questionList.length, //数据总数，从服务端得到
            limit: 1,
            pre: "上一题",
            next: "下一题",
            curr: location.hash.replace('#!index=', ''),//获取hash值为fenye的当前页
            hash: 'index',//自定义hash值
            jump: function (obj,first) {
                console.log(obj.curr);
                //获取上一页的textarea内容
                //if(first){//首次渲染加html
                var i = obj.curr - 1;
                var addhtml = "";
                switch (flag) {
                    // case 0://未提交
                    //     addhtml = fillSubmitNotOk(questionList[i], i + 1);
                    //     break;
                    case 1://待批改
                        addhtml = fillNotChecked(questionList[i], i + 1);
                        break;
                    case 2://已批改
                        addhtml = fillHasChecked(questionList[i], i + 1);
                        break;
                    default:
                        break;
                }
                $("#question-content").html(addhtml);
                //$("#question-content").append(addhtml);
                // if(flag===0){
                //     //添加按钮
                //     var btnStr="<div class=\"layui-btn-group\" style=\"margin-left:200px;\">\n" +
                //     "                  <button type=\"button\" class=\"layui-btn\" id=\"btnHandin\">\n" +
                //     "                    <i class=\"layui-icon layui-icon-ok-circle\">提交所有答案</i>\n" +
                //     "                  </button>\n" +
                //     "              </div>\n";
                //     $("#buttonSub").html(btnStr);
                //     //本题答案保存显示
                //     $("textarea")
                // }
                //}
            }
        });


    });
}

// layui.use('upload', function(){
//     var upload = layui.upload;
//
//     //执行实例
//     var uploadInst = upload.render({
//       elem: '#btnUpload' //绑定元素
//       ,url: '/upload/' //上传接口
//       ,done: function(res){
//         //上传完毕回调
//         //上传发送数据
//
//         //添加元素 文件图标和名字
//         /*
//
//         */
//
//       }
//       ,error: function(){
//         //请求异常回调
//       }
//     });
//   });


//已提交 未批改
function fillNotChecked(question, index) {
    var insertHtml = "" +
        "<div class=\"left-content\">\n" +
        "<h2>题目" + index + "</h2>\n" +
        "<br>\n" +
        "<p>" + question.questionContent + "</p>\n" +
        "</div>\n" +
        "<div class=\"right-content\">\n" +
        "<h2><i class=\"layui-icon layui-icon-edit\">我的答案</i></h2> \n" +
        "<br>\n" +
        "<p>" + question.answer + "<\p>" +
        "</div>\n";
    return insertHtml;
}

function fillHasChecked(question, index) {
    return "<div class=\"left-content\">\n" +
        "<h2>题目" + index + "</h2>\n" +
        "<br>\n" +
        "<p>" + question.questionContent + "</p>\n" +
        "</div>\n" +
        "<div class=\"right-content\">\n" +
        "<h2><i class=\"layui-icon layui-icon-edit\">我的答案</i></h2> \n" +
        "<br>\n" +
        "<p>" + question.answer + "<\p>" +
        "<h2>我的得分</h2>" +
        "<br>" +
        "<br>" +
        "<br>" +
        "<p>" + question.score + "</p>" +
        "</div>\n";
}

// function fillSubmitNotOk(question, index) {
//     var insertHtml = "<div class=\"left-content\">\n" +
//         "                <h2>题目"+index+"</h2>\n" +
//         "                <br>\n" +
//         "                <p>"+question.questionContent+"</p>\n" +
//         "            </div>\n" +
//         "            <div class=\"right-content\">\n" +
//         "               <h2><i class=\"layui-icon layui-icon-edit\">我的答案</i></h2>\n" +
//         "               <br>\n" +
//         "               <div class=\"layui-input-block\" style=\"margin-left: 0;\">\n" +
//         "                <textarea placeholder=\"请输入答案\" class=\"layui-textarea\" style='height: fit-content'></textarea>\n" +
//         "              </div>\n" +
//         "              <i class=\"layui-icon layui-icon-\"></i>\n" +
//         // "              <div class=\"layui-btn-group\" style=\"margin-left:50px; bottom:0; position:absolute\">\n" +
//         // "                  <button type=\"button\" class=\"layui-btn\" id=\"btnHandin\">\n" +
//         // "                    <i class=\"layui-icon layui-icon-ok-circle\">提交所有答案</i>\n" +
//         // "                  </button>\n" +
//         // "              </div>\n" +
//         "            </div>";
//
//     return insertHtml;
// }

var testHasCheckedData = {
    "scoreAll": "",
    "questionList": [
        {
            "questionID": "2020222",
            "questionContent": "计算机网络第六版第六章课后题第一题",
            "answer": "1.B",
            "score": "100分"//请求question表格增加score
        },
        {
            "questionID": "2020222",
            "questionContent": "计算机网络第六版第六章课后题第二题",
            "answer": "2.C",
            "score": "100分"//请求question表格增加score
        },
        {
            "questionID": "2020222",
            "questionContent": "计算机网络第六版第六章课后题第三题",
            "answer": "3.D",
            "score": "100分"//请求question表格增加score
        },
        {
            "questionID": "2020222",
            "questionContent": "计算机网络第六版第六章课后题第四题",
            "answer": "4.E",
            "score": "100分"//请求question表格增加score
        },
        {
            "questionID": "2020222",
            "questionContent": "计算机网络第六版第六章课后题第五题",
            "answer": "5.A",
            "score": "0分"//请求question表格增加score
        }
    ]


};

var testSubmitNotOkData = {
    "questionList": [
        {
            "questionID": "20201007",
            "questionContent": "课本P40页第二题"
        },
        {
            "questionID": "20201008",
            "questionContent": "课本P40页第五题"
        }]
};

var testHasNotCheckedData = {
    "questionList": [
        {
            "questionID": "20201001",
            "questionContent": "课本P23页第二题",
            "answer": "a=1,b=3;c=d;"//请求question表格增加answer
        },
        {
            "questionID": "20201002",
            "questionContent": "课本P24页第五题",
            "answer": "aaccddeeff"//请求question表格增加answer
        }]
};

