 package com.kh.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaServlet2 extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("UTF-8");
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues ("topping");
		String[] sides = request.getParameterValues("side");

		int total = 0;
		String topping = "";
		String side = "";
		
		// 피자 주문
        switch(pizza) {
        case "치즈피자": total += 5000; break;
        case "콤비네이션피자" : total += 6000; break;
        case "포테이토피자" : total += 7000; break;
        case "고구마피자" : total += 7000; break;
        case "불고기피자" : total += 8000; break;
        }
	
        // 기본 피자만 주문하고 토핑 & 사이드 선택 안할 수도 있는 경우
        // 토핑, 사이드 => null값 뜨게되고 에러발생 가능성o
        // 해결방안 if문
        
        
        // 토핑 주문
        if(toppings != null) {
        	for (int i = 0; i < toppings.length; i++) {
        		if(i == 0) {	// topping & sides 변수에다 문자열을 넣어주는 것. 메뉴를 무엇을 선택했는지 나타내기 위한
        			topping += toppings[i];
        		} else {
        			topping += ", " + toppings[i];	// 변수 topping에 문자열을 넣어줌
        		}									// ", "으로 문자열 추가하면서 문자열화함
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
        	for (int i = 0; i < sides.length; i++) {
        		if(i == 0) {
        			side += sides[i];		
        		} else {
        			side += ", " + sides[i];	// 변수 side에 문자열을 넣어줌 
        		}								// ", "으로 문자열 추가하면서 문자열화함
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


        request.setAttribute("pizza", pizza);
        request.setAttribute("toppings", topping);	// 1처럼 str[]이 아닌 str으로 보냄
        request.setAttribute("sides", side);
        request.setAttribute("total", total);

        // 내장객체 request에 저장한 데이터를  "jsp/04_pizzaEnd.jsp"로 보낼 것임
        RequestDispatcher view = request.getRequestDispatcher("jsp/04_pizzaEnd2.jsp");
        view.forward(request, response);
        // 데이터를 보낼 곳인 jsp 파일 생성하자
        
        
	}
}
