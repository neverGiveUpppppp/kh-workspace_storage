<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.ArrayList, board.model.vo.*" %>
    
<% ArrayList<Board> bList = (ArrayList<Board>)request.getAttribute("bList"); %>
<% ArrayList<Attachment> fList = (ArrayList<Attachment>)request.getAttribute("fList"); %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{width:1000px; height:700px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left:auto; margin-right:auto; margin-top:50px;
	}
	.thumbnailArea {width:760px; height:550px; margin-left:auto; margin-right:auto;}
	.buttonArea {width:80px; margin-left:auto; margin-right:auto;}
	.thumb-list {width:220px; border:1px solid white; display:inline-block; margin:10px; align:center;}
	.thumb-list:hover {opacity:0.8; cursor:pointer;}
	#insertBtn{background: #B2CCFF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		
		
		<h2 align="center">사진 게시판</h2>
		<div class="thumbnailArea">
			
			<% if(bList.isEmpty() || fList.isEmpty()){ %>
				등록된 사진이 없습니다. <!-- 사진이 진짜 없을 때만 나와야함 -->
			<% }else{%>
				<% for(int i = 0; i < bList.size(); i++){ %>
					<% Board b = bList.get(i); %> <!-- 많은 보드들 중에서 필요한 보드(게시판) 하나 꺼내올 수 있음 -->
					<!-- 게시글에 맞는 섬네일,사진을 매칭시켜주려면 또 뭘써야할까? -->
					<!-- 또 for문 돌려서 하나씩 확인 해야함 -->
					
					<!-- 이중for문 구조 -->	
					<!-- 이중for문 구구단 생각할 것. 1x1 1x2이 형식이 일반게시판1x사진파일1 일반게시판1x사진파일2식으로 하나씩 for문돌려서 매칭시키는 것-->
					<!--  ex)board_id가 1인 게시판에 사진파일 전체 다 매칭시켜서 맞는거 찾고  board_id가 2인 게시판에 사진파일 전체 다 매칭시켜서 맞는거 찾는 방식-->	
					<div class="thumb-list" align="center"> 	<!-- thumb-list -->	
					<!-- 일단 게시글들을 모두 한번씩 출력해야함 -->
						<div>
							<input type="hidden" value="<%= b.getBoardId() %>"> <!-- 상세보기할 때  사용할 것임  --> 
							<% for(int j = 0; j < fList.size(); j++){ %>
								<% Attachment a = fList.get(j); %>
								<% if(b.getBoardId() == a.getBoardId()){ %>
									<img src="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%= a.getChangeName() %>" width="200px" height="150px">
								<% } %>
							<% } %>
						</div>
						<p>
							NO. <%= b.getBoardId() %> <%= b.getBoardTitle() %><br>
							조회수 : <%= b.getBoardCount() %>
						</p>
					</div>
				<% } %>
			<% } %>

		</div>
		
		<div class="buttonArea">
			<% if(loginUser != null) { %>
				<input type="button" onclick="location.href='writeThumbForm.th'" id="insertBtn" value="작성하기">
			<% } %>
		</div>
	</div>
	
	<script>
		$(function(){
			$('.thumb-list').click(function(){
				var bId = $(this).children().children().eq(0).val(); /* 칠드런 p단락 // 그 안에 있는  인풋태그,img태그 / eq(0) : 0번째랑 일치하는거니 input태그.eq(1)이면 img태그 그리고 밸류값 가져와라  */
				location.href = "<%= request.getContextPath() %>/detail.th?bId=" + bId;
			}); 
		});
	</script>
	
	
	
	
	
	
</body>
</html>