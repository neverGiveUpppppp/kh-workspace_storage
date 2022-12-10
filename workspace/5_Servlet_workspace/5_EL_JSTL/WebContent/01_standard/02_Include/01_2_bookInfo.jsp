<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<!-- include -->
	<div style="text-align: center;">
		<h3>신간 소개</div>
		도서명: 점신은 무엇을 먹는게 좋을까?<br>
		저자명: 박춘희<br>
		페이지수 : 100페이지 <br>
		가격 : 15000원<br>
	
	
		<hr>
	
	<!-- 1번 파일을 집어넣을 것 : 1번 파일의 뷰를 넣어서 2번과 합쳐지게 됨-->
	<!-- 기존 jsp include 사용 -->
	<%@ include file="01_1_bookCopyRight.jsp" %>
	
		<hr>
		
	<!-- 표준액션 태그 include 사용 -->
	<jsp:include page="01_1_bookCopyRight.jsp"></jsp:include>
		
	
	
	</div>
	
	
	

</body>
</html>