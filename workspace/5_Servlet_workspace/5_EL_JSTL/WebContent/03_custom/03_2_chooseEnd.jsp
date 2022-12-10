<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!-- uri 자동완성 가능. 여러옵션이 나오는거는 버젼이 다르기 때문 -->

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 뷰인  03_1_choose.jsp에서 값을 받아와 뷰인03_2_chooseEnd.jsp 넣기에 
		param 사용
 -->
<%--	
<!-- 

switch문과 같은 <c:when>

	switch(조건식){
	case 값: break;
	case 값: break;
	default:
	}	
		
		
	<c:choose> = switch
	<c:when> = case
	<c:otherwise> = default
	
	
	
			<c:when>  

			<c:when> == case문 
			<c:when>이 case문 역할함
			default 역할은 otherwise
																										-->--%>
		<c:choose>
			<c:when test="${ Integer.parseInt(param.num) % 5 == 0 }">
				인형1을 뽑았습니다
			</c:when>
			<c:when test="${ Integer.parseInt(param.num) % 5 == 1 }">
				물티슈2을 뽑았습니다
			</c:when>
			<c:when test="${ Integer.parseInt(param.num) % 5 == 3 }">
				물티슈3을 뽑았습니다
			</c:when>
			<c:otherwise>
			
			</c:otherwise>
		</c:choose>
		
		

		


</body>
</html>



