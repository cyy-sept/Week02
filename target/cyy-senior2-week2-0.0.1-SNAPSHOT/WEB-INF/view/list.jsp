<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>商品ID</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>已售百分比</td>
		</tr>
		<c:forEach items="${list }" var="g">
		<tr>
			<td>${g.id }</td>
			<td>${g.name }</td>
			<td>${g.price }</td>
			<td>${g.cpar }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/list?page=${prePage}">上一页</a>
	<a href="${pageContext.request.contextPath }/list?page=${nextPage}">下一页</a>
</body>
</html>