<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>맛조</title>


<!-- <link href="css/foods_styling.css" rel="stylesheet"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/foods_styling5.css" >

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
      <span class="logo_txt">대한민국 대표 맛집 커뮤니티</span><a class="blog-header-logo" href="#" ><img class="logo_img" src="img/teamLogo.png" alt="logo"></a>
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
  <nav class="nav d-flex justify-content-between" >
    <a class="p-2 nav_cssSelect" href="#">한식</a>
    <a class="p-2 nav_css" href="#">중식</a>
    <a class="p-2 nav_css" href="#">양식</a>
    <a class="p-2 nav_css" href="#">일식</a>
    <a class="p-2 nav_css" href="#">디저트</a>
    <a class="p-2 nav_css" href="#">공지사항</a>
  </nav>
</div>
</div>


<main class="container">
  
<div class="p-4 p-md-5 mb-4 text-white bg-dark">

  이미지 추가
</div>

<div class="cardContainer">

  <div class="cardBox" id="cardBoxDetail">
    <div class="">
      <img src="0_MZ/WebContent/images/logo.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
    </div>
    <div class="cardBoxText">
      <div class="card-body">
        <strong class="mb-lg-1 reviewCategory">중식</strong>
        <h5 class="card-title cardTitle">중화요리 팔공1</h5>
        <p class="card-text mb-1 reviewDate">22.02.22 | 조회수 50회</p>
        <p class="card-text mb-auto reviewNormal">위치 : 서울 관악구 신림동 10-621 지하 1층</p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
        <p class="card-text reviewNormal">푸짐한 양과 아낌없는 재료
          푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료
        </p>
      </div>
    </div>
  </div>


    <div class="cardBox" id="cardBoxDetail">
      <div class="cardImg">
        <img src="0_MZ/WebContent/images/logo.png" class="img-fluid  img_cut" alt="중화요리 팔공 리뷰">
      </div>
      <div class="cardTxt">
        <div class="card-body">
          <strong class="mb-lg-1 reviewCategory">중식</strong>
          <h5 class="card-title cardTitle">짜장면집2</h5>
          <p class="card-text mb-1 reviewDate">20.02.10 | 조회수 50회</p>
          <p class="card-text mb-auto reviewNormal">위치 : 서울 관악구 신원로 16 1층</p>
          <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
          <p class="card-text reviewNormal">이보다 쌀 수 있을까? 극한의 가성비</p>
        </div>
      </div>
    </div>


    <div class="cardBox" id="cardBoxDetail">
    <div class="">
      <img src="0_MZ/WebContent/images/logo.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
    </div>
    <div class="cardBoxText">
      <div class="card-body">
        <strong class="mb-lg-1 reviewCategory">중식</strong>
        <h5 class="card-title cardTitle">중화요리 팔공3</h5>
        <p class="card-text mb-1 reviewDate">22.02.22 | 조회수 50회</p>
        <p class="card-text mb-auto reviewNormal">위치 : 서울 관악구 신림동 10-621 지하 1층</p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
        <p class="card-text reviewNormal">푸짐한 양과 아낌없는 재료
          푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료푸짐한 양과 아낌없는 재료
        </p>
      </div>
    </div>
  </div>

    <div class="cardBox" id="cardBoxDetail">
      <div class="">
        <img src="0_MZ/WebContent/images/logo.png" class="img-fluid img_cut" alt="중화요리 팔공 리뷰">
      </div>
      <div class="">
        <div class="card-body">
          <strong class="mb-lg-1 reviewCategory">중식</strong>
          <h5 class="card-title cardTitle">짜장면집4</h5>
          <p class="card-text mb-1 reviewDate">20.02.10 | 조회수 50회</p>
          <p class="card-text mb-auto reviewNormal">위치 : 서울 관악구 신원로 16 1층</p>
          <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
          <p class="card-text reviewNormal">이보다 쌀 수 있을까? 극한의 가성비</p>
          <!-- <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p> -->
        </div>
      </div>
    </div>

</div>




<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center pagination-lg">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>



<button type="button" class="btn btn-sm Writing" style="float: right;"
        data-bs-toggle="button" autocomplete="off"
        onclick="location.href='<%= request.getContextPath() %>/boardWriting.bo'"
        >글쓰기
</button>


<br><br>

<script>
  $(function(){
    $('#cardBoxDetail *').mouseenter(function(){
      $(this).parent().css({'border':'2px solid #F08000','cursor':'pointer'});
    }).mouseout(function(){
      $(this).parent().css('border','none'); 
    }).click(function(){ // 이 게시글만 보겠다고 select해올거면 조건을 넣어줘야하는데 뭐로 나뉠 수 있을까? 글번호 . pk라서 겹칠 일이 없음.
      var num = $(this).parent().children().eq(0).text(); 
      location.href = '<%= request.getContextPath() %>/detail.bo?no=' + num; 
    });
  });

</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

