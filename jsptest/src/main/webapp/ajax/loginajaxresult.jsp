<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 아이디 ajax이고 pw ajax 로그인 성공/나머지 실패 --%> 
<%
String logintime = null;
String result = null;
%>
<c:if test="${param.id.equals(\"ajax\" )&& param.pw.equals(\"ajax\")}">
<%
	logintime = new SimpleDateFormat("yyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
	result = "{\"login\":\"success\", \"logintime\":\"" + logintime + "\"}";
%>
</c:if>

<%=result%>



