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



<!-- 웹페이지 url주소를 바꾸기 위해 사용하는 태그 -->



	<!-- 2번파일의 데이터를 가지고 와서 a태그 링크로 연결되고 싶다면? -->
	<a href="06_2_urlEnd.jsp?pname=귀걸이&pcount=2&option=알러지X&option=큐빅추가">쿼리스트링</a>
	<!-- 단점 : 코드 가독성이 안좋다 -->
	
	<br>
	<!-- url 옮길 파일 value에 지정 -->
	   
   	<c:url value="06_2_urlEnd.jsp" var="u"> 
      <c:param name="pname" value="귀걸이"/>
      <c:param name="pcount" value="2"/>
      <c:param name="option" value="알러지X"/>
      <c:param name="option" value="큐빅추가"/>
 	<!-- 파일2번에 옵션1,2 pramValues.option[0],[1]이 option 순서대로 들어감. } -->
	</c:url> <%-- <!-- < c:url > 태그와 안에 있는 것들 전체를 지정하는 것을 var="" 속성에 담는 것 --> --%>
	<a href="${ u }">jstl:url</a>  <!-- a태그 안 u가 위의 var="u"를 불러오는 것임 -->
	

</body>
</html>