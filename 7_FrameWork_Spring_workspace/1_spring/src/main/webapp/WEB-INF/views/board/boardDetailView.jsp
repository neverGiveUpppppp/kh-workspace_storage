<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#boardDetailTable{width: 800px; margin: auto; border-collapse: collapse; border-left: hidden; border-right: hidden;}
	#boardDetailTable tr td{padding: 5px;}
	.replyTable{margin: auto; width: 500px;} 
	
</style>
</head>
<body>
	<c:import url="../common/menubar.jsp"/>
	
	<h1 align="center">${ board.boardId }번 글 상세보기</h1>
	
	<form action="bupView.bo" method="post">
		<table border="1" id="boardDetailTable">
			<tr>
				<th>번호</th>
				<td>
					${ board.boardId }
					<input type="hidden" value="${ board.boardId }" name="boardId"> <!-- boardId넣는 이유 : 모델어트리뷰트로 받아올려는 것 -->
					<input type="hidden" value="${ page }" name="page">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					${ board.boardTitle }
					<input type="hidden" value="${ board.boardTitle }" name="boardTitle">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					${ board.nickName }
					<input type="hidden" value="${ board.nickName }" name="nickName">
				</td>
			</tr>
			<tr>
				<th>작성날짜</th>
					<td>
						${ board.boardCreateDate }
					</td>
			</tr>
			<tr>
				<th>내용</th>
				<%-- <td>${ board.boardContent }</td> --%>
				<!-- 
					이렇게만 두면 줄바꿈 엔터가 먹지 않음. 
					DB에는 엔터가 \r\n으로 들어가서 이를 치환해주는 작업 필요
				-->
				
				<% pageContext.setAttribute("newLineChar", "\r\n"); %> <!-- \r\n 말고 그냥 \n도, \r도 가능하다 -->
				<td>
					${ fn:replace(board.boardContent, newLineChar, "<br>") }
					<input type="hidden" value="${ board.boardContent }" name="boardContent">
				</td>
				
			</tr>
			
			<c:if test="${ !empty board.originalFileName }">
				<tr>
					<th>첨부파일</th>
					<td>
						<a href="${ contextPath }/resources/buploadFiles/${ board.renameFileName }" download="${ board.originalFileName }">${ board.originalFileName }</a>
						<!-- a태그 안에서 다운로드 받을 것이 있을 때 쓰는 속성 download, 얘는 download="fileName" 이라고 해서 fileName을 지정해줄 수 있다. -->
						<input type="hidden" value="${ board.originalFileName }" name="originalFileName">
						<input type="hidden" value="${ board.renameFileName }" name="renameFileName">
					</td>
				</tr>
			</c:if>
			
			<%-- <c:url var="bupView" value="bupView.bo">
				<c:param name="bId" value="${ board.boardId }"/>
				<c:param name="page" value="${ page }"/>
			</c:url> --%>
			
			
			<c:url var="bdelete" value="bdelete.bo">	<!-- c:url 변수선언함. 그리고 아래 button태그에서 끌어다 씀 -->
				 <c:param name="bId" value="${ board.boardId }"/>	<!-- 삭제버튼에 필요한 게시판번호 데이터보내기 -->
				 <c:param name="renameFileName" value="${ board.renameFileName }"/>
			</c:url>
			<c:url var="blist" value="blist.bo">  <!-- 게시판목록으로 가는 url설정 -->
				<c:param name="page" value="${ page }"/> <!-- 보던 게시판으로 돌아가기 위해 page번호 필요 for pagination -->
			</c:url>
			  
			<!-- 로그인한 유저가 작성자라면, 수정삭제버튼 보이기 --> 
			<c:if test="${ loginUser.id eq board.boardWriter }">
				<tr>
					<td colspan="2" align="center">
						<button>수정하기</button>
						<button type="button" onclick="location.href='${ bdelete }'">삭제하기</button>
					</td>	<!--속성추가 type="button"-->
				</tr>
			</c:if>
			
		</table>
	</form>
	
	
	<p align="center">
		<button onclick="location.href='home.do'">시작 페이지로 이동</button>
		<button onclick="location.href='${ blist }'">목록 보기로 이동</button>
	</p>
	
	
	
	
	
	<br><br>
	
	<table class="replyTable">
		<tr>
			<td><textarea cols="55" rows="3" id="replyContent"></textarea></td>
			<td><button id="rSubmit">등록하기</button></td>
		</tr>
	</table>
	<table class="replyTable" id="rtb">
		<thead>
			<tr>
				<td colspan="2"><b id="rCount"></b></td>
			</tr>
		</thead>
		<tbody>
		
		
		</tbody>
	</table>
	
	<script>
		/* 댓글 등록 먼저 해 볼 예정 */
		$('#rSubmit').click(function(){
			var rContent = $('#replyContent').val();
			var refBId = ${board.boardId};
			
			$.ajax({
				url: 'addReply.bo',
				data: {replyContent:rContent, refBoardId:refBId},
				success: function(data) {
					console.log(data);
					if(data == 'success'){
						$('#replyContent').val(' '); // .val(' ') 넣는 이유?
					}
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
		
		
		function getReplyList() {
			$.ajax({
				url: 'rList.bo',
				data: {bId:${board.boardId}},
				success: function(data) {
					console.log(data);
					
					// 계속 이어붙기 때문에 공백 넣어주기. 댓글이 이어서 나오면 뷰가..
					$tableBody = $('#rtb tbody');
					$tableBody.html('');
					
					var $tr;
					var $writer;
					var $content;
					var $date;
					$('#rCount').text('댓글(' + data.length + ')');
					
					if(data.length > 0) {
						for (var i in data) {
							$tr = $('<tr>');
							$writer = $('<td>').css('width', '100px').text(data[i].nickName);
							$content = $('<td>').text(data[i].replyContent);
							$date = $('<td width="100px">').text(data[i].replyCreateDate);
						
							$tr.append($writer);
							$tr.append($content);
							$tr.append($date);
							$tableBody.append($tr);
						}
					}else{
						$tr = $('<tr>');
						$content = $('<td colspan="3">').text('등록된 댓글이 없습니다.');  /* attr해서 집어넣는 것도 가능 */
					
						$tr.append($content);
						$tableBody.append($tr);
					}
				},
				error: function(data) {
					console.log(data);
				}
			});
		}
		
		// 다른 사람이 쓴 댓글도 볼 수 있게 5초마다 읽어오도록
		$(function(){
			getReplyList();
			
			setInterval(function(){
				getReplyList();
			}, 5000); // 5000 = 5초
		});
		
	</script>
	
	
	
	
</body>
</html>








