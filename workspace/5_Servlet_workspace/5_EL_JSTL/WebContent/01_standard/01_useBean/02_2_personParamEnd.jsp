<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% request.setCharacterEncoding("UTF-8"); %>
	<!-- 02_1_personParam.jsp에서 input태그,checkbox에 값넣고 전송해야 결과나옴 -->
	
	<h2> 1.jsp 표준 액션태그 중 useBean의 param속성 이용하기</h2>
	<%-- jsp:param : <jsp:include>, <jsp:forward>의 하위 요소로 사용되며 해당 페이지에 전달할 값을 기록할 때 사용--%>
	
	<!-- 이름,성별,나이를 넘겨주고 있음. 02_1_personParam.jsp의 input태그에서 받아온 데이터 보낸거 받아올 것임 -->
	<!-- 객체를 만들면서 동시에 값까지 집어넣기 -->
	<jsp:useBean id="person" class="action.model.vo.Person">
		<%-- <jsp:setProperty property="name" name="person" param="name"/> --%>
	<!-- jsp:setProperty가 값을 세팅하는건데 어떤 값으로 세팅할거지? -->
	<!-- 파일1에서는 value로 값을 넣어줬지만, 받아온 값을 사용하기 위해 parameter액션태그 사용 -->
	<!-- param="name"의 name은 파일1의 14번라인 코드의 name속성값을 가져오는 것. 그리고 이 14라인은 input태그로 사용자에게 이름값을 받아오는 코드 -->
	
		<!-- 1)useBean의 param속성 사용 -->
		
		<%-- <jsp:setProperty property="gender" name="person" param="gender"/> --%>
		<%-- <jsp:setProperty property="nai" name="person" param="nai"/> --%> 
		<!-- param=""값은 파일1의 인풋태그의 name속성값을 가져오고 있음-->
		
		
		<!-- 2)property와 param의 이름이 같을 때는 param 생략 가능 -->	
		<%-- <jsp:setProperty property="name" name="person"/> --%>
		<%-- <jsp:setProperty property="gender" name="person"/> --%>
		<%-- <jsp:setProperty property="nai" name="person"/> --%> 
		
		
		<!-- 3)아스트로(*) 전체호출 :이름이 같다는 전제하에 *로 전체 다 호출하기 -->
		<jsp:setProperty property="*" name="person"/> 
		<!-- 뷰인 파일1에서 보낸 form태그 데이터를 vo클래스 person에 setter를 통해 값 저장 -->
		<!-- 뷰인 파일1에서 보낸 form태그 데이터는 각 태그의 name속성에 적혀있는 name,gender,nai를 property속성에 기술해서 참조하여 가져올 수 있다  -->
		
	</jsp:useBean>
	
	이름 : <jsp:getProperty property="name" name="person"/><br> <%-- <% person1.getName %> --%> <!-- person1이 레퍼런스가 되는 것임. 레퍼런스로 참조할 것이 person1. 여기서 가져올 것이 이름 가져올거라 name 기술하면됨 -->
	성별 : <jsp:getProperty property="gender" name="person"/><br>
	나이 : <jsp:getProperty property="nai" name="person"/><br>
	
	
</body>
</html>