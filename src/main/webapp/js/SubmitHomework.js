$(document).ready(function () {

    var strmsg = decodeURIComponent(location.search.slice(1).split("=")[1]);
    var msg = JSON.parse(strmsg);
    var hwid = msg.homeworkID;

    //var questions = testSubmitNotOkData.questionList;


    // $.post("question/queryQuestionByHomeworkId", {homeworkID: hwid})
    //     .done(function (data) {
    //         alert("Data Loaded: " + data);
    //         questions = data.questionList;
    //     });
    var questions;
    var length;
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/question/queryQuestionByHomeworkId",
        data:{homeworkID: hwid},
        async:false,
        success:function (msg) {
            questions = msg;
            length=questions.length;
            console.log(JSON.stringify(msg));
            initialPage(msg);
        },
        error:function () {
            alert("获取作业数据失败");
        }
    });

    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(demo1)', function (data) {
            var o = {};
            var questions = data.field;
            for(var attr in questions){
                var s = questions[attr];
                o[attr.toString()] = s;
            }
            o["homeworkID"] = parseInt(hwid);
            var json = JSON.stringify(o);

            function formToJson(formData){
                var objData = {};

                for (var entry in formData.entries()){
                    objData[entry[0]] = entry[1];
                }
                return objData;
            };

            //var inMsg=JSON.stringify(data.field);
            //var fieldMsg=JSON.parse(inMsg);
            //var formMsg=formToJson(data);
            //var fieldMsg=JSON.parse(data.field);

            //console.log(JSON.stringify(data.field));

            function emerge(msg1, msg2) {
                var resultJsonObject={};
                for(var attr in msg1){
                    resultJsonObject[attr]=msg1[attr];
                }
                for(var attr in msg2){
                    resultJsonObject[attr]=msg2[attr];
                }
                return resultJsonObject;
            };
            //console.log(JSON.stringify(fieldMsg));

            function extend(des, src, override){
                if(src instanceof Array){
                    for(var i = 0, len = src.length; i < len; i++)
                        extend(des, src[i], override);
                }
                for( var i in src){
                    if(override || !(i in des)){
                        des[i] = src[i];
                    }
                }
                return des;
            }

            // fieldMsg.unshift(homeworkMsg);
            // console.log(fieldMsg);

            //var postdata=emerge(homeworkMsg,fieldMsg);
            //var postdata={"homeworkID":"3","7":"hello","8":"world"};
            //console.log(JSON.stringify(postdata));
            //alert(JSON.stringify(postdata));

            //postdata = JSON.stringify(postdata);

            //layer.alert(JSON.stringify(postdata), {
            //    title: '最终的提交信息'
           // });


            $.ajax({
                type: "POST",//这里请求的地址未给出
                url: "http://localhost:8080/sq/submitAllQuestion",//请求程序页面
                async: false,//当有返回值以后才会进行后面的js程序。
                data: json,//请求需要发送的处理数据
                dataType:"json",
                contentType:"application/json",
                success: function (msg) {
                    if(msg.flag===1){
                        alert("提交成功");
                    }else if(msg.flag===0){
                        alert("提交失败");
                    }
                },
                error:function(msg){
                    alert("提交错误,原因是"+JSON.stringify(msg));
                }
            });

            return false;
        });

        // //表单取值
        // layui.$('#LAY-component-form-getval').on('click', function(data){
        //     layer.alert(JSON.stringify(data.field), {
        //         title: '最终的提交信息'
        //     });
        // });

    })
});

var questions;

function initialPage(data) {
    var length = data.length;
    var addHtml = "";
    var i;
    for (i = 0; i < length; i++) {
        addHtml += "<div class=\"layui-form-item layui-form-text\" style=\"width:800px;\">\n" +
            "            <label class=\"layui-form-label\" style=\"height: auto;\">\n" +
            "                <h4>作业" + (i + 1) + "</h4>\n" +
            "                <h6>" + data[i].content + "</h6>\n" +
            "            </label>\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <textarea placeholder=\"请输入内容\" class=\"layui-textarea\" " +
            "id=\"answer" + i + "\" name=\"" + data[i].questionId + "\"></textarea>\n" +
            "            </div>\n" +
            "        </div>";
    }
    $("form").prepend(addHtml);
}

// var testSubmitNotOkData = {
//     "questionList": [
//         {
//             "questionID": "20201007",
//             "questionContent": "课本P40页第二题"
//         },
//         {
//             "questionID": "20201008",
//             "questionContent": "课本P40页第五题"
//         }]
// };

