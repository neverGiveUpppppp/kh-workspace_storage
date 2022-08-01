<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice" %>
    
<% Notice not = (Notice)request.getAttribute("not"); %>    
    
    
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
	#updateNoBtn{background: #D1B2FF;}
	#cancelBtn{background: #B2CCFF;}
	#deleteNoBtn{background: #D5D5D5;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항</h2>
		<div class="tableArea">
			<form action="noticeUpdateForm.no" id="detailForm" name="detailForm" method="post">
				<table>
					<tr>
						<th>제목</th>
						<td colspan="3">
							<%= not.getNoticeTitle() %>
							<input type="hidden" size="50" name="title" value="<%= not.getNoticeTitle() %>">
							<input type="hidden" name="no" value="<%= not.getNoticeNo() %>">				
						</td>	
					</tr>
					<tr>
						<th>작성자</th>
						<td><%= not.getNickName() %> </td>		
						<th>작성일</th>
						<td>
							<%= not.getNoticeDate() %>
							<input type="hidden" name="date" value="<%= not.getNoticeDate() %>">
						</td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="4"> <!-- 공지사항 상세보기 보기전용이기에 수정불가하게 readonly속성 추가 -->
							<!-- 내용부분은 textarea자체가  input태그처럼 값을 넘기기게끔 되어있어서 내용부분은 안넣어도됨-->
							<textarea name="content" cols="60" rows="15" style="resize:none;" readonly><%= not.getNoticeContent() %></textarea>
							<!-- 너무 길면 들여쓰기하는 경우가 있는데 <textarea>는 뷰에서 띄어쓰기가 하나 나옴. 내용 부분 안에 띄어쓰기도 공백으로 인식하기 때문 -->
						</td>
					</tr>
				</table>
			
				<br>
				
				<div align="center">
					<% if(loginUser != null && loginUser.getUserId().equals(not.getNoticeWriter())){ %>
					<input type="submit" id="updateNoBtn" value="수정">
					<input type="button" id="deleteNoBtn" value="삭제" onclick="deleteNotice();">
					<% } %>
					<!-- 조회수가 실시간으로 바뀌도록  location.href='list.no로 변경-->
					<!-- <input type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="취소"> -->
					<input type="button" onclick="location.href='list.no'" id="cancelBtn" value="취소" >
				</div>
			</form>
		</div>
	</div>
	
	<script>
		function deleteNotice(){
			// 정말 삭제할거냐고 물어본 후, 삭제하겠다고 하면 delete.me로 요청
			var bool = confirm('정말 삭제하시겠습니까?');
			if(bool){
				location.href='<%= request.getContextPath() %>/delete.no?no=' + <%= not.getNoticeNo() %>;
				// /delete.no만 하면 어떤 게시판을 지우는지 db가 모르기 때문에 pk인 게시판 번호도 같이 넘겨주자
				
				// 또는
				<%-- $('#myForm').attr('action','<%= request.getContextPath() %>/delete.me'); --%>
				
				// $('#myForm').submit(); //
				// 어떤 방법으로 해도 괜찮음. 다만, 위처럼 attr로 진행하면 action이 바뀌어져 있는 상태이기 때문에
				// 수정하기를 눌러도 delete.me로 넘어감(주의!)
			}
		}
	</script>
	
</body>
</html>




