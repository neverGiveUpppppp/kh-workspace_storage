package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjaxServlet2
 */
@WebServlet("/jQuery2.do")
public class JQueryAjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    // 2.버튼 선택 시, 서버에서 보낸 값 사용자가 수신
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request대신 response 사용하는 이유
		// 전에 데이터를 보낸다고 했을 때 뭐 사용했었죠?
		// request.setAttribute에 담아서 forward 통해서 보냄
		// 서블릿이 뷰한테 요청하는 거기 때문에 request써서 forward하는게 맞음. response가 아닌
		// 제어권을 뷰한테 넘기기는거기에 리퀘스트 사용이 맞음
		// 깜빡거리는 화면이 바뀌는거임. 
		// 근데 여기서는 다름. 요청 받아왔고 응답을 다시 똑같은 웹페이지로  보내주는거기에 response를 사용하는게맞음 3:15 강의
		// 
		// 제어권을 다시 뷰한테 보내기 때문에 요청하는거라 request 사용
		// 뷰를 유지하면서 쓰는거라 뷰를 바꿀 이유도 없고 그렇기에 응답response해주는거기에 리스폰스 사용
		// PrintWriter 반환 받을 수 있는 애가 response이기 때문에 response 사용하는 것이라고 이해해두기만해도 괜찮
		response.setCharacterEncoding("UTF-8");  // request아님. response로 보내는거라 response쓰니 주의!!
		PrintWriter pw = response.getWriter();	// getWriter :    // 1_Servelt에서 html 쓸 때 뷰작성해서 같이보낼 때 사용했던 메소드
		pw.print("서버에서 전송한 값입니다.");
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
