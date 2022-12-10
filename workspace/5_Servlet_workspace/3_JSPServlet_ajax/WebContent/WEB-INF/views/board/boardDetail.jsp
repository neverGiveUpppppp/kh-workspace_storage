<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Board" %>
<% Board b = (Board)request.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:800px; height:500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left:auto; margin-right:auto; margin-top:50px;
	}
	.tableArea {width: 450px; height:350px; margin-left:auto; margin-right:auto; align: center;}
	table{align: center;}
	#updateBtn{background: #B2CCFF;}
	#menuBtn{background: #D1B2FF;}
	#deleteBtn{background: #D5D5D5;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 상세보기</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/boardUpdateForm.bo" id="detailForm" method="post">
				<table>
					<tr>
						<th>분야</th>
						<td>
							<%= b.getCategory() %>
							<input type="hidden" name="category" value="<%= b.getCategory() %>">
						</td>
						<th>제목</th>
						<td colspan="3">
							<%= b.getBoardTitle() %>
							<input type="hidden" name="title" value="<%= b.getBoardTitle() %>">
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%= b.getNickName() %></td>
						<th>조회수</th>
						<td><%= b.getBoardCount() %></td>
						<th>작성일</th>
						<td><%= b.getModifyDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="6">
							<textarea cols="60" rows="15" style="resize:none;" readonly name="content"><%= b.getBoardContent() %></textarea>
							<input type="hidden" name="bId" value="<%= b.getBoardId() %>">
						</td>
					</tr>
				</table>
				
				<div align="center">
					<% if(b.getBoardWriter().equals(loginUser.getUserId()) && loginUser != null){ %>
						<input type="submit" id="updateBtn" value="수정">
						<input type="button" onclick="deleteBoard();" id="deleteBtn" value="삭제">
					<% } %>
					<input type="button" onclick="location.href='<%= request.getContextPath() %>/list.bo'" id="menuBtn" value="메뉴로">
				</div>
			</form>
		</div>
	</div>
	<script>
		function deleteBoard(){
			if(confirm('정말 삭제하시겠습니까?')){
				location.href="<%= request.getContextPath() %>/delete.bo?bId=" + <%= b.getBoardId() %>;
			}
		}
	</script>
</body>
</html>