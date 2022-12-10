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

/**
 * Servlet implementation class pwdFindServlet
 */
@WebServlet("/PwdFind.do")
public class PwdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("str_email01"); 	//@앞까지의 email
		
		String emailAddress = null;
		if(request.getParameter("str_email02") != null) {// 직접입력창이 null이 아니면
			emailAddress = request.getParameter("str_email02");	//직접입력창의 입력값을 eamil주소로하고
		} else {
			emailAddress = request.getParameter("selectEmail"); //null이면 selectBox의 입력값을 eamil주소로 한다.
		}
		
		String userEmail = emailId + "@" + emailAddress; //전체 이메일 주소
		
		String userId = request.getParameter("id");

		Date date = null;
		
		int year = 0;
		int month = 0;
		int day = 0;
		
		if(request.getParameter("year") != "" && request.getParameter("month") != "" 
			&& request.getParameter("day") != "") { //생년월이 창에 아무것도 입력하지 않고 submit하면 문자열 ""이 전송되는데 
			//이것을 숫자로 파싱할 수가 없어서 500에러 발생 -> if문으로 ""이 아닐때라는 파싱하도록 조건을 넣어서 디버깅함 
			
			year = Integer.parseInt(request.getParameter("year"));
			month = Integer.parseInt(request.getParameter("month")) -1;
			day = Integer.parseInt(request.getParameter("day"));
		}
	
		date = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		
		Member member = new Member();
		
		member.setUserId(userId);
		member.setBornDate(date);
		member.setUserEmail(userEmail);
		
		Member findMember = new MemberService().findMember(member);

		if(findMember != null) {
			request.setAttribute("msg", findMember.getUserName() + "님의 회원 인증이 성공적으로 완료 되었습니다. <br>회원님의 이메일 주소로 임시 비밀번호를 발송하였습니다. 임시 비밀번호로 로그인 후 비밀번호를 변경하여주세요" );
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "일치하는 회원정보가 없습니다.");
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
