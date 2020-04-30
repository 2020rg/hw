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
    <script type="text/javascript" src="../javascript/layui.js"></script>
    <link rel="stylesheet" href="../javascript/layui.css">
  </head>
  <body style="background:url(../javascript/bg.jpg) no-repeat;background-size: 100%">
    <div id="login" style="text-align: center;margin-top: 300px">
      <h1>欢迎登录</h1>
      <br/><br/>
      <div class="layui-form-item">
        <div class="layui-inline">
          <lable class="layui-form-label" >用户名：</lable>
          <!--<i class="layui-icon layui-icon-username"></i>-->
          <input type="text" id="username" autocomplete="on" placeholder="请输入用户名" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <lable class="layui-form-label">密码：</lable>
          <!--<i class="layui-icon layui-icon-password"></i>-->
          <input type="text" id="password" type="password" autocomplete="on" placeholder="请输入密码" class="layui-input">
        </div>
      </div>
      <br/><br/>
      <div class="layui-form-item">
        <div class="layui-inline">
          <select name="auth">
            <option value="">请选择身份</option>
            <option value="学生">学生</option>
            <option value="老师">老师</option>
          </select>
        </div>
        <input type="checkbox" name="remember" title="记住密码" style="margin-right: 0px">记住密码
        <br/><br/>
      </div>

      <button type="button" class="layui-btn layui-btn-normal layui-btn-radius">登录</button>
      <button type="button" class="layui-btn layui-btn-normal layui-btn-radius" onclick="window.location.href='register.jsp'">注册</button>
    </div>
  </body>
</html>


