<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
  <ul class="bs db_f footer_nav">
    <li class="bf1"><a href="<c:url value='/login/main.html'/>"><span>首页</span></a></li>
    <li class="bf1"><a href="<c:url value='/login/main.html'/>"><span>个人中心</span></a></li>
    <li class="bf1"><a href="tel:8888888888"><span>电话咨询</span></a></li>
    <li class="bf1"><a href="<c:url value='/userTree/view.html'/>"><span>团队结构</span></a></li>
  </ul>
</nav>

<script src="${fileServerUrl }/res/js/zepto.js?v=${jsversion}"></script>

