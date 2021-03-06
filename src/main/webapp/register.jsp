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
<script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquerysession.js"></script>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="css/register.css">
<body style="background:url(img/bg.jpg) no-repeat;background-size: 100%">
    <div id=register class="layui-form layui-form-pane layui-admin-register">
    <div class="layui-admin-register-header" style="text-align:center;color:black">
        <h1>注册</h1>
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
                <i class="layui-icon layui-icon-cellphone"></i>手机号
            </label>
            <div class="layui-input-block">
                <input required lay-verify="required" id="tel" class="layui-input" type="text" placeholder="请输入手机号" autocomplete="on" style="color:black" />
            </div>
        </div>

        <form class="layui-form" action="">
        <div class="layui-form-item " pane="">
            <label class="layui-form-label">请选择身份</label>
            <div class="layui-input-block" >
                <input name="role" title="教师" type="radio" checked="" value="teacher">
                <input name="role" title="学生" type="radio" value="student">
            </div>
        </div>
        </form>
    <div class="layui-form-item">
        <label class="layui-form-label" style="color:black">
            <i class="layui-icon layui-icon-password"></i>密码
        </label>
        <div class="layui-input-block">
            <input required lay-verify="repass" id="password" class="layui-input" type="password" placeholder="请输入密码" autocomplete="off" style="color:black" />
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="color:black">
                <i class="layui-icon layui-icon-password"></i>确认密码
            </label>
            <div class="layui-input-block">
                <input required lay-verify="repass" id="password2" class="layui-input" type="password" placeholder="请输入密码" autocomplete="off" style="color:black" />
            </div>
        </div>



    <div class="layui-form-item" style="text-align: center">
        <button type="button" id="rButton" class="layui-btn layui-btn-normal layui-btn-radius">注册</button>
        <button type="button" class="layui-btn layui-btn-normal layui-btn-radius" onclick="window.location.href='index.jsp'">返回登陆</button>
    </div>


</div>
<script>
    layui.use(['form'], function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        form.verify({
            //确认密码
            repass: function(value, item){
                if($('#password').val()!=$('#password2').val()){
                    return '密码不同';
                }
            }
        });
        form.render();
    });

    $(function ()  {
    $("#rButton").click(function(){

    var username = $("#username").val();
    var cellphone = $("#tel").val();
    var role=$("input:radio[name='role']:checked").val();
    var password=$("#password").val();
    var password2=$("#password2").val();

    //alert(username+cellphone+role+password);

    if(password==null||password.length===0)
    {
    alert("密码不能为空");
    }
    else if(username==null||username.length===0)
    {
    alert("用户名不能为空");
    }
    else if(cellphone==null||cellphone.length===0)
    {
    alert("电话不能为空");
    }
    else if(password!==password2)
    {
    alert("密码和确认密码不一致");
    }
    else
    {
    $.ajax({
    type:"POST",
    url:"http://localhost:8080/login/signup",
    async:false,
    data:{
    "username":username,
    "cellphone":cellphone,
    "role":role,
    "password":password
    },
    success:function (msg) {
    if(msg.flag==0){
    alert("注册成功！");
    window.location.href="http://localhost:8080";
    }
    else
    {
    alert("注册失败");
    }
    },
    error:function () {
    alert("请求失败");
    }
    });
    }
    });
    });

</script>

</body>
</html>
