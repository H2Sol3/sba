<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	MemberDTO dto = (MemberDTO)application.getAttribute("appdto");
	
	%>
	<h1>전달아이디: <%=dto.getId() %></h1>
	<h1>암호: <%=dto.getPw() %></h1>
	<h1>이름: <%=dto.getName() %></h1>
	
</body>
</html>