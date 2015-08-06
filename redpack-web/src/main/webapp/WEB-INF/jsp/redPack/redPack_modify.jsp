<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="../include/top.jsp"%>
		<title>资料修改</title>
	</head>
<style>
.err {
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
		<input type="hidden" name="id" value="${userDo.userInfoDo.id}"/>
		<input type="hidden" name="userId" value="${userDo.userInfoDo.userId}"/>
		<section class="p1">
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t1"></i>基础信息</h3>
			<div class="form-group db_f">
				<label for="" class="lab">真实姓名：</label>
				<input type="text" id="realName" placeholder="请输入真实姓名"  class="txt bf1 db" name="realName"  value="${userDo.userInfoDo.realName}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">身份证号：</label>
				<input type="text" id ="idCardNo"  placeholder="请输入身份证号码"   class="txt bf1 db"  name="idCardNo" value="${userDo.userInfoDo.idCardNo}"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">手机号码：</label>
				<input type="text" id ="mobile"  placeholder="请输入手机号码"   class="txt bf1 db"  name="mobile" value="${userDo.userInfoDo.mobile}"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">QQ号码：</label>
				<input type="text" id ="qqNumber"   placeholder="请输入QQ号码" class="txt bf1 db"  name="qqNumber" value="${userDo.userInfoDo.qqNumber}"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">微信号:</label>
				<input type="text"  id ="weixiNumber"  placeholder="请输入微信号"  class="txt bf1 db"  name="weixiNumber" value="${userDo.userInfoDo.weixiNumber }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">用户邮箱:</label>
				<input type="text"  id ="eMail"  placeholder="请输入用户邮箱"  class="txt bf1 db"  name="eMail" value="${userDo.userInfoDo.eMail }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">联系地址：</label>
				<input type="text" id="contactAddress"  placeholder="例如：广东省深圳市罗湖区XX小区8栋8号"  class="txt bf1 db"   name="contactAddress"  value="${userDo.userInfoDo.contactAddress }">
			</div>
			
		</article>
		
		
		<article class="loan_inf">
			<h3 class="inf_tip"><i class="t2"></i>银行信息</h3>
			<div class="form-group db_f">
				<label for="" class="lab">开户银行：</label>
				<input type="text" id="bankName" placeholder="请输入开户银行"  class="txt bf1 db" name="bankName"  value="${userDo.userInfoDo.bankName}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户姓名：</label>
				<input type="text"  id="openAccount" placeholder="请输入有开户姓名"class="txt bf1 db" name="openAccount" value="${userDo.userInfoDo.openAccount}"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">银行账号:</label>
				<input type="text"  id ="bankAccount"  placeholder="请输入银行账号" class="txt bf1 db"  name="bankAccount" value="${userDo.userInfoDo.bankAccount }"/>
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户省份：</label>
				<input type="text" id="province"  placeholder="请输入开户省份" class="txt bf1 db" name="province"  value="${userDo.userInfoDo.province}" >
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户城市：</label>
				<input type="text" id="city"  placeholder="请输入开户城市" class="txt bf1 db" name="city"  value="${userDo.userInfoDo.city}">
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">开户银行点：</label>
				<input type="text" id="bankSubbranch" placeholder="请输入开户银行点"  name="bankSubbranch" class="txt bf1 db" value="${userDo.userInfoDo.bankSubbranch}">
			</div>
		</article>
		<article class="loan_inf">
			<h3 class="inf_tip">
				<i class="t3"></i>其他支付方式				
			</h3>
			<div class="form-group db_f">
				<label for="" class="lab">支付宝：</label>
				<input type="text"  id="zfbNumber" placeholder="请输入支付宝帐号"  class="txt bf1 db" name="zfbNumber"  value="${userDo.userInfoDo.zfbNumber }"/>
				
			</div>
			<div class="form-group db_f">
				<label for="" class="lab">财付通：</label>
				<input type="text" id ="xm2" placeholder="请输入财付通帐号"   class="txt bf1 db"  name="cftNumber" value="${userDo.userInfoDo.cftNumber }"/>
			</div>
		</article>
	</section>
	
	<section class="p1" style="padding: 10px 10px 60px;">
			<a href="javascript:void(0);" id="apply" class="apply">确定修改</a>
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