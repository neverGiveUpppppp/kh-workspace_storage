<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .outer{
         width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
         margin-left: auto; margin-right: auto; margin-top: 5%;
      }
   #idCheck, #nickCheck{border-radius: 15px; color: white; background: #FFD8D8;}
   #emailCheck{border-radius: 15px; color: white; background: #FFD8D8;}
   #joinForm td {text-align: right;}
   #joinForm tr:nth-child(1) > td:nth-child(3),
      #joinForm tr:nth-child(5) > td:nth-child(3){text-align: left;}
   .signUpBtns{text-align: center;}
   .signUpBtns input {background: #D1B2FF; color: white;}
   .signUpBtns input+input {background: #B2CCFF; color: white;}
   td>.must{color: red; font-weight: bold;}
</style>
</head>
<body>
   <%@ include file="../common/menubar.jsp" %>
      
   <div class="outer">
      <br>
      <h2 align="center">회원가입</h2>
      
      <form action="<%= request.getContextPath() %>/insert.me" method="post" id="joinForm" name="joinForm" onsubmit="return insertValidate();">
         <table>
            <tr>
               <td width="200px"><label class="must">*</label> 아이디</td>
               <td><input type="text" maxlength="13" name="joinUserId" required id="joinUserId"></td>
<!-- td태그 삭제 -->  <!-- <td width="200px"><input type="button" id="idCheck" value="중복확인"></td> -->
            	<td width="200px"><label id="idResult"></label></td>
            </tr>
            <tr>
               <td><label class="must">*</label> 비밀번호</td>
               <td><input type="password" maxlength="13" name="joinUserPwd" required></td>
            </tr>
            <tr>
               <td><label class="must">*</label> 비밀번호 확인</td>
               <td><input type="password" maxlength="13" name="joinUserPwd2" required></td>
               <td><label id="pwdResult"></label></td>
            </tr>
            <tr>
               <td><label class="must">*</label> 이름</td>
               <td><input type="text" name="userName" required></td>
            </tr>
            <tr>
               <td><label class="must">*</label> 닉네임</td>
               <td><input type="text" maxlength="15" name="nickName" required></td>
               <td width="200px"><input type="button" id="nickCheck" value="중복확인"></td>
            </tr>
            <tr>
               <td>연락처</td>
               <td>
                  <input type="tel" maxlength="11" name="phone" placeholder="(-없이)01012345678">
               </td>
            </tr>
            <tr>
               <td>이메일</td>
               <td><input type="email" name="email"></td>
               <td><input type="button" value="이메일 확인" id="emailCheck"></td>
               <!--  onclick="location.href='<%= request.getContextPath() %>/checkEmail.me'" -->
            </tr>
            <tr>
               <td>주소</td>
               <td><input type="text" name="address"></td>
               <td></td>
            </tr>
            <tr>
               <td>관심분야</td>
               <td>
                  <input type="checkbox" id="sports" name="interest" value="운동">
                  <label for="sports">운동</label>
                  <input type="checkbox" id="climbing" name="interest" value="등산">
                  <label for="climbing">등산</label>
                  <input type="checkbox" id="fishing" name="interest" value="낚시">
                  <label for="fishing">낚시</label>
                  <input type="checkbox" id="cooking" name="interest" value="요리">
                  <label for="cooking">요리</label>
                  <input type="checkbox" id="game" name="interest" value="게임">
                  <label for="game">게임</label>
                  <input type="checkbox" id="etc" name="interest" value="기타">
                  <label for="etc">기타</label>
               </td>
               <td></td>
            </tr>
         </table>
         
         <br clear="all">
         
         <div class="signUpBtns">
            <input type="submit" value="가입하기">
            <input type="button" onclick="location.href='<%= request.getContextPath() %>'" value="메인으로">
         </div>
      </form>
   </div>
   
   <script>
//       document.getElementById('idCheck').onclick = function(){
//          window.open('checkIdForm.me', 'idCheckForm', 'width=300, height=200');
//       }
      var isUsable = false;      // id 중복 시 false, 사용 가능 시 true
      var isIdChecked = false;   // id 중복 확인 했는지 여부
      
      $('#joinUserId').on('change paste keyup', function(){ // 세 조건 중 하나라도 들어오면 함수 작동
         isIdChecked = false;
      });
      
      $('#joinUserId').change(function(){
         var userId = $('#joinUserId');
         
         if(!userId || userId.val().length < 4){
            alert('아이디는 최소 4자리 이상이어야 합니다.');
            userId.focus();
         } else{
            $.ajax({
               url: '<%= request.getContextPath() %>/checkId.me',
               type: 'post',
               data: {inputId:userId.val()},
               success: function(data){
                  console.log(data);
                  console.log(typeof data); // str
                  
                  if(data == '0'){	// 서버에서 들어오는 값이 str이나 js는 간단 파싱이 가능한 숫자형 문자는 자동캐스팅해줘서 에러안나고 잘 실행됨
                	  console.log('사용 가능');	  // but, 만일을 대비해 비교 숫자를 str로 만들어주자. data == 0에 '' 랩하자
                		
                	  // 아이디 중복확인 결과 메세지
                	  $('#idResult').text('사용 가능합니다.').css({'color':'green','float':'left','display':'inline-block'});
               	  	  isUsable = true;
               	  	  isIdChecked = true;
               	  	  
               	  	  
               	  	  
                  } else if(data == '1'){		 
                	  // console.log('사용 불가능');
                	  
                	  // 아이디 중복확인 결과 메세지
                	  $('#idResult').text('사용 불가능합니다 ').css({'color':'red', 'float':'left', 'display':'inline-block'});
                	  userId.focus();

                  	  isUsable = false;
               	  	  isIdChecked = false;
               	  }
                  
               },
               error: function(data){
                  console.log(data);
               }
            });
         }
      });
      
      // 중복 확인 안되면 회원가입 버튼 눌러도 안넘어가게 하는 함수
      function insertValidate(){
    	  if(isUsable && isIdChecked){
	   	  	  return true;
	   	  }else{
	    	  alert('아이디 중복확인을 해주세요');
	   	      return false;
	   	  }
   	  }

      // 회원가입 인증 메일 관련
      $('#emailCheck').click(function(){
    	 var email = $('input[name=email]').val();
    	 /* console.log(email); */
    	 location.href='<%= request.getContextPath() %>/checkEmail.me?email=' + email;
      });
      
      
   </script>
   
   
   
   
   
   
   
   
</body>
</html>

