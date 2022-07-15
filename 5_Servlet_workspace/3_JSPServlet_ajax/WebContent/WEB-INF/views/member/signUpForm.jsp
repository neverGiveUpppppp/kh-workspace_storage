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
<!-- 중복확인 부분 td 삭제 -->	<!-- 	<td width="200px"><input type="button" id="idCheck" value="중복확인"></td> -->
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
					<td></td>
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
//		document.getElementById('idCheck').onclick = function(){
//			/* window.open('checkIdForm.me',); */ /*  < % = request.getContextPath() % >앞에다가 해줘도 된다 */
//			window.open('checkIdForm.me','idCheckForm','width=300, height=200') /* idCheckForm : 창에 대한 name값 */
//		}

		var isUsable = false; 		// id 중복 시 false, 사용 가능 시 true
		var isIdChecked = false; 	// id 중복 확인 했는지 여부
		
		$('#joinUserId').on('change paste keyup', function(){ // change paste keyup
			// 클릭 대신 chnge 바뀐다거나 붙여넣기한다거나 키업 키보드가 써진다고 한다면 나중에라도 값을 바꿀 수 있음. 
			// 유저가 아이디 중복 체크하고 중복 안됬는데 다시 아이디를 바꾸고 회원가입 버튼 누르면 중복확인이 안된 상태니 이를 막아주기 위해
			// 중복확인을 안한걸로 치겠다고 하는 코드
			isIdChecked = false;
		});
		$('#joinUserId').change(function(){ // 강의 12:34
			var userId = $('#joinUserId');
			
			// 아이디 4자리 이상 쓰게하는 코드
			if(!userId || userId.val().length < 4){
				alert('아이디는 최소 4자리 이상이어야 합니다.');
				userId.focus();
			}else{
				$.ajax({
					// 정확하게 할려면 컨텍스트 패스 적어줘야함. 정확하다는 의미는 폴더,경로가 존재할 때 이를 무시하고 루트 컨텍스트부터 시작하고 싶으면 붙이는 것
					url: '<%= request.getContextPath() %> /checkId.me', 
					type: 'post',
					data: {inputId:userId.val()}, // inputId : 서블릿에서 파라미터로 가져온 것
					success: function(data){
					console.log(data);
					},
					error: function(data){
					console.log(data);

					
					
					
					
				});
			}
		}
		
	</script>
	
	
	
</body>
</html>







