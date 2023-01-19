<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${param.id}회원님</h1>
${param.pw} 암호를 입력하셨습니다.
<h3>점심 주문 목록은 <br>
${!empty paramValues.lunch[0]?paramValues.lunch[0]:"없음"}<br><!-- paramValues는 배열이니 뒤에 인덱스넣어주기 -->
${paramValues.lunch[1]}<br>
${paramValues.lunch[2]}<br>
${paramValues.lunch[3]}<br>
${!empty paramValues.lunch[4]?paramValues.lunch[4]:"없음"} 
입니다.
</h3> 
</body>
</html>