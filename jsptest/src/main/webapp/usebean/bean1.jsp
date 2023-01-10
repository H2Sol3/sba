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
<%-- <% MemberDTO dto = new MemberDTO(); %> --%>
<!-- dto.setId("id"); -->
<!-- dto.setPw("1111"); -->
<!-- dto.setName("name"); -->
<!-- dto.setPhone("01011112222"); -->
<!-- dto.setEmail("email@mul.com"); -->
<%-- %> --%>
<!-- <H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</H1> -->
<%-- <h3>아이디:<%=dto.getId() %></h3> --%>
<%-- <h3>암호:<%=dto.getPw() %></h3> --%>
<%-- <h3>이름:<%=dto.getName() %></h3> --%>
<%-- <h3>폰:<%=dto.getPhone() %></h3> --%>
<%-- <h3>이메일:<%=dto.getEmail() %></h3> --%>
==========================================================
<jsp:useBean id="dto" class="dto.MemberDTO"/>
<jsp:setProperty property="id" name="dto" value="id"/> <!-- name에는 useBean의 id 속성이 그대로 들어가야 함 -->
<jsp:setProperty property="pw" name="dto" value="1111"/>
<jsp:setProperty property="name" name="dto" value="name"/>
<jsp:setProperty property="phone" name="dto" value="01011112222"/>
<jsp:setProperty property="email" name="dto" value="email@mul.com"/>

<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</H1>
<h3>아이디:<jsp:getProperty property="id" name="dto"/></h3>
<h3>암호:<jsp:getProperty property="pw" name="dto"/></h3>
<h3>이름:<jsp:getProperty property="name" name="dto"/></h3>
<h3>폰:<jsp:getProperty property="phone" name="dto"/></h3>
<h3>이메일:<jsp:getProperty property="email" name="dto"/></h3>
</body>
</html> 