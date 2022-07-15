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


	<!-- el에서 문자열 비교시, ==연산자로 내용 비교 가능 불가능? 가능	-->
	<!-- 폴더 02_el의 오퍼레이터 파일에서 <h3> 비교연산 확인 -->
	
	<br><br>
	<!-- == 비교 -->
	
	<b>== 비교</b><br>
	<c:if test="${ param.str1 == param.str2 }">
		'${ param.str1 }' 문자와 '${ param.str2 }'문자는 같습니다.
	</c:if><br><br>
	
	<b>!= 비교</b><br>
	<c:if test="${ param.str1 != param.str2 }">
		'${ param.str2 }' 문자와 '${ param.str2 }' 문자는 같지 않습니다.
	</c:if>
	
	
	
	
	<br><br>
	
	<!-- eq 비교 -->
	<b>eq 비교</b><br>
	<c:if test="${ param.str1 eq param.str2 }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같습니다.
	</c:if>
	<c:if test="${ param.str1 ne param.str2 }">
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같지 않습니다.
	</c:if>
		
	<br><br>
		
	<!-- equals 비교 -->
	<b>equals 비교</b><br>
	<c:if test="${ param.str1.equals(param.str2) }">	<!-- .equals() -->
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같습니다.
	</c:if>
	<c:if test="${ !param.str1.equals(param.str2) }"> <!-- ! equals() -->
		'${ param.str1 }' 문자와 '${ param.str2 }' 문자는 같지 않습니다.
	</c:if>
	
	
	
	
	

</body>
</html>







