
<%@page import="java.util.ArrayList"%>
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

	<!-- 액션태그 사용 -->
	<jsp:useBean id="memberlist" class="java.util.ArrayList" scope="request" />
	<%
	for (Object o : memberlist) {
		MemberDTO dto = (MemberDTO) o;
		out.println("<h3>" + dto.getId() + " : " + dto.getName() + " : " + dto.getAddress() + " : " + dto.getIndate()
		+ "</h3>");
	}
	%>

</body>
</html>