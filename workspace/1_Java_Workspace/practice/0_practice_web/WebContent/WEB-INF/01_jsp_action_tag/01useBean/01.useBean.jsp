<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 1.useBean으로  vo클래스 객체 정보 불러오기</h2>
<% action.model.vo.Person person = new action.model.vo.Person(); %>
<label><%= person.getNai() %></label>




</body>
</html>