<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 1.JSP표준 액션 태그 중 useBean을 사용하여 vo클래스 객체 정보 불러오기</h2>
	
	<jsp:useBean id="p" class="action.model.vo.Person"></jsp:useBean>
	
	<jsp:setProperty property="name" name="p" value="a"/>
	
	jsp:useBean & getProperty로 vo클래스 값 가져오기 : 
	<jsp:getProperty property="name" name="p"/><br><br>


</body>
</html>


