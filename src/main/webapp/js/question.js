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
            /*
            
            */

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
})