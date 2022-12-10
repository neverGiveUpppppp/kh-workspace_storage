<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- 파일2번에서 보내온데이터를 받은 것 -->
	<%
		String num1 = request.getParameter("firstNum");
		String num2 = request.getParameter("secondNum");
		int result = (int)request.getAttribute("result");
	%>
	
	<%= num1 %>부터<%= num2 %>까지의 합은? <span style="color:pink;"><%= result %></span>
	
	<!-- 파일1번의 뷰에서 1+1 계산하기 눌러서 값 전송하고, 2번 파일의 url로 바뀌고 나오는 문자는 3번파일의 값이 나옴
		jsp.forward 때문임. 리퀘스트 디스패처 forwarding처럼 화면이동은 똑같으나 url이 그대로 유지된 상태로 이동시킴
		
		RequestDispatcher forward와 액션태그 jsp.forward의 차이
		url 유지 x
		url 유지 o
		
		
		폼으로 퍼스트넘, 세컨드넘을 넘김
		리퀘스트에 담아서 넘겼기 때문에 (스코프 : 리퀘스트의 영역은 한번 요청까지임)
		요청 마무리 했고 또 리퀘스트를 요청할려면 다시 리퀘스트 써야하는데 
		리퀘스트는 일회용이고 또다른 요청에 쓰일려면 다시 리퀘스트를 써줘야함
		
		기존에는 리퀘스트를 한번쓰고 소멸함
		
		jsp.forward는 리퀘스트를 재사용 가능
		forward는 forward()랑 같음
		forward와 sendDirect와 많이 비교했었는데 이 중 데이터를 담을 수 있는 유무에서 리퀘스트와 리스폰스 객체가 유지되서 데이터를 담는 것 떄문에
		그대로 가져와서 전달할 수 있었던 것
		같은 역할이라 이 포워드도 리퀘스트(요청)하면 리퀘스트와 리스폰스를 유지한 상태에서 요청하기 때문에 
		다시 한번 리퀘스트가 가능했던 것
			다시말해, request하고 또 firstNum과 secondNum을 호출할 수 있었던 것  
			Q.url이 유지되서 request가 유지되는거로 봐도되나요?
			A. 3개가 다 연결되어있기에 그렇게 봐도 괜찮
			
		1번 파일의 폼태그 메소드값을 post가 아닌 get방식으로 바꾸면 더 명확해짐
			
			
	 -->
	

</body>
</html>