$(document).ready(function(){
    layui.use('element', function(){
        var element = layui.element;
        
        //事件监听
        element.on('tab(homework-resource)', function(data){
          console.log(data);
        });
      });
})