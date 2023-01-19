<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#ajaxresult {background-color: yellow;}
</style>
<script src="resources/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#ajaxbtn").on('click',function(){
			$.ajax({
				url:'loginajax',
				type:'post',
				data:{'id':$("#id").val(), 'pw':$("#pw").val()},
				dataType: 'json',
				success: function(data){ 
					$("#ajaxresult").html("<h1>"+data.process+"</h1>");
				},
				error: function(request, status, error){
					alert("code:"+request.status+"\n"
							+"message:"+request.responseText+"\n"
							+"error:"+error);
			    }
			})//ajax
		});//ajaxbtn on
		
		$("#ajaxbtn2").on('click',function(){
			$.ajax({
				url:'myinformajax',
				type:'post',
				data:{'id':$("#id").val(), 'pw':$("#pw").val()},
				dataType: 'json',
				success: function(data){ 
					$("#ajaxresult").html("회원 아이디= "+data.id);
					$("#ajaxresult").append("회원 암호= "+data.pw);
					$("#ajaxresult").append("회원 이름= "+data.name);
					$("#ajaxresult").append("회원 폰= "+data.phone);
					$("#ajaxresult").append("회원 이메일= "+data.email);
					$("#ajaxresult").append("회원 주소= "+data.address);
					$("#ajaxresult").append("회원 가입일= "+data.indate);
				},
				error: function(request, status, error){
					alert("code:"+request.status+"\n"
							+"message:"+request.responseText+"\n"
							+"error:"+error);
			    }
			})//ajax
		});//ajaxbtn2 on
		
		$("#ajaxbtn3").on('click',function(){
			$.ajax({
				url:'memberlistajax',
				type:'get',
				dataType: 'json',
				success: function(data){ // 자바 배열 List -> 자바스크립트 배열처럼
					$("#ajaxresult").html('');
					for(var i =0;i<data.length;i++){
						$("#ajaxresult").append(data[i].id+":"+data[i].name+":"+data[i].address+"<br>")
					}
				},
				error: function(request, status, error){
					alert("code:"+request.status+"\n"
							+"message:"+request.responseText+"\n"
							+"error:"+error);
			    }
			})//ajax
		});//ajaxbtn on
		
		$("#ajaxbtn4").on('click',function(){
			$.ajax({
				url:'paginglistajax/'+$("#page").val(),
				type:'get',
				dataType: 'json',
				success: function(data){ // 자바 배열 List -> 자바스크립트 배열처럼
					$("#ajaxresult").html('');
					for(var i =0;i<data.length;i++){
						$("#ajaxresult").append(data[i].id+":"+data[i].name+":"+data[i].address+"<br>")
					}
				},
				error: function(request, status, error){
					alert("code:"+request.status+"\n"
							+"message:"+request.responseText+"\n"
							+"error:"+error);
			    }
			})//ajax
		});//ajaxbtn on
		
	});//ready

</script>
</head>
<body>
<form action="loginajax" method=post >
	아이디<input type=text name="id" id="id"><br>
	암호<input type=password name="pw" id="pw"><br>
	<input type="submit" value="로그인"><br>
</form>
<input type="button" id="ajaxbtn" value="ajax로그인"><br>
<input type="button" id="ajaxbtn2" value="내정보주세요"><br>
<input type="button" id="ajaxbtn3" value="회원리스트주세요"><br>

페이지 번호 입력: <input type="number" id="page"><br>
<input type="button" id="ajaxbtn4" value="페이징리스트주세요"><br>
<div id="ajaxresult"></div> 
</body>
</html>