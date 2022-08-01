<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Board" %>
<% Board b = (Board)request.getAttribute("b"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:500px; height:350px; margin-left:auto; margin-right:auto;}
	#updateBtn, #cancelBtn{background: #B2CCFF; border-radius: 10px; color: white; width: 80px; height: 25px; display: inline-block;}
	#updateBtn:hover, #cancelBtn:hover{cursor: pointer;}
	#cancelBtn{background: #D1B2FF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 수정</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/update.bo" method="post">
				<table>
					<tr>
						<th>분야<input type="hidden" name="bId" value="<%= b.getBoardId() %>"></th>
						<td>
							<select name="category">
								<option>--------</option>
								<option value="10" <%= b.getCategory().equals("공통") ? "selected":"" %>>공통</option>
								<option value="20" <%= b.getCategory().equals("운동") ? "selected":"" %>>운동</option>
								<option value="30" <%= b.getCategory().equals("등산") ? "selected":"" %>>등산</option>
								<option value="40" <%= b.getCategory().equals("게임") ? "selected":"" %>>게임</option>
								<option value="50" <%= b.getCategory().equals("낚시") ? "selected":"" %>>낚시</option>
								<option value="60" <%= b.getCategory().equals("요리") ? "selected":"" %>>요리</option>
								<option value="70" <%= b.getCategory().equals("기타") ? "selected":"" %>>기타</option>
							</select>
						</td>	
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="58" name="title" value="<%= b.getBoardTitle() %>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="15" cols="60" name="content" style="resize:none;"><%= b.getBoardContent() %></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button type="submit" id="updateBtn">수정</button>
					<div id="cancelBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo'">취소</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>