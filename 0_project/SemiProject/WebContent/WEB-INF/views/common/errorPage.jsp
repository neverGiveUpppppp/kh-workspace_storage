<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/blog/">
<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-examples/assets/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	body{background:url('<%= request.getContextPath() %>/sample/backone.jpg'); background-size:cover;}
	#sheet{background:white; border-radius:20px; width:500px; height:500px; margin:auto; margin-top:30px;}
	
</style>
<!-- Custom styles for this template -->
<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-examples/blog/blog.css" rel="stylesheet">
</head>
<body>
	<div id="sheet">
		<br><br><br>
		
		<img class="logo_img" src="bootstrap-5.1.3-examples/blog/images/logo.png" alt="logo" style="display: block; margin: 0px auto;">
		
		<br><br>
		
		<h4 align = "center" id="contentArea" style="color:#F08000; padding-top:50px;"><%= msg %></h4>
		
		<br><br><br><br>
			
		<div align ="center">
		<input class="btn btn-sm btn-outline-secondary" onclick = "history.back();" type="button" value="다시 시도" style="border: none;background:#F08000; color: white;">&nbsp;
	    <input class="btn btn-sm btn-outline-secondary" onclick = "location.href='<%= request.getContextPath() %>'" type="button" value="메인으로 돌아가기" style="border: none;background: #F08000;color: white;">
		
<!-- 			<button onclick = "history.back();">이전 페이지</button> -->
<%-- 			<button onclick = "location.href='<%= request.getContextPath() %>'">홈으로 돌아가기</button> --%>
		</div>
	</div>
</body>
</html>