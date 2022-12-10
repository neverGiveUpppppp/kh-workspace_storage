<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
String pizza = (String)request.getAttribute("pizza"); //(String) 강제형변환 적용
String topping = (String)request.getAttribute("topping"); 	// attr의 리턴타입이 object이기 때문
String city = (String)request.getAttribute("sideMenu");
String pizzaPrice = (String)request.getAttribute("pizzaPrice");

%>   
    
    
<!DOCTYPE html>
<html style="background: RGB(255,236,246);">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	/* ul{list-style:none;}
	.today{display:inline-block; "color:pink";}
	.twidth1{width:70px;} */
	
	h2{color: pink;}
	th, td {padding:5px;}
	        
</style>

</head>
<body>

	
	<h1>오늘은 
		<span style="color:pink;"><%@ include file="today.jsp" %></span> 
		입니다.
	</h1>
    <h1>피자 아카데미</h1>
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th>종류</th>
            <th>이름</th>
            <th>가격</th>
            <th rowspan="12"></th>
            <th>종류</th>
            <th>이름</th>
            <th>가격</th>
        </tr>
        <tr>
            <td rowspan="5">피자</td>
            <td>치즈피자</td>
            <td>5000</td>
            <td rowspan="11">사이드</td>
            <td>오븐구이통닭</td>                         
            <td>9000</td>                         
        </tr>
        <tr>
            <td>콤비네이션피자</td>
            <td>6000</td>
            <td>치킨스틱&윙</td>                         
            <td>4900</td>                         
        </tr>
        <tr>
            <td>포테이토피자</td>
            <td>7000</td>
            <td>치즈오븐스파게티</td>                         
            <td>4000</td>                         
        </tr>
        <tr>
            <td>고구마피자</td>
            <td>7000</td>
            <td>새우링&웨지감자</td>                         
            <td>3500</td>                         
        </tr>
        <tr>
            <td>불고기피자</td>
            <td>8000</td>
            <td>갈릭포테이토</td>                         
            <td>3000</td>                         
        </tr>
        <tr>
            <td rowspan="6">토핑</td>
            <td>고구마무스</td>
            <td>1000</td>
            <td>콜라</td>                         
            <td>1500</td>                         
        </tr>
        <tr>
            <td>콘크림무스</td>
            <td>1500</td>
            <td>사이다</td>                         
            <td>1500</td>                         
        </tr>
        <tr>
            <td>파인애플토핑</td>
            <td>2000</td>
            <td>갈릭소스</td>                         
            <td>500</td>                         
        </tr>
        <tr>
            <td>치즈토핑</td>
            <td>2000</td>
            <td>피클</td>                         
            <td>300</td>                         
        </tr>
        <tr>
            <td>치즈크러스트</td>
            <td>2000</td>
            <td>핫소스</td>                         
            <td>100</td>                         
        </tr>
        <tr>
            <td>치즈바이트</td>
            <td>3000</td>
            <td>파마산 치즈가루</td>                         
            <td>100</td>                         
        </tr>
    </table>
    <br><br>
    <form action="/2_JSP/04_pizza.do" method="post">
        <label>피자    : </label>
        <select name="pizza">
            <option value="치즈피자">치즈피자</option>
            <option value="콤비네이션피자">콤비네이션피자</option>
            <option value="포테이토피자">포테이토피자</option>
            <option value="고구마피자">고구마피자</option>
            <option value="불고기피자">불고기피자</option>
        </select><br>
        <label>토핑     : </label>
        <input type="checkbox" name="topping" value="고구마무스">고구마무스
        <input type="checkbox" name="topping" value="콘크림무스">콘크림무스
        <input type="checkbox" name="topping" value="파인애플토핑">파인애플토핑
        <input type="checkbox" name="topping" value="치즈토핑">치즈토핑
        <input type="checkbox" name="topping" value="치즈크러스트">치즈크러스트
        <input type="checkbox" name="topping" value="치즈바이트">치즈바이트<br>
        <label>사이드 : </label>
        <input type="checkbox" name="sideMenu" value="오븐구이통닭">오븐구이통닭
        <input type="checkbox" name="sideMenu" value="치킨스틱&윙">치킨스틱&윙
        <input type="checkbox" name="sideMenu" value="치즈오븐스파게티">치즈오븐스파게티
        <input type="checkbox" name="sideMenu" value="새우링&웨지감자">새우링&웨지감자
        <input type="checkbox" name="sideMenu" value="갈릭포테이토">갈릭포테이토
        <input type="checkbox" name="sideMenu" value="콜라">콜라
        <input type="checkbox" name="sideMenu" value="사이다">사이다
        <input type="checkbox" name="sideMenu" value="갈릭소스">갈릭소스
        <input type="checkbox" name="sideMenu" value="피클">피클
        <input type="checkbox" name="sideMenu" value="핫소스">핫소스
        <input type="checkbox" name="sideMenu" value="파마산 치즈가루">파마산 치즈가루<br><br>
        <input type="submit" name="butt" value="확인">
    </form>


	<%-- <span class='pizza'><%= pizza %></span><span class='pizzaPrice'><%= pizzaPrice %></span>이시며, --%>
		





<%-- 	<h2 display="inline-block" id="today"> 
		
	
			오늘은 	<p id="today"><%@ include file="today.jsp" %></p>  입니다
		
	</h2>
	<h2>피자 아카데미</h2>
	
	<table border="1" width="450px" height="600px" display="inline-block">
		<tr>
			<th id="twidth1">종류</th>
			<th>이름</th>
			<th>가격</th>
			<td rowspan="12" width="15px"></td>
			<th id="twidth1">종류</th>
			<th>이름</th>
			<th>가격</th>
		</tr>
		<tr>
			<td rowspan="5">피자</td>
			<td>치즈피자</td>
			<td>5000</td>
			<td rowspan="11">사이드</td>
			<td>오븐구이통닭</td>
			<td>9000</td>
		</tr>
		<tr>
			<td>콤비네이션피자</td>
			<td>6000</td>
			<td>치킨스틱&윙</td>
			<td>4900</td>
		</tr>
		<tr>
			<td>포테이토피자</td>
			<td>7000</td>
			<td>치즈오븐스파게티</td>
			<td>4000</td>
			
		</tr>
		<tr>
			<td>고구마피자</td>
			<td>7000</td>
			<td>새우링&웨지감자</td>
			<td>3500</td>
		</tr>
		<tr>
			<td>불고기피자</td>
			<td>8000</td>
			<td>갈릭포테이토</td>
			<td>3000</td>
		</tr>
		<tr>
			<td rowspan="6">토핑</td>
			<td>고구마무스</td>
			<td>1000</td>
			<td>콜라</td>
			<td>1500</td>
		</tr>
		<tr>
			<td>콘크림무스</td>
			<td>1000</td>
			<td>사이다</td>
			<td>1500</td>
		</tr>
		<tr>
			<td>파인애플토핑</td>
			<td>2000</td>
			<td>갈릭소스</td>
			<td>500</td>
		</tr>
		<tr>
			<td>치즈토핑</td>
			<td>2000</td>
			<td>피클</td>
			<td>300</td>
		</tr>
		<tr>
			<td>치즈크러스트</td>
			<td>2000</td>
			<td>핫소스</td>
			<td>100</td>
		</tr>
		<tr>
			<td>치즈바이트</td>
			<td>3000</td>
			<td>파마산 치즈가루</td>
			<td>100</td>
		</tr>
	</table>
	
	<ul>
		<li>
			피자 :
			<select name="pizza">
				<option value="pizza1">치즈피즈</option>
				<option value="pizza2">콤비네이션피자</option>
				<option value="pizza3">포테이토피자</option>
				<option value="pizza4">고구마피자</option>
				<option value="pizza5">불고기피자</option>
			</select>
		</li>
		<li>
			토핑 :
			고구마무스<input type="checkbox" name="topping" id="korea" value="한식">
			콘크림무스<input type="checkbox" name="topping" id="china" value="중식">
			파인애플토핑<input type="checkbox" name="topping" id="japan" value="일식">
			치즈토핑<input type="checkbox" name="topping" id="western" value="양식">
			치즈크러스트<input type="checkbox" name="topping" id="dduck" value="분식">
			치즈바이트<input type="checkbox" name="topping" id="dduck" value="분식">
		</li>
		<li>
			사이드 :
			오븐구이통닭<input type="checkbox" name="sidemenu" id="korea" value="한식">
			치킨스틱&윙<input type="checkbox" name="sidemenu" id="china" value="중식">
			치즈오븐스파게티<input type="checkbox" name="sidemenu" id="japan" value="일식">
			새우링&웨지감자<input type="checkbox" name="sidemenu" id="western" value="양식">
			감자포테이토<input type="checkbox" name="sidemenu" id="dduck" value="분식">
			갈릭포테이토<input type="checkbox" name="sidemenu" id="dduck" value="분식">
			콜라<input type="checkbox" name="sidemenu" id="dduck" value="분식">
			사이다<input type="checkbox" name="sidemenu" id="dduck" value="분식">
			갈릭소스<input type="checkbox" name="sidemenu" id="dduck" value="분식">
			피클<input type="checkbox" name="sidemenu" id="dduck" value="분식">
			핫소스<input type="checkbox" name="sidemenu" id="dduck" value="분식">
			파마산 치즈가루<input type="checkbox" name="sidemenu" id="dduck" value="분식">
		</li>
		<li>
			<br>
			<input type="submit" id="btnok" value="확인">
		</li>
	
	</ul> --%>
	
	

<!-- <form action="/02_JSP/confirmPizza" name="myInfoForm" method="post"> -->
<form action="<%= request.getContextPath() %>/confirmPizza" name="myInfoForm" method="post">
	<!-- getContextPath() : 컨텍스트 루트를 반환하는 역할 
	내가 직접 불러올거를 다른거를 이용해서 불러오는 것(?) 강의시간 5:06
	-->
|A}&nbsp;&nbsp; &nbsp; :
<select id="pizza" name="pizza" required>
	<option value=“치즈피자">치즈피자</option>
	<option value=" 콤비네이션피자">콤비네이션피자</option>
	<option value="포테이토피자">포테이토피자</option>
	<option value="고구마피자">고구 마피자</option>
	<option value=" 불고기피자">불고기피자</option>
	<!-- value에 피자이름하고 가격을 같이 넣어서 보낼 수도 있다
		value="치즈피자/5000"
		str[0] : 피자명 
		str[1] : 피자가격
		
	 -->
</select>


<!-- <form action="/2_JSP/confirmPizza" name="myInfoForm" method="post"> -->
<form action="<%= request.getContextPath() %>/confirmPizza" name="my InfoForm" method="post">
피자&nbsp;&nbsp;&nbsp; :
<select id="pizza" name="pizza" required>
<option value="#JÆ1] A|/5000">|A/option>
<option value="콤비네이션피자/6000">콤비네이션피자</option>
<option value="포테이토피자/7000">포테이토피자</option>
<option value="고구마피자/7000">고구마피자</option >
<option value=“불고기피자/8000">불고기피자</option >
</select>
I
<br>
토핑&nbsp;&nbsp;&nbsp; :
<input type="checkbox" name="topping" id="topping1" value="17019A">1701eA
<input type="checkbox" name="topping" id="topping2" value="aPA">22894
<input type="checkbox" name="topping" id="topping3" value="#210NE8">I210H
<input type="checkbox" name="topping" id="topping4" value="/XEg">A|EE
<input type="checkbox" name="topping" id="topping5" value="/X2AE">t|X2ZAE
<input type="checkbox" name="topping" id="topping6" value="HF0|E">X|ZUt0|E

	
	

</body>
</html>


