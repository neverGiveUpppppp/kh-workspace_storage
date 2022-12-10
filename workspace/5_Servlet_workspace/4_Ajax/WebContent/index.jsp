
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
	
	<h1>jQuery를 이용한 Ajax구현</h1>
	
	<h3>1.버튼 선택 시, 전송 값 서버에 출력</h3>	<!-- client가 server에 requset -->
	이름 : <input type="text" id="myName">
	<button id="nameBtn">이름 전송</button>
	<script>
	/* 		
		$('#nameBtn').on('click',function(){ 과 같은 기능 코드
		$('#nameBtn').click(function(){
*/	
/* 
		$('#nameBtn').on('click',function(){
			var name = $('#myName').val();
		
			$.ajax({
				url: 'jQuery1.do',		 // jQuery1.do주소의 서블릿 호출하는 것. 서블릿 생성하러 ㄱㄱ
				data: {sendName:name},	  // data속성 : 서버로 전송할 요청 Parameter 설정 // sendName이 키값 name이 밸류값
				// 변수 name 안에 사용자가 인풋태그에 입력한 값이 담겨있음. 
				// name변수를 센드네임 변수에 집어 넣은 것. 
				
				success: function(){	// ajax 통신 성공 시 호출되는 함수를 지정
					alert('통신 성공'); 	// success : 통신 잘 성공했어 확인할 수 있게 해주는 속성	
				},
				error: function(){
					alert('통신 실패');		// error : 통신 실패 일 경우
					console.log(data);
				},
				complete: function(){	// complete : ajax통신 성공여부와 관계없이 통신 완료 후 실행되는 함수 지정
					alert('성공실패 무관하게 작동하는 complete');	// 석세스로 통신성공 뜬 후 complete로 다시 실행됨
				}
			});	
		});	
		 */
		 
		 $('#nameBtn').on('click',function(){
				var name = $('#myName').val();
		        
				$.ajax({
		        	url: 'jQuery1.do',
		        	type: 'get',
		            data: {sendName:name},
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
/* 같은코드 $('#getServerTextBtn').on('click',function(){ */
		$('#getServerTextBtn').click(function(){	/* 유저가 서버에 보낼 값이 없기 때문에  ajax바로 사용*/
			$.ajax({
		
				url: 'jQuery2.do',		// ajax 필수 속성
				// data 속성 보낼게 없기 때문에 사용x
//				type:'post',	// type : Http 요청 방식 지정 (GET / POST) 
				// 타입 속성 자체를 미지정시 디폴트값 get
				// post로 넘기면 인코딩 깨져야 하지 않나? ajax는 크게 영향 안받는편이나 확실하게는 인코딩해주는게 좋다
				success: function(data){

					// 서버에서 보내온 데이터값을 받아올거야. 누구 사용?
					// data 사용
					// date 두가지 있음 
					// 1)함수에 매개변수로 쓰이는 데이터
					// 		function(data)에서의 데이터는 서버에서 클라이언트로 보낸 데이터를 받아주는 역할 
					// 		서버에서 클라이언트로 데이터가 들어오는 곳.  받아오는거임 매개변수니까
					// 2)속성으로 쓰이는 데이터 : 클라이언트에서 서버로 가는 데이터 기술
					//
					// date 두가지 말씀하신게 바꿔말하면,
					// ajax 속성값 date랑
					// success 함수의 매개변수명임
					//
					// Q.success 함수의 매개변수명을 관례적으로 data로 쓰는건가여?
					// A.yes
					
					console.log(data);
					$('#p1').text(data);
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
		// 아작 ajax 시작한게 아님. 틀을 잡아보라는 것
		
		$('#plusBtn').on('click',function(){
			var num1 = $('#firstNum').val();	// input태그값 가져오기
			var num2 = $('#secondNum').val();	// val() : 밸류값 가져오기
		
			$.ajax({
				url: 'jQuery3.do',
				data: {firstNum:num1, secondNum:num2}, // ,로 매개변수값 여러 넣기 가능
				success: function(data){
					console.log(data);	// 서블릿에서 int로 넘겼는데 여기 출력된건 str
					console.log(typeof data); // Print메소드로 보냈기 때문에 str로 보내진 것
					console.log(Number(data) + 3); // JS 형변환 Number, parseInt도 있음
					$('#p2').text(data);	// 
				},
				error: function(data){
					console.log(data); // 에러가 나면 못찾기 때문에 습관 들여서 써주는게 좋다
				}
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
		// 전송된 학생들의 이름은 서버의 console창에 아래 예시와 같이 출력되고  화면에서는 "전송 성공"이라는 알람창이 뜸
		// 		console 출력 예시 : 수업을 들을 하생은 ooo,xxx,ㅁㅁㅁ입니다
	
		$('#studentTest').on('click',function(){
			// 방법1 : 변수로 밸류값 보내기
			var student1 = $('#student1').val();
			var student2 = $('#student2').val();
			var student3 = $('#student3').val();
			
			// 방법2 : 스크립트에서 써서 서블릿으로 보내기
			var print = "수업을 들을 학생은 " + student1 + ", " + student2 + ", " + student3 + "입니다.";
			
			$.ajax({
				//url: 'jQuery4.do'로 서블릿 호출하고 
				url: 'jQuery4.do',
				data: {student1:student1, student2:student2, student3:student3, print:print},
				success: function(data){
					console.log(data);
					alert("전송 성공");
				},
				error:function(data){
					console.log(data);
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
		$('#getUserInfoBtn').click(function(){
			var userNo = $('#userNo').val();
			
			$.ajax({
				url:'jQuery5.do',
				data:{userNo:userNo},
				datatype: 'json', // datatype json 없어도 잘 받아와지기는 하나 혹시 모를 장치를 걸어두는 역할. 쓰기를 권장
				success:function(data){
					console.log(data);   // User [userNo=1, userName=강건강, userNation=대한민국]
							// model.vo에서 적은 오버라이딩 toString의 폼으로 받아옴. 데이터처리가 엄청 힘들어져서 잘못된 방법임
										
										// json 라이브러리 클래스 적용 후 json으로 보내온 것
										// {"userNation":"????","userNo":1,"userName":"???"}
					console.log(typeof data);	// 
				// 객체 안에 키값
					var resultStr = "";
					if(data != null){
						// success:function(data){에서 서버로부터 데이터는 받아옴
						// 1, 강건강, 대한민국 출력하라
						
						// 객체 안에  key값 접근 방법 2가지
						// data 객체 안에 키값이 존재
						// 1) obj[attr] : $쓰면 다 인식가능
						// 2)  obj.attr : 완전할 때만 사용가능
						
						// 방법1
						var resultStr = data.userNo + ", " + data.userName + ", " + data.userNation;
						// 방법2
						var resultStr = data['userNo'] + ", " + data['userName'] + ", " + data['userNation'];

					}else{
						resultStr = "해당 회원이 없습니다.";
					}
					$('#p3').text(resultStr);
					
					// textarea에 서버에서 받아온 값 출력하기
					// 방법1 : .val()
					$('#textarea3').val(resultStr); // input태그랑 textarea태그는 val() 메소드를 사용해서 값 추출해야함
					
					// 방법2 : .text()
					$('#textarea3').text(resultStr);
				},						 
				error:function(data){
					console.log(data);
				}
			});
		});
	</script>
	
	
	
	<br>
	
	
	<h3>6. 서버로 기본값 전송, 서버에서 리스트 객체 반환</h3>
	유저 번호 : <input type="text" id="userNo2"><br>
	유저번호 전송 -> 해당 유저가 있는 경우 유저 정보,<br> 
				없는 경우 전체 가져오기<br>
	
	<button id="getUserInfoBtn2">정보 가져오기</button> 
	<p class="test" id="p4"></p>
	<textarea class="test" id="textarea4" cols="40" rows="5"></textarea>
	<script>
		$('#getUserInfoBtn2').on('click',function(){
				
			$.ajax({
				url:'jQuery6.do',
			 // url:'${pageContext.request.contextPath}/jQueryAjax5', // pageContext : scope page의 context // page스코프의 contextPath를 요청해라는 의미
	    	 // url:'00_practice_now/jQueryAjax5', // 루트까지 잘맞는지 확인하고 다르면 루트까지 url을 지정해줘야함. 00_practice_now는 프로젝트파일명임.
				data:{userNo:$('#userNo2').val()},	// 변수 안만들고 데이터 보내기
				success: function(data){
					/* 
					// 방법1 : JSON Object 중첩방식
					console.log(data); // 어떤 데이터형식으로 들어오는지 항상 확인할 것 
					
					// 서블릿에서 받아온 데이터 화면에 어떻게 뿌리면 좋을까?
							
					// 객체 안에 객체라 for문 돌려봐야함
					// 객체 돌릴려고 하는거라 for in문 써야함
					// for(var i in data) <- 포인문 양식
					// i는 객체의 키  data는 서블릿에서 받아온 데이터
					// 돌릴 대상이 객체면, i는 객체의 키
					// 돌릴 대상이 배열이면, i는 인덱스
					console.log(i); // 0-6이 나오면 한번 더 들어가서 객체 데이터를 가져와야하고,
									// userNatio,userNo 같은 것들이 나오면 value값을 바로 가져오면 됨 강의4:23
				
					var result = "";									
					for (var i in data){
						if(typeof data[i] != 'object'){ // data에 i번째라는 키의 밸류값을 지칭함
							// typeof로 데이터타입이  object가 나오기 때문에, 'if조건은 data[i]가 객체아니면'이라는 조건이 됨
							// typeof가 빠지면 위의 조건은 완전 다른 조건이 됨
						// 0-6 안에 있는 값이 객체임. 따라서 밸류에 접근하려면 한번 더 안으로 들어가야함
						// userNation은 밸류 값임 
						// typeof를 통해서 내가 현재 가진 값이 객체인지 아닌지 알아볼려고 사용
							result = data.userNo + ", " + data.userName + ", " + data.userNation;
						
						}else{
							// result += data[i].userNo + ", " + data[i].userName + ", " + data[i].userNation + "<br>";  // 이중 배열
							result += data[i].userNo + ", " + data[i].userName + ", " + data[i].userNation + "\n";  // 이중 배열
							// 강의 4:32
							// 리절트 p태그에 넣을 것임. 그럴려면 줄바꿈을 해야함 강의 4:45
							
						}
					}
					// $('#p4').text(result); <br> 줄바꿈이 안먹히고 str되서 찍혀나옴
					// $('#p4').html(result); // <br>를 태그로 인식시키기 위해 .text()가 아닌 .html() 사용
					$('#textarea4').val(result); // textarea는 줄바꿈 안되고 <br>이라고 뜸. textarea는 <br>태그+html()이 아닌 "\n" 사용해야 줄바꿈 됨
					 */
					
					 
					// 방법2 : JSONArray 사용
					// 서블릿6으로 이동ㄱㄱ
					// jsonArray 
					console.log(data); // [{..}] -> 대괄호 []는 배열 의미. 안에 객체들 있으니 객체배열을 의미함
					
					var result = "";
					for(var i in data){
					 // result += data[i].userNo + ", " + data[i].userName + ", " + data[i].userNation +"<br>";
						result += data[i].userNo + ", " + data[i].userName + ", " + data[i].userNation + "\n";  // 이중 배열
					}
					// $('#p4').html(result); // <br>를 태그로 인식시키기 위해 .text()가 아닌 .html() 사용
					$('#textarea4').val(result);
					
				},
				error: function(xhr){ // xhr // XMLHttpRequest (XHR)
					console.log(xhr.status); // 무슨 에러인지 나오는 코드
				// arc postman api 사용해볼 것
				}
			});
		});
	</script>
	
	
	
	<br>
	<!-- 문제 설명 22.5.13 5:26 -->
   <h3>7. 서버로 데이터 여러 개 전송, 서버에서 리스트 객체 반환</h3>
   <!-- 유저번호를 하나씩 보냈는데 지금은 1,3,7식으로 여러개 보낼 수 있음. 
   1,3,70이면 1,3만 담김
   1,70,3이면 1,3만 담김
   	이거를 리스트 객체로 뽑아야함. 리스트객체란? 힌트 맵보고 리스트라고하진 않는다...
    -->
   <h4>유저 번호 전송 --> 현재 있는 유저 정보만 모아서 출력</h4>
	유저 정보(번호,번호,번호) : <input type="text" id="userNo3">
	<button id="getUserInfoBtn3">정보 가져오기</button>
	<p class="test" id="p5"></p>
	<script>
		$("#getUserInfoBtn3").click(function(){
			$.ajax({
				url: "jQuery7.do",
				type: "get",
				data: {userNo:$("#userNo3").val()},
				success: function(data){
					var resultText = "";
					
					for(var i in data.list){
						var user = data.list[i];
						
						resultText += user.userNo + ", " + user.userName + ", " + user.userNation + "\n";
					}
					
					$("#textarea5").val(resultText);
				}
			});
		});
	</script>
   
   <br>
   
   <h3>8. 서버로 데이터 여러개 전송, 서버에서 맵 형태의 객체 반환</h3>
   <!-- 7번 넘버랑은 다르게 이름으로 받음.
   		7번이 리스트객체면 8번은 map형태의 객체로 반환
    -->
   <h4>이하 내용은 7번 문제와 동일</h4>
	유저 정보(이름,이름,이름) : <input type="text" id="userName">
	<button id="getUserInfoBtn4">정보 가져오기</button><br><br>
	<textarea id="textarea6" class="test" cols="40" rows="5"></textarea>
	<script>
		$("#getUserInfoBtn4").click(function(){
			$.ajax({
				url:"jQuery8.do",
				type:"get",
				data:{userName:$("#userName").val()}, 
				success:function(data){
					var resultStr = "";
					
					for(var key in data){
						var user = data[key];
						
						resultStr += user.userNo + ", " + user.userName + ", " + user.userNation + "\n";
					}
					
					$("#textarea6").val(resultStr);
				}
			});
		});
	</script>
	
	
	
	
	<br>
	
	<h3>9. 서버 유저 정보로 표 구성하기</h3>
	<button id="userInfoBtn">유저 정보 불러오기</button><br><br>
	<table id="userInfoTable" border="1" cellpadding="0" cellspacing="0">
		<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국적</th>
		</tr>	
		</thead>
		<tbody></tbody>
	</table>
	<script>
		$('#userInfoBtn').click(function(){
			$.ajax({
				url: 'jQuery9.do',
				success: function(data){
					console.log(data);
					// 강의 10:43
					$tableBody = $('#userInfoTable tbody');
					$tableBody.html(''); // 누를 때마다 추가되는게 아닌 새로 덧붙이고 싶다면 추가. ''공백을 넣으므로써 리셋시킴. 지우고 넣고 하는 개념 강의11:24
					// 변수 이름을 지을 때, _와 $ 2가지 방법 가능
					// 변수명에 $를 왜 붙일까?
					// 제이쿼리 접근법이랑 자바스크립트 접근법이랑 아웃풋 형태가 다름
						// 둘이 어떻게 다른지 찍어보자
					console.log(document.getElementById('userInfoBtn')); // js접근 : 태그 자체로 반환(다큐먼트 형태)
					console.log($('userInfoBtn'));	// 제이쿼리 접근 : 안에서 반환하는 객체형태
					// 강의  10:49
					// js는 innerText(),innerHTML()...
					// jquey는 text(),html()로 가져왔었음
					
					// 둘 중 어떤걸로 들어오는지 알 길이 없음. 이 때문에 이름만 보고도 알 수 있게 표시해줄 필요가 있음
					// $tableBody 앞에 $을 붙이는게 제이쿼리 접근법이라고 알려주는 용도
					
					$.each(data, function(index, value){ 
						// 강의11:01 for문 같은거. 돌릴 데이터를 매개변수에 넣고 그때 들어갈 인덱스랑 밸류를 함수에
						// func 안 value는 그 인덱스에 해당하는 값
						// 잘 모르겠으면 찍어보자
						console.log(index);
						console.log(value);
						
						// $변수명은 제이쿼리 변수라는 의미
						var $tr = $('<tr>');
						var $noTd = $('<td>').text(value.userNo);
						var $nameTd = $('<td>').text(value.userName);
						var $nationTd = $('<td>').text(value.userNation);
						
						$tr.append($noTd);		/* td를 tr로 넣어준다는의미이고 */
						$tr.append($nameTd);
						$tr.append($nationTd);	
						
						$tableBody.append($tr);	/*  <tr>를 tableBody(tbody태그) 에 넣기 */
						// 닫는태그는 자동으로 생성됨
						// 누를 때마다 추가되는게 아닌 새로 덧붙이고 싶다면,
						// $tableBody = $('#userInfoTable tbody'); 아래 $tableBody.html(''); 코드 추가 
					});
				},
				error: function(data){
					console.log(data);
					
				}
			});
		});
	</script>
			
		
	
	
	<br>
	
	<h3>10.서버에서 List객체 반환 받아 select태그를 이용해 보여줌</h3>
	유저이름 :<input type="text" id="selectUserName"> 
	<button id="selectListBtn">유저 정보 불러오기</button><br><br>
	<select id="selectListTest"></select>
	<script>	
		$('#selectListBtn').click(function(){
			$.ajax({
				url:'jQuery10.do',
				success: function(data){
					console.log(data);
					$select = $('#selectListTest'); // 셀렉트 태그 자체를 $select에 넣기
					
					// 불러오기 버튼 여러번 누르면 데이터가 겹쳐서 쌓이는데, 여러번 눌러도 한번만 나오도록 하기
					$select.find('option').remove(); // 셀렉트 태그에서 파인드 찾아라 그리고 옵션으로 되어있는 후손 찾아라 얘네를 지우고 시작
					// find가 후손 찾으라는 메소드고 (jQuery때 참조), 
					// 그 find메소드가 $select에 있으니까 $select에서 option으로 되어있는 후손을 찾으라는겁니다 (option = option태그들)
					// Q.for문 안에 옵션 태그 넣은거 지칭하는거져?
					// A.select태그 안에 들어간 option태그들인데 결국 그 for문 때문에 들어가긴 한거죠


					for(var i in data){
						var name = data[i].userName;
						var selected = (name == $('#selectUserName').val()) ? 'selected' : '';
						// 옵션태그에 대해 어펜드 할 것임
						$select.append('<option value="'+data[i].userNo +'"' + selected + '>' + name + "</option>"); // 옵션태그에 대해 어펜드 할 것임
						// 강의 11:35 기존 방식처럼 꼭 val() 메소드 같은거 안써도 위에처럼 가능
						// $select.append($'<option>'.val().text());	// 기존 방식
						// 10번 코드는 기존 방식과 다르게 해본 것.
						// 모모가 선택이 되어있게끔 만듦	
					}
					
				},
				error: function(data){
					console.log(data);
					
				}
			})
		});
		
	
	</script>
	
</body>
</html>





