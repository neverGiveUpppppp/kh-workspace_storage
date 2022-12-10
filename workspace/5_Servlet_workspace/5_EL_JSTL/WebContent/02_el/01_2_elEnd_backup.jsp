<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="action.model.vo.Person" %>
    
<% 
	Person person = (Person) request.getAttribute("person");
	String beverage = (String) request.getAttribute("beverage");
	int year= (int) request.getAttribute("year");
	String[] products = (String[])request.getAttribute("products");
	String book = (String) request.getAttribute("book");
	String movie = (String) request.getAttribute("movie");
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
<style>.item{font-weight: bold; color: yellowgreen;}</style>
</head>
<body>


	<h2>scriptlet을 통해 request객체에 저장된 데이터 출력</h2>
	<h4>개인 정보(<%= year %>)</h4>
<%-- 	
	이름 : <%= person.getName() %><br>
	성별 : <%= person.getGender() %><br>
	나이 : <%= person.getNai() %><br>
	<h4>취향 정보</h4>
	<%= person.getName() %>님이 가장 좋아하는 음료 :<%= beverage %><br>
	<%= person.getName() %>님이 가장 좋아하는 물건 :<%= products[0] %>, <%= products[1] %>,<%= products[2] %><br>
	<%= person.getName() %>님이 가장 좋아하는 도서 :<%= book %><br>
	<%= person.getName() %>님이 가장 좋아하는 영화 :<%= movie %><br> <!-- book, movie는 session이랑 applicaion영역에 있으므로 임포트 필요x -->
	 --%>
	<!-- 잘못나온 것 : session과 application에서 불러온 도서,영화 -->
	<!-- 잘못 나온 이유 : 리퀘스트 영역에는 book,movie가 없어서 못찾은 것 -->
	<!-- 그럼에도 request로 가져온 이유 : 영역에 없는걸 가져올 경우 null 뜨는걸 보여주기 위해 -->
	
	<!-- 스크립틀릿 없이도 EL 사용가능 -->
	<!-- 이를 보여주기 위해 스크립틀릿 부분 전부 삭제함 -->
	
</body>
</html>


