<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>	
	
</head>
<body>


	<h1 align="center"> Spring에서의 aJax 사용</h1>
		
	<ol>
		<li>
			<h2>1.서버 쪽 컨트롤러로 값 보내기</h2>
			<button id="test1">테스트</button>
			<script>
				$('#test1').on('click',function(){
					$.ajax({
						
						url: 'test1.do',
						data:{name:'강건강', age:20},
						type: 'post',
						success: function(data){
							console.log(data);
							if(data = 'ok'){
								alert('전송 성공');
							}else{
								alert('전송 실패');
							}
						},
						error: function(data){
							console.log(data);
							
						}
					});
				});
			</script>
		</li>
		<li>
			<h2>2.컨트롤러에서 리턴하는 JSON객체 받아 출력하기</h2>
			<button id="test2">테스트</button>
			<div id="d2"></div>
			<script>
				$('#test2').click(function(){
					$.ajax({
						url:'test2.do',
				// 방법1	// dataType: 'json', // setContentType만 하는거보다 데이터타입에 json 추가해서 보내는게 더 안전함
						type: 'post',
						success:function(data){
							/* console.log(data);
				// 방법2			data=JSON.parse(data); // 결과값은 객체로 나와야함 // json 타입으로는 잘나오나 인코딩이 안됨

				// 방법3 : URLEncoder.encode() & decodeURIComponent()
				// 인코딩시켜서 안보이게하고 다시 받아와서 디코딩해서 진행하면된다(url인코딩 사용) 강의 12:23
							$('#d2').html('번호 : ' + data.no
										+ '<br>제목 : ' + data.title
										+ '<br>작성자 : '+ decodeURIComponent(data.writer) // 컨트롤러에서 인코딩해서 보낸 한글데이터를 디코딩해서 바로 볼 수 있게 decodeURIComponent() 코드추가
										+ '<br>내용 : '+ decodeURIComponent(data.content.replaceAll('+',' ')));	 */
							console.log(data);
										
				// 방법4			
				// 방법4는 컨트롤러에				
						},
						error:function(data){
							console.log(data);
						}
					});
				});
			</script>
		</li>
		
		
	</ol>



</body>
</html>





