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
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login.do")
@WebServlet(urlPatterns="/login.do", name="LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
			request.setAttribute("msg", "로그인에 실패하였습니다. 회원님의 ID와 PWD를 확인하여주세요."); 
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
