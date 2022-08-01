<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>맛조 - 상세페이지</title>


<!-- <link href="css/foods_styling.css" rel="stylesheet"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<!-- style sheet -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/foods_detail.css" >

<style>


  @media (min-width: 768px){
    .cardContainer > div {
      flex-basis: 49%;
    }
  }  
  @media (min-width: 425px){
    .cardContainer > div {
      flex-basis: 99%;
      /* width: 100%; */
    }
  }
</style>

</head>
<body>
  




  
<div class="container">
<header class="blog-header py-3">
  <div class="row flex-nowrap justify-content-between align-items-center">
    <div class="col-4 pt-1">
      <a class="link-secondary" href="#"> </a>
    </div>
    <div class="col-4 text-center">
      <span class="logo_txt">대한민국 대표 맛집 커뮤니티</span><a class="blog-header-logo" href="#" ><img class="logo_img" src="img/MZ logo.png" alt="logo"></a>
    </div>
    <div class="col-4 d-flex justify-content-end align-items-center">
      <a class="link-secondary" href="#" aria-label="Search">
      </a>
      </a>
      <a class="btn btn-sm btn-outline-secondary signIn" href="#">Sign in</a>
      <a class="btn btn-sm btn-outline-secondary signUp" href="#">Sign up</a>
    </div>
  </div>
</header>


<div class="bbb nav-scroller py-1 mb-2 ">
  <nav class="nav d-flex justify-content-around" >
    <a class="p-2 nav_css" href="#">한식</a>
    <a class="p-2 nav_cssSelect" href="#">중식</a>
    <a class="p-2 nav_css" href="#">양식</a>
    <a class="p-2 nav_css" href="#">일식</a>
    <a class="p-2 nav_css" href="#">디저트</a>
    <a class="p-2 nav_css" href="#">공지사항</a>
  </nav>
</div>
</div>





<!-- main -->
<main class="container">
  
<div class="p-4 p-md-5 mb-4 text-white bg-dark">

  이미지 추가
</div>


<!-- main content -->
<!-- articleNeck_text  articleNeck_thumbnail -->
<div class="article">
  <div class="articleHead">
    <h4 class="card-title mb-5 text-center">중화요리 팔공  res.restaurant_name</h4>
  </div>

  <div class="articleSubTitle" >
    <div class="articleMainTop">
      <strong class="mt-5 reviewCategory">중식 food_type</strong>
      <div class="reviewDateTie">
        <span class="reviewDate justify-content-center" style="width:5%">22.02.22 board_date/if문 넣어서 수정하면 modify_date로</span>
        <span class="reviewDate">조회수 50회 board_count</span>
      </div>
      <p class="">위치 : 서울 관악구 신림동 10-621 지하 1층 res.restaurant_address</p>
      <p class="">Tel : 010-1111-2222  res.restaurant_phone</p>
      <div class="">
        <span class="reviewFeatureTitle">간단 소개 </span>
        <p class=""> (간단소개 내용)  res.restaurant_intro
          푸짐한 양과 아낌없는 재료 푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료
        </p>
      </div>
    </div>
    <div class="img">
      <!-- image table : image.image_NO -->
      <img src="0_MZ/WebContent/images/logo.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
    </div>  
  </div>


  <!-- 캐러셀 -->
  <div id="carouselExampleIndicators" class="carousel slide " data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner mb-5">
      <div class="carousel-item active">
        <img src="0_MZ/WebContent/images/best_m_img.png" class="d-block w-100" alt="...">
      </div>
      <div class="carousel-item">
        <img src="0_MZ/WebContent/images/logo.png" class="d-block w-100" alt="...">
      </div>
      <div class="carousel-item">
        <img src="0_MZ/WebContent/images/main_txt.png" class="d-block w-100" alt="...">
      </div>
    </div>
    <!-- 캐러셀 버튼 -->
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <div class="btnBox"><span class="carousel-control-prev-icon" aria-hidden="true"></span></div>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <div class="btnBox"><span class="carousel-control-next-icon" aria-hidden="true"></span></div>
        <span class="visually-hidden">Next</span>
      </button>
    
  </div>

  <div class="articleMainBotton mb-5">
    <p>
    <span class=""> 음식 카테고리 : food_type</span><br>
    <span class=""> 리뷰한 음식 : food_name</span><br><br>
        res.restaurant_content <br>
        리뷰 음식 외에 레스토랑 다른 메뉴 및 전반적인 설명 <br>
        음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 <br>
        음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 <br>
        음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 <br>
        음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 <br>
        음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 음식 내용 블라블라 <br>
      </p>
  </div>

</div>




<!-- 글쓰기 버튼 -->
<div class="btn-toolbar mb-5" role="toolbar" aria-label="Toolbar with button groups"
      style="float: right;">
  <div class="btn-group me-1 " role="group" aria-label="First group">
    <button type="button" class="btn Writing" 
            data-bs-toggle="button" autocomplete="off">목록</button>
  </div>
  <div class="btn-group me-5" role="group" aria-label="Second group">
    <button type="button" class="btn Writing"
            data-bs-toggle="button" autocomplete="off">글쓰기</button>
  </div>
</div>

<!-- 
<button type="button" class="btn btn-sm Writing" 
        style="float: right;"
        data-bs-toggle="button" autocomplete="off">글쓰기
</button>

<button type="button" class="btn btn-sm Writing" 
        style="float: right;"
        data-bs-toggle="button" autocomplete="off">목록
</button>
 -->


<br><br>




</main>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>    


