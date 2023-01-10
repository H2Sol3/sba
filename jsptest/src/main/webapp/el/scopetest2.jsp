<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scopetest2.jsp</h1>

jsp a(pageContext) 출력 = <%=pageContext.getAttribute("a") %><br>
jsp a(request) 출력 = <%=request.getAttribute("a") %><br>
jsp a(session) 출력 = <%=session.getAttribute("a") %><br>
jsp a(application) 출력 = <%=application.getAttribute("a") %><br><br>

el a 출력(현재 페이지의 jsp태그 전달 값) = ${pageScope.a }<br>
el a 출력(이동 전의 jsp태그 전달 값) = ${requestScope.a }<br>
el a 출력(세션 전달 값) = ${sessionScope.a }<br>
el a 출력(어플리케이션 전달 값) = ${applicationScope.a }<br><br>


el 컨텍스트명 출력 = ${pageContext.request.contextPath } <!-- 현재 페이지에서 request라는 이름을 가진 객체 -->
el jsp명 출력 = ${pageContext.request.requestURI }




<!-- el 전달 변수 해석 출력 -->
<!-- 순위 -->
<!-- 1. pageScope 찾는다. -->
<!-- 2. requestScope -->
<!-- 3. sessionScope -->
<!-- 4. applicationScope -->
</body>
</html>