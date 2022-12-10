<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="personFrm" action="01_useBean.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<div id="radioSet">
						<label for="man">남</label><input type="radio" name="gender" id="man" value="남">
						<label for="woman">여</label><input type="radio" name="gender" id="woman" value="여">
					</div>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="nai" id="nai"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>