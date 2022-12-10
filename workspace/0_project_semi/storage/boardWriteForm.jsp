<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    <form action="<%= request.getContextPath() %>/insert.no" method="post" style="padding: 0 10px;">
	      <!-- 제목 -->
	      <div class="form-group row mb-2">
	        <label for="form_title" class="col-sm-2 col-form-label">제목</label>
	        <div class="col-sm-10">
	          <input type="text" class="form-control" name="title" id="form_title">
	        </div>
	      </div>
	      <!-- 작성자 -->
	      <div class="form-group row mb-2">
	        <label for="form_writer" class="col-sm-2 col-form-label">작성자</label>
	        <div class="col-sm-10">
	          <input type="text" class="form-control" id="writer" name="writer">
	        </div>
	      </div>
<!-- 	      <div class="form-group row mb-2">
	        <label for="form_title" class="col-sm-2 col-form-label">첨부파일</label>
	        <div class="col-sm-10">
	          <input type="file" name="file" style="resize:none;">
	        </div>
	      </div> -->
	      <!-- 작성일 -->
	      <div class="form-group row mb-2">
	        <label for="form_date" class="col-sm-2 col-form-label">작성일</label>
	        <div class="col-sm-10">
	        	<input type="date" name="date" class="form_date" id="today">
	        </div>
	      </div>

	      <!-- 내용 -->
	      <div class="form-group">
	        <label for="form_content" class="mb-2">내용</label>
	        <textarea class="form-control" id="exampleFormControlTextarea1" rows="10"  style="resize:none;" name="content" ></textarea>
	      </div>
	    <div class="btn_area" style="margin-top:20px; text-align:right;">
	      <input class="btn btn-sm btn-outline-secondary" type="submit" id="insertNoticeBtn" value="등록">
	      <input class="btn btn_org btn-sm btn-outline-secondary" type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="취소">
	    </div>
	    </form>
		
		

	  </div>
	</main>
	<script>
		document.getElementById('today').valueAsDate = new Date();
	</script>
</body>
</html>