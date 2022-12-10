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
<!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">-->


<link href="css/blog.css" rel="stylesheet">
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!-- <script src="https://code.jquery.com/jquery-3.4.1.js"></script> -->

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

/* 	.carousel-inner > .carousel-item > img{ height: 720px; } */

</style>

    
<!-- Custom styles for this template -->
<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="bootstrap-5.1.3-examples/blog/blog.css" rel="stylesheet">
</head>
<body>
 <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> 
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
$('.carousel').carousel({
	interval: 3000 //기본 5초
})
</script>

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
	 <!-- header -->
	<%@ include file="WEB-INF/views/common/fixArea.jsp" %>
	</div>
	
	<!-- 메인 배너 -->
	<main class="container" role="main">
	  <div class=" mb-4 text-white rounded main_bg">
		<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="images/main_01.png" alt="First slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="images/main_02.png" alt="Second slide">
		    </div>
		  </div>
		</div>	
	  </div>
	  
<!-- 		<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img class="d-block w-100" src="..." alt="First slide">
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="..." alt="Second slide">
			    </div>
			  </div>
			</div>	   -->
	
	<!-- 추천맛집 -->
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
	            <image href="images/best_m_img.png"/>
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
	          <svg class="bd-placeholder-img" width="300" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
	          	<image href="images/best_m_img_02.png" style=""/>
	          	<!-- <rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text> -->
	          </svg>
	        </div>
	      </div>
	    </div>
	  </div>
	
	<!-- 새로 오픈했어요 -->
	  <div class="row g-4 con-box_1">
	    <div class="col-md-8 con_01">
	      <h3 class="pb-3 mb-4 border-bottom">
	        새로 오픈했어요!
	      </h3>
	      <article class="blog-post">
	        <div class="col-md-6">
	          <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con" >
	            <div class="col-auto d-none d-lg-block con_thum" style="overflow:hidden;">
	             <image src="images/ko_img_02.png" style="width:100%"/>
	              <!-- <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div> -->
	    			
	            </div>
	            <div class="col p-2 d-flex flex-column position-static">
	              <strong class="d-inline-block" style="color: #F08000;">한식</strong>
	              <h3 class="mb-1">소문난 감자탕</h3>
	              <p class="card-text mb-auto">강남구 역삼동 93-9</p>
	            </div>
	          </div>
	
	          <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con" style="margin-left: 25px;">
	            <div class="col-auto d-none d-lg-block con_thum" style="overflow: hidden;">
	            	<image src="images/pa_img_01.png" style="width:100%;" />
	              <!-- <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div> -->
	    
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
	            <div class="col-auto d-none d-lg-block con_thum" style="overflow: hidden;">
	            <image src="images/ch_img_01.png" style="width:100%;"/>
	              <!-- <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div> -->
	    
	            </div>
	            <div class="col p-2 d-flex flex-column position-static">
	              <strong class="d-inline-block" style="color: #F08000;">중식</strong>
	              <h3 class="mb-1">소문난 감자탕</h3>
	              <p class="card-text mb-auto">강남구 역삼동 93-9</p>
	            </div>
	          </div>
	
	          <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con" style="margin-left: 25px;">
	            <div class="col-auto d-none d-lg-block con_thum" style="overflow:hidden;">
	              <image src="images/jp_img_01.png" style="width:100%;"/>
	              <!-- <div class="bd-placeholder-img" width="265" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></div> -->
	    
	            </div>
	            <div class="col p-2 d-flex flex-column position-static">
	              <strong class="d-inline-block" style="color: #F08000;">양식</strong>
	              <h3 class="mb-0">모힝</h3>
	              <p class="card-text mb-auto" >강남구 역삼동 93-9</p>
	            </div>
	          </div>
	        </div>
	
	      </article>
			<!-- 새로운 맛집 더보기 -->
<!-- 	      <nav class="blog-pagination" aria-label="Pagination">
	        <a class="btn btn-outline-primary" href="#">더 보기</a>
	      </nav> -->
	
	    </div>
	    <!-- 맛집 스토리 -->
	    <div class="col-md-8 con_01" style="padding-right: 10px;">
	      <h3 class="pb-3 mb-4 border-bottom">
		        맛집 스토리
	      </h3>
	      <article class="blog-post">
	        <div class="post_magazine" style="top: 2rem;">
	          <div class="bg-light rounded con_blog" style="background-image: url(images/mat_story_img.png); background-size: auto; opacity: 80%;">
	            <!-- <h4 class="con_blog_tit">숨은 맛집_1)</h4> -->
	           <iframe width="638" height="240" src="https://www.youtube.com/embed/h2Q5UT0B39U" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" style="border-radius:2px;" allowfullscreen ></iframe>
	          </div>
	        </div>
	      </article>
	
		<!-- 공지사항 -->
	      <h3 class="pb-3 mb-4 border-bottom">
	        NOTICE
	      </h3>
	        <article class="con_notice">
	          <div class="post_magazine" style="top: 2rem;">
	            <div class="p-4 mb-3 bg-light rounded con_blog" id="NoticeList">
	            <ul id="noticeList">

	                <li id="li0"></li>
	                <li id="li1"></li>
	                <li id="li2"></li>
	                <li id="li3"></li>
	                <li id="li4"></li>
	                
	            </ul>
	            </div>
	          </div>

             	<script>    
/* 	                $('#li1').click(function(){
	                    $('#li1').html("바뀌나 바뀌나 바뀌나 바뀌나 바뀌나 바뀌나?");
	                 }); */     
	              
	                 
	                $(document).ready(function(){
	                    $.ajax({
	                       url: 'NoticeList.in',
	                       type: 'get',
	                       success: function(data){
	                          console.log(data);
	                          if(data != null){
	                             var resultStr= "";
	                             for(var i in data){
	                                resultStr += data[i].listTitle + data[i].listDate;
	                                $('#li'+i).html(resultStr);
	                             }
	                          }
	                       
	                       },
	                       error: function(data){
	                          alert('통신실패');
	                          console.log(data);
	                       }
	                    });
	                 });	            	
	                  
				</script>	         
	        </article>
	
	    </div>
	
	  </div>
	
	</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>



</body>
</html>