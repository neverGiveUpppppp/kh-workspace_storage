<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.*, java.util.*"%>
    
<%
	Board b = (Board)request.getAttribute("board");
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
%>


    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer {
		width:1000px; height:735px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left:auto; margin-right:auto; margin-top:50px;
	}
	.detail{text-align:center;}
	.detail th, .detail td{width: 1000px; padding: 10px; background: rgba(255, 255, 255, 0.4);}
	.detail th{background: white;}
	#titleImgArea{width:500px; height:300px; margin-left:auto; margin-right:auto;}
	#contentArea{height:30px;}
	.detailImgArea{width:250px; height:210px; margin-left:auto; margin-right:auto;}
	#titleImg{width:500px; height:300px;}
	.detailImg{width:250px; height:180px;}
	.downBtn{background: #D1B2FF;}
	#thumbTable{margin: auto;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<table class="detail" id="thumbTable">
			<tr>
				<th width="50px">제목</th>
				<td colspan="5"><%= b.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%= b.getNickName() %></td>
				<th>조회수</th>
				<td><%= b.getBoardContent() %></td>
				<th>작성일</th>
				<td><%= b.getModifyDate() %></td>
			</tr>
			<tr>
				<th>대표<br>사진</th>
				<td colspan="4">
					<!-- 대표사진 넣는 코드 -->
					<div id="titldImgArea" align="center">
						<a href="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%= fileList.get(0).getChangeName () %>"
							download="<%= fileList.get(0).getChangeName () %>">
							<!-- getChangeName하면 변경된 이름 저장한 파일을 다운받는거고 origin하면 원본파일명으로 저장함 -->
						<img id="titleImg" src="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%= fileList.get(0).getChangeName()%>">
					</div>
				</td>
			</tr>
			<tr>
				<th>사진<br>메모</th>
				<td colspan="6">
					<p id="contentArea">
						<%= b.getBoardContent() %>
					</p>
				</td>
			</tr>
		</table>
		
		<table class="detail">
			<!-- 내용 사진들 여러장 추가한거 보이게 하는 <tr> 및 코드 -->
			<tr>
				<% for(int i = 1; i < fileList.size(); i++){ %>
					<td>
						<div class="detailImgArea">
							<a href="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%= fileList.get(0).getChangeName () %>"
								download="<%= fileList.get(i).getOriginName() %>">
							
							<img id="detailImg" class="detailImg"
							src="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%= fileList.get(i).getChangeName() %>">
						</div>
					</td>
				<% } %>
			</tr>
		</table>
	</div>
	
	
</body>
</html>



