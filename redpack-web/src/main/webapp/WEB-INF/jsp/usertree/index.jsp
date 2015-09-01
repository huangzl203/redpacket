<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/top.jsp"%>
<link type="text/css" href="${fileServerUrl}/res/css/base.css" rel="stylesheet" />
<link type="text/css" href="${fileServerUrl}/res/css/Spacetree.css" rel="stylesheet" />

<!--[if IE]><script language="javascript" type="text/javascript" src="../../Extras/excanvas.js"></script><![endif]-->

<!-- JIT Library File -->
<script language="javascript" type="text/javascript" src="${fileServerUrl}/res/js/jit.js"></script>

<!-- Example File -->
<script language="javascript" type="text/javascript" src="${fileServerUrl}/res/js/example1.js"></script>

<title>团队结构树</title>
</head>

<body onload="init();">
<div id="container">
<div id="center-container">
    <div id="infovis"></div>    
</div>
</div>
	<!--弹出框-->
	<%@ include file="../common/foot.jsp"%>

	<c:if test="${message!= null}">
		<script>alert(${message})</script>
	</c:if>
</body>

</html>