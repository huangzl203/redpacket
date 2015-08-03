<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<title>个人中心</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Cache-Control" content="no-cache" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="MobileOptimized" content="320" />
		<link href="${fileServerUrl }/res/css/eLoan.css?v=${jsversion}" rel="stylesheet" type="text/css">
	</head>
	<body style="padding-bottom: 60px">
		<header class="center_head">
			<div class="head-inf">
			<a href="<c:url value='/app/elend/tongzhi'/>" class="tongzhi"><c:if test="${tzNum >0}"><em>${tzNum} </em></c:if></a>
				<h2>${userDo.userInfoDo.realName }</h2>
				<p class="db_f">
					<span class="bf1">${loanChannelDo.loanUserDo.mobileShort }</span>
					<span class="bf1">${loanChannelDo.loanUserDo.idNoShort }</span>
				</p>
			</div>
            <c:if test="${loanDo.loanStatus == 'PENDING' || loanDo.loanStatus == 'PROCESSING' || loanDo.loanStatus == 'AUDITED'||loanDo.loanStatus == 'TREATY'||loanDo.loanStatus == 'SUBJECTED' || loanDo.loanStatus == 'REPAYING'}">
				<div class="head-lend db_f">
					<span><em>贷款金额(元)</em>${loanDo.applyAmountString}</span>
					<span><em>还款期限(元)</em>${loanDo.loanPeriod}</span>
					<span><em>月还款额(元)</em><fmt:formatNumber value="${settDetailDo.principal+settDetailDo.interest}" pattern="##0.00"/></span>
				</div>
			</c:if>
		</header>
		<%@ include file="../include/foot.jsp"%>
		<script  type="text/javascript">
		$(function(){
			$(".center-list li span").bind('touchend', function(){
				var that = $(this);
				if(that.next(".down").length){
					that.siblings('.h_table').hide().prev("em").removeClass("down");
				} else {
					that.next('em').addClass("down").next('.h_table').show();
					that.parent().siblings().find('.h_table').hide().prev("em").removeClass("down");
				}
			})
			$("nav ul li").eq(1).addClass("current");
		})
		
		</script>
	</body>
</html>