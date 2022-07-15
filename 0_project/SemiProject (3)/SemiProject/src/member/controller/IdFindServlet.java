package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class idFindServlet
 */
@WebServlet("/idFind.do")
public class IdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String year = request.getParameter("year");		//생년
		String month = request.getParameter("month");	//생월
		String day = request.getParameter("day");		//생일
			
		String emailId = request.getParameter("str_email01"); 	//@앞까지의 email
		
		String emailAddress = null;
		if(request.getParameter("str_email02") != null) {// 직접입력창이 null이 아니면
			emailAddress = request.getParameter("str_email02");	//직접입력창의 입력값을 eamil주소로하고
		} else {
			emailAddress = request.getParameter("selectEmail"); //null이면 selectBox의 입력값을 eamil주소로 한다.
		}
		
			
		
		String userEmail = emailId + "@" + emailAddress; //전체 이메일 주소
		
		String strBornDate = year + "-" + month + "-" + day; 
		
		
		//java.sql.Date형식으로 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.sql.Date sdate = null;	
		java.util.Date udate = null;
		
		try {
			udate = sdf.parse(strBornDate);
			sdate = new java.sql.Date(udate.getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Member member = new Member();
		
		member.setUserName(userName);
		member.setBornDate(sdate);
		member.setUserEmail(userEmail);
		

		Member selectMember = new MemberService().selectMember(member);
		
		if(selectMember != null) {
			request.setAttribute("msg", selectMember.getUserName() + "님의 ID찾기에 성공하였습니다. <br>입력하신 이메일을 확인하여 주세요." );
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request,	response);
		} else {
			request.setAttribute("msg", "일치하는 회원정보가 없습니다."); 
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
