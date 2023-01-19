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
//jsp태그 값 정의 -- el 출력
String b = "jsp만의 변수";
pageContext.setAttribute("a", "pageContext공유");
request.setAttribute("a", "request공유");
session.setAttribute("a", "session공유");
application.setAttribute("a", "application공유");
%>
jsp b 출력 = <%=b %><br>
jsp a(pageContext) 출력 = <%=pageContext.getAttribute("a") %><br>
jsp a(request) 출력 = <%=request.getAttribute("a") %><br>
jsp a(session) 출력 = <%=session.getAttribute("a") %><br>
jsp a(application) 출력 = <%=application.getAttribute("a") %><br><br>

el b 출력 = ${b }<br>
el a 출력 = ${a }<br>
el a 출력 = ${a }<br>
el a 출력 = ${a }<br>
el a 출력 = ${a }<br><br>

<a href="${pageContext.request.contextPath}/el/scopetest2.jsp">링크이동</a>
<%-- <jsp:forward page="/el/scopetest2.jsp" /> --%>


</body>
</html>