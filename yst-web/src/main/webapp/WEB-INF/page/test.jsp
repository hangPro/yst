    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="ctx" value="${pageContext.request.contextPath}"/>
        <!DOCTYPE html>
        <!-- saved from url=(0029)https://m.bzy.ai/activity/190 -->
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0" />
        <title>邀请你加入</title>
        <meta name="keywords" content="" />
        <meta name="description" content=""/>
        <script type="text/javascript" async="" src="${ctx}/skin/Scripts/vds.js"></script>
        <script type="text/javascript" src="${ctx}/skin/Scripts/bw-loader-415.6.31.js"></script>
        <script type="text/javascript" src="${ctx}/skin/Scripts/vds-wx-plugin.js"></script>
        <script type="text/javascript" src="${ctx}/skin/Scripts/js/jquery.min.js"></script>
        <script type="text/javascript" src="${ctx}/skin/Scripts/js/common.js"></script>
        <link href="${ctx}/skin/demo/app.e53e9ea45d90bc46196424ecef69afba.css" rel="stylesheet" />
        <link href="${ctx}/skin/demo/style.css" rel="stylesheet" />
        </head>
        <style type="text/css">
        ul li{list-style: none;}
        li{float: left;
            padding: 2px 5px ;
            border-width:2px;
            border: 1px solid #dadada;
            margin: 2px 2px;border-radius:20px;
            border-color: rgba(0, 0, 0, 0.35);
            color: #000;
            }
        .info h4{font-weight: 600}
        a{
            font-size:12px;
            font-weight:300;
            color:#999;
            padding:7px 18px;
            }
            .shadowDiv {
            -moz-box-shadow: inset 0 0 10px #CCC;
            -webkit-box-shadow: inset 0 0 10px #CCC;
            box-shadow: inset 0 0 10px #CCC;
            }
        </style>
        <body>
        <div id="app">
        <div class="">
        <div class="center-cropped" style='background-image: url("../uploads/180914/weixin.jpg");'></div>
        <div class="info">


        <div class="shadowDiv" style="margin-top:10px;float: left;">
        <h4>群介绍</h4>
        <pre>8.23唯品会开放平台多品类招商会，欢迎大家入群交流学习！！！</pre>
        </div>

        <div class="shadowDiv" style="display: block;margin-top: 10px;background: #fff;border: 1px solid #f1f1f1;float: left;width: 95%">
        <h4 style="float: left;">温州跨境电商交流集群</h4>
        <ul style="width: 100%;height: 100%;float: left;">
        <li><a href="/plus/view.php?aid=215">温州跨境＆外贸01群</a></li>
        <li><a href="/plus/view.php?aid=25">温州跨境＆外贸02群</a></li>
            <li><a href="/plus/view.php?aid=24">温州跨境＆外贸03群</a></li>
            <li><a href="/plus/view.php?aid=21">美国本土免费礼物Amazon群</a></li>
        </ul>
        </div>
        <div class="shadowDiv" style="display: block;margin-top: 10px;background: #fff;border: 1px solid #f1f1f1;float: left;width: 95%">
        <h4 style="float: left;">温州跨境电商交流集群</h4>
        <ul style="width: 100%;height: 100%;float: left;">
        <li><a href="/plus/view.php?aid=215">温州跨境电商1群</a></li>
        <li><a href="/plus/view.php?aid=25">温州跨境电商2群</a></li>
        <li><a href="/plus/view.php?aid=24">温州跨境电商3群</a></li>
        <li><a href="/plus/view.php?aid=23">温州跨境电商4群</a></li>
        <li><a href="/plus/view.php?aid=21">温州跨境电商5群</a></li>

        </ul>
        </div>

        <div class="shadowDiv" style="margin: 10px 0px 30px;float: left; margin-bottom: 80px;">
        <h4>已入群群员(2000)</h4>
        <div class="weui-flex">

        </div>
        </div>
        </div>
        <div class="wechat" style="position: fixed; bottom: 10px; right: 12px; left: 12px;">
        <a href="${ctx}/page/list?tid=1&aid=208" class=""><span class="apply">点击申请入群</span></a>
        <!---->
        </div>
        </div>
        </div>
        <script type="text/javascript" src="${ctx}/skin/Scripts/manifest.c85f10cce6721fac5617.js"></script>
        <script type="text/javascript" src="${ctx}/skin/Scripts/vendor.40966f3cf74f0d1a9528.js"></script>
        <script type="text/javascript" src="${ctx}/skin/Scripts/app.43684113489494f838d1.js"></script>

        <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
        <div class="vux-toast">
        <div class="weui-mask_transparent" style="display: none;"></div>
        <div class="weui-toast weui-toast_success" style="width: 7.6em; display: none;">
        <i class="weui-icon-success-no-circle weui-icon_toast"></i>
        <p class="weui-toast__content"></p>
        </div>
        </div>
        <script src="${ctx}/skin/Scripts/bw-send-415.6.31.js"></script>
        <script type="text/javascript" src="${ctx}/skin/demo/saved_resource" async=""></script>

        <!-- 语音播放 -->
        <script type="text/javascript">
        $(function () {
        var dshiqi = null;

        //录音播放
        $(".askinput").on("click", ".r_yuyin", function () {
        //先暂停其他的
        $(this).parent(".add_yuyin").siblings().find("s").removeClass("bofang");
        let audio = $(this).find("audio")[0],
        time = $(this).data("time");
        if (audio.paused) {
        audio.play(); //audio.play();// 这个就是播放
        $(this).find("s").addClass("bofang");
        dshiqi = setTimeout(function () { //dshiqi是外层定义好的一个变量！
        $(this).find("s").removeClass("bofang"); //播放完毕去除动画
        }, time * 1000)
        } else {
        audio.pause(); // 这个就是暂停
        $(this).find("s").removeClass("bofang");
        clearTimeout(dshiqi);
        }
        })


        })
        </script>
        <script>
        wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: 'wx5f5fdfa4cdcafef2', // 必填，公众号的唯一标识
        timestamp: "1539235864", // 必填，生成签名的时间戳
        nonceStr: 'BdTfyWH0EiIF175A', // 必填，生成签名的随机串
        signature: '544d75aa688f770c0ba14f8fdfafa70da1073e23',// 必填，签名，见附录1
        jsApiList: [
        'checkJsApi',
        'onMenuShareTimeline',
        'onMenuShareAppMessage',
        'onMenuShareQQ',
        'onMenuShareWeibo'
        ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });
        var wstitle = "邀请你加入"; //此处填写分享标题
        var wsdesc = "“马凯跃”邀请你加入8.23唯品会开放平台多品类招商会，进入可查看详情。"; //此处填写分享简介
        var wslink = "http://www.wzdssq.com/plus/view.php?aid=208"; //此处获取分享链接
        var wsimg = "http://www.wzdssq.com/uploads/180728/1-1PHQ53251125.jpg"; //此处获取分享缩略图

        </script>
        <script type="text/javascript" src="${ctx}/skin/demo/wxshare.js"></script>
        <!-- 语音播放 -->
        </body>
        </html>