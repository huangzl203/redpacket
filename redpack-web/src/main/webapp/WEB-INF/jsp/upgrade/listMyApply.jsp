<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/top.jsp"%>
	<title>申请记录</title>
</head>
	<style>
.err{
  width: 100%;
  display: block;
  color: #f00;
  position: absolute;
  left: 0;
  padding: 0 80px;
  margin-top: -18px;
}
</style>
<body>
    <form action="modifyUpdata" method="post" >
	<section class="p1">
		<c:forEach items="${upgradeList}" var="upgradeDo">
		<article class="loan_inf">
			收款人编号： ${upgradeDo.reciver.userId}   收款人姓名：${upgradeDo.reciver.realName} 手机号：${upgradeDo.reciver.mobile} 金额 ：${upgradeDo.upgradeAmount}   等级 ： ${upgradeDo.afterUpgrade}级  
			    
			    ${upgradeDo.statusName}
		</article>
		</c:forEach>
	</section>
	
	</form>
	<%@ include file="../include/foot.jsp"%>
	<script>
	$(function(){
		$("#apply").bind('touchstart', function(){
			$(".err").remove();
			document.forms[0].submit();
		})
	})
	</script>
</body>
</html>