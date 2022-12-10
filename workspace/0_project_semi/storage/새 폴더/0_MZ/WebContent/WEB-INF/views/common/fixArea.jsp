<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
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
<link href="/0_MZ/WebContent/css/blog.css" rel="stylesheet">
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <header class="blog-header py-3">
	    <div class="row flex-nowrap justify-content-between align-items-center">
	      <div class="col-4 pt-1">
	        
	      </div>
	      <div class="col-4 text-center">
	        <span class="logo_txt" >대한민국 대표 맛집 커뮤니티</span>
	        <a class="blog-header-logo" onclick="location.href='<%= request.getContextPath() %>'">
	        	<img class="logo_img" src="images/logo.png" alt="logo"></a>
	      </div>
	      <div class="col-4 d-flex justify-content-end align-items-center">
	        <a class="btn btn-sm btn-outline-secondary" href="#" style="margin-right: 10px;border: none;background: #F08000;color: white;/* font-weight: 600; */">Sign in</a>
	      <a class="btn btn-sm btn-outline-secondary" href="#" style="box-sizing: content-box;">Sign up</a></div>
	    </div>
	  </header>
	  <div class="nav-scroller py-1 mb-2">
	    <nav class="nav d-flex">
	      <a class="p-2 link-secondary" onclick="location.href='<%= request.getContextPath() %>/board1Kor.bo'">한식</a>
	      <a class="p-2 link-secondary" href="/0_MZ/WebContent/WEB-INF/views/board/foods_review_Chinese1.jsp">중식</a>
	      <a class="p-2 link-secondary" onclick="location.href='<%= request.getContextPath() %>/board1Wes.bo'">양식</a>
	      <a class="p-2 link-secondary" href="#">일식</a>
	      <a class="p-2 link-secondary" href="#">디저트</a>
	      <a class="p-2 link-secondary" onclick="location.href='<%= request.getContextPath() %>/list.no'">공지사항</a>
	    </nav>
	  </div>
	 </div>
	 
	<!-- footerArea -->
	<footer class="blog-footer">
	  <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
	  <p>
	    <a href="#">Back to top</a>
	  </p>
	</footer>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
</body>
</html>