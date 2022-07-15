<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue();">
	<b>아이디 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkId.me" id="idCheckForm"> <!--/checkId.me용 서블릿 만들러가자  -->
		<input type="text" id="inputId" name="inputId">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	
	
	<!-- 중복체크했을 때 사용중인지 사용가능한지 알려주기 위해 결과값을 둘로 나눌 것임
		 뭘가지고 결과값을 나눌 수 있을까?
	 -->
	<%
		Integer result = (Integer)request.getAttribute("result"); /* Integer : Wrapper클래스 Integer int의 형변환 */  
	/* 변수 데이터타입을 int라고 안하고 Integer 쓴 이유 
	처음 아이디 중복확인 팝업창을 띄웠습니다. 이미 사용중인 아이디입니다 메시지를 미리 보일 필요 있나? 
	인풋태그 박스에 아이디 넣고 중복확인 클릭해야 그담 결과를 메시지를 보여주는 프로세스임. 고로, 처음 팝업창 뜨면 아무 메시지가 없어야함. 
	근데 처음 막 팝업창에 들어왔는지 뭘로 알 수 있을까? int로 데이터타입을 설정 했을 때, result값이 없으면 0일거고 그럼 아무것도 안나오고 0이 아니면 이미사용중 메시지 뜰건데 
	0이라고 하는 경우의 수는 처음 들어왔다 아니다 뿐 아니라 사용 가능 불가능까지 구분 짓는 숫자임
	내가 카운트를 했으니까. 리절트가 0일수도 아닐수도 있음. 처음 들어왔다는건 0이다 아니다로 구분 지을 수 없다. 반환받는 값이 0일 수도 있기 때문. 숫자가 아닌 다른걸로 구분 지어야하는데 이걸 인티저로 구분짓겠다는 것*/
	
	/* int 안쓰는 이유
	int에는 ..이라고 하는 참조값이 없음. 반환받을 값이 0이나 1을 반환 받게 될텐데 처음에 들어왔다 아니다를 정수로는 알 수 없음
	그래서 처음 들어왔다 아니다를 구분할 수 있게 Wrapper클래스 Integer를 사용하는 것 */
	
	
		if(result != null) {
			if(result == 0){	
	%>			
				사용 가능한 아이디 입니다.
	<%
			}else{
	%>		
			이미 사용중인 아이디 입니다.
	<%
			}
		}
	%>
	
	<!-- 현재 문제 -->
	<!-- 아이디 중복검사했는데 중복확인 했는데 쓴게 사라짐. 왜 사라질까? 
		중복확인을 누르면 checkIdServlet으로 감. doGet메소드 실행하고 마지막에 getRequestDispatcher(경로..checkIdForm.jsp) 때문에
		다시 checkIdForm으로 감. 화면이 다시 새로고침 되는 것. checkIdForm에 현재 아무것도 없기에 아무것도 없는 상태로 새로고침 되는 것 
		중복확인 누르면 체크아이디 서블릿으로 감. 화면이 다시 새로고침되는 것. 체크아이디 폼 아무것도 없는 상태로 -->
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인"> <!-- id속성값 보내서 중복확인 할 것임 -->
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){ /* 로드할 때부터 checkedId를 확인하고 가는 것 */
			if('<%= request.getAttribute("checkedId") %>' == 'null'){ 
									/*  'null'은 null이 아니라 문자열 null.  */
/* 그럼 null 대신 다른 문자열을 써도 되는 건가요? 반환받지 못해서 null인 상태의 '< %= request.getAttribute("checkedId") %>' 찾아주기 위해 'null'과 대입시키는 것*/
		
		// 회원가입 시 아디에 적어둔 값을 중복확인 클릭하면 뜨는 중복확인 팝업창의 인풋태그 박스값에 들어가 있게 해볼 것		
		document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value;
		// opener : 나(중복확인 팝업창)를 열어준 부모창에 있는값. 부모창 객체를 참조하는 것. 여기서 부모창은 회원가입 페이지(signUpfrom.jsp)고 나는 중복확인 팝업창(checkIdForm.jsp) 
		// 조인폼은 signUpfrom.jsp의 폼태그 name속성값이 joinForm
		// joinUserId도 signUpfrom.jsp의 name 속성값
		// value : opener.document.joinForm.joinUserId에 대한 밸류값을 어디다 집어넣을거냐면 
		// 내가 들어오자마자 집어 넣을 곳인 이 jsp문서 상단의 폼태그 아래 있는 첫번째 input태그(name속성값=inputId)임.
		// 이게 코드로는 document.getElementById('inputId').value 이것. 즉, 오른쪽의 밸류값을 왼쪽의 밸류값에 넣어준다는 의미
		
			} else{
				document.getElementById("inputId").value = '<%= request.getAttribute("checkedId") %>';
			}
		}
		// 중복 확인창에서 새로쓰고 중복확인한 아디를 회원가입페이지 아이디란에 넣고 싶다면?
		// checkIdFrom.jsp의 하단쪽 input태그의 id값=usedId를  클릭 했을 때, 
		// inputId에 있는 밸류값을  부모창 joinUserId란의 밸류값에 넣어주게 만든다
		document.getElementById('usedId').onclick=function(){	// checkIdFrom.jsp의 하단쪽 input태그의 id값=usedId를  클릭 했을 때, 
			opener.document.joinForm.joinUserId.value = document.getElementById("inputId").value;
			self.close(); // 중복확인창에서 확인 누르면 창 닫히는 코드
		}
		
	</script>
</body>
</html>


