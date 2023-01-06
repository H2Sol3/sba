<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="/jsptest/js/jquery-3.6.1.min.js"></script> -->
<script type="<%=request.getContextPath() %>/js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	$('tr:even').css("background-color","pink");
	$('tr:odd').css("background-color","silver");
});
</script>
<style>
table{margin:auto;}
tb, table{border:2px solid blue;}
</style>
</head>
<h1>구구단을 출력합니다.</h1>
<%--
<body>
	<%
	int start = (Integer.parseInt(request.getParameter("start")));
	int end = (Integer.parseInt(request.getParameter("end")));
	%>
	<table style="text-align: center; border =2; border-color: blue;">
		<tr>
			<%
			for (int i = start; i <= end; i++) {
			%>
			<td>
				<%
				for (int j = 1; j <= 9; j++) {
				%> 
				<%=i%> * <%=j%> = <%=i * j%><br> 
				<% } %>
			</td>
			<%
			}
			%>
		</tr>
	</table> --%>
	
	<%
	if(request.getMethod().equals("GET")&& request.getParameter("id").equals("admin")){
		String start2 = request.getParameter("start");
		String end2 = request.getParameter("end");
		int start = 0, end = 0;
		if(start2 != null || !start2.equals("")){
			start = Integer.parseInt(start2);			
		}
		if(end2 != null || !end2.equals("")){
			end = Integer.parseInt(end2);		
		}
		%>
		<table border=1>
	<%	for(int j=1;j<=9;j++){ %>
			<tr> 
		<%	for(int i = start; i<=end;i++){ %>
				<td><%=i%> * <%=j%> = <%=i * j%></td>
			<%}%>
			</tr>
		<%}%>
		</table>
	<%}else{%>

	<h3>post방식은 지원하지 않습니다.</h3>
	<%
	}
	%>
<h1><a href="input.jsp">구구단 입력하기</a></h1>
</body>
</html>





























