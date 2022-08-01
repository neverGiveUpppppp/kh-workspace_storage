<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		int first = Integer.parseInt(request.getParameter("firstNum"));
		int second = Integer.parseInt(request.getParameter("secondNum"));
		
		int result = 0;
		for(int i = first; i <= second; i++){
			result += i;
		}
		
		request.setAttribute("result", result);
		
	%>

	<!-- 위에서 받은 거를 forward로 보낼 것임 -->
	<!-- forward는 리퀘스트디스패처 포워드랑 비슷 -->
	<jsp:forward page="01_3_sumView.jsp"/>




</body>
</html>


