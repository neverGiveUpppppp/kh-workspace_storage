<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.MZNotice" %>
<%
	MZNotice mnotice = (MZNotice)request.getAttribute("mnotice");
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
	  <div class="boardform_area">
	    <form action="noticeUpdateForm.no" id="detailForm" name="detailForm" method="post" style="padding: 0 10px;">
	    
	      <!-- 제목 -->
	      <div class="form-group row mb-2">
	        <label for="form_title" class="col-sm-2 col-form-label">제목</label>
	        <div class="col-sm-10">
	        	<%= mnotice.getNoticeTitle() %>
	          <input type="hidden" class="form-control" name="title" id="form_title" value="<%= mnotice.getNoticeTitle() %>">
	        </div>
	      </div>
	      
	      <!-- 작성자 -->
	      <div class="form-group row mb-2">
	        <label for="form_writer" class="col-sm-2 col-form-label">작성자</label>
	        <div class="col-sm-10">
	        <%= mnotice.getNoticeWriter() %>
	        </div>
	      </div>
	  
	      <!-- 내용 -->
	      <div class="form-group">
	        <label for="exampleFormControlTextarea1" class="mb-2">내용</label>
	        <!-- 게시글 날짜, 조회수 -->
	        <div class="no_chk" style="float:right;">
		        <span><%= mnotice.getNoticeDate() %></span>
		        	<input type="hidden" name="date" value="<%= mnotice.getNoticeDate() %>">
		        <span style="font-size:0.5rem; color:#ccc;">|</span>
		        <span>조회수  : <%= mnotice.getNoticeCount() %></span>
	        </div>
	        <input type="hidden" name="no" value="<%=  mnotice.getNoticeNo() %>">
	        
	        <textarea class="form-control" id="form" rows="10"  style="resize:none;background:none;" name="content" readonly><%= mnotice.getNoticeContent() %></textarea>
	      </div>
	    <div class="btn_area" style="margin-top:20px; text-align:right;">
	    <!-- 관리자 계정 로그인 필요-->
	      <input class="btn btn-sm btn-outline-secondary" type="submit" id="updateBtn" value="수정">
	      <input class="btn btn-sm btn-outline-secondary" type="button" id="deleteBtn" value="삭제" onclick="deleteNotice();" style="background-color: #6c757d;">
	      
	      <input class="btn btn_org btn-sm btn-outline-secondary" type="button" onclick="location.href='list.no'" id="cancelBtn" value="목록으로">
	    </div>
	    </form>
		
		

	  </div>
	</main>
	<script>
	function deleteNotice(){
		var bool = confirm('공지사항을 삭제하시겠습니까?');
		if(bool){
			location.href='<%= request.getContextPath() %>/delete.no?no=' + <%= mnotice.getNoticeNo() %>;
		}
	}
	</script>	
</body>
</html>