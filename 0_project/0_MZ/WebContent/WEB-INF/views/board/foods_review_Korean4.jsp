<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*" %>
    
<%
	ArrayList<MZBoard> list = (ArrayList<MZBoard>)request.getAttribute("list");
	Pagination pi = (Pagination)request.getAttribute("pi");

	System.out.println("jsp pi = "+pi); /* 디버깅용 */
	
	
%>
    
    
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

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/foods_styling6.css" >

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
      <span class="logo_txt">대한민국 대표 맛집 커뮤니티</span><a class="blog-header-logo" href="#" >
      <img class="logo_img" src="<%= request.getContextPath() %>/images/logo.png" alt="logo"></a>
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
    <a class="p-2 nav_cssSelect" onclick="location.href='<%= request.getContextPath() %>/board1Kor.bo'">한식</a>
    <a class="p-2 nav_css" onclick="location.href='<%= request.getContextPath() %>/board2Ch.bo'">중식</a>
    <a class="p-2 nav_css" onclick="location.href='<%= request.getContextPath() %>/board3West.bo'">양식</a>
    <a class="p-2 nav_css" onclick="location.href='<%= request.getContextPath() %>/board4Jp.bo'">일식</a>
    <a class="p-2 nav_css" onclick="location.href='<%= request.getContextPath() %>/board5Des.bo'">디저트</a>
    <a class="p-2 nav_css" onclick="location.href='<%= request.getContextPath() %>/board1Kor.bo'">공지사항</a>
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
      <img src="<%= request.getContextPath() %>/images/logo.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
    </div>
    <div class="cardBoxText">
      <div class="card-body">
        <strong class="mb-lg-1 reviewCategory"><%= list.get(0).getFoodType() %><!-- 한식 --></strong><br>
        <span class="reviewDate justify-content-center" style="width:5%"><%= list.get(0).getBoardDate() %><!-- 글쓴날짜 -->/if문 넣어서 수정하면 modify_date로</span>
        <span class="reviewDate"> 조회수 : <%= list.get(0).getBoardCount() %><!-- 조회수  --></span>
        <p class="card-text mb-auto reviewNormal">위치 : <%= list.get(0).getRestaurantAddress() %> <!-- 장소 --></p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
        <p class="card-text reviewNormal"><%= list.get(0).getRestaurantIntro() %>
        </p>
      </div>
    </div>
  </div>


    <div class="cardBox" id="cardBoxDetail">
      <div class="cardImg">
        <img src="<%= request.getContextPath() %>/images/logo.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
      </div>
      <div class="cardTxt">
        <div class="card-body">
          <strong class="mb-lg-1 reviewCategory"><%= list.get(1).getFoodType() %><!-- 한식 --></strong><br>
          <span class="reviewDate justify-content-center" style="width:5%"><%= list.get(1).getBoardDate() %><!-- 글쓴날짜 -->/if문 넣어서 수정하면 modify_date로</span>
          <span class="reviewDate"> 조회수 : <%= list.get(1).getBoardCount() %><!-- 조회수  --></span>
        <p class="card-text mb-auto reviewNormal">위치 : <%= list.get(1).getRestaurantAddress() %> <!-- 장소 --></p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
        <p class="card-text reviewNormal"><%= list.get(1).getRestaurantIntro() %>
        </div>
      </div>
    </div>


    <div class="cardBox" id="cardBoxDetail">
    <div class="">
      <img src="<%= request.getContextPath() %>/images/logo.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
    </div>
    <div class="cardBoxText">
      <div class="card-body">
        <strong class="mb-lg-1 reviewCategory"><%= list.get(2).getFoodType() %><!-- 한식 --></strong><br>
        <span class="reviewDate justify-content-center" style="width:5%"><%= list.get(2).getBoardDate() %><!-- 글쓴날짜 -->/if문 넣어서 수정하면 modify_date로</span>
        <span class="reviewDate"> 조회수 : <%= list.get(2).getBoardCount() %><!-- 조회수  --></span>
        <p class="card-text mb-auto reviewNormal">위치 : <%= list.get(2).getRestaurantAddress() %> <!-- 장소 --></p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
        <p class="card-text reviewNormal"><%= list.get(2).getRestaurantIntro() %>        </p>
      </div>
    </div>
  </div>

    <div class="cardBox" id="cardBoxDetail">
      <div class="">
        <img src="<%= request.getContextPath() %>/images/logo.png" class="img-fluid img_cut"  alt="중화요리 팔공 리뷰">
      </div>
      <div class="">
        <div class="card-body">
          <strong class="mb-lg-1 reviewCategory"><%= list.get(3).getFoodType() %><!-- 한식 --></strong><br>
        <span class="reviewDate justify-content-center" style="width:5%"><%= list.get(3).getBoardDate() %><!-- 글쓴날짜 -->/if문 넣어서 수정하면 modify_date로</span>
        <span class="reviewDate"> 조회수 : <%= list.get(3).getBoardCount() %><!-- 조회수  --></span>
        <p class="card-text mb-auto reviewNormal">위치 : <%= list.get(3).getRestaurantAddress() %> <!-- 장소 --></p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">간단 소개</p>
        <p class="card-text reviewNormal"><%= list.get(3).getRestaurantIntro() %>
        </div>
      </div>
    </div>

</div>



<%-- 
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center pagination-lg">
    <li class="page-item">
      <a class="page-link" href="<%= request.getContextPath() %>/list.bo?currentPage=1" aria-label="Previous">
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
 --%>

<div class="pagingArea" align="center">
			<!-- 맨 처음으로 -->
			<button type="button" class="btn btn-sm Writing" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=1'"> &lt;&lt; </button>
			
			<!-- 이전 페이지로 -->
			<!-- 이전 페이지 기준이 되는 것 : 현재페이지(currentPage) // < %= pi.getMaxPage()-1 %> : 이 코드의 문제는 0을 지나서 마이스로 가기 때문에 cp가 1에 도달하면 스톱하는 조건 필요 -->
			<button type="button" class="btn btn-sm Writing" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage()-1 %>'" id="beforeBtn"> &lt; </button>
				<script>
					if(<%= pi.getCurrentPage() %> <= 1){ /* 1페이지에 도달하면 버튼 비활성화 */
						$('#beforeBtn').prop('disabled',true); /* 속성 넣을 때 true/false 넣는건 프로퍼티 사용한다고 했었음 . 다양한 값이 들어갈 것은 attr 함수를 사용하는거고*/
					}
				</script>
			
			<!-- 숫자 페이지로 -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){ %>
				<% if(p == pi.getCurrentPage()){ %>
					<button type="button" class="btn btn-sm Writing2" id="choosen" disabled><%= p %></button>
				<% } else{ %>
					<button type="button" class="btn btn-sm Writing2" id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			
			<!-- 다음 페이지로 -->
			<!-- 얘도 마찬가지로 맥스페이지에 도달하면 멈추게 해야함 -->
			<button type="button" class="btn btn-sm Writing" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage()+1 %>'" id="afterBtn"> &gt; </button>
				<script>
					if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
						$('#afterBtn').prop('disabled', true);
					}
				</script>
			<!-- 맨 마지막으로 -->
			 <button type="button" class="btn btn-sm Writing" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getMaxPage() %>'"> &gt;&gt; </button>
			
		</div>


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
      console.log(num);
      location.href = '<%= request.getContextPath() %>/detail.bo?no=' + num; 
    });
  });

</script>
<script>

</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

