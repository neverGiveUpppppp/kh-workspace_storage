<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
    
    <%
    	Member loginUser = (Member)session.getAttribute("loginUser");
    %>
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
<link href="css/blog.css" rel="stylesheet">
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

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script> <!-- Alert창을 꾸미기위한 SweetAlert CDN링크 -->    
<!-- Custom styles for this template -->
<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="bootstrap-5.1.3-examples/blog/blog.css" rel="stylesheet">
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
	        	<img class="logo_img" src="bootstrap-5.1.3-examples/blog/images/logo.png" alt="logo"></a>
	      </div>
	      <div class="col-4 d-flex justify-content-end align-items-center">
 	      	
 	      	<% if(loginUser == null) { %>
	        <a class="btn btn-sm btn-outline-secondary" href="<%= request.getContextPath() %>/loginPage.do" 
	        style="margin-right: 10px; border: none;background: #F08000;color: white;/* font-weight: 600; */">로그인</a>
	      <a class="btn btn-sm btn-outline-secondary" href="<%= request.getContextPath() %>/singUp.do" 
	      style="box-sizing: content-box;">회원가입</a></div>
	    	<% }else{ %>
	    	<label><%= loginUser.getUserName() %>님 환영합니다!&nbsp;</label>
	    	<input class="btn btn-sm btn-outline-secondary" onclick="location.href='<%= request.getContextPath() %>/myPage.me'" 
	    	type="button" value="My page" style="border: none;background: #F08000;color: white;">&nbsp;
	    	<input id="logOutBtn" class="btn btn-sm btn-outline-secondary" type="button" value="LogOut" onclick="logOutConfirm();">
	    	<% } %>
	    
	    </div>
	  </header>
	  <div class="nav-scroller py-1 mb-2">
	    <nav class="nav d-flex">
	      <a class="p-2 link-secondary" href="#">한식</a>
	      <a class="p-2 link-secondary" href="#">중식</a>
	      <a class="p-2 link-secondary" href="#">양식</a>
	      <a class="p-2 link-secondary" href="#">일식</a>
	      <a class="p-2 link-secondary" href="#">디저트</a>
	      <a class="p-2 link-secondary" onclick="location.href='<%= request.getContextPath() %>/list.no'">공지사항</a>
	    </nav>
	  </div>
	 </div>
	 
	<!-- footerArea -->
	<footer class="blog-footer" id="footer">
	          <ul class="f-copy">
            <li>대표 맛집 커뮤니티 맛조</li>
            <li>대표이사 : 박춘희 </li>
            <li>소재지 : 서울특별시 강남구 테헤란로 </li>
        </ul>
        <p class="f-email">이메일 문의 : contact@MZCommunity.com</p>
        <ul class="f-desc">
            <li>전화 문의 : 01-234-5678 (평일 : 10:00 ~ 19:00, 주말/공휴일 제외)</li>
            <li>Copyright ⓒ 2022 MZCommunity</li>
        </ul>
<!-- 	  <p>
	    <a href="#">Back to top</a>
	  </p> -->
	</footer>
	
	 <script>
		//로그아웃 확인받기
		function logOutConfirm(){
			Swal.fire({
				  title: '정말 로그아웃 하시겠습니까?',
				  text: "",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#F08000',
				  cancelButtonColor: '#868e96',
				  confirmButtonText: '확인',
				  cancelButtonText: '취소'
				}).then((result) => {
				  if (result.value) {
					  location.href = '<%= request.getContextPath() %>/logout.me';
				  }
			})
		}

	</script>
</body>
</html>