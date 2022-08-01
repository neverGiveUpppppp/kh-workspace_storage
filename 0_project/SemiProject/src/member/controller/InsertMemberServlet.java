package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;



/**
 * Servlet implementation class insertMemberServlet
 */
@WebServlet(urlPatterns="/insert.me", name="InsertMemberServlet")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			
		
		String userId = request.getParameter("inputId");      // id   1
		String userPwd = request.getParameter("inputPwd");    // pw   2
		String userName = request.getParameter("userName");      // 이름     3
		String phone1 = request.getParameter("userPhone1");      // 핸드폰 010    
		String phone2 = request.getParameter("userPhone2");      // 핸드폰 중간
		String phone3 = request.getParameter("userPhone3");      // 핸드폰 뒷자리
		String email = request.getParameter("email");  			 //이메일 아이디
		//String site = request.getParameter("site");  			 // @ 뒤 이메일 주소
		String gender = request.getParameter("gender");			 // 성별
		String userAddress = request.getParameter("userAddress"); // 주소         5 
		String year = request.getParameter("year");              // 생년
	    String month = request.getParameter("month");            // 월
	    String day = request.getParameter("day");                // 일
		
	    System.out.println(userPwd);
	    
		String phone = phone1 + "-" + phone2 + "-" + phone3;   //핸드폰번호완성  6          
		String strBornDate = year + "-" + month + "-" + day;   
	
		
		String site = null;
		if(request.getParameter("site") != null) {
			site = request.getParameter("site");   
	    } else {
	         site = request.getParameter("selectEmail");
	    }
			String userEmail = email + "@" + site; 
	
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date BornDate = null;                         //생년월일완성  8
	    java.util.Date udate;

	    try {
			udate = sdf.parse(strBornDate);
			BornDate = new java.sql.Date(udate.getTime());

		} catch (ParseException e) {
		
			e.printStackTrace();
		} 
		
	    Member member = new Member(userId, userPwd, userName, phone, userEmail, gender, userAddress, BornDate, null, null, null);
	    
	    int result = new MemberService().insertMember(member);     

		if(result > 0) {
			response.sendRedirect(request.getContextPath());
			
		}else {
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
			
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
