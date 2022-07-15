<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 입력한 두개 수 사이의 값들을 더한 누적 값 구하기</h2>
	
	<!-- 폼태그에 인풋타입 submit 없음 -->
	<form action="01_2_sumCalc.jsp" method="post">
		첫번째 수 : <input type="text" name="firstNum"><br>
		두번째 수 : <input type="text" name="secondNum"><br>
		<button>계산하기</button>
	<!-- 폼태그 안에 있는 button태그는 자동으로 submit 역할함 -->
	<!-- 만약 폼태그 안에 버튼태그를 버튼 역할만 하고 싶으면 버튼태그 안에 type="button" 넣어줘야함 -->	
		
		<!-- 값 넘어감 강의 12:39 -->
	</form>
	
	
	
	
	
	
</body>
</html>