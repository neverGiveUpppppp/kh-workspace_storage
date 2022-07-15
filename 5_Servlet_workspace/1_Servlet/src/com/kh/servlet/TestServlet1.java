package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet{
// HTTP 프로토콜을 사용하는 서블릿은 javax.servlet.http.httpServlet클래스로 GenericServlet을 상속한 클래스

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 와야 시작함
		
		// 요청이 들어오면 처리 시작
		System.out.println("요청 들어왔는지 확인"); // 기능단에서 변경되면 서버 재가동해야함 // 웹페이지에서 양식 제출해야 프린트찍힘
		// 요청이 안들어왔다. why?
		// url 맵핑이 안들어왔기 때문 	// 매핑(mapping) : 하나의 값을 다른 값으로 대응시키는 것
		// web.xml에 </web-app>클로즈 태그 사이에 아래 태그 추가
//		<servlet>
//			<servlet-name>TestServlet1</servlet-name>
//			<servlet-class>com.kh.servlet.TestServlet1</servlet-class>
//		</servlet>
//		<servlet-mapping>
//			<servlet-name>TestServlet1</servlet-name>
//			<url-pattern>testServlet1.do</url-pattern>
//		</servlet-mapping>

		
		
		
		// HttpServletRequest
		// HttpServletRequest : 사용자가 요청한 내용을 받아주는 용도
		// HttpServletRequest.getParameter(String name):String - view에서 보낸 데이터를 받아오는 역할
		// 			매개변수 String name : view에서 보낸 데이터를 받아오는 역할
		// HttpServletRequest.getParameterValues(String name):String[]
		
		// get방식은 데이터가 url에 담겨서 옴.
        // 데이터 잘 받아왔는지 디버깅용 코드
        String name = request.getParameter("name");	// name 이 name으로 되어있는 파라미터에 담긴 값(value)를 가지고 오겠다. -> 이 값을 가진 데이터를 str로 반환
        String gender = request.getParameter("gender");	//  name → value값 담아주는 변수명 적는곳.
        String age = request.getParameter("age");
        String city = request.getParameter("city");
        String height = request.getParameter("height");
        String[] foods = request.getParameterValues("food");
        
        
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
        // setContentType()
		response.setContentType("text/html; charset=UTF-8"); /// setContentType() : 내용에 대한 컨텐트 타입을 적어준다
							// text타입명시 /html 쓸거다 명시
		PrintWriter out = response.getWriter();	// PrintWriter로 반환받음
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
		out.printf("<span class='city'>%s</span>에 사는", city);
		out.printf("키 <span class='height'>%s</span>cm인 ", height);
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
