package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/update.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String myId = request.getParameter("myId");
		String newPhone1 = request.getParameter("newPhone1");
		String newPhone2 = request.getParameter("newPhone2");
		String newPhone3 = request.getParameter("newPhone3");
		String newYear = request.getParameter("newYear");
		String newMonth = request.getParameter("newMonth");
		String newDay = request.getParameter("newDay");
		String newSite = request.getParameter("newSite");
		String newEmail = request.getParameter("newEmail");
		String selectEmail = request.getParameter("selectEmail");
		String newAddress = request.getParameter("newAddress");
		String test = "직접입력";
		
		String newuserEmail = null;
		if(test.equals(request.getParameter("selectEmail"))) {
			newuserEmail = newEmail + "@" + newSite;     
		} else {
			newuserEmail = newEmail + "@" + selectEmail; 
		}
		
		
		
		String myPhone = newPhone1 + "-" + newPhone2 + "-" + newPhone3;   //핸드폰번호완성  6
		                 //이메일 완성  7
		String strBornDate = newYear + "-" + newMonth + "-" + newDay;   
	
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date newBornDate = null;                         //생년월일완성  8
	    java.util.Date udate;

	    try {
			udate = sdf.parse(strBornDate);
			newBornDate = new java.sql.Date(udate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
	    Member m = new Member(myId, null, null, myPhone, newuserEmail, null, newAddress, newBornDate, null, null, null);
	    
	    int result = new MemberService().updateMember(m);
		
		if(result > 0) {
			response.sendRedirect("myPage.me");
		} else {
			request.setAttribute("msg", "회원 정보 수정에 실패하였습니다.");
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
