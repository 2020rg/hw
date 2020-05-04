$(document).ready(function () {
    layui.use('element', function () {
        var element = layui.element;
        //事件监听
        element.on('tab(homework-statics)', function (data) {
            console.log(data);
        });
    });
    layui.use('layer', function () {
        var $ = layui.jquery
            , layer = layui.layer //
    });

    $(".toHasChecked").click(function () {

        var data = getHasCheckedData(score_data);
        layer.open({
            type: 1,
            title: '已批改作业详情',
            offset: 'auto',
            skin: 'layui-layer-molv',
            area: ['500px', '300px'],
            closeBtn: 1,
            shadeClose: true,
            content: data
        });

    });

    $(".checkHomework").click(function () {
        alert("查看作业并提交");
        //这里与查看未批改作业操作一致
        window.location.href="question.html";
    });


    $(".toNotChecked").click(function () {
        alert("查看未批改作业");
        window.location.href="question.html";
    });


})


function getHasCheckedData(datas) {
    var str;
    var self_score = "<h3>个人得分：" + datas.self_score + "</h3>";
    var avg_score = "<h3>平均得分：" + datas.average_score + "</h3>";
    var score_table_name="<h3 style='text-align:center'>成绩分布</h3>";
    var score_table_header = "<table class='layui-table' lay-skin='line' style='border:2px black'>" +
        "<colgroup>" +
        "<col width='70px'>" +
        "<col width='70px'>" +
        "<col>" +
        "</colgroup>" +
        "<thead>" +
        "<tr>" +
        "<th>分数段</th>" +
        "<th>人数百分比</th>" +
        "</tr> " +
        "</thead>";
    var score_table_body =
        "<tbody>" +
        "<tr>" +
        "<td>"+score_data.score_scuttered[0].level+"</td>" +
        "<td>"+score_data.score_scuttered[0].percent+"</td>" +
        " </tr>" +
        " <tr>" +
        "<td>"+score_data.score_scuttered[1].level+"</td>" +
        "<td>"+score_data.score_scuttered[1].percent+"</td>" +
        "</tr>" +
        " <tr>" +
        "<td>"+score_data.score_scuttered[2].level+"</td>" +
        "<td>"+score_data.score_scuttered[2].percent+"</td>" +
        "</tr>" +
        " <tr>" +
        "<td>"+score_data.score_scuttered[3].level+"</td>" +
        "<td>"+score_data.score_scuttered[3].percent+"</td>" +
        "</tr>" +
        " <tr>" +
        "<td>"+score_data.score_scuttered[4].level+"</td>" +
        "<td>"+score_data.score_scuttered[4].percent+"</td>" +
        "</tr>" +
        "</tbody></table>";
        var wrong_table_header="<h3 style='text-align:center'>我的错题</h3>"+
        "<table class='layui-table' lay-skin='line' style='border:2px black'>" +
        "<colgroup>" +
        "<col width='15%'>" +
        "<col width='25%'>" +
        "<col width='60%'>" +
        "<col>" +
        "</colgroup>" +
        "<thead>" +
        "<tr>" +
        "<th>题号</th>" +
        "<th>本班错误人数</th>" +
        "<th>提示</th>" +
        "</tr> " +
        "</thead>";
        var wrong_table_body= "<tbody>" +
        "<tr>" +
        "<td>"+score_data.self_wrong[0].index+"</td>" +
        "<td>"+score_data.self_wrong[0].all_wrong+"</td>" +
        "<td>"+score_data.self_wrong[0].message+"</td>" +
        " </tr>" +
        " <tr>" +
        "<td>"+score_data.self_wrong[1].index+"</td>" +
        "<td>"+score_data.self_wrong[1].all_wrong+"</td>" +
        "<td>"+score_data.self_wrong[1].message+"</td>" +
        "</tr>" +
        "</tbody></table>";
    str = self_score+avg_score+score_table_name+score_table_header
    +score_table_body+wrong_table_header+wrong_table_body;
    return str;
}


//json格式数据测试
var score_data = {
    "self_score": "90",
    "average_score": "76.9",
    "score_scuttered": [
        { "level": "90+", "percent": "6.06%" },
        { "level": "80~90", "percent": "36.36%" },
        { "level": "70~80", "percent": "36.36%" },
        { "level": "60~70", "percent": "13.64%" },
        { "level": "60-", "percent": "4.55%" }
    ],
    "self_wrong": [
        { "index": 1, "all_wrong": 30, "message": "这是个典型问题，再研究一下吧" },
        { "index": 3, "all_wrong": 4, "message": "这是个个人问题，再细心一点" }
    ]
}


/* * *
 * 查看已批作业详情时，后应该为数据表格（错题表格）
 <table id="demo" lay-filter="test"></table>
 layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 312
    ,url: '/demo/table/user/' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
      ,{field: 'username', title: '用户名', width:80}
      ,{field: 'sex', title: '性别', width:80, sort: true}
      ,{field: 'city', title: '城市', width:80} 
      ,{field: 'sign', title: '签名', width: 177}
      ,{field: 'experience', title: '积分', width: 80, sort: true}
      ,{field: 'score', title: '评分', width: 80, sort: true}
      ,{field: 'classify', title: '职业', width: 80}
      ,{field: 'wealth', title: '财富', width: 135, sort: true}
    ]]
  });
  
});

https://www.layui.com/doc/modules/table.html
 * * */
