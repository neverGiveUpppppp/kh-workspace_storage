package ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjaxservlet4
 */
@WebServlet("/jQuery4.do")
public class JQueryAjaxservlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxservlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    // 4. Object형태의 데이터를 서버에 전송, 서버에서 데이터 처리 후 서버 console로 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String student1 = request.getParameter("student1");
		String student2 = request.getParameter("student2");
		String student3 = request.getParameter("student3");
		String print = request.getParameter("print");
		
		
		System.out.println("방법1 : 수업 들을 학생은" + student1 + ", " + student2 + ", " + student3 + "입니다");
		
		System.out.println("방법2 : print"+print);
		
		// 다른 방법 : printf
//		String s1 = request.getParameter("student1");
//		String s2 = request.getParameter("student2");
//		String s3 = request.getParameter("student3");
//		
//		System.out.printf("수업을 들은 학생은 %s, %s, %s입니다.", s1, s2, s3);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
