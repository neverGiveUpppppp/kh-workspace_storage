<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2> 1.JSP표준 액션 태그 중 useBean을 사용하여 vo클래스 객체 정보 불러오기</h2>
	<!-- 이전이라면 아래처럼  썼을 것  -->
	<%-- <% action.model.vo.Person person = new action.model.vo.Person(); %> --%>
	
	<!-- 이전방법과 비교하며 만들어보기 -->
<!-- 내가 만든 아이디 .. 객체에 대한 것 강의10:20 -->
<!-- person1 레퍼런스 변수명을 말함 -->
<%-- <% action.model.vo.Person person1 = new action.model.vo.Person(); %> --%>
	
	
	
	<%-- <jsp:useBean id="person1" class="action.model.vo.Person"></jsp:useBean>  --%><!-- 무슨 객체에 person1에 담을껀지 모름.  --> <%-- <% person1 %> 지금 이 코드 --%>
	<!-- 퍼슨 객체를 만들어서 person1변수에 저장할려고 하는 것이니 퍼슨 객체 지정해주자. class 속성쓰고 안에 끌어올 객체 경로와 객체명 기술 -->
	<!-- 현재 이 코드의 스코프 범위 : page scope -->
	<%-- <jsp:useBean id="person1" class="action.model.vo.Person"></jsp:useBean> --%>	
	
	<%-- <jsp:userBean id="person1" class="action.model.vo.Person"/>  시작과 동시에 닫아주는 태그 코드--%>  
	<!-- 스코프가 page면 너무 작고 쓸 곳이 한정적이니 스코프 지정해주자 -->
	<jsp:useBean id="person1" class="action.model.vo.Person" scope="request"></jsp:useBean>
	<%= person1 %> 
	<!-- 출력값 Person [name=null, gender=, age=0]	 -->
	<!-- 객체를 만들긴 만들었으나 어떤 값을 넣을지 지정을 안해서 toString으로 인해 반환되서 기본값인 str로 들어가있음 강의 10:30-->
	 
	 <!-- 해당 스코프에서 해당 클래스 타입으로 person1이 존재하면, 해당 객체를 가져오고 없으면 새로 생성 -->
	 
	<br>
	<!-- 안에 있는 값을 가져올 것임  -->
	<!-- get역할을 하는 jsp:getProperty 사용  -->
	이름 : <jsp:getProperty property="name" name="person1"/><br> <%-- <% person1.getName %> --%> <!-- person1이 레퍼런스가 되는 것임. 레퍼런스로 참조할 것이 person1. 여기서 가져올 것이 이름 가져올거라 name 기술하면됨 -->
	성별 : <jsp:getProperty property="gender" name="person1"/><br>
	나이 : <jsp:getProperty property="nai" name="person1"/><br>

	<!-- name속성에 참조할 '객체명', property속성에 참조해 올 '변수(필드)명' -->
<!-- Q. property속성의 값은 어디에서 가져온 걸까? -->
<!-- 필드, 기본생성자, 생성자의 매개변수, 게터세터 등 다양한 곳에서 name,gender,age를 가져올 수 있는데 이 중 어디일까? -->
<!-- 증명 & 해보자 실제로 어떤지  -->
<!-- 1.게터 리턴명에 영향이다? -->
		<!-- 게터의 리턴명 변경했지만 age값이 문제없이 잘나옴 -->
<!-- 2.생성자의 this.age = 값의 영향이다? -->
		<!-- this.age = 값 변경했지만 영향x -->
<!-- 3.vo의Person클래스의 필드의 영향이다? -->
	<!-- private int age 필드명을 변경했는데 영향x -->
<!-- A. getter의 생성자명을 찾아 값을 가져오는 것. 자바는 대소문자 구분하기에 대소문자 바뀌어도 인식x -->


	<br><hr><br>
	
	<h2> 2.JSP표준액션 태그 중 useBean을 사용하여 vo클래스에 데이터 초기화하기</h2>
	<!-- 객체만들기 -->
	
	<!-- jsp:setProperty로 값과 세터명을 지정하고 vo클래스에 값이 저장되는 것 -->
	<jsp:useBean id="person2" class="action.model.vo.Person" scope="session"/> <!-- 객체생성 -->
	<jsp:setProperty property="name" name="person2" value="강건강"/>
	<jsp:setProperty property="gender" name="person2" value="남"/> <!-- jsp:setProperty로 값과 세터명을 지정하고 vo클래스에 값이 저장되는 것 -->
	<jsp:setProperty property="nai" name="person2" value="20"/>	  <!-- setAge 생성자에 값 20을 저장하겠다는 의미 -->

	이름 : <jsp:getProperty property="name" name="person1"/><br> <%-- <% person1.getName %> --%> <!-- person1이 레퍼런스가 되는 것임. 레퍼런스로 참조할 것이 person1. 여기서 가져올 것이 이름 가져올거라 name 기술하면됨 -->
	성별 : <jsp:getProperty property="gender" name="person1"/><br>
	나이 : <jsp:getProperty property="nai" name="person1"/><br>

<!-- name에 들어가는 값(person2)를 변수임 -->


</body>
</html>








