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
<jsp:useBean id="dto2" class="dto.MemberDTO" scope="application"/>
<jsp:setProperty property="*" name="dto2"/>
</body>
</html> 