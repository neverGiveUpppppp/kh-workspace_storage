<%@ page language="java" contentType="text/html; charset=UTF-8" import="member.model.vo.Member"
    pageEncoding="UTF-8"%>
<%
Member member = (Member)request.getAttribute("member");
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
	  text-align: center;
      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
    }
    
    .btn-submit {
		background-color:#FFA500; width:50%; height:50px; 
		font-weight: bold; border:none; border-radius:12px; cursor:pointer;  	
	 }
	 
    #updateBtn {background: #D1B2FF; color: white;}
    #deleteBtn {background: #FFD8D8; color: red;}
	#goMain {background: #B2CCFF; color: black; width:50%; height:50px;}
    
    .c-n{font-weight: bold;}
    
  </style>
</head>

<body>
<div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="join"><%= member.getUserId() %>님의 회원정보</h4>
         <hr style="border-color:#F08000;">
        
        
        <br><br>
        
  
 <form class="validation-form" action="<%= request.getContextPath() %>/updateForm.me" method="post" id="myForm" name="myForm">
        

        
        
        <div class="row">
        	<div class="col-md-12 mb-6">
            	<label for="name">아이디</label>
            		<%= member.getUserId() %><input type="hidden" class="form-control" name="myId" required value="<%= member.getUserId() %>">       
            </div>      
        </div>
          	  
        <br>
           
        <div class="row">
        	<div class="col-md-12 mb-6">
            	<label for="name">이름</label>
            		<%= member.getUserName() %><input type="hidden" class="form-control" name="myName" required value="<%= member.getUserName() %>">       
            </div>      
        </div>
          	  
        <br>
          	
		<div class="row">
        	<div class="col-md-12 mb-6">
              <label for="gender">성별</label>
             	<%= member.getGender() %><input type="hidden" class="form-control" name="mygender " required value="<%= member.getGender() %>">
            </div>
        </div>
			
		<br>
		
		<div class="row">
            <div class="col-md-12 mb-6">
              <label for="birth">생년월일</label>
              	<%= member.getBornDate() %><input type="hidden" class="form-control" name="myBorn" required value=" <%= member.getBornDate() %>">
            </div>
        </div>
			
       	<br>
		
		<div class="row">
            <div class="col-md-12 mb-6">
            	<label for="phone">연락처</label>
             		<%= member.getPhone() %><input type="hidden" class="form-control" name="myPhone" required value="<%= member.getPhone() %>">
            </div>
        </div>
			
		<br>
          
       <div class="row">
       		<div class="col-md-12 mb-6">
              	<label for="email">E-MAIL</label>
             		<%= member.getUserEmail() %><input type="hidden" class="form-control" name="myEmail" required value=" <%= member.getUserEmail() %>">
            </div>
       </div>
			
       <br>
     
          
       <div class="row">
            <div class="col-md-12 mb-6">
              <label for="address">주소</label>
              		<%= member.getUserAddress() %><input type="hidden" class="form-control" name="myAddress" required value="<%= member.getUserAddress() %>">
            </div>
          </div>			
       <br>
		
		
       <div class="row">
            <div class="col-md-12 mb-6">
              <label for="address">가입 날짜</label>
              		<%= member.getEnrollDate() %><input type="hidden" class="form-control" name="myEnrollDate" required value="<%= member.getEnrollDate() %>">
            </div>
          </div>			
       <br>

   
	<div class="row"> 
		<div class="col-md-6 mb-3"> 
			<input class="btn-submit" id="updatePwdBtn" type="submit" value="수정하기" onclick="location.href='update.me'"></input>
		</div> 
		<div class="col-md-6 mb-3"> 
			<input class="btn-submit" id="updatePwdBtn" type="button" value="비밀번호 변경 하기" onclick="location.href='updatePwdForm.me'"></input>
		</div>
	</div>
	
	<div class="row"> 
		<div class="col-md-6 mb-3"> 
			<input class="btn-submit" id="deleteBtn" type="button" value="탈퇴하기" onclick="deleteMember();"></input>
		</div> 
		<div class="col-md-6 mb-3"> 
			<input class="btn-submit" id="goMain" id="button" type="button" value="메인으로" onclick="location.href='<%= request.getContextPath() %>'"></input>
		</div>
	</div>
  
  
  	
</form>
  		</div>
    </div>   
</div>

<script>
		function deleteMember(){
			// 정말 삭제할거냐고 물어본 후, 삭제하겠다고 하면 delete.me로 요청
			var bool = confirm('정말 탈퇴하시겠습니까?');
			if(bool){
				location.href = '<%= request.getContextPath() %>/delete.me';
			
				// attr 로 진행하면 action이 바뀌어져 있는 상태이기 때문에 수정하기를 눌러도 delete.me 로 넘어감 !! 주의
		
			}
		
		}	
	</script>

    
</body>
<footer class="my-3 text-center text-small">
	<p class="c-n">&copy; 2022 ㅁㅈ</p>
</footer>


</html>