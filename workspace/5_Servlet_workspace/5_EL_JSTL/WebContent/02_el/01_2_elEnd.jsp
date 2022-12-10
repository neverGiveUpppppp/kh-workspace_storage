<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="action.model.vo.Person" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
<style>.item{font-weight: bold; color: yellowgreen;}</style>
</head>
<body>


	<h2>scriptlet을 통해 request객체에 저장된 데이터 출력</h2>
	

	<h2>EL의 내장객체 xxxxScope을 통해 request객체에 저장된 데이터 출력</h2>
	
	<h4>개인 정보(${requestScope.year })</h4>  <!-- 옆에 빨간색 에러는 무시해도됨  -->
	<!-- 저장되어있는 영역 지정.저장된 변수명 -->
	<!-- ${requestScope.year } -->
	이름 : ${requestScope.person.name }<br> <!-- requestScope.person만 찍으면 객체 전체가 찍힘 : Person [name=, gender=0, age=20] -->
	성별 : ${requestScope.person.gender }<br> <!-- 저장되어있는 영역 지정.저장된 객체명.변수명  -->
	나이 : ${requestScope.person.nai }<br> <!-- 서블릿에서 age받아오는게 아닌 vo 게터명에서 받아오는 것. 서블릿에서 데이터 가져오려고 임포트도 안했음 참고로 -->
	<h4>취향 정보</h4>
	${requestScope.person.name }님이 가장 좋아하는 음료 : ${ requestScope.beverage }<br>
	${requestScope.person.name }님이 가장 좋아하는 물건 : ${ requestScope.products[0] },
												  ${ requestScope.products[1] },
												  ${ requestScope.products[2] }<br>
	${requestScope.person.name }님이 가장 좋아하는 도서 : ${ sessionScope.book}<br>
	${requestScope.person.name }님이 가장 좋아하는 영화 : ${ applicationScope.movie }<br>
	
	
	
	<!-- 영역에 맞는 스코프 안쓰고  requestScope쓴 이유 -->
	<!-- 반환이 아무것도 안됨. 
		기존 scriptlet request에서는 없는 값 가져오면 null인데,
		EL은 아무것도 반환이 안됨 -->
	${requestScope.person.name }님이 가장 좋아하는 도서 : ${ requestScope.book }<br>  <!-- 반환이 아무것도 안됨 -->
	${requestScope.person.name }님이 가장 좋아하는 영화 : ${ requestScope.movie }<br> <!-- 반환이 아무것도 안됨 -->
	
	
	
	
	
	<h2>EL : Scope를 생략하여 저장된 데이터 출력</h2>
	<!-- 서로 이어져 있지 않기에 어떤건 스코프영역 지정해도 되고 어떤건 안해도 됨 -->
	<!-- 
		el 내장객체 pageScope, requestScope, sessionScope, applicationScope는 생략가능
		그럼 생략된 건 어떻게 찾을까?
		pageScope -> requestScope -> sessionScope -> applicationScope 순으로 찾음
		모두 다 돌아서 찾음
		
		영역 지정 안해줬으니 컴퓨터 입장에서 저 영역 순으로 찾아서 데이터 연결한다는 의미
		ex) ${ year } 데이터를 끌어올려고 하면,
			pageScope에서 찾고 없으면 requestScope찾고 없으면 세션,어플 순으로 
		
		${ requestScope.book}에서 있는거는 스코프 지정했으니 그것만 찾은데 처음부터 찾기 시작해서 다 나오게 된다
					
					
		여러 스코프에 동일한 속성을 기록하여 이름 충돌(name conflict)이 의심되면 명시적으로 scope를 지정해야함
			이에 대한 예시 : beverage 찍으면 왜 식혜만 나올까?(beverage를 세션과 어플영역에도 넣어서 실험 )
						이유 :  찾았으니까 뒤에꺼는 스킵
			
			
	 -->
	<h4> 개인정보(${ year })</h4>
	이름 : ${ person.name}<br>
	성별 : ${ person.gender }<br>
	나이 : ${ person.nai }<br>
	<h4>취향 정보</h4>
	${ person.name } 님이 가장 좋아하는 음료 : ${ beverage }, ${sessionScope.beverage }, ${applicationScope.beverage }<br> 
	${ person.name } 님이 가장 좋아하는 물건 : ${ products[0] }, ${ products[1] }, ${ products[2] }<br>
	${ person.name } 님이 가장 좋아하는 도서 : ${ book}<br>
	${ person.name } 님이 가장 좋아하는 영화 : ${ movie }<br>


	<!-- -->
	
	
	
	
	
	
</body>
</html>


