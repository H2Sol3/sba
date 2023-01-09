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
<%-- <jsp:param value="<%request.getParameter("id"); %>" name="id"/> --%>
<%-- <jsp:param value="<%request.getParameter("pw"); %>" name="password"/> --%>
<%-- <jsp:param value="<%request.getParameter("name"); %>" name="name"/> --%>
<%-- <jsp:param value="<%request.getParameter("phone"); %>" name="phonenumber"/> --%>
<%-- <jsp:param value="<%request.getParameter("email"); %>" name="email"/> --%>

<%-- <jsp:useBean id="dto2" class="dto.MemberDTO"/> --%>
<%-- <jsp:setProperty property="id" name="dto2" value="<%=request.getParameter("id") %>"/> <!-- name에는 useBean의 id 속성이 그대로 들어가야 함 --> --%>
<%-- <jsp:setProperty property="id" name="dto2" param="id"/> <!-- name에는 useBean의 id 속성이 그대로 들어가야 함 --> --%>
<%-- <jsp:setProperty property="*" name="dto2"/> --%>
<%-- <jsp:setProperty property="pw" name="dto2" param="password"/> --%>
<%-- <jsp:setProperty property="name" name="dto2" param="name"/> --%>
<%-- <jsp:setProperty property="phone" name="dto2" param="phonenumber"/> --%>
<%-- <jsp:setProperty property="email" name="dto2" param="email"/> --%>
<%-- <% MemberDAO().insertMember(dto); %> --%>
<!-- <H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</H1> -->
<%-- <h3>아이디:<jsp:getProperty property="id" name="dto2"/></h3> --%>
<%-- <h3>암호: <jsp:getProperty property="pw" name="dto2"/></h3> --%>
<%-- <h3>이름: <jsp:getProperty property="name" name="dto2"/></h3> --%>
<%-- <h3>폰: <jsp:getProperty property="phone" name="dto2"/></h3> --%>
<%-- <h3>이메일: <jsp:getProperty property="email" name="dto2"/></h3> --%>


<jsp:useBean id="dto2" class="dto.MemberDTO" scope="request"/>
<jsp:setProperty property="*" name="dto2"/>
<jsp:forward page="beanrequest2.jsp" />
</body>
</html> 