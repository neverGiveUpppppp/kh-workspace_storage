package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet3 extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HttpServletRequest
		// HttpServletRequest : 사용자가 요청한 내용을 받아주는 용도
		// HttpServletRequest.getParameter(String name):String - view에서 보낸 데이터를 받아오는 역할
		// 			매개변수 String name : view에서 보낸 데이터를 받아오는 역할
		// HttpServletRequest.getParameterValues(String name):String[]
		
		
		// post 방식으로 get방식처럼 그냥보내면 글씨가 깨져서 나온다.
		// 때문에 데이터를 받아오기 전 인코딩 방식을 변경해줘야한다
		request.setCharacterEncoding("UTF-8"); // setCharacterEncoding("UTF-8")
		
		String name = request.getParameter("name");	// name으로 되어있는 파라미터에 담긴 값(value)를 가지고 오겠다. -> 이 값을 가진 데이터를 str로 반환
		String gender = request.getParameter("gender");	//  name → value값 담아주는 변수명 적는곳.
        String age = request.getParameter("age");
        String city = request.getParameter("city");
        String height = request.getParameter("height");
        String[] foods = request.getParameterValues("food");
        
        
        // 나이 대를 가지고 선물 추천하기 기능 추가
        String recommendation = null;
        switch(age) {
        case "10대 미만": recommendation="막대사탕"; break;
        case "10대" : recommendation="운동화"; break;
        case "20대" : recommendation="지갑"; break;
        case "30대" : recommendation="상품권"; break;
        case "40대" : recommendation="스포츠용품";break;
        case "50대" : recommendation="안마기"; break;
        }
        // 결과화면 이동, 데이터 필요o
        // 내가지금 뷰한테 결과화면으로 보낼 데이터들을 모아줄것임. 
        // setAttribute() : 내가 전달하고자 하는 데이터를 어떤 이름의 공간으로 담아서 보낼 지 지정해주는 메소드
//        결과화면은 응답(response)하는건데 왜 리퀘스트에 담을까?
//        결과 화면을 따로 분리해서 만들 것임	V → C(servlet) → 결과화면 V
        request.setAttribute("name", name);		// 각 변수는 위의 str변수와 링크 : ex)변수 name은 위의 String name과 링크
        request.setAttribute("gender", gender);
        request.setAttribute("age", age);
        request.setAttribute("city", city);
        request.setAttribute("height", height);
        request.setAttribute("foods", String.join(", ",foods));
        request.setAttribute("recommendation", recommendation);
        // 데이터를 담아둔 request변수들
        
        
        // 이동할 경로 지정
        // 결과화면View 분리할 이동경로 지정. jsp파일 생성
        RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet3End.jsp");
        view.forward(request, response);
        //response 뭐 담은건 없는데 같이 보내줘야하기때문에 보내줘여
        
        
        // 데이터 잘 받아왔는지 디버깅용 코드
        System.out.println(name);		// null	// 강건강   <- 웹페이지에서 이름에 강건강 적고 제출한 후 콘솔 결과
        System.out.println(gender);		// null	// 남자	
        System.out.println(age);		// null	// 20대
        System.out.println(city);		// null	// 서울
        System.out.println(height);		// null	// 한식  <- 복수체크해도 한식 하나만 나온다. 이럴 때는 배열로 받아주자. getParameterValues() 사용
        for (String f : foods) {		// str[] 값 디버깅용 
        	System.out.println(f);
        }
        
		
		
		
		
		// HttpServletResponse 
		// HttpServletResponse : 처리 결과를 웹브라우저로 보여주기 위한 용도 
        // setContentType() : 내용에 대한 컨텐트 타입을 적어준다
        // 		내가 지금 보내는 리스폰스에서 반환을 보내는 것
        // 		응답하는 페이지에 mim이라고 타입이 있음. 그 타입을 정해주는 것. 매개변수 값은 고정
        
        response.setContentType("text/html; charset=UTF-8");// text타입명시 /html 쓸거다 명시
        													// 안넣으면 글씨가 인코딩이랑 또 다르게 깨져나온다
		PrintWriter out = response.getWriter();	// PrintWriter클래스 : 
		out.println("<html>");
		out.println("<head>");
		out.println("<title> 개인정보 출력화면 </title>");
		
		out.println("<style>");
		out.println("h2{color:red;}");
		out.println("span{font-weight: bold;}");
		out.println(".name{color:orange;}");
		out.println(".gender{color:yellow; background:black;}");
		out.println(".age{color:green;}");
		out.println(".city{color:blue;}");
		out.println(".height{color:navy;}");
		out.println(".food{color:purple;}");
		out.println("</style>");
		
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h2>개인 취향 테스트 결과</h2>");
		out.println("<span class='name'>" + name + "</span>님은 ");
		out.printf("<span class='age'>%s</span>이시며, ", age);
		out.printf("<span class='city'>%s</span>에 사는 ", city);
		out.printf("<span class='height'>%s</span>cm인 ", height);
		out.printf("<span class='gender'>%s</span>입니다. ", gender);
		out.println("좋아하는 음식은 <span class='food'>");
		
		// 위에서 str arr로 받은 값을 화면에 출력
		for(int i = 0 ;  i < foods.length; i++) {
			if(i == 0) {
				out.printf("%s", foods[i]);
			}else {
				out.printf(", %s", foods[i]);
			}
		}
		
		
		
		out.println("</span>입니다.");
		out.println("</body>");
		
		
		out.println("</style>");
		out.println("</head>");
		out.println("</html>");
		
		
	}
	
	
}

