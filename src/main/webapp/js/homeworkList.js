$(document).ready(function () {

    // $.get("http://localhost:8080/homework/queryHomewokByTeacherId",function(data){
    //     initialPage(data);
    // });

    $.ajax({
        type:"POST",
        url:"http://localhost:8080/homework/queryHomeworkByTeacherId",
        //async:false,
        success:function (msg) {
            //msg.SubmitOkNum=msg.SubmitOkNum-msg.HasCheckedNum;
            initialPage(msg);
            console.log(JSON.stringify(msg));
        },
        error:function () {
            alert("获取作业数据失败");
        }
    });
    //initialPage(initialData);

    layui.use('element', function () {
        var element = layui.element;
        //事件监听
        element.on('tab(homework)', function (data) {
            console.log(data);
        });
    });
    layui.use('layer', function () {
        var $ = layui.jquery
            , layer = layui.layer //
    });


    
    //flag 0
    $(".checkHomework").click(function () {
        alert("查看作业并批改");
        var id=$(this).attr("id");
        var hwMsg={"homeworkID":id};
        var StriMsg=JSON.stringify(hwMsg);
        console.log(StriMsg);
        window.location.href="homework_correct.html?Homework="+ window.encodeURIComponent(StriMsg);
    });
});

function initialPage(datas) {
    //alert("inital is processed");
    //hw-info
    var info =
        "<p class=\"fly-home-info\"><span style=\"font-size: 20px;\">已提交作业： </span><span style=\"font-size: 20px;color: #F34743;\">" + datas.SubmitOkNum + "</span></p>" +
    "<p class=\"fly-home-info\"><span style=\"font-size: 20px;\">未提交作业： </span><span style=\"font-size: 20px;color: #F34743;\">" + datas.SubmitNotOkNum + "</span></p>" +
    "<p class=\"fly-home-info\"><span style=\"font-size: 20px;\">已批改作业： </span><span style=\"font-size: 20px;color: #F34743;\">" + datas.HasCheckedNum + "</span></p>"
    $("#homeworkInformation").append(info);

    var i = 0;
    //SubmitOkList
    var list1 = "";
    var length1 = datas.SubmitOkCheckedList.length;
    for (i = 0; i < length1; i++) {
        list1 +=
            "<li class=\"layui-col-md layui-col-xs\">" +
            "<a href=\"javascript:;\" class=\"x-admin-backlog-body\">" +
            "<p><cite>" + datas.SubmitOkCheckedList[i].courseName +
            " " + datas.SubmitOkCheckedList[i].studentId +
            " " + datas.SubmitOkCheckedList[i].studentName + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>" + datas.SubmitOkCheckedList[i].homeworkID + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>" + datas.SubmitOkCheckedList[i].homeworkIntroduce + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>截止时间：" + datas.SubmitOkCheckedList[i].homeworkDDL + "</cite></p>" +
            "</a>" +
            "</li>";

    }
    //$("#SubmitOkList").append(list1);

    //NotCheckedList
    var list2 = "";
    var length2 = datas.SubmitOkNotCheckList.length;
    for (i = 0; i < length2; i++) {
        list2 +=
            "<li class=\"layui-col-md layui-col-xs\">" +
            "<a href=\"javascript:;\" class=\"x-admin-backlog-body\">" +
            "<p><cite>" + datas.SubmitOkNotCheckList[i].courseName +
            " " + datas.SubmitOkNotCheckList[i].studentId +
            " " + datas.SubmitOkNotCheckList[i].studentName + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>" + datas.SubmitOkNotCheckList[i].homeworkID + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>" + datas.SubmitOkNotCheckList[i].homeworkIntroduce + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>截止时间：" + datas.SubmitOkNotCheckList[i].homeworkDDL + "</cite></p>" +
            "</a>" +
            "</li>";
    }
    $("#HasNotCheckedList").append(list2);

    //HasCheckedList
    var list3 = "";
    var length3 = datas.SubmitOkCheckedList.length;
    for (i = 0; i < length3; i++) {
        list3 +=
            "<li class=\"layui-col-md layui-col-xs\">" +
            "<a href=\"javascript:;\" class=\"x-admin-backlog-body\">" +
            "<p><cite>" + datas.SubmitOkCheckedList[i].courseName +
            " " + datas.SubmitOkCheckedList[i].studentId +
            " " + datas.SubmitOkCheckedList[i].studentName + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>" + datas.SubmitOkCheckedList[i].homeworkID + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>" + datas.SubmitOkCheckedList[i].homeworkIntroduce + "</cite></p>" +
            "<p class=\"fly-home-info\"><span>截止时间：" + datas.SubmitOkCheckedList[i].homeworkDDL + "</cite></p>" +
            "</a>" +
            "</li>";
    }
    $("#HasCheckedList").append(list3);
}