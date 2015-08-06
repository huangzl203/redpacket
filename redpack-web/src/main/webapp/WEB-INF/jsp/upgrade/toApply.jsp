<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="p" uri="http://www.hehenian.com/parent"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/top.jsp"%>
	<title>升级申请</title>
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
    <form action="/upgrade/apply" method="post" >
    <input type="hidden" name="userId" value="${currentUser.userid}"/>
    <input type="hidden" name="id" value="${gradeFee.id}"/>
	<section class="p1">
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t1"></i>升级说明</h3>
			<div class="form-group db_f">
				<label for="" class="lab">您目前的级别为：</label>
				<input type="text" id ="currentGrade" readonly="readonly" class="txt bf1 db"  name="currentGrade" value="${gradeFee.beforeUpgrade }"/>
			
				<label for="" class="lab">下一级将升级为:</label>
				<input type="text"  id ="nextGrade"  readonly="readonly"  class="txt bf1 db"  name="nextGrade" value="${gradeFee.afterUpgrade }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">并需要向上层会员： 交升级款 ${gradeFee.gradeAmount } 元</label>
			</div>
		</article>
		
		
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t2"></i>您的上层分别为：</h3>
			<p:parent userInfo="${currentUser}" item="parent" index="idx">
			<div class="form-group db_f">
				<label for="" class="lab">上${idx}层：</label>
				<input type="text" id="parentLevel" readonly="readonly"  class="txt bf1 db" name="parentLevel"  value="${parent.userName}" >
			</div>
			</p:parent>
		</article>
	</section>
	
	<section class="p1" style="padding: 10px 10px 60px;">
			<a href="javascript:void(0);" id="apply" class="apply">我要升级</a>
	</section>
	</form>
	<%@ include file="../include/foot.jsp"%>
	<script>
	$(function(){
		$("#apply").bind('click', function(){
			$(".err").remove();
			document.forms[0].submit();
		})
	})
	</script>
</body>
</html>