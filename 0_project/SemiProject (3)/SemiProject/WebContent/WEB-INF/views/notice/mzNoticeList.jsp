<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,notice.model.vo.* "%>
<%
	ArrayList<MZNotice> list = (ArrayList<MZNotice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	System.out.println(pi);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<script src="js/jquery-3.6.0.min.js"></script>
<title>맛집 커뮤니티, 맛조</title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/blog/">
<!-- Bootstrap core CSS -->
<%-- <link href="<%= request.getContextPath() %>/bootstrap-5.1.3-examples/assets/dist/css/bootstrap.min.css" rel="stylesheet"> --%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="css/blog.css" rel="stylesheet">

<style>

 

	
  table {text-align: center;}


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
            <ul class="pagination c_org" id="pagination-demo">
             <li class="page-item"><a class="page-link">First</a></li>
              <li class="page-item"><a class="page-link">Previous</a></li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">Next</a></li>
              <li class="page-item"><a class="page-link" href="#">Last</a></li>
            </ul>
          </nav>
        </div>
        <!-- 관리자 계정으로만 버튼 보이기 -->
        <div class="btn_area">
			<% if(loginUser != null && loginUser.getUserId().equals("admin")) { %> 
    	      <input class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='writeNoticeForm.no'" id="writerNoBtn" value="글쓰기">
        	<% } %>
        </div>
      </div>


  </div>
  

  
</section>

</main>


	<script>
	//클릭했을때의 기능, notice작업과 동일한 작업
		$(function(){
			$('#listArea td').click(function(){
				var num = $(this).parent().children().eq(0).text(); // #listArea td의 tr안에있는 td들의 맨 첫번쨰 값 텍스트
				location.href = '<%= request.getContextPath() %>/detail.no?no=' + num; 
			});
		}); 
	</script>
	
	<Script>
    $('#pagination-demo').twbsPagination({
        totalPages: 35,
        visiblePages: 1,
        onPageClick: function (event, page) {
            $('#page-content').text('Page ' + page);
        }
    });
	</Script>
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>