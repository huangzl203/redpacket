<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<meta charset="utf-8" />
<%@ include file="include/top.jsp"%>
<style type="text/css">
    html, body { color:#222; font-family:Microsoft YaHei, Helvitica, Verdana, Tohoma, Arial, san-serif; margin:0; padding: 0; text-decoration: none; }
    img { border:0; }
    ul { list-style: none outside none; margin:0; padding: 0; }
    body {
        background-color:#eee;
    }
    body .mainmenu:after { clear: both; content: " "; display: block; }
 
    body .mainmenu li{
        float:left;
        margin-left: 2.5%;
        margin-top: 2.5%;
        width: 30%; 
        border-radius:3px;
        overflow:hidden;
    }
 
    body .mainmenu li a{ display:block;  color:#FFF;   text-align:center }
    body .mainmenu li a b{
        display:block; height:80px;
    }
    body .mainmenu li a img{
        margin: 15px auto 15px;
        width: 50px;
        height: 50px;
    }
 
    body .mainmenu li a span{ display:block; height:30px; line-height:30px;background-color:#FFF; color: #999; font-size:14px; }
 
    body .mainmenu li:nth-child(8n+1) {background-color:#36A1DB}
    body .mainmenu li:nth-child(8n+2) {background-color:#678ce1}
    body .mainmenu li:nth-child(8n+3) {background-color:#8c67df}
    body .mainmenu li:nth-child(8n+4) {background-color:#84d018}
    body .mainmenu li:nth-child(8n+5) {background-color:#14c760}
    body .mainmenu li:nth-child(8n+6) {background-color:#f3b613}
    body .mainmenu li:nth-child(8n+7) {background-color:#ff8a4a}
    body .mainmenu li:nth-child(8n+8) {background-color:#fc5366}
</style>
</head>
 
<body>
    <ul class="mainmenu">
        <li><a href="/" ><b><img src="images/tb01.png" /></b><span>个人中心</span></a></li>
        <li><a href="/userTree/view.html" ><b><img src="images/tb02.png" /></b><span>团队建设</span></a></li>
        <li><a href="/upgrade/toApply.html" ><b><img src="images/tb03.png" /></b><span>升级申请</span></a></li>
        <li><a href="/upgrade/listAudit.html" ><b><img src="images/tb04.png" /></b><span>审批</span></a></li>
        <li><a href="/upgrade/listApply.html" ><b><img src="images/tb05.png" /></b><span>申请记录</span></a></li>
        <li><a href="/" ><b><img src="images/tb06.png" /></b><span>私人记录</span></a></li>
        <li><a href="/" ><b><img src="images/tb06.png" /></b><span>规则</span></a></li>
        <li><a href="/" ><b><img src="images/tb07.png" /></b><span>公告</span></a></li>
        <li><a href="/" ><b><img src="images/tb08.png" /></b><span>在线留言</span></a></li>         
    </ul>
    <!-- 欢迎大家关注我的博客！如有疑问,请加QQ群：135430763共同学习！ -->
    <%@ include file="include/foot.jsp"%>
    <script  type="text/javascript">
		$(function(){
			$("nav ul li").eq(0).addClass("current");
		})
	</script>
</body>
</html>