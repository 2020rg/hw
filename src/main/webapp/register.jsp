<%--
  Created by IntelliJ IDEA.
  User: 雷蕾
  Date: 2020/4/29
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<script type="text/javascript" src="javascript/layui.js"></script>
<link rel="stylesheet" href="javascript/layui.css">
<body style="background:url(javascript/bg.jpg) no-repeat;background-size: 100%">
    <div id="register" style="text-align: center;margin-top: 200px">
        <h1>注册</h1>
        <br/>
        <div class="layui-form-item">
            <div class="layui-inline">
                <lable class="layui-form-label" >用户名：</lable>
                <!--<i class="layui-icon layui-icon-username" style="font-size: 30px"></i>-->
                <input type="text" id="username" autocomplete="on" placeholder="请输入用户名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-inline">
            <label class="layui-form-label">请选择身份</label>
            <div class="layui-input-block">
                <input type="radio" name="auth" value="student" title="学生">
                <input type="radio" name="auth" value="teacher" title="老师">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <lable class="layui-form-label">手机号：</lable>
                <!--<i class="layui-icon layui-icon-cellphone"></i>-->
                <input type="text" id="telphone" autocomplete="on" placeholder="请输入手机号" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <lable class="layui-form-label">密码：</lable>
                <!--<i class="layui-icon layui-icon-password"></i>-->
                <input type="text" id="password1" type="password" placeholder="请输入密码" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <lable class="layui-form-label">确认密码：</lable>
                <!--<i class="layui-icon layui-icon-password"></i>-->
                <input type="text" id="password2" type="password" placeholder="请再次输入密码" class="layui-input">
            </div>
        </div>

        <div class="layui-input-inline">
            <br/><br/>
            <button type="button" class="layui-btn layui-btn-normal layui-btn-radius">注册</button>
    </div>

</body>
</html>
