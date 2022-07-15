<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- fmt 형식 지정하는거 볼 것임 

fmt:formatNumber
표현하고자 하는 숫자의 포맷을 통화 기호, ‘,’ 표시, % 표시 등 원하는 쓰임에 맞게 지정 가능



																				-->
	<fmt:setLocale value="ko_kr"/>										
																				
	<h3> 숫자 데이터 : formatNumber</h3>
	<fmt:formatNumber value="123456789"/><br> <!-- 123,456,789 -->
		<!-- groupingUsed -->	
	<fmt:formatNumber value="123456789" groupingUsed="falsed"/><br>  <!-- groupingUsed="디폴트값은 true" 강의 12:22-->
	<fmt:formatNumber value="1.2345678" /><br>  <!-- 1.235 소수점 셋째자리까지 나오고 반올림-->
	
	
	<!-- pattern="" : 원하는 자릿수 설정 -->
	<fmt:formatNumber value="1.2345678" pattern="#.##"/><br>  <!-- 1.23 소수점 두자리까지 나오고 반올림 --> <!-- 오라클 toNumber 때 했던 것과 비슷 -->
	<fmt:formatNumber value="1.2345678" pattern="#.00"/><br>  <!-- 1.23 소수점 두자리까지 나오고 반올림 -->
		<!-- #과 0의 차이 -->
	<fmt:formatNumber value="1.2" pattern="#.##"/><br>  <!-- 1.2   여분의 자릿수 공백(스페이스바)도 없는 없는 공간 -->
	<fmt:formatNumber value="1.2" pattern="#.00"/><br>  <!-- 1.20 여분의 자릿수는 0으로 채움 -->
	
	
	<!-- type="" : 기호 -->
	<fmt:formatNumber value="0.12" type="percent"/><br>  	  <!-- 12% -->
	<fmt:formatNumber value="123456789" type="currency"/><br> <!-- ￦123,456,789 -->
		<!-- currencySymbol="" --> 
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br>  <!-- $123,456,789 -->
	<!-- ¤ 가 나온다면 로케일 설정해야함 -->
	<%-- <fmt:setLocale value="ko_kr"/> --%> <!-- 코드 순서를 위로 올려야 적용됨. 프로시듀얼 프로그래밍 -->																				

</body>
</html>