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
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-examples/assets/dist/css/bootstrap.min.css" rel="stylesheet">

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
<link href="bootstrap-5.1.3-examples/blog/blog.css" rel="stylesheet">
</head>
<body>
	<div class="container">
<%-- 	  <header class="blog-header py-3">
	    <div class="row flex-nowrap justify-content-between align-items-center">
	      <div class="col-4 pt-1">
	        
	      </div>
	      <div class="col-4 text-center">
	        <span class="logo_txt" >대한민국 대표 맛집 커뮤니티</span>
	        <a class="blog-header-logo" onclick="location.href='<%= request.getContextPath() %>'">
	        	<img class="logo_img" src="bootstrap-5.1.3-examples/blog/images/logo.png" alt="logo"></a>
	      </div>
	      <div class="col-4 d-flex justify-content-end align-items-center">
	        <a class="btn btn-sm btn-outline-secondary" href="#" style="margin-right: 10px;border: none;background: #F08000;color: white;/* font-weight: 600; */">Sign in</a>
	      <a class="btn btn-sm btn-outline-secondary" href="#" style="box-sizing: content-box;">Sign up</a></div>
	    </div>
	  </header> --%>
	<%@ include file="WEB-INF/views/common/fixArea.jsp" %>
	</div>
	
	<main class="container" role="main">
	  <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark main_bg">
	    <div class="col-md-6 px-0">
	      <h1 class="display-4 fst-italic">Title of a longer featured blog post</h1>
	      <p class="lead my-3">Multiple lines of text that form the lede, informing new readers quickly and efficiently about what’s most interesting in this post’s contents.</p>
	      <p class="lead mb-0"><a href="#" class="text-white fw-bold">Continue reading...</a></p>
	    </div>
	  </div>
	
	  <div class="row mb-2">
	    <div class="col-md-6">
	      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
	        <div class="col p-4 d-flex flex-column position-static">
	          <strong class="d-inline-block mb-2" style="color: #F08000;">맛조 추천</strong>
	          <h3 class="mb-0">맛조 추천 맛집</h3>
	          <p class="card-text mb-auto" style="margin-top: 10px;">맛조에서 한식, 중식, 양식, 일식 맛집을 추천합니다!</p>
	        </div>
	        <div class="col-auto d-none d-lg-block">
	          <svg class="bd-placeholder-img" width="300" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
	            <image href="images/best_m_img.png" height="200" width="200"/>
	            <!--<rect width="100%" height="100%" fill="#55595c" style="background-image: url(images/best_m_img.png);"/>-->
	          </svg>
	
	        </div>
	      </div>
	    </div>
	    <div class="col-md-6">
	      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
	        <div class="col p-4 d-flex flex-column position-static">
	          <strong class="d-inline-block mb-2" style="color: #F08000;">맛조 추천</strong>
	          <h3 class="mb-0">맛조 추천 맛집</h3>
	          <p class="card-text mb-auto" style="margin-top: 10px;">맛조에서 디저트 맛집을 추천합니다!</p>
	        </div>
	        <div class="col-auto d-none d-lg-block">
	          <svg class="bd-placeholder-img" width="300" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
	
	        </div>
	      </div>
	    </div>
	  </div>
	
	  <div class="row g-4 con-box_1">
	    <div class="col-md-8 con_01">
	      <h3 class="pb-3 mb-4 border-bottom">
	        새로 오픈했어요!
	      </h3>
	
	      
	
	      
	
	      <article class="blog-post">
	        <div class="col-md-6">
	          <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con" >
	            <div class="col-auto d-none d-lg-block con_thum">
	              <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div>
	    
	            </div>
	            <div class="col p-2 d-flex flex-column position-static">
	              <strong class="d-inline-block" style="color: #F08000;">한식</strong>
	              <h3 class="mb-1">소문난 감자탕</h3>
	              <p class="card-text mb-auto">강남구 역삼동 93-9</p>
	            </div>
	          </div>
	
	          <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con" style="margin-right: 25px;">
	            <div class="col-auto d-none d-lg-block con_thum">
	              <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div>
	    
	            </div>
	            <div class="col p-2 d-flex flex-column position-static">
	              <strong class="d-inline-block" style="color: #F08000;">양식</strong>
	              <h3 class="mb-0">모힝</h3>
	              <p class="card-text mb-auto" >강남구 역삼동 93-9</p>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-md-6">
	          <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con" >
	            <div class="col-auto d-none d-lg-block con_thum">
	              <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div>
	    
	            </div>
	            <div class="col p-2 d-flex flex-column position-static">
	              <strong class="d-inline-block" style="color: #F08000;">한식</strong>
	              <h3 class="mb-1">소문난 감자탕</h3>
	              <p class="card-text mb-auto">강남구 역삼동 93-9</p>
	            </div>
	          </div>
	
	          <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con" style="margin-right: 25px;">
	            <div class="col-auto d-none d-lg-block con_thum">
	              <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div>
	    
	            </div>
	            <div class="col p-2 d-flex flex-column position-static">
	              <strong class="d-inline-block" style="color: #F08000;">양식</strong>
	              <h3 class="mb-0">모힝</h3>
	              <p class="card-text mb-auto" >강남구 역삼동 93-9</p>
	            </div>
	          </div>
	        </div>
	
	      </article>
	
	      <nav class="blog-pagination" aria-label="Pagination">
	        <a class="btn btn-outline-primary" href="#">더 보기</a>
	      </nav>
	
	    </div>
	    <div class="col-md-8 con_01" style="padding-right: 10px;">
	      <h3 class="pb-3 mb-4 border-bottom">
	        맛집 스토리
	      </h3>
	      <article class="blog-post">
	        <div class="post_magazine" style="top: 2rem;">
	          <div class="p-4 mb-3 bg-light rounded con_blog" style="background-image: url(images/mat_story_img.png); background-size: auto; opacity: 80%;">
	            <h4 class="con_blog_tit">숨은 맛집_1)</h4>
	            <p class="mb-0">당신이 몰랐던 숨은 맛집을 알려드릴게요</p>
	          </div>
	        </div>
	      </article>
	
	      <h3 class="pb-3 mb-4 border-bottom">
	        NOTICE
	      </h3>
	        <article class="con_notice">
	          <div class="post_magazine" style="top: 2rem;">
	            <div class="p-4 mb-3 bg-light rounded con_blog">
	              <ul>
	                <li><a href="#"><sapn class="notice_list">공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다.</sapn><span class="notice_date">2022.04.29</span></a></li>
	                <li><a href="#"><sapn class="notice_list">공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다.</sapn><span class="notice_date">2022.04.29</span></a></li>
	                <li><a href="#"><sapn class="notice_list">공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다.</sapn><span class="notice_date">2022.04.29</span></a></li>
	                <li><a href="#"><sapn class="notice_list">공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다.</sapn><span class="notice_date">2022.04.29</span></a></li>
	                <li><a href="#"><sapn class="notice_list">공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다. 공지사항입니다.</sapn><span class="notice_date">2022.04.29</span></a></li>
	            </ul>
	            </div>
	          </div>
	        </article>
	
	    </div>
	
	  </div>
	
	</main>

</body>
</html>