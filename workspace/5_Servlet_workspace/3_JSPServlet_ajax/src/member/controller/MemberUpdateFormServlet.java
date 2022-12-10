package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

/**
 * Servlet implementation class UpdateForm
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

		
	// 1.mypage.jsp에서 숨겨서 넘긴 데이터(input태그 type="hidden")를  MemberUpdateFormServlet에 받아 
	// 2.memberUpdateForm.jsp로 받아온 데이터 넘기기			<- 1,2번까지가 서블릿 완성
	// 3.memberUpdateForm.jsp가 받은 데이터를 화면에 뿌리기
		
		
		// 1.mypage.jsp에서 숨겨서 넘긴 데이터(input태그 type="hidden")를  MemberUpdateFormServlet에 받아오기
		// 데이터가 없었다면 "-"로 넘어올 것임
		request.setCharacterEncoding("UTF-8");
		String myId = request.getParameter("myId");
		String myName = request.getParameter("myName");
		String myNickName = request.getParameter("myNickName");
		String myPhone = request.getParameter("myPhone");
		String myEmail = request.getParameter("myEmail");
		String myAddress = request.getParameter("myAddress");
		String myInterest = request.getParameter("myInterest");
		
		Member myInfo = new Member(myId, null, myName, myNickName, myPhone, myEmail, myAddress, myInterest, null, null, null);
		System.out.println("memberUpdateFormServlet"+myInfo);
		
		// 2.memberUpdateForm.jsp로 받아온 데이터 넘기기	
		request.setAttribute("myInfo", myInfo);
		request.getRequestDispatcher("WEB-INF/views/member/memberUpdateForm.jsp").forward(request, response);

				
		
		// 정보 업데이트라 데이터 이동이 있으니 포워드...?
		// url유지시킬려고 사용
//		request.getRequestDispatcher("WEB-INF/views/member/memberUpdateForm.jsp").forward(request, response); 
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
