<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- 
메뉴바 파일 넣을 건데

	인클루드 하는 방법 2가지
1.인클루드 지시자 사용
2.표준 액션태그 사용
	- 커스텀태그만 라이브러리 필요

  
 		1.인클루드 지시자 사용 																-->
<%--   <%@ include file="menubar.jsp" %> --%>
  
  <!-- 2.표준 액션태그 사용 -->
  <jsp:include page="WEB-INF/views/common/menubar.jsp"></jsp:include>
  <h1 align="center">Hello, I'm MyBatis!</h1>
  <div align="center">
  		<img src="${pageContext.servletContext.contextPath }/resources/mybatis.PNG">  
  		<!-- 스크립틀릿 request.Contextpath대신 el로 표현 -->
  </div>


</body>
</html>