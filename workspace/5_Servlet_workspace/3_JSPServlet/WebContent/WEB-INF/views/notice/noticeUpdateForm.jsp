<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width: 600px; height: 500px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:450px; height:350px; margin-left:auto; margin-right:auto;}
	#updateNoBtn{background: #B2CCFF;}
	#cancelBtn{background: #D1B2FF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항 수정</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/update.no" method="post">
				<table>
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="text" name="title" size="50"value='<%= request.getAttribute("title") %>'>
							<input type="hidden" name="no" value='<%= request.getAttribute("no") %>'>
						</td>				
					</tr>
					<tr>
						<th>작성자</th>
						<td>운영자</td>
						<th>작성일</th>
						<td><td><input type="date" name="date" value='<%= request.getAttribute("date") %>'></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="60" rows="15" style="resize:none;"><%= request.getParameter("content") %></textarea>
						</td>
					</tr>
				</table>
				
				<br>
				
				<div align="center">
					<input type="submit" id="updateNoBtn" value="저장">
					<input type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>