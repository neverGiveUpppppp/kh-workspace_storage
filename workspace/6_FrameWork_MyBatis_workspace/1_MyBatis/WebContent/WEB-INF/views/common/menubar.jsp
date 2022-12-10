<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${ contextPath }/js/jquery-3.6.0.min.js"></script> <!-- src="${ contextPath } : 어디선가 변수로 쓴 것을 가져온 것 -->
<title>Insert title here</title>
<style>
	#welcome{background: black; text-shadow: -1px -1px 0 red, 1px -1px 0 white, -1px 1px 0 white, 1px 1px 0 white;}
	.login-area {height:100px;}
	.btn-login {height:50px;}
	.loginTable{text-align: right; float: right;}
	#logoutBtns>a{text-decoration: none; color: black;}
	#logoutBtns>a:hover{text-decoration: underline; font-weight: bold;}
	.nav-area{background: black; height: 50px;}
	.menu{display: table-cell; width: 250px; height: 50px; text-align: center;
		vertical-align:middle; font-size: 20px; background: black; color: white;
	}
	.menu:hover{background: orangered; cursor: pointer;}
</style>
</head>
<body>
	<!-- 컨텍스트패쓰를 변수로 짧게 쓸 수 있게 var 지정! -->
	<!-- c:set까지 매번 쓰기 번거로우니 영역(scope)지정까지 하자 -->
	<!-- scope="application"이면 프로젝트 파일 내에 다 작동함 -->
	<!-- pageContext.servletContext.contextPath에서  servletContext대신 request도 가능-->
	<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"></c:set> 
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"></c:set> --%> 
	<h1 id="welcome" align="center" onclick="home()">Welcome to MyBatis World!!</h1> <!-- 밑에 home 펑션 작동하도록 onclick="" 추가 -->
	<br>
	
	
	
	
	<!-- ----------------------1. 회원 관련 서비스 -------------------------- -->
	<div class="login-area">	  
		<c:if test="${ empty sessionScope.loginUser }">  <!-- c:if -->
		<!-- 1_1. 로그인 관련 폼 만들기 -->
		<form action="${ contextPath }/login.me" method="post">
			<table class="loginTable">
				<tr>
					<td>아이디 : </td>
					<td>
						<input type="text" name="userId">
					</td>
					<td rowspan="2">
						<button id="login-btn" class="btn btn-login">로그인</button> <!-- 폼태그 안에 모든 버튼은 submit역할함. 이게 디폴트값 -->
					</td>
				</tr>
				<tr> 
					<td>비밀번호 : </td>
					<td>
						<input type="password" name="userPwd">
					</td>
				</tr>
				<tr>
					<td colspan="3" id="logoutBtns">
						<a href="${ contextPath }/memberInsertForm.me">회원가입</a>
						<a href="${ contextPath }/findMemberForm.me">아이디/비밀번호 찾기</a>
					</td>
				</tr>
			</table>
		</form>
		</c:if>
		<c:if test="${ !empty sessionScope.loginUser }">
			<table class="loginTable">
				<tr>
					<td colspan="2"><h3>${ loginUser.userName }님 환영합니다.</h3>
				</tr>
				<tr>
					<td><button onclick="location.href='${ contextPath }/info.me'">내 정보 보기</button></td>
					<td><button onclick="location.href='${ contextPath }/logout.me'">로그아웃</button></td>
				</tr>
			</table>
		</c:if>
	</div>
	
	<!-- 공지사항과 게시판 비슷. admin만 쓸 수 있는 차이가 보통이라 게시판만 진행  -->
	<div class="nav-area" align="center">
		<div class="menu" onclick="home();">HOME</div>
		<div class="menu" >공지사항</div>
		<div class="menu" onclick="location.href='${contextPath}/selectList.bo'">게시판</div>
		<div class="menu" >etc.</div>
	</div>
	
	<script>
		function home(){
			location.href="${ contextPath }";
		}
	</script>
	
	
	
</body>
</html>