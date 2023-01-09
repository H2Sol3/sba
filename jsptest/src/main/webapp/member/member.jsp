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
<jsp:useBean id="member" class="dto.MemberDTO" scope="request"/>
아이디: <jsp:getProperty property="id" name="member"/><br>
암호: <jsp:getProperty property="pw" name="member"/><br>
이름: <jsp:getProperty property="name" name="member"/><br>
주소: <jsp:getProperty property="address" name="member"/><br>

<a href="member?menu=insert_db.jsp">회원가입하러가기</a>
</body>
</html>