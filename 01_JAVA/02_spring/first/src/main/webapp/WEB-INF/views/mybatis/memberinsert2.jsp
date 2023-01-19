<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
축 가입 축<br><br>
<%-- id: ${dto.id }<br> --%>
<%-- pw: ${dto.pw }<br> --%>
<%-- name: ${dto.name }<br> --%>
<%-- phone: ${dto.phone }<br> --%>
<%-- email: ${dto.email }<br> --%>
<%-- indate: ${dto.indate } --%>

${insertresult }
</body>
</html>