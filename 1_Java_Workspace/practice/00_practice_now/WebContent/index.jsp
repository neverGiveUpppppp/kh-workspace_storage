
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.0.min.js"></script>

<title>Insert title here</title>


<style>.test{width:300px; min-height:50px; border:1px solid red;}</style>

</head>
<body>
	
	<h1>jQuery-Ajax구현</h1>
	
	<h3>1.client가 server에 requset</h3>
	이름 : <input type="text" id="myName">
	<button id="nameBtn">전송</button>
	<script>
		$('#nameBtn').on('click',function(){
			var userName = $('#myName').val();
	        
			$.ajax({
	        	url: 'jQueryAjaxServlet1',
	        	type: 'get',
	            data: {userName:userName},
	            success: function(){
	            	alert('전송 성공');
	            },
	            error: function(){
	            	alert('전송 실패');
	            },
	            complete: function(){
	            	alert('성공실패 상관없이 무조건 실행되는 complete');
	            }
			});
		});

	</script>
	
	
	<br>
	

	<h3>2.버튼 선택 시, 서버에서 보낸 값 사용자가 수신</h3>		<!-- 서버가 클라이언트에 response -->
	<button id="getServerTextBtn">서버에서 보낸 값 확인</button>
	<p class="test" id="p1"></p>
	<script>
		$('#getServerTextBtn').click(function(){
			$.ajax({
				url:'jQueryAjax2',
				// data : 서버에서 사용자에게 보낼 데이터가 없으므로 기술x
				type : 'get',
				success: function(data){
					alert('성공');
					console.log(typeof data);
					$('#p1').text(data);
				},
				error: function(){
					alert("에러 발생");	
				},
				complete: function(){
					alert('comeplete work');
				}
			});
		});
	</script>
	
	<br>
	
	<h3>3. 서버로 기본형 전송 값이 있고, 결과로 문자열을 받아 처리</h3>
	<h4>두 개의 값을 더한 결과를 받아옴</h4>
	첫번째 숫자 : <input type="text" id="firstNum"><br>
	두번째 숫자 : <input type="text" id="secondNum"><br>
	<button id="plusBtn">더하기</button>
	<p class="test" id="p2"></p>
	<script>
		// 더하기 버튼을 누르면 첫번째 숫자의 값과 두번째 숫자의 값을 ajax를 통해 jQuery3.do쪽으로 전송하는 코드 작성
		$('#plusBtn').click(function(){
			var n1 = $('#firstNum').val();
			var n2 = $('#secondNum').val();
			
			$.ajax({
				url: 'jQueryAjax3',
				data: {n1:n1, n2:n2},
				type: 'post',
				datatype: 'text',
				success: function(data){
					console.log('전송 성공');
					console.log("받아온 data값 = " +data);
				},
				error: function(data){
					console.log('전송 실패');
				},
				async: true
			});
		});
	</script>


	<br>
	
	
	<h3>4. Object형태의 데이터를 서버에 전송, 서버에서 데이터 처리 후 서버 console로 출력</h3>
	<!-- 여기서 말하는 콘솔은 이클립스 콘솔을 의미함 -->
	학생1 : <input type="text" id="student1"><br>
	학생2 : <input type="text" id="student2"><br>
	학생3 : <input type="text" id="student3"><br>
	<button id="studentTest">결과확인</button>
	<script>
		// 결과확인 버든을 누르면 학생1, 학생2, 학생3의 이름이 jQuery4.do 쪽으로 전송
		// 전송된 학생들의 이름은 서버의 console창에 아래 예시와 같이 출력되고
		// 화면에서는 "전송 성공"이라는 알람창이 뜸
		// console 출력 예시 : 수업을 들을 하생은 ooo,xxx,ㅁㅁㅁ입니다
		$('#studentTest').on('click',function(){
			var student1 = $('#student1').val();
			var student2 = $('#student2').val();
			var student3 = $('#student3').val();
			
			$.ajax({
				url:'jQueryAjax4',
				data: {student1:student1, student2:student2, student3:student3},
				type: 'post',
				/* datatype: 'text', */
				success:function(data){
					alert('전송 성공');	
				},
				error: function(data){
					alert('fail');
				},
				complete: function(){
					alert('another func');
				},
			});
		
		});
	</script>


	<br>
	
	<h3>5. 서버로 기본형 데이터 전송, 서버에서 객체반환</h3>
	<!-- 객체반환은 복수 데이터를 보낼 수 있으므로 복수데이터 의미 -->
	<h4>유저 번호 보내서 해당 유저 정보 가져오기</h4>
	유저 번호 : <input type="text" id="userNo"><br>
	<button id="getUserInfoBtn">정보 가져오기</button>
	<p class="test" id="p3"></p>
	<textarea class="test" id="textarea3" cols="40" rows="5"></textarea>
	<script>
			// 유저 번호에 따라서 사람 검색하는게 목표
		$('#getUserInfoBtn').on('click',function(){
			var userNo = $('#userNo').val();
			
			$.ajax({
				// url:'${pageContext.request.contextPath}/jQueryAjax5', // 
			    url:'00_practice_now/jQueryAjax5',
				data: {userNo:userNo},
				datype:'json',
				success: function(data){
					console.log(data);
					console.log(typeof data);
					var result = "";
					if(data != null){
						// var result = data.userNo+" "+data.userName + ", " + data.userNation;
						var result = data["userNo"]+" "+data["userName"] + ", " + data['userNation'];
					}
				},
				error: function(xhr){ // xhr // XMLHttpRequest (XHR)
					console.log(xhr.status); // 무슨 에러인지 나오는 코드
				// arc postman api 사용해볼 것
				}
				
				
			});
			
		});
	
	</script>
	
	
	
</body>
</html>





