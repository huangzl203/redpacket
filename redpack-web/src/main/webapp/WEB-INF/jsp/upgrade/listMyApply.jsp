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
			收款人编号： XXXX   收款人姓名：XXXXX 手机号：1336922222   金额 ：80  等级 ： 1级  
			    
			    未审核
		</article>
		
		<article class="loan_inf">
				收款人编号： XXXX   收款人姓名：XXXXX 手机号：1336922222   金额 ：80  等级 ： 1级  
			    
			    未审核
		</article>
		<article class="loan_inf">
				收款人编号： XXXX   收款人姓名：XXXXX 手机号：1336922222   金额 ：160  等级 ： 2级  
			    
			    未审核
		</article>
		<article class="loan_inf">
				收款人编号： XXXX   收款人姓名：XXXXX 手机号：1336922222   金额 ：240  等级 ： 3级  
			    
			    未审核
		</article>
		<article class="loan_inf">
				收款人编号： XXXX   收款人姓名：XXXXX 手机号：1336922222   金额 ：320  等级 ： 4级  
			    
			    未审核
		</article>
		
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