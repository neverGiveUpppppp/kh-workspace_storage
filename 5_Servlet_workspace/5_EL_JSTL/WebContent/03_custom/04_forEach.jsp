<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<!-- 
	반복문
	자바의 for, for-in문에 해당하는 기능 제공
	for문과 비교했을 때 자바는 zero-base라 0부터 시작이지만 <c:forEach>는 1부터 시작
	str이 String이라는건 명시 필요x



														 -->--%>
	<!-- 1부터 6까지 반복, 반복변수 i -->
	
	<!-- 기본 for문 -->
	<c:forEach begin="1" end="6" var="i">
		${ i } <!-- $는 제이쿼리 외에도 EL도 있다! --> <!-- 자바랑 다르게 숫자출력이 가로로. 즉 -->
	</c:forEach>
	<!-- 기본 for문 응용 -->
	<c:forEach begin="1" end="6" var="i">
		<h${i}> 반복문${i} </h${i}> 
	</c:forEach>
	
	
	
	<!-- 기본 for문 + 증가수 step-->
	<c:forEach begin="1" end="6" var="i" step="2">
		${ i }
	</c:forEach>


	<!-- 기본 for문 + 마이너스(리버스)포문 -->
	<!-- 포문 거꾸로 하고 싶다면? -->
	<!-- begin이 end보다 크면 for문이 작동x 
		 step을 -로 줘도 작동 x
		 el 안에서 값을 더 크게줘서 역순으로 가도록												 -->
	<c:forEach begin="1" end="6" var="i" step="1">
		<h${ 7-i }> 반복문 ${ 7-i }</h${7-i }>
	</c:forEach>




<hr><hr>
<% 
/* 반복문 돌릴 데이터 */
	String[] nameArr = {"신형만", "봉미선", "신짱구", "신짱아"};
	request.setAttribute("family", nameArr); /* nameArr변수를 family라는 name속성값을 지정해주는 것 */
/* 	Q.setAttribute가 nameArr변수를 family라는 name속성값을 지정해주는건가요?
	A.yes		
*/
%>
	<ol>
		<c:forEach items="${ family }" var="f">  <!-- 임시로 담아둘 곳 f -->
			<li>${ f }</li>
		</c:forEach>
	</ol>	
	
	<hr>
	
	
	<!-- for in문 -->	
	<c:set var="alphabet">
	<!-- 배열로 인지하게 됨 -->
	<!-- items가 컬렉션을 받기 때문에 배열이 되는 것 -->
		A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
	</c:set>
	<c:forEach items="${ alphabet }" var="a" varStatus="vs">
		${ a }<br>
		vs.first : ${ vs.first }<br>	<!-- first  : A가 처음이라 true -->
		vs.last : ${ vs.last }<br>		<!-- last : Z가 마지막이라 true // A에서는 마지막이 아니었으므로 false -->
		vs.index : ${ vs.index }<br>
		vs.count : ${ vs.count }<br>
		vs.current : ${ vs.current }<br><!-- current : 현재 문자인 A -->
	</c:forEach>
	

</body>
</html>


