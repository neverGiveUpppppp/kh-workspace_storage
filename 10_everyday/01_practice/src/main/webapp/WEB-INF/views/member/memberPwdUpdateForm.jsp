<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> prac</title>

<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/resources/css/member-style.css"> 

</head>
<body>

	<c:import url="../common/menubar.jsp"/>

	<h1 align="center">비밀번호 수정</h1>
	
	<div class="centerText">
		<form action="mPwdUpdate" method="post">
			<table>
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" name="newPwd1"></td>
				</tr>
				<tr>
					<th>새 비밀번호 확인</th>
					<td><input type="password" name="newPwd2"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기">
						<button type="button" onclick="location.href='home.do'">시작화면으로</button>
					</td>
				</tr>
				
			</table>
		</form>	
	</div>

</body>
</html>