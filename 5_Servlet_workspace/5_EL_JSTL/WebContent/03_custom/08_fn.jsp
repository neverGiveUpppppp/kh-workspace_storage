<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>         
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>문자열 관련 함수 태그 : fn</h2>
	<c:set var="str" value="How are you?"/>
	<%-- <!-- 넣을 값에 <fn:>할 것 같지만 el 안에서 사용함 --> --%>
	원문: ${str}<br>
	모두 대문자로 : ${fn:toUpperCase(str) }<br>
	모두 소문자로 : ${fn:toLowerCase(str) }<br>
	are의 위치 : ${fn:indexOf(str,"are") }<br> <!-- indexOf : 글자 위치 나타냄 -->
	are를 were로 바꾸기 : ${fn:replace(str,"are","were") }<br> 	<!-- replace : 위치바꾸기 -->																	
	문자열 길이: ${fn:length(str) }<br> <!-- length : 문자열 길이 -->
	
	 																		

</body>
</html>