<%--
  Created by IntelliJ IDEA.
  User: 雷蕾
  Date: 2020/4/29
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="layui/layui.js"></script>

    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/login.css">

</head>
<body style="background:url(img/bg.jpg) no-repeat;background-size: 100%">

<div class="layui-form layui-form-pane layui-admin-login">
    <div class="layui-admin-login-header" style="text-align:center;color:black">
        <h1>欢迎登陆</h1>
    </div>
    <br />
    <br />
    <br />
    <div class="layui-form-item">
        <label class="layui-form-label" style="color:black">
            <i class="layui-icon layui-icon-username"></i>用户名
        </label>
        <div class="layui-input-block">
            <input required lay-verify="required" id="username" class="layui-input" type="text" placeholder="请输入用户名" autocomplete="off" style="color:black" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="color:black">
            <i class="layui-icon layui-icon-password"></i>密码
        </label>
        <div class="layui-input-block">
            <input required lay-verify="required" id="password" class="layui-input" type="password" placeholder="请输入密码" autocomplete="off" style="color:black" />
        </div>
    </div>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label" style="color:black">
                选择身份
            </label>
            <div class="layui-input-block">
                <select name="role">
                    <option value=""></option>
                    <option value="student">学生</option>
                    <option value="teacher">教师</option>
                </select>
            </div>
        </div>
    </form>

    <div class="layui-form-item">
        <a id="forget_pwd" style="margin-top:10px;float:right;color:#01AAED">忘记密码？</a>
    </div>

    <div class="layui-form-item" style="text-align: center">
        <button type="button" id="login" class="layui-btn layui-btn-normal layui-btn-radius" >登录</button>
        <button type="button" class="layui-btn layui-btn-normal layui-btn-radius" onclick="window.location.href='register.jsp'">注册</button>
    </div>


</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquerysession.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
    });

    $(function ()  {
        $("#login").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();
            var role=$("select[name='role']").val();
            console.log(username);
            console.log(password);
            console.log(role);
            if (!username) {
                alert("账号必填!");
                $("#username").focus();//获取焦点
                return;
            }
            if (!password) {
                alert("密码必填!");
                $("#password").focus();//获取焦点
                return;
            }

            $.ajax({
                type: "POST",
                url: "login/userLogin",//请求程序页面
                async: false,//当有返回值以后才会进行后面的js程序。
                data: {
                    "phone":username,
                    "password":password,
                    "role":role,
                },//请求需要发送的处理数据
                success: function (msg) {
                    if (msg.flag == "-1") {
                        alert("用户密码错误");
                    } else if (msg.flag == "-2") {
                        alert("用户不存在");
                    } else if (msg.flag == "0") {
                        if (role=="student") window.location.href = 'pages/student/studentClass.html';
                        else window.location.href='pages/teacher/index.html';
                    }

                },
                error:function(xhr){alert(xhr.responseText)}
            });
        });
    });



</script>



</body>
</html>


