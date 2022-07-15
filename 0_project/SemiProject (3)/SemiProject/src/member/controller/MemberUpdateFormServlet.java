package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;


/**
 * Servlet implementation class MemberUpdateFormServlet
 */
@WebServlet("/updateForm.me")
public class MemberUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String myId = request.getParameter("myId");
		String myName = request.getParameter("myName");
		String myPhone = request.getParameter("myPhone");
		String myEmail = request.getParameter("myEmail");
		String myAddress = request.getParameter("myAddress");
		String myBorn = request.getParameter("myBorn");
		
		
		
//		String[] ArrayStr = myEmail.split("@"); //@뒷 문장 자르기
//		String email1 = ArrayStr[0]; 
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date mybirthday = null;                         //생년월일완성  8
	    java.util.Date udate;

	    try {
			udate = sdf.parse(myBorn);
			mybirthday = new java.sql.Date(udate.getTime());

		} catch (ParseException e) {
		
			e.printStackTrace();
		} 
		
	    
		Member myInfo = new Member(myId, null, myName , myPhone, myEmail, null, myAddress, mybirthday, null, null, null);
		
		request.setAttribute("myInfo", myInfo);
		request.getRequestDispatcher("WEB-INF/views/member/memberUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
