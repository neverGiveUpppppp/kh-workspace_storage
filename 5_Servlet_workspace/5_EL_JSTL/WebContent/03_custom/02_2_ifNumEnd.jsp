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

	<!-- 뷰->뷰 이동이라 param 사용 -->
	<%-- 스크립틀릿 사용 <% if 블라블라 %> 했겠지만 core 조건문 사용 해보자. 맨위에 일단 taglib 지시자 설정--%>
	<!-- 비교할껀데 if문 필요 -->


		<c:if test="${ Integer.parseInt(param.num1) > Integer.parseInt(param.num2) }">
			${ param.num1 } 숫자는 ${ param.num2 } 숫자보다 크다
		</c:if>
		
		<br><br>
 
 		 <!-- test속성값에 조건식이 들어감 & 조건 안에는 el param이 들어감. param이 들어가면서 true/false가 나오고 -->
		<c:if test="${ Integer.parseInt(param.num1) > Integer.parseInt(param.num2) }">
			${param.num1 } 숫자는 ${param.num2 } 숫자보다 크다 <!-- el문에서 트루펄스로 논리값이 반환되기 떄문에 조건식 발동되게 됨  -->
		</c:if>
		<!-- 코어 안에서는 if문만 있고 else if나 else 없음. 즉, 단일 if문으로 해결해야함 -->
		<c:if test="${ Integer.parseInt(param.num2) > Integer.parseInt(param.num1) }"> 
			${ param.num2 } 숫자는 ${param.num1 } 숫자보다 크다
		</c:if>



		<br><br>
<!-- 
			if문
			문자열로 비교하기 때문
			10하고 5는 첫번째 문자가 1보다 5가 커서 5가 10보다 크다고 나오는 것 
			11 10은 첫번쨰 문자가 1은 같고 두번째 문자가 1이 0보다 커서 제대로 나오는 것 
			Integer.parseInt()로 묶어줘야한다
				즉, param의 기본값은 문자열 출력
				
				
-->	
		 
		 <!-- ==같다 조건에서는 인티저.파스인트 안해줘도 됨. 문자열로 비교해도 같기 때문. 엄밀하게 얘기하면 다르긴 함 -->
		<c:if test="${ Integer.parseInt(param.num2) == Integer.parseInt(param.num1) }"> <!-- 코어 안에서는 if문 있고 else if나 else 없음. 즉, 단일 if문으로 해결해야함 -->
			'${ param.num2 }' 숫자는  '${param.num1 }' 숫자와 같다
		</c:if>

</body>
</html>







