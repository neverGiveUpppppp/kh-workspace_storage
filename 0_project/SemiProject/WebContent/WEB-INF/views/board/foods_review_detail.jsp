<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.MZBoard, java.util.ArrayList" %>
    
<% 
	MZBoard b = (MZBoard)request.getAttribute("board"); 
%>


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
    <h4 class="card-title mb-5 text-center">중화요리 팔공</h4>
  </div>

  <div class="articleSubTitle" >
    <div class="articleMainTop">
      <strong class="mt-5 reviewCategory">중식 </strong>
      <div class="reviewDateTie">
        <span class="reviewDate justify-content-center" style="width:5%">22.02.22</span>
        <span class="reviewDate">조회수 48회 </span>
      </div>
      <p class="">위치 : 서울 관악구 신림동 10-621 지하 1층 </p>
      <p class="">Tel : 02-877-9815</p>
      <div class="">
        <span class="reviewFeatureTitle">간단 소개 </span>
        <p class=""> 줄서서 먹는 오랜 맛집. 짬뽕의 해물 양이 많고 푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료
        </p>
      </div>
    </div>
    <div class="img">
      <!-- image table : image.image_NO -->
      <img src="<%= request.getContextPath() %>/images/review01 palgong.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
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
        <img src="<%= request.getContextPath() %>/images/review01 palgong.png" class="d-block w-100" alt="...">
      </div>
      <div class="carousel-item">
        <img src="<%= request.getContextPath() %>/images/review01-1 palgong.png" class="d-block w-100" alt="...">
      </div>
      <div class="carousel-item">
        <img src="<%= request.getContextPath() %>/images/review01-2 palgong.png" class="d-block w-100" alt="...">
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
    <span class=""> 음식 카테고리 : 중식</span><br>
	동네에 있어 감사한 중식당<br>
지난번에 볶음밥을 맛있게 먹었던 팔공에 다시 방문했다. 지난 방문 때는 대기 없이 먹을 수 있었는데 이번에는 30분 정도 대기해야 했다.<br> 
대기 후에 테이블에 앉아 해물짬뽕과 군만두를 주문했다. 군만두가 먼저 나온 뒤 뒤이어 바로 짬뽕이 나왔다.<br><br> 
군만두 : 갈색 빛깔로 잘 튀겨진 군만두는 피와 소 모두 특별하진 않았지만 바로 튀겨줬기 때문에 맛있게 먹었다. <br>
해물짬뽕 : 진한 국물과 함께 조개, 오징어, 새우, 표고, 피망, 브로콜리 등 다양한 재료들이 볶아져 나왔다. <br> 
닭육수와 해산물의 감칠맛과 야채들의 달콤함에 불맛까지 더해져 깊으면서도 너무 기름지지 않고 깔끔한 국물이 좋았다. 해산물들도 잘 익혀 부드럽고 쫄깃하게 먹을 수 있었다.<br> 
손님들이 몰리는 식사시간에도 한 그릇, 한 그릇 바로 바로 조리하는 정성이 고맙다. 동네에 이렇게 정성스럽고 맛있는 중식당이 있어 기쁘고 감사하다.<br>
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
            data-bs-toggle="button" autocomplete="off"
            onclick="location.href='<%= request.getContextPath() %>/boardWriting.bo'"
            >글쓰기</button>
  </div>
</div>




<br><br>




</main>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>    


