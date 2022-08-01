package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.MemberException;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/minsert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// memberInsertForm.jsp에서 데이터 받아오기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		Date birthDay = new Date(new GregorianCalendar (year, month-1, date).getTimeInMillis());
		
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
	
		Member m = new Member (userId, userPwd, userName, nickName, email, birthDay, gender, phone, address, null, null, null);
		
		try {
			new MemberService().insertMember(m);
			// 홈으로 가게 페이지 이동해줘야함
			response.sendRedirect(request.getContextPath());
		}catch(MemberException e) {
			request.setAttribute("message", e.getMessage());
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


/*

	  String userId = request.getParameter("userId");
      String userPwd = request.getParameter("userPwd");
      String userName = request.getParameter("userName");
      String nickName = request.getParameter("nickName");
      String email = request.getParameter("email");
      
      int year = Integer.parseInt(request.getParameter("year"));
      int month = Integer.parseInt(request.getParameter("month"));
      int date = Integer.parseInt(request.getParameter("date"));
      Date birthDay = new Date(new GregorianCalendar(year, month-1, date).getTimeInMillis());
      
      String phone = request.getParameter("phone");
      String address = request.getParameter("address");
      String gender = request.getParameter("gender");
      
      Member m = new Member(userId, userPwd, userName, nickName, email, birthDay, gender, phone, address, null, null, null);
      
      try {
         new MemberService().insertMember(m);
         
         response.sendRedirect(request.getContextPath());//메인으로 넘어가기
      } catch (MemberException e) {
         request.setAttribute("message", e.getMessage());
         request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
      }
      
   }

 * 
 * 
 */



