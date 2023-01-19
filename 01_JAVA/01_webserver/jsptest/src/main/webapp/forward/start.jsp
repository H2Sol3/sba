<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 예제_start.jsp</title>
</head>
<body>
	<%
	String id = request.getParameter("id");  //브라우저 입력 -브라우저에서 인코딩
	String filename = ""; 
	String menu [] =null;
	if (id != null){
		if(id.equals("admin") || id.equals("administrator")){
			filename="admin.jsp";
			menu = new String[3];
			menu[0] ="모든사용자정보조회";
			menu[1] ="회원강제탈퇴";
			menu[2] ="상품관리";
		}
		else{
			filename = "user.jsp"; /* 일반 회원은 회원 페이지로 이동해야하니까 */
			menu = new String[4];
			menu[0] = "회원가입";
			menu[1] = "상품구입";
			menu[2] = "결제";
			menu[3] = "장바구니 조회";
		}
		//id가 null이 아니라는 의미니까 바로 menu 넘겨버리기
		request.setAttribute("menu", menu);//객체를 넘겨야하니까 param이 아닌 setAttr! 
	} else {
		System.out.println("<h1>아이디 입력해주세요</h1>");	 //원래는 <% % > 내부에 하는데 오타가 많아지니 out내장객체 사용해서 출력하기!!!!!!!

		filename = "none.jsp";/* null이 아닐때 admin,user로 이동함. null인경우에는 filename이 비어있으니 하나 더 만들어 준 것! */
	}
	%>

	<jsp:forward page="<%=filename%>">
		<jsp:param value="<%=URLEncoder.encode(\"홍길동2\")%>" name="username" />
	</jsp:forward>
</body>
</html>




