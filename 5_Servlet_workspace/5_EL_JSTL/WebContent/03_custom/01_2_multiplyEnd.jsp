<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
	prefix="c" : 코어를 c라고 부르겠다고 지정 
	url : 
-->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>jstl core 라이브러리</h1>
	<h2>core set태그 : 변수선언</h2>


	<p>
		사용할 태그 라이브러리 선언 : taglib 지시자 사용 <br>
		prefix : 앞첨자, 다른 태그와 구분할 수 있는 namespace제공 (코어를 계속 부르기 힘드니 별칭을 지어주는 것)<br>	
		uri : 실제 웹상의 주소가 아닌 해당 라이브러리를 나타내는 '식별자'<br>
	</p>
		
<!-- 
	  지시자를 담을 수 있는 건  강의5:21 < %@   %> 
 	 page, include, taglib
		  taglib는 외부에있는 라이브러리를 쓰겠다는 의미의 속성값
		  	
 -->
		
<%-- 	<c:set></c:set> <!-- Core를 나타내는 접두사로 c를 많이 사용함 // prefix 안쓰면 core라고 써야함 -->	 --%>
	
	
<!-- 	
	1번 파일 멀티플라이에서 name="num1" 값을 받아올 것
	서블릿을 거쳐오는게 아닌 뷰에서 바로 넘어오는 것임.
		스크립틀릿을 사용한다면 getParameter() - 파라미터 값을 가져오는거기 때문에 겟파라미터 메소드
		core set태그를 사용한다면 , 													-->
	<c:set var="no1" value="${ param.num1 }"/> <!-- 뷰에서뷰로 가져올 때만 사용 -->
	<c:set var="no2" value="${ param.num2 }"/>
	
	<!-- 위 num1,2의 곱셈값을 result에 넣을 것임 --> <!-- el 사용해야함 -->
	<c:set var="result" value="${ no1 * no2}"/>
	<c:set var="result" value="${ param.num1 * param.num2 }"/> <!-- 이 방법도 가능 -->  
	<p>${ no1 } * ${ no2 }" = ${ result }</p>



	<hr>
	
	
	
	<h2>core remove 태그</h2>
	<c:set var="result" value="9999" />
	<c:set var="result" value="9999" scope="request"/>
	${ result }
	
	${ result } <!-- 위에서 찍었던 result 찍으면 다시 9999가 나오는데, 뒤에 만든 값이 덮어씌워진 것 -->
	<!-- 스코프 범위 지정안하면 page일 수 밖에 없음  -->
	
	<!-- 스코프 지정과 미지정 시 차이 -->
	삭제 전 result : ${result }<br> <!-- 위의 no1*no2한 값인 12가 나옴 -->
	삭제 전 requestScope.result : ${ requestScope.result }<br> <!-- 9999 나옴 -->
	
	<br>
	
	<c:remove var="result"/>
	<!-- result 변수 삭제 -->
	<!-- 스코프 지정안하면 모든 스코프의 범위에서 삭제함 & 스코프 지정 삭제 가능 -->
	삭제 후 result : ${result }<br> <!-- 결과값 : 빈칸 -->
	삭제 후 requestScope.result : ${ requestScope.result }<br> <!-- 결과값 : 빈칸 -->
	
	<!-- 지정한 스코프에서만 삭제 -->
	<c:remove var="result" scope="request"/> <!-- request 스코프에 있는 var변수만 삭제-->
	1)c:remove scope : request
		삭제 후 result : ${result }<br> <!-- 결과값 : 넣은 숫자 -->
	삭제 후 requestScope.result : ${ requestScope.result }<br> <!-- 결과값 : 빈칸 -->
	
	<c:remove var="result" scope="page"/> <!-- request 스코프에 있는 var변수만 삭제-->
	2)c:remove scope : page
	삭제 후 result : ${result }<br> <!-- 결과값 : 9999 -->
	삭제 후 requestScope.result : ${ requestScope.result }<br> <!-- 결과값 : 9999 -->


</body>
</html>







