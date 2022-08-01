<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<h4 class="join">비밀번호 수정</h4>
        		<hr style="border-color:#F08000;">
	<br><br>
        	
	<form class="validation-form" novalidate action="<%= request.getContextPath() %>/updatePwd.me" method="post" id="updatePwdForm" name="updatePwdForm" onsubmit="return send();">
        
      
      	<div class="row">
            <div class="col-md-6 mb-3"> 
              	<label for="id">현재 비밀번호</label>
              	<input type="password" class="form-control" name="inputPwd" id="joinUserPwd" placeholder="현재 비밀번호 " required>
              		<div id="pwResult"></div>
              		<div class="invalid-feedback" id="result_id_msg">
                		현재 비밀번호를 입력해주세요.
              		</div>
          	</div>
        </div>
        
        
            
       <div class="row">
           <div class="col-md-6 mb-3">
	           <label for="password">변경 비밀번호</label>
	           <input type="password" class="form-control" name="newPwd1" id="password" placeholder="변경 비밀번호 " required>
              		<div id="pwResult0"></div>
              		<div class="invalid-feedback" id="pwResult">
                		새 비밀번호를 입력해주세요.
              		</div>
           </div>      
       </div>
          	
          	
		<div class="row">
        	<div class="col-md-6 mb-3">
              	<label for="pasword2">변경 비밀번호 확인</label>
              	<input type="password" class="form-control" name="newPwd2" id="password2" placeholder="변경 비밀번호확인" required>
              		<div id="pwResult1"></div>
              		<div class="invalid-feedback" id="pwResult2">
                		새 비밀번호오동일하게 입력해주세요.
              		</div>
           </div>
       	</div>
			
        
  		<br><br>
  		
	<div class="row"> 
		<div class="col-md-6 mb-3"> 
			 <input class="btn-submit" id="updateBtn" type="submit"  value="수정하기" ></input>
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
	
<script>






	//비밀번호 일치(text)
	$('#password2').on('change paste keyup', function(){
		var password = $('#password').val().trim()
		var password2 = $('#password2').val().trim()
		if(password != ("") && password2 != ("") && password != password2){
			$('#pwResult1').text('비밀번호가일치하지 않습니다.').css('color' , 'red');
			//$(this).val('');
			$(this).focus();
			return false;
		} else {
			//$('#pwResult1').text('비밀번호가 일치합니다.').css('color' , 'green');
			$('#pwResult1').text('')
		}
	});

	//비밀번호 일치(alert)
//	function send(){
//		var newPwd = $('input[name="newPwd"]');
//		var newPwd2 = $('input[name="newPwd2"]');
	
//		if(newPwd.val().trim() != newPwd2.val().trim()){
//			alert('비밀번호가 다릅니다.');
//			newPwd2.val('');
//			newPwd2.focus();		
//			return false;
//		} else if(newPwd.val().trim() == '' || newPwd2.val().trim() == ''){
//			alert('비밀번호를 입력해주세요');		
//			return false;
//		}
//			return true;
//	}
	
	
	
	
	
	
	

	//비밀번호 유효성
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




    //빈칸 전체확인
// 	window.addEventListener('load', () => {
// 		const forms = document.getElementsByClassName('validation-form');
// 	    	Array.prototype.filter.call(forms, (form) => {
// 	       		form.addEventListener('submit', function (event) {
// 	         		if (form.checkValidity() === false) {
// 	           			event.preventDefault();
// 	           			event.stopPropagation();
// 	           			form.classList.add('was-validated');
// 	         		}
// 	       		}, false);
// 	     	});
// 	}, false);

</script>

		
	
</body>

<footer class="my-3 text-center text-small">
	<p class="c-n">&copy; 2022 ㅁㅈ</p>
</footer>
</html>