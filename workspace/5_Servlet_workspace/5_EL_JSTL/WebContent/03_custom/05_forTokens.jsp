<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- forEach -->
	<c:set var="family" value="신형만, 봉미선, 신짱구, 신짱아"/>
	<ul>
		<c:forEach var="f" items="${ family }"> <!-- items가 컬렉션을 받기 떄문에 f의 값이 배열로 -->
			<li>${ f }</li>
		</c:forEach>
	</ul>	


	<!-- forTokens -->
	<c:set var="family" value="신형만, 봉미선, 신짱구, 신짱아"/>
	<ul>
		<c:forTokens var="f" items="${ family }" delims=", "> <!-- delimeter : 구분자 -->
			<li>${ f }</li>
		</c:forTokens>
	</ul>	

	
	<c:set var="family2" value="신형만, 봉미선/신짱구-신짱아 고길동,둘리/도우너.희동이-또치 마이콜"/>
	<ul>
		<c:forEach var="f" items="${ family2 }"> 
			<li>${ f }</li>
		</c:forEach>
	</ul>

	<!-- 구분자가 많은 경우, forTokens가 필요성을 느끼게됨 -->
	<!-- 구분자 delims=", / - . " 이것들 전부 처리함 -->
	<ul>
		<span>데이터 원본 : 신형만, 봉미선/신짱구-신짱아 고길동,둘리/도우너.희동이-또치 마이콜"<br></span>
		<c:forTokens var="f" items="${ family2 }" delims=", / - . "> <!-- delimeter : 구분자 -->
			<li>${ f }</li>
		</c:forTokens>
	</ul>



</body>
</html>





