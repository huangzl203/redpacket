<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../common/head.jsp" %>
	<head>
		<title>推荐会员</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Cache-Control" content="no-cache" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="MobileOptimized" content="320" />
		<link href="${fileServerUrl }/res/css/eLoan.css?v=${jsversion}" rel="stylesheet" type="text/css">
	</head>
<body class="bg-2">
<header class="top-bar">
		<a href="<c:url value='/redPack/personalCenter.html'/>">
		<span class="icon-back">
			</span>
		</a>
		<span>推荐会员</span>
	</header>
	<section class="sign-area">
		<form action="${loginServerUrl }/account/register.do" id="regForm" method="post">
			<div class="sign-style br-3">
				<span class="sign-lable pr75">真实姓名</span>
				<input type="text" name="userName" id="userName" placeholder="请输入您的真实姓名">
			</div>
			<div class="sign-style br-2">
				<span class="sign-lable">手机号码</span>
				<input type="text" id="mobilePhone" name="mobilePhone" placeholder="请输入注册手机号码">
			</div>
			<div class="sign-sub">
				<input type="button" id="regBtn" value="立即注册">
			</div>
		</form>
	</section>
	<%@ include file="../include/foot.jsp"%>
	<script>
		$(function(){
			$("nav ul li").eq(2).addClass("current");
			sbh();
			$("#regBtn").bind("click",function(){
				var userName = $("#userName").val();
				if(userName==null || userName.length==0){
					popWindow("请输入真实姓名");
					return;
				}
			 	if (!/^[\u4E00-\u9FA5]{2,5}$/ig.test(userName)) {
				 	popWindow("请输入2-5字的中文");
					return ;
				}  
				
				var mobilePhone = $('#mobilePhone').val();
				if (mobilePhone == "" || mobilePhone.length==0) {
					popWindow("请输入手机号");
					return;
				}
                var re =new RegExp("/^1[3|5|7|8|][0-9]{9}$/");
                if (!/^0{0,1}(13[0-9]|15[0-9]|18[0-9]|14[0-9]|17[0-9])[0-9]{8}$/.test(mobilePhone)){
                     popWindow("输入手机号的格式有误");
                     return;
                }
				$(this).attr('disabled',true);
				var options = {type:"POST",url:"${loginServerUrl }/account/register.html",data:{userName:userName,mobilePhone:mobilePhone,referenceId:'${userDo.id}'}};
				ajaxRequest(options,function(data){
					if(data.result=='注册成功'){
						window.location.href="${loginServerUrl }/redPack/personalCenter.html";
					}else{
						popWindow(data.result);
						$('#regBtn').removeAttr('disabled');
					}
				});
			});
		})
	</script>
</body>
</html>