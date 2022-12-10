<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- <% %> : html 안에 자바코드를 집어넣을 수 있게하는 코드 -->    
    

<%
    // html 안에다가 자바코드를 집어넣은 것
    // TestServlet3.java에서 setAttribute()를 통해 저장한 데이터를 불러오기 위한 코드

	String name = (String)request.getAttribute("name"); //(String) 강제형변환 적용
    String age = (String)request.getAttribute("age"); 	// attr의 리턴타입이 object이기 때문
    String city = (String)request.getAttribute("city");
    String height = (String)request.getAttribute("height");
    String gender = (String)request.getAttribute("gender");
    String food = (String)request.getAttribute("foods");
    String recommendation = (String)request.getAttribute("recommendation");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> testServlet3End.jsp </title>

<style>
	h2{color: red;}
	span{font-weight: bold;}
	.name{color: orange;}
	.gender{color: yellow; background: black;}
	.age{color: green;}
	.city{color: blue;}|
	.height{color: navy;}
	.food{color: purple;}
</style>


</head>
<body>


<!-- 	<h2>개인 취향 테스트 결과</h2>
    <span class='name'>%s</span>님은 
    <span class='age'>%s</span>이시며, 
    <span class='city'>%s</span>에 사는 
    키 <span class='height'>%s</span>cm인 
    <span class='gender'>%s</span>입니다.
   	좋아하는 음식은 <span class='food'>%s</span>입니다.
     -->


	<h2>개인 취향 테스트 결과</h2>
	<span class='name'><%= name %></span>님은 <span class='age'><%= age %></span>이시며,
	<span class='city'><%= city %></span>에 사는 키 <span class='height'><%= height %></span>cm인
	<span class='gender'><%= gender %></span>입니다.
	좋아하는 음식은 <span class='food'><%= food %></span>입니다.
	
	
	<br><hr><br>
	
	
    <h3>%s에 맞는 선물 추천</h3>
    '%s' 선물은 어떠신가요?
	


</body>
</html>