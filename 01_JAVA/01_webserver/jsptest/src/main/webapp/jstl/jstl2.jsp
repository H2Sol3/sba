<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<!-- include/forward -->
<c:url var="mypage" value="http://localhost:8080/jsptest/jstl/loginage.jsp" />
<%-- <c:url var="mypage" value="http://www.google.com" /> --%>


<!-- redirect는 forward와 유사함 
	jsp:forward 차이
	1. url최초요청하면 값 불변
	2. 같은 서버, 같은 웹어플리케이션 파일 이동 가능
-->
<%-- <c:redirect url="${mypage}"> --%>
<%-- 	<c:param name="name" value="홍길동" /> --%>
<%-- 	<c:param name="age" value="21" /> --%>
<%-- </c:redirect> --%>


<!-- jsp:include -->
<c:import url="${mypage }">
	<c:param name="name" value="홍길동" />
	<c:param name="age" value="21" />	
</c:import>
<h1>import한 직후입니다.</h1>
</body>
</html>