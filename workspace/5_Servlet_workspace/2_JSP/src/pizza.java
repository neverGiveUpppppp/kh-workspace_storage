
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pizza extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String pizza = req.getParameter("pizza");
		String[] topping = req.getParameterValues("topping");
		String[] sideMenu = req.getParameterValues("sideMenu");
		
		
        // 데이터 잘 받아왔는지 디버깅용 코드
		System.out.println(pizza);		// null	// 남자	
        for (String f : topping) {		// str[] 값 디버깅용 
        	System.out.println(f);
        }
        
        for (String f2 : sideMenu) {		// str[] 값 디버깅용 
        	System.out.println(f2);
        }
        
        
        
        String pizzaPrice = null;
        switch(pizza) {
        case "치즈피자": pizzaPrice="5000"; break;
        case "콤비네이션피자" : pizzaPrice="6000"; break;
        case "포테이토피자" : pizzaPrice="7000"; break;
        case "고구마피자" : pizzaPrice="7000"; break;
        case "불고기피자" : pizzaPrice="8000";break;
        }
        
        
        // 결과화면 이동, 데이터 필요o
        // 내가지금 뷰한테 결과화면으로 보낼 데이터들을 모아줄것임. 
        // setAttribute() : 내가 전달하고자 하는 데이터를 어떤 이름의 공간으로 담아서 보낼 지 지정해주는 메소드
//        결과화면은 응답(response)하는건데 왜 리퀘스트에 담을까?
//        결과 화면을 따로 분리해서 만들 것임	V → C(servlet) → 결과화면 V
        req.setAttribute("pizza", pizza);		// 각 변수는 위의 str변수와 링크 : ex)변수 name은 위의 String name과 링크
        req.setAttribute("topping", String.join(", ",topping));
        req.setAttribute("sideMenu", String.join(", ",sideMenu));
        req.setAttribute("pizzaPrice", pizzaPrice);
//        request.setAttribute("foods", String.join(", ",foods));
//        request.setAttribute("recommendation", recommendation);
        // 데이터를 담아둔 request변수들
        
        
        // 이동할 경로 지정
        // 결과화면View 분리할 이동경로 지정. jsp파일 생성
        RequestDispatcher view = req.getRequestDispatcher("jsp/04_pizza.jsp");
        view.forward(req, resp);
        //response 뭐 담은건 없는데 같이 보내줘야하기때문에 보내줘여
        
        
        // 데이터 잘 받아왔는지 디버깅용 코드
        System.out.println(pizza);		// null	// 강건강   <- 웹페이지에서 이름에 강건강 적고 제출한 후 콘솔 결과
        for (String f : topping) {		 
        	System.out.println(f);
        }
        System.out.println(sideMenu);		// null	// 서울
        for (String f : sideMenu) {		 
        	System.out.println(f);
        }
        System.out.println(pizzaPrice);		// null	// 한식  <- 복수체크해도 한식 하나만 나온다. 이럴 때는 배열로 받아주자. getParameterValues() 사용
        
        
        
        
        
        
        
     // HttpServletResponse 
     		// HttpServletResponse : 처리 결과를 웹브라우저로 보여주기 위한 용도 
             // setContentType() : 내용에 대한 컨텐트 타입을 적어준다
             // 		내가 지금 보내는 리스폰스에서 반환을 보내는 것
             // 		응답하는 페이지에 mim이라고 타입이 있음. 그 타입을 정해주는 것. 매개변수 값은 고정
             
        	resp.setContentType("text/html; charset=UTF-8"); // 안넣으면 글씨가 인코딩이랑 또 다르게 깨져나온다
     		// text타입명시 /html 쓸거다 명시
     		PrintWriter out = resp.getWriter();	// PrintWriter클래스 : 
     		out.println("<html>");
     		out.println("<head>");
     		out.println("<title> 피자주문 </title>");
     		
//     		out.println("<style>");
//     		out.println("h2{color:pink;}");
//     		out.println("</style>");
//     		
     		out.println("</head>");
     		out.println("<body>");
     		
     		out.println("<h3>주문 내역</h3>");
     		out.println("<span>피자는</span>");
     		out.println("<span class='pizza'>" + pizza + "</span>, ");
     		out.println("<span>토핑은</span>");
//     		out.printf("<span class='topping'>%s</span>, ", topping);
     		for(int i = 0 ;  i < topping.length; i++) {
     			if(i == 0) {
     				out.printf("%s", topping[i]);
     			}else {
     				out.printf(", %s", topping[i]);
     			}
     		}
     		
     		out.println();
     		out.println("<span> 사이드는</span>");
     		
     		// 위에서 str arr로 받은 값을 화면에 출력
     		for(int i = 0 ;  i < sideMenu.length; i++) {
     			if(i == 0) {
     				out.printf("%s", sideMenu[i]);
     			}else {
     				out.printf(", %s", sideMenu[i]);
     			}
     		}
     		out.println("<span> 주문 하셨습니다.</span>");
     		out.println();
     		
     		
     		out.println("<h4>총합 : </h4>");

     		out.println("<h2>즐거운 식사시간 되세요</h2>");
     		
     		
     		out.println("</body>");
     		out.println("</head>");
     		out.println("</html>");
        
        
        
        
	}
}
