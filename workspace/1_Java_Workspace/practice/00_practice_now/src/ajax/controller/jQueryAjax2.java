package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jQueryAjax2
 */
@WebServlet("/jQueryAjax2")
public class jQueryAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jQueryAjax2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");  // request아님. response로 보내는거라 response쓰니 주의!!
		PrintWriter pw = response.getWriter();	// getWriter :    // 1_Servelt에서 html 쓸 때 뷰작성해서 같이보낼 때 사용했던 메소드
		pw.print("서버에서 전송한 값입니다.");
		
//		response.getWriter().print("서버에서 전송한 데이터 입니다");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
