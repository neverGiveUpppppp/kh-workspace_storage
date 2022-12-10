package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class TemporaryLogin
 */
@WebServlet("/temporaryLogin.do")
public class TemporaryLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemporaryLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputId = request.getParameter("inputId");
		String inputPwd = request.getParameter("inputPwd");
		
		System.out.println(inputId);
		System.out.println(inputPwd);
		
		Member member = new Member();
		
		member.setUserId(inputId);
		member.setUserPwd(inputPwd);
		
		
		Member loginUser = new MemberService().loginMember(member);
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(1800); //세션에 대한 유효시간 30분으로 설정
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "임시 비밀번호로 로그인에 실패하였습니다. 발급받으신 임시 비밀번호를 회원님의 이메일에서 확인하여 주세요"); 
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request,	response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
