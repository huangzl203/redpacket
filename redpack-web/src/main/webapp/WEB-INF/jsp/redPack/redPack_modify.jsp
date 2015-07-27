<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="include/top.jsp"%>
	<title>资料修改</title>
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
    <input type="hidden" name="loanId" value="${loanDo.loanPersonDo.loanId}"/>
    <input type="hidden" name="loanPersonId" value="${loanDo.loanPersonDo.loanPersonId}"/>
	<section class="p1">
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t1"></i>基础信息</h3>
			<div class="form-group db_f">
				<label for="" class="lab">真实姓名：</label>
				<input type="text" id="realName" placeholder="请输入真实姓名"  class="txt bf1 db" name="propertyDo.coveredArea"  value="${loanDo.loanPersonDo.propertyDo.coveredArea}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">手机号码：</label>
				<input type="text" id ="mobile"  placeholder="请输入手机号码"   class="txt bf1 db"  name="loanRelationDoList[0].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[0].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">QQ号码：</label>
				<input type="text" id ="qqNumber"   placeholder="请输入QQ号码" class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
			
			<div class="form-group db_f">
				<label for="" class="lab">一级密码:</label>
				<input type="text"  id ="onePassword"  placeholder="请输入一级密码"  class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">二级密码:</label>
				<input type="text"  id ="twoPassword"  placeholder="请输入二级密码"  class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">联系地址：</label>
				<input type="text" id="adres" placeholder="请输入联系地址"  class="txt bf1 db" placeholder="例如：8栋108号">
			</div>
			
		</article>
		
		
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t2"></i>银行信息</h3>
			<div class="form-group db_f">
				<label for="" class="lab">开户银行：</label>
				<input type="text" id="bank" placeholder="请输入开户银行"  class="txt bf1 db" name="propertyDo.coveredArea"  value="${loanDo.loanPersonDo.propertyDo.coveredArea}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户姓名：</label>
				<input class="txt bf1 db" id="email" placeholder="请输入有开户姓名" type="email"  name="email" value="${loanDo.loanPersonDo.email}"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">银行账号:</label>
				<input type="text" placeholder="请输入银行账号"  id ="xm2" class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户省份：</label>
				<input type="text" id="area"  placeholder="请输入开户省份" class="txt bf1 db" name="propertyDo.coveredArea"  value="${loanDo.loanPersonDo.propertyDo.coveredArea}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户城市：</label>
				<input type="text" id="addr"  placeholder="请输入开户城市" name="propertyDo.houseAddress" class="txt bf1 db" value="${loanDo.loanPersonDo.propertyDo.houseAddress}">
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户银行点：</label>
				<input type="text" id="addr" placeholder="请输入开户银行点"  name="propertyDo.houseAddress" class="txt bf1 db" value="${loanDo.loanPersonDo.propertyDo.houseAddress}">
			</div>
			
		</article>
		
		
		
		
		<article class="loan_inf">
			<h3 class="inf_tip">
				<i class="t3"></i>其他支付方式				
			</h3>
			<div class="form-group db_f">
				<label for="" class="lab">支付宝：</label>
				<input type="text" placeholder="请输入支付宝帐号"  class="txt bf1 db" id="mobile1" name="loanRelationDoList[0].mobile"  value="${loanDo.loanPersonDo.loanRelationDoList[0].mobile }"/>
				
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">财付通：</label>
				<input type="text" placeholder="请输入财付通帐号"  id ="xm2" class="txt bf1 db"  name="loanRelationDoList[1].ralationName" value="${loanDo.loanPersonDo.loanRelationDoList[1].ralationName }"/>
			</div>
		</article>
	</section>
	
	<section class="p1" style="padding: 10px 10px 60px;">
			<a href="javascript:void(0);" id="apply" class="apply">确定修改</a>
	</section>
	</form>
	<%@ include file="include/foot.jsp"%>
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