<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>个人中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta name="MobileOptimized" content="320" />
<link href="${fileServerUrl }/res/css/eLoan.css?v=${jsversion}"
	rel="stylesheet" type="text/css">
</head>
<body style="padding-bottom: 60px">
	<header class="center_head">
		<div class="head-inf">
			<c:if test="${tzNum >0}">
				<a href="<c:url value='/app/elend/tongzhi'/>" class="tongzhi">
					<em>${tzNum} </em>
				</a>
			</c:if>
			<h2>${userDo.userInfoDo.realName }</h2>
			<p class="db_f">
				<span class="bf1">${userDo.userInfoDo.mobileString }</span> <span
					class="bf1">${userDo.userInfoDo.idCardNoString }</span>
			</p>
		</div>
		<div class="head-lend db_f">
			<span><em>会员状态</em>正式会员</span> <span><em>会员级别</em>五级会员</span> <span><em>团队会员数</em>
				<fmt:formatNumber
					value="${settDetailDo.principal+settDetailDo.interest}"
					pattern="##0" /></span>
		</div>
	</header>

	<article>
		<section>
			<h2 class="progess-tip p1">
				<em> 升级付分信息
				</em>
			</h2>
			<div class="">
				<p style="padding:0 10px;">当前等级：5</p>
				<p style="padding:0 10px;">下一个付分等级：6级</p>
				<p style="padding:0 10px;">付分金额：1200.00分</p>
			</div>
		</section>
		<section>
			<div class="p1 db_f">
				<div class="p1 bf1"><a href="<c:url value='/common/modifyInfo.html'/>" class="apply">修改资料</a></div>
				<div class="p1 bf1"><a href="<c:url value=''/>" class="apply">我要升级</a></div>
			</div>
		</section>
		<section>
			<ul class="center-list">
				<li><span class="hj">你的团队信息</span><em></em>
					<table class="r_table h_table">
						<thead>
							<tr>
								<th>层数</th>
								<th>数量</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>3/3</td>
							</tr>
							<tr>
								<td>2</td>
								<td>8/9</td>
							</tr>
						</tbody>
					</table></li>
				<li><span class="ld">团队付分情况</span><em></em>
					<table class="r_table h_table">
						<thead>
							<tr>
								<th>等级</th>
								<th>付分总额</th>
								<th>付分情况</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>240.00</td>
								<td>3/3</td>
							</tr>
							<tr>
								<td>2</td>
								<td>800.00</td>
								<td>5/9</td>
							</tr>
						</tbody>
					</table></li>
			</ul>
		</section>

		<%@ include file="../include/foot.jsp"%>
		<script type="text/javascript">
			$(function() {
				$(".center-list li span").bind(
						'touchend',
						function() {
							var that = $(this);
							if (that.next(".down").length) {
								that.siblings('.h_table').hide().prev("em")
										.removeClass("down");
							} else {
								that.next('em').addClass("down").next(
										'.h_table').show();
								that.parent().siblings().find('.h_table')
										.hide().prev("em").removeClass("down");
							}
						})
				$("nav ul li").eq(1).addClass("current");
			})
		</script>
</body>
</html>