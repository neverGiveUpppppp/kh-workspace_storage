<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>


</head>
<body>

	오늘 날씨가 정말 좋네요!<br>
	<!-- 오늘 날짜는 (오늘날짜 집어 놓을것)입니다. -->
	오늘 날짜 <%@ include file="today.jsp" %>입니다. <!-- today.jsp를 상대경로로 가져옴 -->

	<%
		/* String today = "최고의 날씨"; */ /* 중복이라 사용불가 */
		
	%>


</body>
</html>


