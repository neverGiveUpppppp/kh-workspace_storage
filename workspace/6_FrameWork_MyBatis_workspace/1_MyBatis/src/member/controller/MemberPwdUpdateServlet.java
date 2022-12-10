package member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.MemberException;

/**
 * Servlet implementation class MemberPwdUpdateServlet
 */
@WebServlet("/mPwdUpdate.me")
public class MemberPwdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 누구의 비번을 변경할지에 대한 id와 원래 비밀번호와 바꿀 비밀번호 두가지도 가져와야함
		HttpSession session = request.getSession();
		Member member = (Member) request.getSession().getAttribute("loginUser");
		String userId = member.getUserId();
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
				
		// member에 위의 것들 담기에는 부적합. id,pw 다 있긴하지만, 새로운 비번의 필드 존재x
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", userId);		// key : "id", value : userId
		map.put("oldPwd", userPwd);	// key : "oldPwd", value : userPwd
		map.put("newPwd", newPwd);	// key : "newPwd", value : newPwd
		
		try {
			new MemberService().updatePwd(map);
			
			// 비번 수정하면 로그아웃 시킴. 세션에 있는 비번정보를 그대로 가져갈려는 이유
			member.setUserPwd(newPwd);
			session.setAttribute("loginUser", member); // 58,60라인 코드를 쓰는 이유 : 세션영역에서 가져오는 loginUser정보랑 db의정보랑 다르기 때문
			response.sendRedirect(request.getContextPath()); 
		} catch (MemberException e) {
			request.setAttribute("message", e.getMessage()); // setAttribute의 "message"는 errorPage.jsp에서 EL로 받을 것임
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		
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
