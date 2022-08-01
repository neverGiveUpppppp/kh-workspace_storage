package com.kh.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("UTF-8");
		String pizza = request.getParameter("pizza"); // "pizza"는 04_pizz.jsp의 <select id="pizza" name="pizza" required>에서 name속성값을 끌어온 것
		String[] toppings = request.getParameterValues ("topping");
		String[] sides = request.getParameterValues("side");

		
		// recommendation을 힌트로 준 이유
		// switch를 가지고 메뉴를 분류해서 가격을 추출할 수 있었기 때문 
		
		// 피자 주문
		int total = 0;
        switch(pizza) {
        case "치즈피자": total += 5000; break;
        case "콤비네이션피자" : total += 6000; break;
        case "포테이토피자" : total += 7000; break;
        case "고구마피자" : total += 7000; break;
        case "불고기피자" : total += 8000; break;
        }
	
        // 주의사항
        //메뉴 중에 체크를 안할 경우 발생하는 null값 처리
        // 	  ex)기본 피자만 주문하고 토핑 & 사이드 선택 안할 수도 있는 경우
        // 토핑, 사이드 => null값 뜨게되고 에러발생 가능성
        // 해결방안 if문
        
        
        // 토핑 주문
        if(toppings != null) {
        	for (int i = 0; i < toppings.length; i++) {
		    	switch(toppings[i]) {
		    	case "고구마무스": total += 1000; break;
		    	case "콘크림무스": total += 1500; break;
		    	case "파인애플토핑": total += 2000; break;
		    	case "치즈토핑": total += 2000; break;
		    	case "치즈크러스트": total += 2000; break;
		    	case "치즈바이트": total += 3000; break;
		    	}
        	}
    	}
        
        
        // 사이드 주문
        if(sides != null) {
        	for (int i = 0; i < toppings.length; i++) {
		    	switch(sides[i]) {
		    	case "오븐구이통닭": total += 9000; break;
		    	case "치킨스틱&윙": total += 4900; break;
		    	case "치즈오븐스파게티": total += 4000; break;
		    	case "새우링&웨지감자": total += 3500; break;
		    	case "갈릭포테이토": total += 3000; break;
		    	case "콜라": total += 1500; break;
		    	case "사이다": total += 1500; break;
		    	case "갈릭소스": total += 500; break;
		    	case "피클": total += 300; break;
		    	case "핫소스": total += 100; break;
		    	case "파마산 치즈가루": total += 100; break;
		    	}
        	}
    	}
        
        
        // jsp 교류
        // 위에서 view단인 04.pizza.jsp에서 받아온 데이터를 String타입 변수에 담아두었고 ,
        // 이를 setAttribute() 메소드를 통해 변수 request(내장객체)에 저장
        	
        request.setAttribute("pizza", pizza);		// String 타입	// ("pizza", pizza)의 pizza는, String pizza = request.getParameter("pizza")의 String pizza 변수
        request.setAttribute("toppings", toppings); // String[] 타입	// ("pizza", pizza)의 "pizza"는, 지정해 준 것. 변수명 지정하듯이
        request.setAttribute("sides", sides);		// String[] 타입
        request.setAttribute("total", total);		// int 타입
        
        // 내장객체 request에 저장한 데이터를  "jsp/04_pizzaEnd.jsp"로 보낼 것임
        RequestDispatcher view = request.getRequestDispatcher("jsp/04_pizzaEnd.jsp");
        view.forward(request, response);
        // 데이터를 보낼 곳인 jsp 파일 생성하자
        
        // setAttribute()
        //이 요청에 속성을 저장합니다. 속성은 요청 사이에 재설정됩니다. 이 방법은 RequestDispatcher와 함께 가장 자주 사용됩니다.
        // 속성 이름은 패키지 이름과 동일한 규칙을 따라야 합니다. java.*, javax.* 및 com.sun.*으로 시작하는 이름은 Sun Microsystems에서 사용하도록 예약되어 있습니다.
        // 전달된 객체가 null인 경우 효과는 removeAttribute(java.lang.String)를 호출하는 것과 동일합니다.
        
        // RequestDispatcher()
        // 클라이언트로부터 요청을 받아 서버의 모든 리소스(예: 서블릿, HTML 파일 또는 JSP 파일)로 보내는 개체를 정의합니다. 
        // servletcontainer는 특정 경로에 있거나 특정 이름으로 지정된 서버 리소스 주위의 래퍼로 사용되는 RequestDispatcher 개체를 만듭니다.
        // 이 인터페이스는 서블릿을 래핑하기 위한 것이지만 서블릿 컨테이너는 모든 유형의 리소스를 래핑하기 위해 RequestDispatcher 개체를 생성할 수 있습니다.
        
        // getRequestDispatcher()
        // 지정된 경로에 있는 리소스에 대한 래퍼 역할을 하는 RequestDispatcher 개체를 반환합니다. 
        // RequestDispatcher 개체는 요청을 리소스에 전달하거나 응답에 리소스를 포함하는 데 사용할 수 있습니다. 리소스는 동적이거나 정적일 수 있습니다.
        // 지정된 경로 이름은 상대적일 수 있지만 현재 서블릿 컨텍스트 외부로 확장할 수는 없습니다. 경로가 "/"로 시작하면 현재 컨텍스트 루트에 상대적인 것으로 해석됩니다. 
        // 서블릿 컨테이너가 RequestDispatcher를 반환할 수 없는 경우 이 메서드는 null 반환
        
        
        
	}
}
