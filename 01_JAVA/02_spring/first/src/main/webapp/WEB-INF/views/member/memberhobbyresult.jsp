<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디, 나이, 취미 출력</title>
</head>
<body>
<table border=3>
<tr style="background-color: pink"><td style="font-style:;">아이디</td><td> ${id}<br></td></tr>
<tr style="background-color: yellow"><td>나이</td><td> ${age}<br></td></tr>
<tr style="background-color: skyblue;"><td>취미</td><td> 
<% String[] list = request.getParameterValues("hobby");
	for(String s : list){
		out.println(s);
	}
%></td></tr>
<%-- <tr><td>취미: ${hobby}</td></tr> --%>
<tr style="background-color: silver"><td>모델값</td><td> ${result}</td></tr>
</table>
</body>
</html>