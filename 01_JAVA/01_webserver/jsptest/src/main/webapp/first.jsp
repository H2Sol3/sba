<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>spring 회원님 환영합니다</h1>
<% String id = request.getParameter("id"); 
Date now = new Date();
%><!-- id값 불러오기 -->
<h1><%=id %> 회원님 <%=now %>시각에 로그인하셨습니다.</h1>
</body>
</html>