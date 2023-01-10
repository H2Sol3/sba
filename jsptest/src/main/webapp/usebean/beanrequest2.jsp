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
==========================================================
<jsp:useBean id="dto" class="dto.MemberDTO" scope="request"/>
<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</H1>
<h3>아이디:<jsp:getProperty property="id" name="dto"/></h3>
<h3>암호: <jsp:getProperty property="pw" name="dto"/></h3>
<h3>이름: <jsp:getProperty property="name" name="dto"/></h3>
<h3>폰: <jsp:getProperty property="phone" name="dto"/></h3>
<h3>이메일: <jsp:getProperty property="email" name="dto"/></h3>
</body>
</html> 