<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<%
String pizza = (String)request.getAttribute("pizza");
String[] toppings = (String[])request.getAttribute("toppings");
String[] sides = (String[])request.getAttribute("sides");
int total = (int)request.getAttribute("total");
// request에 담긴 toppings로 부터 받아오는 데이터가 배열이기 때문에 받는 입장인 얘도 String[]로 변경. 강제형변환에도 []추가
// 받아오기 전인 서블릿에서 배열을 string으로 미리 강제형변환 해줘도 됨
// 배열로 보내고 받는 방법 외에 다른 방법 
// 방법1 :  String 클래스 join() 메소드로도 사용
// 방법2 : 변수 하나 만들고 이어붙이기
// toppings & sided에는 주문 시 체크안하면 null이 들어올 수 있음을 기억할 것

%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 04_pizzaEnd.jsp </title>

</head>
<body>

	
	<h1>주문 내역</h1>
    <h2>
    
    	피자는 <span style="color: red;"><%= pizza %></span>,
		토핑은 <span style="color: green;">
			<% 
				if(toppings != null){	// 사이드메뉴 체크가 null이 아닐 때
					for(int i = 0; i < toppings.length; i++){	// topping이랑 sides가 여러개 주문할 수 있기에 for문으로 받아서 다 읽어 올 수 있게해야함
						if(i == 0){
			%>
							<%= toppings[i] %>
			<%
						}else{
			%>
						, <%= toppings[i] %>		
			
			<%
						}
					}
				}else{
			%>
				
					(없음)
			<%
				}
			%>
		</span>,
		사이드는<span style="color: blue;">
		<%
			if(sides != null){
				for(int i = 0; i < sides.length; i++){
					if(i == 0){
		%>
						<%= sides[i] %>
		<%
				}else{
		%>
					, <%= sides[i] %>		
		
		<%
					}
				}
			}else{
		%>
				(없음)
		<%
			}
		%>
		</span> 주문 하셨습니다.
    </h2><br><br><br>
    
    
    
    <h2> 총합 : <span style="text-decoration: underline;"><%= total %>원</span></h2><br>
    
    
    <h1 style="color: pink;"> 즐거운 식사시간 되세요~</h1>
    
</body>
</html>
    
    <!-- 
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


	

</body>
</html>

 -->
