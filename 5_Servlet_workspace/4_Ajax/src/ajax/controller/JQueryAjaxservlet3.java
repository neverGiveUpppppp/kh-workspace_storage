package ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjaxservlet3
 */
@WebServlet("/jQuery3.do")
public class JQueryAjaxservlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxservlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    // 3. 서버로 기본형 전송 값이 있고, 결과로 문자열을 받아 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// get방식이라 인코딩 필요x
		// ajax의 data속성값은 key값이 str이기 때문에 str타입으로 보내오므로 형변환 해줘야함
		int num1 = Integer.parseInt(request.getParameter("firstNum"));
		int num2 = Integer.parseInt(request.getParameter("secondNum"));

		int sum = num1 + num2;
		
		response.getWriter().print(sum); // sum이 인트값이라도 Print메소드로 보냈기 때문에 str로 보내진다
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
