<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="Pragma" contect="no-cache">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - jqGird</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/animate.css/3.5.2/animate.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>

    <link href="${ctx}/assets/css/imggrid.css" rel="stylesheet" />
    <script src="${ctx}/assets/js/imggrid.js"></script>
    <script src="${ctx}/assets/js/jquery.museum.js"></script>
</head>
<body style="">
    <div style="max-width: 886px;background-color:#f5f5f5;border-color:#ddd;padding:10px 15px;border-top-left-radius:3px;border-top-right-radius:3px;">
    款号：<input type="text" id="name" />
    大类：<select id="mDimNew11Id"></select>
    性别：<select id="mDimNew13Id"></select>
    品种：<select id="mDimNew14Id"></select>
    组织：<select id="mDimNew15Id"></select>
    年份：<select id="mDim13Id"></select>
    <input type="button" id="queryBtn" onclick="queryBtn()" value="查询"/></div>
    <div id="imggrid" class="row"></div>
    <script>
    //获取属性
    function dimDate(){
        $.ajax({
            type:'post',
            url:'${ctx}/dimNew/getDimNewList',
            data:{},
            cache:false,
            dataType:'json',
            success:function(data){
              var result = data.data;
              var html = "<option value>全部</option>";
              for (var i = 0;i<result.bigClassList.length;i++){
                html += '<option value="'+result.bigClassList[i].id+'">'+result.bigClassList[i].attribname+'</option>';
              }
              $("#mDimNew11Id").html(html);
              html = "<option value>全部</option>";
              for (var i = 0;i<result.sexList.length;i++){
                html += '<option value="'+result.sexList[i].id+'">'+result.sexList[i].attribname+'</option>';
              }
              $("#mDimNew13Id").html(html);
              html = "<option value>全部</option>";
              for (var i = 0;i<result.pzList.length;i++){
                html += '<option value="'+result.pzList[i].id+'">'+result.pzList[i].attribname+'</option>';
              }
              $("#mDimNew14Id").html(html);
              html = "<option value>全部</option>";
              for (var i = 0;i<result.zzList.length;i++){
                html += '<option value="'+result.zzList[i].id+'">'+result.zzList[i].attribname+'</option>';
              }
              $("#mDimNew15Id").html(html);
              html = "<option value>全部</option>";
              for (var i = 0;i<result.yearList.length;i++){
                html += '<option value="'+result.yearList[i].id+'">'+result.yearList[i].attribname+'</option>';
              }
              $("#mDim13Id").html(html);
            }
        });
    }
    dimDate();
    function queryBtn(){
        //加载分页插件
        var mDimNew11Id = $("#mDimNew11Id").val()=='undefined'?'':$("#mDimNew11Id").val();
        var mDimNew13Id = $("#mDimNew13Id").val()=='undefined'?'':$("#mDimNew13Id").val();
        var mDimNew14Id = $("#mDimNew14Id").val()=='undefined'?'':$("#mDimNew14Id").val();
        var mDimNew15Id = $("#mDimNew15Id").val()=='undefined'?'':$("#mDimNew15Id").val();
        var mDim13Id = $("#mDim13Id").val()=='undefined'?'':$("#mDim13Id").val();
        var name = $("#name").val()=='undefined'?'':$("#name").val();
        $('#imggrid').imgGrid({
            title: '样衣查询',
            type: 'GET',//GET|POST
            url: '${ctx}/boot/pageList',//ajax URL
            params: {mDimNew11Id:mDimNew11Id,
                    mDimNew13Id:mDimNew13Id,
                    mDimNew14Id:mDimNew14Id,
                    mDimNew15Id:mDimNew15Id,
                    mDim13Id:mDim13Id,
                    name:name},//url参数
            height: '900px',
            width: '100%',
            img: {width: '203px',height:'350px', animate: 'zoomIn' },//图片宽度，及动画效果
            onClick: function (obj, index, item) {//点击图片事件
            },
            render: function (item, index) {//自定义显示图片
                var str = '<img style="height:300px;" id="img_'+index+'" src="' + item.bigImgUrl + '" />';
                str += '<h3>'+item.name+'</h3>';
                return str;
            }
        });

        }
    queryBtn();
    </script>
</body>



</html>
