package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		String userId = member.getUserId();
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		
		int year = Integer.parseInt(request.getParameter("year"));
		int month= Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		Date birthDay = new Date(new GregorianCalendar (year, month-1, date).getTimeInMillis()); //
		
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member m = new Member(userId, null, userName, nickName, email, birthDay, gender, phone, address, null, null, null);
		
		try {
			new MemberService().updateMember(m);
			m = new MemberService().selectMember(member); // 다시 넘길 것임
			// m을 넘기면 비번이 null이라 39번라인 세션영역에서 받아온 loginUser정보인 member변수를 사용해야함
			session.setAttribute("loginUser", m); // 58,60라인 코드를 쓰는 이유 : 세션영역에서 가져오는 loginUser정보랑 db의정보랑 다르기 때문
			response.sendRedirect("info.me"); // info.me = 내정보보기 페이지 // 즉, 최종적으로 내정보보기 페이지로 간다는 것 
			
		}catch(MemberException e) {
			request.setAttribute("message", e.getMessage()); // setAttribute의 "message"는 errorPage.jsp에서 EL로 받을 것임
			// getMessage()가 MemberException e에서 나오는 에러메시지를 받아서 setAttibute로 request 영역에 저장하는게 맞는지?
			// MemberException e에서 e.printStackTrace() 할 때, 경로 에러 뜨게 한 것 같이 getMessage()로 이 메세지를 받는게 맞는지?
			
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
