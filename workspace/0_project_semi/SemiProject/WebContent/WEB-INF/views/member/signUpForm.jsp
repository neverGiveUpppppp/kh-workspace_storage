<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
  
  
  /*배경화면 이미지 파일 처리 */ 
    body {
      min-height: 100vh;
      background-image: url('sample/backone.jpg');
      background-repea: no-repeat;
      background-size : cover; 
    }

	/* 화면 타이틀명 */
	.join{color:#FFA500; font-weight: bold;}

	/* 인풋 설명란  */
	label{font-weight: bold;}

	
	/* 인풋창 */
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
    
    /* submit 버튼 */
    .btn-submit {
    	font-color: white;
		background-color:#FFA500; width:100%; height:50px; 
		font-weight: bold; border:none; border-radius:12px; cursor:pointer;  	
	 }
	 
	 /* 취소하기 버튼*/
    #cancel {background: #B2CCFF; font-color: black; width:100%; height:50px; font-weight: bold; border-radius:12px; cursor:pointer; }
    .c-n{font-weight: bold;}
    
</style>
</head>

<body>

	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="join">회원가입</h4>
				 <hr style="border-color:#F08000;">
        
	<br><br>
        													
	<form class="validation-form" id="frm" novalidate action="<%= request.getContextPath() %>/insert.me" method="post" id="joinForm" name="joinForm" onsubmit="reuturn insertValidate();">
        
        
		<div class="row">
            <div class="col-md-6 mb-3">
              	<label for="id">아이디</label>
              	<input type="text" class="form-control" name="inputId" id="joinUserId" placeholder="아이디 "  autocomplete=”off” required>
              		<div id="idResult"></div>
              		<div class="invalid-feedback" id="result_id_msg">
                		아이디를 입력해주세요.
              		</div>
          	</div>
        </div>
        
        
            
       <div class="row">
           <div class="col-md-6 mb-3">
	           <label for="password">비밀번호</label>
	           <input type="password" class="form-control" name="inputPwd" id="password" placeholder="비밀번호 "  autocomplete=”off” required>
              		<div id="pwResult0"></div>
              		<div class="invalid-feedback" id="pwResult">
                		비밀번호를 입력해주세요.
              		</div>
           </div>      
       </div>
          	
          	
		<div class="row">
        	<div class="col-md-6 mb-3">
              	<label for="pasword2">비밀번호 확인</label>
              	<input type="password" class="form-control" name="joinUserPwd2" id="password2" placeholder="비밀번호확인"  autocomplete=”off” required>
              		<div id="pwResult1"></div>
              		<div class="invalid-feedback" id="pwResult2">
                		비밀번호를 입력해주세요.
              		</div>
           </div>
       	</div>
			
			
		<div class="row">
            <div class="col-md-6 mb-3">
              	<label for="name">이름</label>
              	<input type="text" class="form-control" name="userName" id="name" placeholder="이름"  autocomplete=”off” required>
              		<div id="nameResult0"></div>
              		<div class="invalid-feedback">
                		이름을 입력해주세요.
              		</div>          
          	</div>         	
         	<div class="col-md-6 mb-3">
          	 	<label for="gen">성별</label>
          	 		<div class="input-group mb-3">
	          			<div class="form-check form-check-inline">
	  						<input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="M" required>
	  						<label class="form-check-label" for="inlineRadio1">남자</label>
	  					</div>
						<div class="form-check form-check-inline">
						  	<input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="W" required>
						  	<label class="form-check-label" for="inlineRadio2">여자</label>
						</div>
					</div>
			</div>        	
        </div>	
		
			
		<div class="row">
            <div class="col-md-6 mb-3">
            	<label for="pasword2">핸드폰 번호</label>
              	<div class="input-group mb-3">
  					<input type="text" class="form-control" placeholder="010" maxlength="3" name="userPhone1" id="phone1"  autocomplete=”off” required>
  					<span class="input-group-text">-</span>
  					<input type="text" class="form-control" placeholder="xxxx" maxlength="4" name="userPhone2" id="phone2"  autocomplete=”off” required>
  					<span class="input-group-text">-</span>
  					<input type="text" class="form-control" placeholder="xxxx" maxlength="4" name="userPhone3" id="phone3"   autocomplete=”off” required>
  					<div id="phoneResult0"></div>
  					<div class="invalid-feedback">
                		핸드폰 번호를 입력해 주세요.
              		</div>      
				</div>
            </div>
     	</div>
          
          
       
       
       	     
   		<div class="row">
       		 <div class="col-md-12 mb-3">
              	<label for="birth">생년월일</label>
				<div class="input-group mb-3">
					<input type="text" class="form-control mr-3" placeholder="년(4자리)" name="year" maxlength="4" required  autocomplete=”off” onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">					  
						<select class="custom-select mr-3"  name="month" id="root" required>
		                	<option value="">월</option>
			                <option value="01">1월</option><option value="02">2월</option>
			                <option value="03">3월</option><option value="04">4월</option>
			                <option value="05">5월</option><option value="06">6월</option>
			                <option value="07">7월</option><option value="08">8월</option>
			                <option value="09">9월</option><option value="10">10월</option>
			                <option value="11">11월</option><option value="12">12월</option>
		              	</select>		              
		            	 <select class="custom-select mr-3" id="root" name="day" required>
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
             	<label for="pasword2">E-MAIL</label>
			 	<div class="input-group mb-3">
					<input type="text" class="form-control" name="email" id="email01" placeholder="이메일 아이디"  autocomplete=”off” required> 
					<span class="input-group-text">@</span>
					<input type="text" name="site" id="email02" disabled value="naver.com" required>
						<select class="custom-select" name="selectEmail" id="selectEmail" required>
							 <option value="1">직접입력</option>
							 <option value="naver.com" selected>naver.com</option>
							 <option value="hanmail.net">hanmail.net</option>
							 <option value="iei.co.kr">iei.kr</option>
						</select>
						<button type="button" id=checkNumber class="btn btn-danger">인증번호 발송</button>
						<div class="invalid-feedback">
                		e-mail을 입력해주세요.
              			</div>      
					</div>
				</div>	
			</div>			
			<div id="emailResult0"></div>
											
		
		    <br>
		    
	       
				<div id="refresh">			
					<input type="hidden" class="form-control" name="hiddenNumber" id="hiddenNumber" value="<%= session.getAttribute("checkNumber") %>">		
				</div>
				<span id="countDown"></span>
				
				<div class="row">
            		<div class="col-md-6 mb-3">
              			<input type="text" class="form-control" name="confirmNumber" id="confirmNumber" placeholder="인증번호를 입력해주세요"  autocomplete=”off” required>
  					</div>
  					<div class="col-md-6 mb-3">
  				    	<button type="button" name="confirm" id="confirm" class="btn btn-danger">인증번호 확인</button>
  					</div>
            		<div class="invalid-feedback">
                		인증번호를 입력해주세요.
            		</div>        
             	</div>
				
				
			
		
        <div class="mb-3">
        	<label for="address">주소</label>
            <input type="text" class="form-control" name="userAddress" id="address" placeholder="Ex: 서울특별시 강남구"  autocomplete=”off” required>
            	<div class="invalid-feedback">
              		주소를 입력해주세요.
            	</div>
        </div>

      
        <hr class="mb-4">
        	<div class="custom-control custom-checkbox">
            	<input type="checkbox" class="custom-control-input" id="aggrement" required>
            	<label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          	</div>
        
        <br>
        
        <button class="btn-submit" type="submit">가입 신청</button>
        
        <br><br>
        
        <input class="btn-submit" id="cancel" type="button" onclick="location.href='javascript:history.go(-1)'" value="취소하기"></input>
	</form>
			</div>
		</div>
	</div>
  

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
		var seconds = 120; 
		function countDown() {
			var min = parseInt((seconds)/60);
			var sec = seconds%60;
			$("#countDown").html(min+":" + sec); 
			if(seconds > 0){
				seconds--;
			} else if(seconds <= 0){	
				$("#countDown").html("인증시간 만료"); 	
				$("#hiddenNumber").val(""); 
			}
		}

		$('#checkNumber').click(function(){
		var eamilId = "";
		emailId =  $('#email01').val();
		var userEmail = $('#email01').val() + '@' +  $('#email02').val();
		console.log(userEmail);
		
			$.ajax({
				url:'checkNumber.do',
				type:'get',
				data:{email:userEmail, emailId:emailId},
				success:function(data){
					setInterval(countDown,1000);
					alert("인증번호를 이메일로 전송하였습니다.");
					$('#hiddenNumber').val(data);
				},
				error:function(data){
					alert('이메일 전송에 실패하였습니다. 이메일을 확인하여 주세요.');
				}
			});
		});
		
		
  
		function focusConfirm(){
			 var hiddenNumber = $('#hiddenNumber').val(); 
	         var confirmNumber = $('#confirmNumber').val();
	         if(hiddenNumber != confirmNumber){
	        	 $('#confirmNumber').val('').focus();
	         }
		}
		

			
		$('#confirm').click(function(){
	         var hiddenNumber = $('#hiddenNumber').val(); 
	         var confirmNumber = $('#confirmNumber').val();
	         if(hiddenNumber == confirmNumber) {
	            alert('인증에 성공하셨습니다.');
	            
	         } else {   	 
	            alert('인증에 실패하였습니다. 다시 입력해 주세요');
	           
	            
	         }
	  })



<!-- 아이디 중복체크 및 4자 미만x 정규식 -->


		var isUserble = false;   // id 중복 시 false, 사용 가능 시 true
		var isIdChecked = false; // id 중복 확인 했는지 여부
		
		/* $('#joinUserId').on('change paste keyup', function(){
			 isIdChecked = false;
		}); */
	
		$('#joinUserId').change(function(){
			var userId = $('#joinUserId');
			var regExp = /^[a-z]+[a-z0-9]{4,19}$/g;
			
			if(!userId || userId.val().length < 4){
				$('#idResult').text('아이디는 최소 4자리 이상이어야 합니다.').css('color' , 'red');
			} else if(!regExp.test(userId.val().trim())) {
				$('#idResult').text('영소문자숫자 또는 영소문자로 작성').css('color' , 'red');
			} else {
				$.ajax({
					url: '<%= request.getContextPath() %>/CheckId.me',
					type: 'post',
					data: {inputId:userId.val()}, 
					success: function(data){
						console.log(data);
						if(data == '0'){
							$('#idResult').text('사용 가능합니다.').css({'color':'green', 'float':'left', 'display':'inline-block'});
							isUsable = true;
							isIdChecked = true;
						} else if(data = '1'){
							$('#idResult').text('이미 사용중인 아이디입니다.').css({'color':'red', 'float':'left', 'display':'inline-block'});
							userId.focus();
							isUsable = true;
							isIdCheked = false;
						}
					},
					error: function(data){
						console.log(data);
					}	
				});
			}
		});
		
		function insertValidate(){
			if(isUsable && isIdChecked){
				return true;
			} else{
				alert('아이디 중복확인을 해주세요');
				return false;
			}
		}
	
		
	

	

		
		
		
		
//	 	 $('#name').on('change paste keyup', function(){
//	 		 var name = $('#name').val().trim();
//	 		 var n_RegExp = /^[가-힣]{2,15}$/;
			 
//	 		 if(name != '' && n.n_RegExp.test(name)){
//	 				alert('비밀번호가일치하지 않습니다.');		
//	 				$(this).focus();
			
//	 				return false;
//	 			} else {
//	 				alert('비밀번호가 일치합니다.');
//	 				return false;
//	 			}
//	 	 });

	
</script>




<!-- 비밀번호 확인 -->
<script>

	$('#password2').on('change paste keyup', function(){
		var password = $('#password').val().trim()
		var password2 = $('#password2').val().trim()
		if(password != ("") && password2 != ("") && password != password2){
			$('#pwResult1').text('비밀번호가일치하지 않습니다.').css('color' , 'red');
// 			$(this).val('');
			$(this).focus();
	
			return false;
		} else {
// 			$('#pwResult1').text('비밀번호가 일치합니다.').css('color' , 'green');
			$('#pwResult1').text('')
		}
	});
	
	
	
	$("#password").change(function(){
    	checkPassword($('#password').val());
	});
	
	function checkPassword(password,id){
    
    	if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(password)){            
    		alert('숫자+영문자+특수문자 조합으로 8자리 이상 사용해야 합니다.');
        	$('#password').val('').focus();
        	return false;
    	}   
    	
    	var checkNumber = password.search(/[0-9]/g);
    	var checkEnglish = password.search(/[a-z]/ig);
    	if(checkNumber <0 || checkEnglish <0){
        	alert("숫자와 영문자를 혼용하여야 합니다.");
        	$('#password').val('').focus();
        	return false;
    	}
    	
    	if(/(\w)\1\1\1/.test(password)){
        	alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
        	$('#password').val('').focus();
        	return false;
    	}
        
   
    return true;
	} 
	
	

	
	
	//이름 정규식
	$('#name').on('change paste keyup', function(){
		var userName = $('#name').val().trim();
		var regex = /^[가-힣a-zA-Z]+$/;
		
		if(regex.test(userName)) {
			$('#nameResult0').text('');
			// $(this).val('');
			$(this).focus();
	
			return false;
		} else {
			$('#nameResult0').text('한글 영어로만 작성').css('color' , 'red');
			$(this).val('');
	
		}
	});
	
	
	
	
	
	
// 	 $('#name').on('change paste keyup', function(){
// 		 var name = $('#name').val().trim();
// 		 var n_RegExp = /^[가-힣]{2,15}$/;
		 
// 		 if(name != '' && n.n_RegExp.test(name)){
// 				alert('비밀번호가일치하지 않습니다.');		
// 				$(this).focus();
		
// 				return false;
// 			} else {
// 				alert('비밀번호가 일치합니다.');
// 				return false;
// 			}
// 	 });

</script>
	 
	 
	
	
	
	
	 
<!-- 이메일 직접입력 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript"> 
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
	 			$('#emailResult0').text('한글은 입력할 수 없습니다.').css('color', 'red');
	 			return false;
	 		}else{
	 			$('#emailResult0').text('사용가능한 이메일입니다.').css('color', 'green');
	 			return true;
	 		}
	 	})	
	});
	
	
	


// 	[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}
	//이메일 정규식
// 	$('#email01').on('change paste keyup', function(){
// 		var userEmail = $('#email01').val().trim();
// 		var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{4,20}$/i
		
// 		if(regex.test(userEmail)) {
// 			$('#emailResult0').text('');
// 			// $(this).val('');
// 			return false;
// 		} else {
// 			$('#emailResult0').text('이메일 아이디를 다시 확인해주세요').css('color' , 'red');
		   
	
// 		}
// 	});
	
// 	   var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	   
// 	   $(function(){
// 	      $('#email01').on('change paste keyup', function(){
// 	         if(!regExp.test($('#email01').val())){
// 	            $('#emailResult0').text('이메일을 확인해주세요.').css('color' , 'red');
// 	         return false;   
// 	         } else{
// 	            $('#emailResult0').text('');
// 	         return true;
// 	         }
// 	      });
// 	   });
	

	
	
	window.addEventListener('load', () => {
     const forms = document.getElementsByClassName('validation-form');

     Array.prototype.filter.call(forms, (form) => {
       form.addEventListener('submit', function (event) {
         if (form.checkValidity() === false) {
           event.preventDefault();
           event.stopPropagation();
           form.classList.add('was-validated');
         }
       }, false);
     });
   }, false);
	
	
	
	
	
	
</script>





  
</body>

<footer class="my-3 text-center text-small">
	<p class="c-n">&copy; 2022 ㅁㅈ</p>
</footer>

</html>