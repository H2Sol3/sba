<%@page import="springmvc.ListDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springmvc.HelloDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>list컨트롤러부터 받은 메세지</h1>
	<%
	ListDTO list = (ListDTO) request.getAttribute("model");
	%> 
	1. getList()
	<br>
	<%=list.getList()%>
	<br> 2. el
	<br> ${model.list}
	
<%-- 	<c:forEach items="${memberlist }" varStatus=""> --%>
		
<%-- 	</c:forEach> --%>
</body>
</html>







