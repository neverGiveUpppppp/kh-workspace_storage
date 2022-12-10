<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Random"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입 화면 샘플 - Bootstrap</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>  
    body {  
      min-height: 100vh;
	  font-family: "NOTO-SANS";
      background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
    }  
    
    body{background-image:url("<%= request.getContextPath() %>/sample/backone.jpg"); background-size:cover;}
   	   .btn-submit {
    	font-color: white;
		background-color:#FFA500; width:100%; height:50px; 
		font-weight: bold; border:none; border-radius:12px; cursor:pointer;  	
	 }

    .input-form {
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3" style="color:#F08000; font-weight:600;" >PassWord찾기</h4>
       
       <hr style="border-color:#F08000;">
        
        <form class="validation-form" novalidate action="<%= request.getContextPath() %>/PwdFind.do">
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">아이디</label>
              <input type="text" class="form-control" id="id" name="id" onkeyup="this.value=this.value.replace( /[^a-z|A-Z|0-9]/gi,'');" autocomplete="off" placeholder="아이디" maxlength="15" value="" required>
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
            </div>
          </div>
          
          <div class="row">
              <div class="col-md-12 mb-3">
              <label for="birth">생년월일</label>
            	<div class="input-group mb-3">
                 <input type="text" class="form-control mr-3" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name="year" autocomplete="off" placeholder="년" maxlength="4" aria-label="Username">
															<!-- onKeyup으로 입력된 값들 중 숫자 이외(^가 부정의 역할)의 값을 ''으로 대체한다. /g 플래그는
															 	  전체에 해당되는 모든 문자열을 담은 배열을 반환(그것들 중 0~9에 해당하는 숫자가 아닌것)-->
                 <select class="custom-select mr-3" id="root" name="month">
                      <option value="">월</option>
                      <option value="1">1월</option><option value="2">2월</option>
                      <option value="3">3월</option><option value="4">4월</option>
                      <option value="5">5월</option><option value="6">6월</option>
                      <option value="7">7월</option><option value="8">8월</option>
                      <option value="9">9월</option><option value="10">10월</option>
                      <option value="11">11월</option><option value="12">12월</option>
                    </select>
                    
                 <select class="custom-select mr-3" id="root" name="day">
                    <option value="">일</option>
                    <option value="1">1일</option><option value="2">2일</option><option value="3">3일</option>
                    <option value="4">4일</option><option value="5">5일</option><option value="6">6일</option>
                    <option value="7">7일</option><option value="8">8일</option><option value="9">9일</option>
                    <option value="10">10일</option><option value="11">11일</option><option value="12">12일</option>
                    <option value="13">13일</option><option value="12">14일</option><option value="15">15일</option>
                    <option value="16">16일</option><option value="17">17일</option><option value="18">18일</option>
                    <option value="19">19일</option><option value="20">20일</option><option value="21">21일</option>
                    <option value="22">22일</option><option value="23">23일</option><option value="24">24일</option> 
                    <option value="25">25일</option><option value="26">26일</option><option value="27">27일</option>
                    <option value="28">28일</option><option value="29">29일</option><option value="30">30일</option>
                    <option value="31">31일</option>
                  </select>    			
  
					<input type="hidden" id="inputPwd" name="inputPwd" value="<%= Math.abs(new Random().nextInt()) %>"> 
					
					<!-- 난수 넘겨받고 넣어 놓기 name을 input으로 만들어서 암호화하기  -->
					<!-- 임시 비밀번호 전의 서블릿에서 요청 받아서 서블릿으로 넘겨주고 다음 서블릿으로 넘겨주기  -->
                 </div>
             </div> 
     	 </div>

        <div class="row">	
		 	<div class="col">
             	<label for="pasword2">E-MAIL</label>
			 	<div class="input-group mb-3">
					<input type="text" class="form-control" name="str_email01" id="str_email01" autocomplete="off" placeholder="이메일 아이디" > 
					<span class="input-group-text">@</span>
					<input type="text" name="str_email02" id="str_email02" disabled autocomplete="off" value="naver.com" placeholder="이메일 주소">
						<select class="custom-select" name="selectEmail" id="selectEmail">
							 <option value="1">직접입력</option>
							 <option value="naver.com" selected>naver.com</option>
							 <option value="naver.com">daum.net</option>
							 <option value="hanmail.net">gmail.com</option>
							 <option value="iei.co.kr">iei.kr</option>
						</select>
	         	</div>
         	</div>
		</div>

          <hr class="mb-4">
          
          <div class="mb-4"></div>
<!--           <button class="btn btn-primary btn-lg btn-block" type="submit" style = "background-color:#F08000; border-color:#F08000;">확인</button> -->
          <button class="btn-submit" id="check" type="submit" style="background-color: #F08000;">확인</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 YD</p>
    </footer>
  </div>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script> 
  <script type="text/javascript"> 
 	 $('#selectEmail').change(function(){ 
	  	$("#selectEmail option:selected").each(function () { 
	  		if($(this).val()== '1'){ //selectBox에서 직접입력을 선택하면 
	 			$("#str_email02").val(''); 				  //직접입력 창을 한번 비워주고
	 			$("#str_email02").attr("disabled",false); //직접입력 input창 이용할 수 있게 속성변경
	 		
	  		}else { 
	  			$("#str_email02").val($(this).text()); 	  //this(selectEmail)요소의 text를 직접입력창의 value로 대입해주고
	  			$("#str_email02").attr("disabled",true);  //직접입력 input창 이용할 수 없게 속성변경
	  		} 
	  	}); 
	}); 
 	 
 	$('#check').click(function(){
  		var userEmail = $('input[name=str_email01]').val() + '@' +  $('input[name=str_email02]').val();
  		var strBornDate = $('input[name=year]').val() + '-' +  $('select[name=month]').val() + '-' + $('select[name=day]').val();
  		var id = $('#id').val();
  		var inputPwd = $('#inputPwd').val();
  		
  		console.log(userEmail);
  		console.log(strBornDate);
  		console.log(id);
  		
  		$.ajax({
  			url:'pwdCheckEmail.me',
  			type:'get',
  			data:{emailPwd:inputPwd, inputPwd:inputPwd, email:userEmail, strBornDate:strBornDate, id:id},
  			success:function(data){
  				alert("성공");
  			},
  			error:function(data){
  				alert('실패');
  			}
  		});

  	});
</script>

</body>

</html>