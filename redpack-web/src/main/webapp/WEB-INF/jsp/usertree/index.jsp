<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/top.jsp"%>
<%@ include file="../common/head.jsp"%>
<link type="text/css" href="${fileServerUrl}/res/css/base.css" rel="stylesheet" />
<link type="text/css" href="${fileServerUrl}/res/css/Spacetree.css" rel="stylesheet" />

<!--[if IE]><script language="javascript" type="text/javascript" src="../../Extras/excanvas.js"></script><![endif]-->

<!-- JIT Library File -->
<script language="javascript" type="text/javascript" src="${fileServerUrl}/res/js/jit.js"></script>

<!-- Example File -->
<script language="javascript" type="text/javascript" src="${fileServerUrl}/res/js/userTree.js"></script>
<script language="javascript" type="text/javascript">
function refonclick(){
	//	alert($('#user_ref_id').val());
	    if("" == $('#user_ref_id').val()){
	    	popWindow("请选择接受人");
	    }else{
			window.location.href="/account/regIndex.html?userid=" +  $('#user_ref_id').val();
	    }
	}
</script>
<title>团队结构树</title>

</head>

<body onload="init();">
	<header class="top-bar">
		<a href="javascript:history.go(-1);">
			<span class="icon-back">
			</span>
		</a>
			团队结构树
	</header>
<input type='hidden' id='user_ref_id'/>
<div id="container">
<div id="center-container">
    <div id="infovis"></div>    
</div>
</div>
	<!--弹出框-->
	<nav>
  <ul class="bs db_f footer_nav">
    <li class="bf1"><a href="<c:url value='/login/main.html'/>"><span>首页</span></a></li>
    <li class="bf1"><a href="<c:url value='/redPack/personalCenter.html'/>"><span>个人中心</span></a></li>
    <li class="bf1"><a href='#' onclick="refonclick()"/>"><span>推荐会员</span></a></li>
    <li class="bf1"><a href="<c:url value='/userTree/view.html'/>"><span>团队结构</span></a></li>
  </ul>
</nav>
</body>
</html>