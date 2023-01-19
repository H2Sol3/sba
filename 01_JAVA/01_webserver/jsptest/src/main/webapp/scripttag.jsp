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
	String msg ="콘솔 출력";  
	//jsp 서블릿 변환시 _jspServlet()의 문장으로 간주
	//jsp 서블릿 변환시 _jspServlet()의 지역변수로 간주
	System.out.println(msg);
%>
<!-- 메서드 선언은 < %!에서 작성 -->
<%! 
	String msg2="멤버변수";

	void multiply(int a, int b){
	System.out.println(msg2+":"+a*b);

} %>
<% multiply(10,20); %>
</body>
</html>