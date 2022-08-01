package tryto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pracServlet1_get extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		System.out.println("요청 들어왔는지 확인");
		
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String city = req.getParameter("city");
		String height = req.getParameter("height"); 
		String[] foods = req.getParameterValues("food");
		

        System.out.println(name);		// a
        System.out.println(gender);		// 남자	
        System.out.println(age);		// 20대
        System.out.println(city);		//  서울
        System.out.println(height);		// 177
        for (String f : foods) {		// str[] 값 디버깅용 // 한식  <- 복수체크해도 한식 하나만 나온다. 이럴 때는 배열로 받아주자. getParameterValues() 사용 
        	System.out.println(f);
        }
        
        
        
        resp.setContentType("text/html; charset=UTF-8"); /// setContentType() : 내용에 대한 컨텐트 타입을 적어준다
		// text타입명시 /html 쓸거다 명시
		PrintWriter out = resp.getWriter();	// PrintWriter로 반환받음
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
