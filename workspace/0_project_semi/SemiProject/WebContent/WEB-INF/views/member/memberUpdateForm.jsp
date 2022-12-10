<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"  %>
<%
	Member myInfo = (Member)request.getAttribute("myInfo");
%>


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
      background-image: url('sample/backone.jpg');
      background-repea: no-repeat;
      background-size : cover; 
    }

	.join{color:#FFA500; font-weight: bold;}

	label{font-weight: bold;}

	
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
    }
    
    .btn-submit {
    	font-color: white;
		background-color:#FFA500; width:100%; height:50px; 
		font-weight: bold; border:none; border-radius:12px; cursor:pointer;  	
	 }
     #cancel {background: #B2CCFF; font-color: black; width:100%; height:50px; font-weight: bold; border-radius:12px; cursor:pointer; }
    .c-n{font-weight: bold;}
    
  </style>
</head>

<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="join"><%= myInfo.getUserId() %>님의 회원정보 수정</h4>
        		<hr style="border-color:#F08000;">
	<br><br>
        	
	<form class="validation-form" novalidate action="<%= request.getContextPath() %>/update.me" method="post" id="updateForm" name="updateForm" onsubmit="reuturn insertValidate();">
        
      
      	
      	<div class="row">
        	<div class="col-md-12 mb-6">
            	<input type="hidden" class="form-control" name="myId" required value="<%= myInfo.getUserId() %>">       
            </div>      
        </div>
      
      	<br><br>
      
		<div class="row">
            <div class="col-md-6 mb-3">
            	<label for="pasword2">New 핸드폰 번호 </label>
              	<div class="input-group mb-3">
  					<input type="text" class="form-control" placeholder="010" maxlength="3" name="newPhone1" id="phone1"  autocomplete=”off” required>
  					<span class="input-group-text">-</span>
  					<input type="text" class="form-control" placeholder="xxxx" maxlength="4" name="newPhone2" id="phone2"  autocomplete=”off” required>
  					<span class="input-group-text">-</span>
  					<input type="text" class="form-control" placeholder="xxxx" maxlength="4" name="newPhone3" id="phone3"  autocomplete=”off” required>
  					<div id="phoneResult0"></div>
  					<div class="invalid-feedback">
                		핸드폰 번호를 입력해 주세요.
              		</div>      
				</div>
            </div>
     	</div>
          
          
       
       
       	     
   		<div class="row">
       		 <div class="col-md-12 mb-3">
              	<label for="birth">New 생년월일</label>
				<div class="input-group mb-3">
					<input type="text" class="form-control mr-3" placeholder="년(4자리)" name="newYear" maxlength="4" required  autocomplete=”off” onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">					  
						<select class="custom-select mr-3"  name="newMonth" id="root" required>
		                	<option value="">월</option>
			                <option value="01">1월</option><option value="02">2월</option>
			                <option value="03">3월</option><option value="04">4월</option>
			                <option value="05">5월</option><option value="06">6월</option>
			                <option value="07">7월</option><option value="08">8월</option>
			                <option value="09">9월</option><option value="10">10월</option>
			                <option value="11">11월</option><option value="12">12월</option>
		              	</select>		              
		            	 <select class="custom-select mr-3" id="root" name="newDay" required>
	                    <option value="">일</option>
		                    <option value="1">1일</option><option value="2">2일</option><option value="3">3일</option>
		                    <option value="4">4일</option><option value="5">5일</option><option value="6">6일</option>
		                    <option value="7">7일</option><option value="8">8일</option><option value="9">9일</option>
		                    <option value="10">10일</option><option value="11">11일</option><option value="12">12일</option>
		                    <option value="13">13일</option><option value="12">14일</option><option value="15">15일</option>
		                    <option value="12">16일</option><option value="17">17일</option><option value="12">18일</option>
		                    <option value="19">19일</option><option value="12">20일</option><option value="21">21일</option>
		                    <option value="12">22일</option><option value="21">23일</option><option value="12">24일</option> 
		                    <option value="21">25일</option><option value="12">26일</option><option value="21">27일</option>
		                    <option value="12">28일</option><option value="21">29일</option><option value="12">30일</option>
		                    <option value="21">31일</option>
                  	</select>	
		             <div class="invalid-feedback">
                		생년월일을 입력해주세요.
              		</div>          
	        	</div>
	     	</div> 
		</div>
			
			
		<div class="row">	
		 	<div class="col">
             	<label for="pasword2">New E-MAIL</label>
			 	<div class="input-group mb-3">
					<input type="text" class="form-control" name="newEmail" id="email01" placeholder="이메일 아이디"  autocomplete=”off” required> 
					<span class="input-group-text">@</span>
					<input type="text" name="str_email02" name="newSite" id="email02" disabled value="naver.com" required>
						<select class="custom-select" name="selectEmail" id="selectEmail" required>
							 <option value="1">직접입력</option>
							 <option value="naver.com" selected>naver.com</option>
							 <option value="hanmail.net">hanmail.net</option>
							 <option value="iei.co.kr">iei.kr</option>
						</select>
						<div class="invalid-feedback">
                		e-mail을 입력해주세요.
              		</div>      
	         	</div>
         	</div>
		</div>
			<div id="emailResult0"></div>     
		
        <div class="mb-3">
        	<label for="address">New 주소</label>
            <input type="text" class="form-control" name="newAddress" id="address" placeholder="Ex: 서울특별시 강남구"  autocomplete=”off” required>
            	<div class="invalid-feedback">
              		주소를 입력해주세요.
            	</div>
        </div>
        
  		<br><br>
  		
        <div class="row"> 
		<div class="col-md-6 mb-3"> 
			 <input class="btn-submit" id="updateBtn" type="submit"  value="수정하기"></input>
		</div> 
		<div class="col-md-6 mb-3"> 
			<input class="btn-submit" id="cancel" type="button" onclick="location.href='javascript:history.go(-1)'" value="취소하기"></input>  <!-- 뒤로 가기 -->
		</div>
	</div>
        
        
        
        
	</form>
			</div>
		</div>
	</div>
	
	
	
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"> 

	//이메일 직접입력
	$('#selectEmail').change(function(){ 
		$("#selectEmail option:selected").each(function () { 
	 		if($(this).val()== '1'){ 
	 	 		$("#email02").val(''); 
	 	 		$("#email02").attr("disabled",false); 
	 	 		
	 	  	}else { 
	 	  		$("#email02").val($(this).text()); 
	 	  		$("#email02").attr("disabled",true); 
	 	  	} 
	 	}); 
	 }); 
	//이메일 한글입력 막기
	$(function(){
	 	var regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	 	//var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	 	$('#email01').on('change', function(){
	 		if(regExp.test($('#email01').val())){
	 			$('#emailResult0').text('이메일을 확인해주세요.').css('color', 'red');
	 			return false;
	 		}else{
	 			$('#emailResult0').text('사용가능한 이메일입니다.').css('color', 'green');
	 			return true;
	 		}
	 	})	
	});
	
	
	//빈칸 전체 확인
// 	window.addEventListener('load', () => {
// 	     const forms = document.getElementsByClassName('validation-form');

// 	     Array.prototype.filter.call(forms, (form) => {
// 	       form.addEventListener('submit', function (event) {
// 	         if (form.checkValidity() === false) {
// 	           event.preventDefault();
// 	           event.stopPropagation();
// 	           form.classList.add('was-validated');
// 	         }
// 	       }, false);
// 	     });
// 	   }, false);
	
</script>		
	
</body>

<footer class="my-3 text-center text-small">
	<p class="c-n">&copy; 2022 ㅁㅈ</p>
</footer>
</html>