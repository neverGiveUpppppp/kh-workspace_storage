<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Signin Template · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
    
	<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-examples/assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
  	  #memberManagement{font-size:17px; color:white; font-weight:400;}
  	  body {font-family: "NOTO-SANS";}
	  body{background:url('<%= request.getContextPath() %>/sample/back2.webp'); background-size: 50% 95%;}
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
    <link href="<%= request.getContextPath() %>/bootstrap-5.1.3-examples/sign-in/signin.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script> <!-- Alert창을 꾸미기위한 SweetAlert CDN링크 -->
  </head>
  
  
  <body class="text-center">
 	
    
<main class="form-signin">
  
  <form action="<%= request.getContextPath() %>/login.do" id="form">
   <img class="mb-4" src="<%= request.getContextPath() %>/sample/logo.png" onclick="location.href='<%= request.getContextPath() %>'" style="cursor:pointer;" alt="" width="100" height="65">
    <h1 class="h3 mb-3 fw-normal" style="font-size:40px; color:#F08000; -webkit-text-stroke-width: 0.5px;
	-webkit-text-stroke-color: white"><b>Login</b></h1>
	
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" name="inputId" placeholder="name@example.com" autocomplete="off" required></input>
      <label for="floatingInput">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" name="inputPwd" placeholder="Password" autocomplete="off" required></input>
      <label for="floatingPassword">Password</label>
    </div>
   
    <div align="left">
    	<input type="checkBox" id="box" name="temporaryLogin"><label style="color:white;">&nbsp;임시 비밀번호로 로그인 하기</label>
    </div>
    <br>
    <div id="memberManagement">
			<label onclick="location.href='<%= request.getContextPath() %>/singUp.do'" style="cursor:pointer">회원가입&nbsp;&nbsp;</label>ㅣ
			&nbsp;&nbsp;</label><label onclick="location.href='<%= request.getContextPath() %>/idFindPage.do'" style="cursor:pointer">ID찾기&nbsp;&nbsp;ㅣ
			&nbsp;&nbsp;</label><label onclick="location.href='<%= request.getContextPath() %>/PwdFindPage.do'" style="cursor:pointer">PW찾기</label>	
	</div>
	<br>
	
    <br>
 	<button type="submit" class="btn btn-outline-light" id="login" style="border-width: 3px; font-weight:600; font-size:1.2em; width:200px; height:50px;">로그인</button>

<!--     <button class="w-100 btn btn-lg btn-primary" type="submit" style = "background-color:#F08000; border-color:#F08000;">로그인</button> -->
    <br>
    <br>
    <br>
   	<span id="home">
<!--    	HOME버튼을 왼쪽 상단에 넣고 싶었는데 위치변경에 실패하여 일단 보류함  -->
<!-- 		<button type="button"  class="btn btn-outline-light" style="color:white; font-size:15px; width:70px;" >HOME</button> -->
  	</span>
    <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
  </form>
</main> 
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
	
	$(document).ready(function(){
	    $("#box").change(function(){
	        if($("#box").is(":checked")){
	        	<%-- 암호와 안되는 서블릿으로 요청보내기 --%>
	        	Swal.fire({
	        		title: '임시 비밀번호로 로그인',
	        		text: 'PW찾기로 임시 비밀번호를 발급 받으신 회원분들만 임시 비밀번호로 로그인 가능합니다.',
	        		icon: 'warning',
	        		showCancelButton: false, // cancel버튼 보이기. 기본은 원래 없음
	        		confirmButtonColor: '#F08000', // confrim 버튼 색깔 지정
	        		cancelButtonColor: '', // cancel 버튼 색깔 지정
	        		confirmButtonText: '확인', // confirm 버튼 텍스트 지정
	        		cancelButtonText: '', // cancel 버튼 텍스트 지정
	        		reverseButtons: true, // 버튼 순서 거꾸로
	        		})

// 	            alert("메일로 임시 비밀번호를 발급 받으신 회원분들만 임시 비밀번호로 로그인 가능합니다. 기존 비밀번호로 로그인하실 회원분들은 체크박스를 해제하여 주세요.");
	            $('#form').attr("action", "<%= request.getContextPath() %>/temporaryLogin.do"); 
	        }else{
	        	<%-- 암호와 되는 서블릿으로 요청보내기 --%>
	            alert("암호화 되는 서블릿으로 요청보내기!");
	            $('#form').attr("action", "<%= request.getContextPath() %>/login.do");
	        }
	    });
	});
	
	</script>
  </body>
</html>
