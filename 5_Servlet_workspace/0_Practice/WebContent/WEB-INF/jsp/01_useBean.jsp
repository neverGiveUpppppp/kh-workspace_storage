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
	<% jsp.action.model.vo.Person p = new jsp.action.model.vo.Person(); %>
	<%= p.setName("a") %>
	<label>성별<%= p.getName() %></label><br><br>
	
	<jsp:useBean id="Person" class="jsp.action.model.vo.Person"></jsp:useBean>
	
	<jsp:setProperty property="name" name="Person" value="a"/>
	
	jsp:useBean & getProperty로 vo클래스 값 가져오기 : 
	<jsp:getProperty property="name" name="Person"/><br><br>
	
	기존 jsp방식으로  vo클래스 값 가져오기 : 
	<%= p.getName() %><br><br>
	<!-- 표준액션태그와 jsp와 값 연동 안됨 -->

		
		
	<span>span태그는 인라인블록</span>


</body>
</html>


