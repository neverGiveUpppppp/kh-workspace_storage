package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signUpFormServlet
 */
@WebServlet("/signUpForm.me")		// 회원가입 누르면 서블릿이 signUpForm.jsp로 넘어가게 할 것임
public class SignUpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("WEB-INF/views/member/signUpFrom.jsp");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/member/signUpForm.jsp");
		view.forward(request, response);
	    // forward & sendRedirect 둘 중 어떤걸로 보내야 할까?
		// 여기서 sendRedirect 안 쓰는 이유 2가지
		// 1.url 지정한 걸로 바뀜. 인터넷 주소창 url이 컨텍스트루인 3_JSPServlet 다음 /web-inf/views/member/signUpForm.jsp가 나옴
		// 	  sendRedirect에 의해서 url이 아예 바뀌다보니 첫번째 목표인 url에 어떤 jsp인지 어떤 경로에 있는지 노출시키지 않기로 한거랑 상충되고
		// 2.web-inf 아래 파일이 있으면 단순한 경로지정을 통해서  화면이 바뀌지 않는다. 그래서 분명히 파일은 존재하지만 404 에러 발생했었음
		
		// Q.그럼 WEB-INF에 있는 파일에 대해서는 sendRedirect를 쓰지 않는 건가요?
		// A.무조건은 아님. sendRedirect할 때 url을 통해서 연결할 수 있기 떄문에 무조건 그렇지는 않다
		// Q.매개변수에 넘겨준 경로가 Web-INf아래있으면 안된다는 말씀인가여?
		// A.인자로 넘겨준게 저기 있으면 안됨. 못들어가는거니까
		
		// 에러 잡는 팁
		// 회원가입창 눌러도 반응이 없는데 어디보면 좋을까여? 
		// 에러 났으니 f12 눌러서 확인할 것.
		// 문제가 없으면 회원가입 버튼에 문제가 있으니 메뉴바 쪽을 보면 됨
		// location.href의 location이 소문자 l이었음(대소문자 구분)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
