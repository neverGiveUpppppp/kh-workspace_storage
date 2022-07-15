package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.me")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 가져갈 필요 없기 때문에 sendRedirect() 사용
		HttpSession session = request.getSession(); 
		session.invalidate(); // 세션무효화
		response.sendRedirect(request.getContextPath());
		// Q.response.sendRedirect(request.getContextPath());는 
		// WebContent의 WEB-INF의 menubar.jsp로 이어지는 건가요? 맞다면 getContextPath()는 해당 프로젝트 명 경로를 가져오는 걸로 아는데
		// 프로젝트 실행 시 WEB-INF가 먼저 실행되기 때문에 menubar.jsp로 이어지는 건가요?
		// A.지금은 아니고 최종적으로는 그렇다. 
		// 왜냐면 getContextPath는 컨텍스트 루트를 말한다고 했었다. 이는 인터넷 주소창 url의 3_JSPServlet으로 가는 것임. 
		// 프로젝트 자체로 실행을 시키면 그 메인으로 실행시키면 그 메인의 웰컴파일 리스트를 web.xml에 지정 해줬었음(index.jsp index.html ). 
		// index.jsp가 menubar를 include하고 있기 때문에 그래서 결론적으로 보면 menubar까지 가진 하지만 
		// 그래도 명시적인걸로 보면은 welcome-file 리스트에 있는 index.jsp로 감
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
