<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/top.jsp"%>
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
    <input type="hidden" name="loanId" value="${loanDo.loanPersonDo.loanId}"/>
    <input type="hidden" name="loanPersonId" value="${loanDo.loanPersonDo.loanPersonId}"/>
	<section class="p1">
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t1"></i>升级说明</h3>
			<div class="form-group db_f">
				<label for="" class="lab">您目前的级别为：</label>
				<input type="text" id ="qqNumber" readonly="readonly" class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			
				<label for="" class="lab">下一级将升级为:</label>
				<input type="text"  id ="onePassword"  readonly="readonly"  class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">并需要向上层会员： 交升级款  元</label>
			</div>
		</article>
		
		
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t2"></i>您的上层分别为：</h3>
			<div class="form-group db_f">
				<label for="" class="lab">上1层：</label>
				<input type="text" id="bank" readonly="readonly"  class="txt bf1 db" name="propertyDo.coveredArea"  value="${loanDo.loanPersonDo.propertyDo.coveredArea}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">上2层：</label>
				<input type="text" id ="mobile"  readonly="readonly"   class="txt bf1 db"  name="loanRelationDoList[0].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[0].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">上3层：</label>
				<input type="text" id ="qqNumber" readonly="readonly" class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">上4层：</label>
				<input class="txt bf1 db" id="email" readonly="readonly" type="email"  name="email" value="${loanDo.loanPersonDo.email}"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">上5层:</label>
				<input type="text" readonly="readonly" id ="xm2" class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">上6层：</label>
				<input type="text" id="area" readonly="readonly" class="txt bf1 db" name="propertyDo.coveredArea"  value="${loanDo.loanPersonDo.propertyDo.coveredArea}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">上7层：</label>
				<input type="text" id="addr"  readonly="readonly" name="propertyDo.houseAddress" class="txt bf1 db" value="${loanDo.loanPersonDo.propertyDo.houseAddress}">
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">上8级：</label>
				<input type="text" id="addr" readonly="readonly"  name="propertyDo.houseAddress" class="txt bf1 db" value="${loanDo.loanPersonDo.propertyDo.houseAddress}">
			</div>
			
		</article>
	</section>
	
	<section class="p1" style="padding: 10px 10px 60px;">
			<a href="javascript:void(0);" id="apply" class="apply">我要升级</a>
	</section>
	</form>
	<%@ include file="/include/foot.jsp"%>
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