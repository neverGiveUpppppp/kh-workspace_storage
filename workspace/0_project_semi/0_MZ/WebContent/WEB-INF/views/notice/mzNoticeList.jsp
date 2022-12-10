<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,notice.model.vo.MZNotice"%>
<%
	ArrayList<MZNotice> list = (ArrayList<MZNotice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">

<title>맛집 커뮤니티, 맛조</title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/blog/">
<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-examples/assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

 
	.board_list{
		width: 1200px; margin-top: 50px; height: 520px;
	}
	
  table {text-align: center;}

	.tableArea{width:800px; margin:auto; height: 100%; }

  tbody td {text-align: center;}  
	
	.blog-footer{
		width:100%;
		height:100px;
		position:absolute;
		bottom:0;
		text-align: center;
		color: black;	
	}
    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
</style>

    
<!-- Custom styles for this template -->
<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="bootstrap-5.1.3-examples/blog/blog.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%@ include file="../common/fixArea.jsp" %>
	</div>
<main class="container">

<section class="list_element">
  <div class="container board_list">

    <!-- <div class="imageArea" align="center">공지사항</div> -->
    <table class="table listArea" id="listArea">
      <thead>
        <tr>
          <th scope="col" width="10%">글번호</th>
          <th scope="col" width="50%">글제목</th>
          <th scope="col" width="10%">작성자</th>
          <th scope="col"  width="10%">조회수</th>
          <th scope="col" width="10%">작성일</th>
        </tr>
      </thead>
      <tbody>
          <tr>
			<%
				if(list.isEmpty()){
			%>
			<td colspan="5">조회된 리스트가 없습니다.</td>
          </tr>
			<%
				} else {
			%>
				<%
					for(MZNotice n : list){
				%>
					<tr>
						<td><%= n.getNoticeNo() %></td>
						<td><%= n.getNoticeTitle() %></td>
						<td><%= n.getNoticeWriter() %></td>
						<td><%= n.getNoticeCount() %></td>
						<td><%= n.getNoticeDate() %></td>
					</tr>
				<% } %>
			<% } %>
      </tbody>
    </table> 
      
      <br>
		<!-- 페이지 정보 -->
      <div class="nav_con">
        
        <div class="nav_area">
          <nav aria-label="Page navigation example ">
            <ul class="pagination c_org">
              <li class="page-item"><a class="page-link" href="#">Previous</a></li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
          </nav>
        </div>
        <div class="btn_area">
          <a href="boardWrite.html"><input class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='writeNoticeForm.no'" id="writerNoBtn" value="글쓰기"></a>
        </div>
      </div>


  </div>
</section>
</main>

	<script>
		$(function(){
			$('#listArea td').mouseenter(function(){ // listArea 안에 있는 td, for문의 td포함
				$(this).parent().css({'background':'darkgray', 'cursor':'pointer'}); //여러가지 객체를 집어넣을때 {}사용 10:13 
			}).mouseout(function(){
				$(this).parent().css('background', 'none');
			}).click(function(){
				var num = $(this).parent().children().eq(0).text(); // #listArea td의 tr안에있는 td들의 맨 첫번쨰 값 텍스트
				location.href = '<%= request.getContextPath() %>/detail.no?no=' + num; 
			});
		});
	</script>

</body>
</html>