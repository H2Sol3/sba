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
	int count = 0;
//서버 시작 후 최초 요청
	if(application.getAttribute("count")==null){
		count=1;
		application.setAttribute("count", count);
	}else{
		count = (Integer)application.getAttribute("count")+1;
	}

%>
<h1>서버 시작 후 <%=count %> 번째 방문자입니다.</h1>
</body>
</html>