<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*" %>
    
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

 	System.out.println(pi); /* 디버깅용  */
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	#listArea{text-align: center;}
	.tableArea{width:650px;	height:350px; margin-left:auto;	margin-right:auto;}
	th{border-bottom: 1px solid grey;}
	.pagingArea button{border-radius: 15px; background: #D5D5D5;}
	.buttonArea{margin-right: 50px;}
	.buttonArea button{background: #D1B2FF; border-radius: 5px; color: white; width: 80px; heigth: 25px; text-align: center;}
	button:hover{cursor: pointer;}
	#numBtn{background: #B2CCFF;}
	#choosen{background: #FFD8D8;}
	#listArea{margin: auto;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시판</h2>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th width="100px">글번호</th>
					<th width="100px">카테고리</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th width="100px">조회수</th>
					<th width="150px">작성일</th>
				</tr>
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<% } else{ %>
					<% for(Board b : list){ %>
					<tr>
						<td><%= b.getBoardId() %></td>
						<td><%= b.getCategory() %></td>
						<td><%= b.getBoardTitle() %></td>
						<td><%= b.getNickName() %></td>
						<td><%= b.getBoardCount() %></td>
						<td><%= b.getModifyDate() %></td>
					</tr>
					<% } %>
				<% } %>
			</table>
		</div>
		
		<!-- 페이징 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=1'"> &lt;&lt; </button>
			
			<!-- 이전 페이지로 -->
			<!-- 이전 페이지 기준이 되는 것 : 현재페이지(currentPage) // < %= pi.getMaxPage()-1 %> : 이 코드의 문제는 0을 지나서 마이스로 가기 때문에 cp가 1에 도달하면 스톱하는 조건 필요 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage()-1 %>'" id="beforeBtn"> &lt; </button>
				<script>
					if(<%= pi.getCurrentPage() %> <= 1){ /* 1페이지에 도달하면 버튼 비활성화 */
						$('#beforeBtn').prop('disabled',true); /* 속성 넣을 때 true/false 넣는건 프로퍼티 사용한다고 했었음 . 다양한 값이 들어갈 것은 attr 함수를 사용하는거고*/
					}
				</script>
			
			<!-- 숫자 페이지로 -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){ %>
				<% if(p == pi.getCurrentPage()){ %>
					<button id="choosen" disabled><%= p %></button>
				<% } else{ %>
					<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			
			<!-- 다음 페이지로 -->
			<!-- 얘도 마찬가지로 맥스페이지에 도달하면 멈추게 해야함 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage()+1 %>'" id="afterBtn"> &gt; </button>
				<script>
					if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
						$('#afterBtn').prop('disabled', true);
					}
				</script>
			<!-- 맨 마지막으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getMaxPage() %>'"> &gt;&gt; </button>
			
		</div>
		
		
		<!-- 작성하기 버튼 -->
		<div class="buttonArea" align="right">
			<% if(loginUser != null){ %>
				<button onclick="location.href='<%= request.getContextPath() %>/writeBoardForm.bo'"> 작성하기 </button>
			<% } %>
		</div>
	</div>
	
	<script>
	$(function(){
		$('#listArea td').mouseenter(function(){
			$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
		}).mouseout(function(){
			$(this).parent().css('background','none');
		}).click(function(){
			var bid = $(this).parent().children().eq(0).text();
			
			if(<%= loginUser %> != null){
				location.href = '<%= request.getContextPath() %>/detail.bo?bId=' + bId;
			} else {
				alert('회원만 이용할 수 있는 서비스입니다. ');
			}
		});
	});
	</script>
	
</body>
</html>




