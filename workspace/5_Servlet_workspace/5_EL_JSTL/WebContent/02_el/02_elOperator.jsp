<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="action.model.vo.Person, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		String str1 = "안녕";					// str
		String str2 = new String("안녕");		// 객체로 생성된 str 
		int big = 10;
		int small = 3;
		
		Person p1 = new Person("강건강", '남', 20);
		Person p2 = new Person("강건강", '남', 20);
	
		pageContext.setAttribute("str1", str1);
		pageContext.setAttribute("str2", str2);
		pageContext.setAttribute("big", big);
		pageContext.setAttribute("small", small);
		pageContext.setAttribute("p1", p1);
		pageContext.setAttribute("p2", p2);
		
		ArrayList<String> list = new ArrayList<>();
		list.add(str1);
		pageContext.setAttribute("list", list);
		
		
		ArrayList<String> list2 = new ArrayList<>();
		pageContext.setAttribute("list2", list2);
		
		
		ArrayList<String> list3 = null;
		pageContext.setAttribute("list3", list3);
		
	%>
	
	<%= request.getContextPath() %>
	

	<h3>산술연산</h3>
	<!-- ${} 외의 글자는 전부 화면 그대로 출력 됨  -->
	10 * 7 = ${ 10 * 7 }<br>
	<%-- 100 / 3 = ${ 100 /3 } = ${ 100 div 3 }<br> --%> <!-- div 3에 빨간줄 뜨는건 이클립스 버그 -->
	15 % 4 = ${ 15 % 4 } = ${ 15 mod 4 }<br>
	
	
	<hr>
	스크립트 : <%= str1 == str2 %> <br><!-- false로 뜸 --> 
	el : ${str1 == str2 } 또는 ${ str1 eq str2 }<br> <!-- true 뜸 -->
	
	스크립트 : <%= str1 != str2 %><br>
	el : ${str1 != str2 } 또는 ${str1 ne str2 }<br>
	
	
	big > small : ${ big > small } 또는 ${ big gt small }<br>		 <!-- true -->
	big < small : ${ big < small } 또는 ${ big lt small }<br>		<!-- false -->
	big >= small : ${ big >= small } 또는 ${ big ge small }<br>  <!-- true -->
	big <= small : ${ big <= small } 또는 ${ big le small }<br>  <!-- false -->
	<br>
	
	p1 == p2 : <%= p1 == p2 %> / ${ p1 == p2 } 또는 ${p1 eq p2 }<br> <!-- false -->
	
	<br>

	<h3>객체가 비어있는지 null인지 체크</h3>
	${ empty list }<br> <!-- false  -->
	${ empty list2 }<br> <!-- true  -->
	${ empty list3 }<br> <!-- true  --> <!-- 빈 객체 true -->

	<br>

	<h3>논리연산자/부정연산자</h3>
	${ true and true }, ${ true && true }<br>  <!-- true, true -->
	${ true or false }, ${ true || false }<br> <!-- true, true -->
	${ !true }, ${ not true } <br> <!-- false,false -->				



</body>
</html>






