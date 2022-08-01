<!-- java import하는 방법1 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/error.jsp"%>
<%@ page import="java.util.ArrayList"%>   
   

<!-- java import하는 방법2 -->
<%--  <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- pageEncoding="UTF-8" import="java.utill.ArrayList" %> --%>
    
<!--  지시자의 종류 3가지 -->  
<!--     
		page : 현재 jsp의 설정, 정보를 담아두는 곳
   		tag library
  		include
   
 -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> jsp/02_directivePage.jsp </title>




</head>
<body>
	<!-- HTML주석 --> <!-- html주석은 개발자툴에서 보임 -->
	<%-- JSP주석 --%> <!-- jsp주석은 개발자툴에서 안보임 -->

	<%
		int total = 0;
		for(int i = 1; i<= 10; i++){

	%>
		이렇게하면 어떻게 될까나?<%= i %><br>   <!-- 이 문장이 포문 안에있어서 10번 출력됨 --> 
										<!-- for문 적용도 되고 br태그도 먹힘  -->
	<%
		total += 1;
		}

		ArrayList<String> list = new ArrayList<>(); //	ArrayList사용을 위해 위에 <%page안에 % >임포트해야함
		list.add(null);
		System.out.println(list.get(0).charAt(0)); // 널포인트익셉션 에러발생
	%>
	
	<br><br>
	
	<%-- JSP 출력문코드 : <%= 출력내용 %>    --%>
	1부터 10까지의 합은 <%= total %> 입니다.<br> <%-- total이라는 변수에 저장했으니 출력할려면 출력문코드 <%= %>코드에 total변수를 넣어준다 --%>
										 <!-- 출력문에 세미콜론(;) 사용 x -->
	1부터 10까지의 합은<% out.print(total); %> <!-- 위와 같은 결과 코드 --> <!-- 자바코드가 들어가기에 ;을 넣어야함 -->
	
	
	<!-- JSP 특징 -->
	
	
	
	
</body>
</html>



