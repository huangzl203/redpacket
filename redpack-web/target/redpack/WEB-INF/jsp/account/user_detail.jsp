<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="${fileServerUrl}res/js/jquery.min.js?v=${jsversion}" type="text/javascript"></script>
</head>
<body>
	编号：${userDo.id}<br/>
	用户名称：${userDo.username}<br/>
	邮件地址：${userDo.email}<br/>
	手机号码：${userDo.mobilePhone}<br/>
	推荐人：${userDo.refferee}<br/>
</body>
</html>