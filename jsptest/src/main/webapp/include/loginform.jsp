<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 화면입니다.</h1>
<%-- 	<%request.setAttribute("dto", dto) %> --%>
	<%
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember("id3", "pw"); /* id,pw 전달 */
		request.setAttribute("member",dto); /* include되는 파일쪽으로 "member"가 전달되는것!!! */
	%>
	<jsp:include page="bottom.jsp">
		<jsp:param value="jsp" name="id" />
		<jsp:param name="filename" value="<%=request.getRequestURI() %>"/>
	</jsp:include>
</body>
</html>