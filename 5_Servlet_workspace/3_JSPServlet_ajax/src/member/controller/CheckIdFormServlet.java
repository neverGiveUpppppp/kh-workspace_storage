package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckIdFormServlet
 */
@WebServlet("/checkIdForm.me")
public class CheckIdFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// CheckIdForm.me에서 넘겨줘야하는데 뭘로 넘겨줄 거에요? 팝업창 화면을 띄울려고함(보낼 데이터 필요없음)
		// sendRedirect를 쓰면 WEB-INF에 바로 접근불가. WEB-INF라는 경로가 url로 들어가게 될건데 그렇게되면 그 경로를 찾아들어갈 수 없기 때문에가 첫번째
		// 두번째는 url이 경로에 노출되기에 안좋다. url를 유지하기 위해서, 제대로 잘 찾아갈 수 있기 위해서 request.getRequestDispatcher(경로).forward(req,res) 사용 
		// 브라우저가  redirect를 쓰면 WEB-INF로 바로 접근할수 없움
		
		// .forward() 바로 붙이기
		// 아까는 RequestDispatcher view라고 하는 이름에 담아서 view.forward로 코딩했는데, 바로 포워딩만 할거라면 굳이 객체를 만들 필요 없이 바로 메소드 체이닝해서 넘겨도 상관x
		request.getRequestDispatcher("WEB-INF/views/member/checkIdForm.jsp").forward(request, response);

		// redirect 안되는 이유 : url을 바꾸는건 표면적으로 바꾸는 것이므로 web-inf에 있어서 불가능한 것
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
