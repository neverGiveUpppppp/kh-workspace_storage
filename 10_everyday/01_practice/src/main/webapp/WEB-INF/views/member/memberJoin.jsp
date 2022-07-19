<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>prac</title>



</head>
<body>

	<jsp:include page="../common/menubar.jsp"/>
	
	<h1 align="center">회원가입</h1>
	
	<div class="centerText">
		<form action="minsert.me" method="post" id="joinForm">
			<table>
				<tr>
					<th>* 아이디</th>
					<td>
						<input type="text" name="id" id="userId">
						<span class="guide ok"> 사용 가능 아이디</span>
						<span class="guide error"> 사용 불가능 아이디</span>
						<input type="hidden" id="idDuplicateCheck" value="0"/> <!-- 기본값 value 0으로 해놓고 백단에서 받아온 값에 따라 1로 바꿔서 사용가능 불가능 보여줌-->
					</td>
				</tr>
				<tr>
					<th>* 이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>* 비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<th>* 비밀번호 확인</th>
					<td><input type="password" name="pwd2"></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nickName"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="M">남
						<input type="radio" name="gender" value="F">여
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="age" min="20" max="100"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="post" class="postcodify_postcode5" value="" size="6"> <!-- value가 0인건 input태그로 사용자의 정보를 받아야하기 때문 -->
						<button type="button" id="postcodify_search_button">검색</button>
					</td>
				</tr>
				<tr>
					<th>도로명 주소</th>
					<td><input type="text" name="address1" class="postcodify_address" value=""></td>
				</tr>
				<tr>
					<th>상세 주소</th>
					<td><input type="text" name="address2" class="postcodify_extra_info" value=""></td>
				</tr>
				
				<!-- jQuery와 Postcodify를 로딩을 위한 스크립트 -->
				<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
				<script>
				// 검색 단추를 누르면 팝업 레이어가 열리도록 설정함
					$(function(){
						$("#postcodify_search_button").postcodifyPopUp();
					});
				</script>
				
				<tr>
					<td colspan="2" align="center">
						<button onclick="return validate();">가입하기</button>
						<input type="reset" value="취소하기"> <!-- 인풋 리셋은 name속성 필요없이 value에 텍스트나타나게 -->
						<button type="button" onclick="location.href='home.do'">시작 페이지로</button>
					</td>
				</tr>
			</table>
		</form>
	</div>




	<script>
		${'#userId'}.on('keyUp',function(){
			var userId = $(this).val().trim(); /* trim() : 앞뒤 공백제거 */
			
			if(userId.length > 4){ // 변수명.length
				$('.guide').hide();
				$('#idDuplicateCheck').val(0);
				return;
			}
			
			$.ajax({
				url:'dupId.me',
				date:{id:userId},
				success:function(data){
					console.log(date);
					
					if(data == 1){
						$('guide.error').show();
						$('guide.ok').hide();
						$('#idDuplicateCheck').val(0);
					}else{
						$('.guide.error').hide();
						$('.guide.ok').show();
						$('#idDuplicateCheck').val(1);
					}
				},
				error:function(data){
					console.log(date);		
				}
				
			});
		});
	
		function validate(){
			if($('#idDuplicateCheck').val() == 0){ // 유효성 검사로 중복아이디면 밸류값이 0
				alert('사용 가능한 아이디를 입력해주세요');
				$('#userId').focus(); // 아이디 입력하고 입력창으로 포인터 이동시키는 .focus()
				return false;
			}else{
				${'#joinForm'}.submit(); // .submit() : 폼태그 submit시키는 코드
			}
		}
		
	</script>


</body>
</html>