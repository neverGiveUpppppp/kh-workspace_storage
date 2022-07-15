<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title> error/error.jsp </title>



</head>
<body>

	<h1>에러 처리 페이지입니다</h1>
	<%= exception %><br>
	<%= exception.getClass().getName() %><br>
	<%= exception.getMessage() %><br> <!-- 매개변수 생성자 옆에 나오는 ... 강의시간 12:30 -->
	

</body>
</html>


