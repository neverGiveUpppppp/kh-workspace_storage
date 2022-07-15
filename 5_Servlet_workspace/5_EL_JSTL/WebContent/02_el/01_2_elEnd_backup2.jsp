<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="action.model.vo.Person" %>
<%--     
<% 
	Person person = (Person) request.getAttribute("person");
	String beverage = (String) request.getAttribute("beverage");
	int year= (int) request.getAttribute("year");
	String[] products = (String[])request.getAttribute("products");
	String book = (String) request.getAttribute("book");
	String movie = (String) request.getAttribute("movie");
%>
    --%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
<style>.item{font-weight: bold; color: yellowgreen;}</style>
</head>
<body>


	<h2>scriptlet을 통해 request객체에 저장된 데이터 출력</h2>
	
	<%-- <h4>개인 정보(<%= year %>)</h4> --%>
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
	
	
	<h2>EL의 내장객체 xxxxScope을 통해 request객체에 저장된 데이터 출력</h2>
	
	<h4>개인 정보(${requestScope.year })</h4>  <!-- 옆에 빨간색 에러는 무시해도됨  -->
	<!-- 저장되어있는 영역 지정.저장된 변수명 -->
	<!-- ${requestScope.year } -->
	이름 : ${requestScope.person.name }<br> <!-- requestScope.person만 찍으면 객체 전체가 찍힘 : Person [name=, gender=0, age=20] -->
	성별 : ${requestScope.person.gender }<br> <!-- 저장되어있는 영역 지정.저장된 객체명.변수명  -->
	나이 : ${requestScope.person.age }<br>
	<h4>취향 정보</h4>
	${requestScope.person.name }님이 가장 좋아하는 음료 : ${ requestScope.beverage }<br>
	${requestScope.person.name }님이 가장 좋아하는 물건 : ${ requestScope.products[0] },
												  ${ requestScope.products[1] },
												  ${ requestScope.products[2] }<br>
	${requestScope.person.name }님이 가장 좋아하는 도서 : ${ sessionScope.book}<br>
	${requestScope.person.name }님이 가장 좋아하는 영화 : ${ applicationScope.movie }<br>
	<!-- 영역에 맞는 스코프 안쓰고  requestScope쓴 이유 -->
	<!-- 반환이 아무것도 안됨. 
		기존 scriptlet request에서는 없는 값 가져오면 null인데,
		EL은 아무것도 반환이 안됨 -->
	${requestScope.person.name }님이 가장 좋아하는 도서 : ${ requestScope.book}<br> 
	${requestScope.person.name }님이 가장 좋아하는 영화 : ${ requestScope.movie }<br>
	
	
	
</body>
</html>


