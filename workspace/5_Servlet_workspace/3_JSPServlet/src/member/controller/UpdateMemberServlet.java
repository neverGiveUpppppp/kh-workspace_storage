package member.controller;

import java.io.IOException;
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
@WebServlet("/updateMember.me")
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
		
		String userId = request.getParameter("myId");
		String userName = request.getParameter("myName");
		String nickName = request.getParameter("myNickName");
		String phone = request.getParameter("myPhone");
		String email = request.getParameter("myEmail");
		String address = request.getParameter("myAddress");
		String[] iArr = request.getParameterValues("myInterest");
	
		String interest = ""; // 회원가입 페이지에서 관심분야 체크 부분, 처리 코드
		// 배열 자체가 널이 들어간 상태에서 .랭쓰 해버리면 널포인터익셉션 나는거니 먼저 처리해주는 것
		if(iArr != null) {
			for (int i = 0; i < iArr.length; i++) {
				if(i == 0) {
					interest += iArr[i];
				} else {
					interest += ", " + iArr[i] ;
				}
			}
		}
		Member m = new Member(userId, null, userName, nickName, phone, email, address, interest, null, null, null);
		int result = new MemberService().updateMember(m);
		
		System.out.println("서블릿 " + result);
		// db에서 수정완료 값을 받아왔으니 결과를 유저에게 알려줘야한다
		// 내 정보 보기 쪽으로 넘어가면 되는데, 이때 내 정보 보기 url을 이용해서 넘어갈 것임
		if(result > 0) {
			response.sendRedirect("mypage.me");
		}else {
			request.setAttribute("msg", "회원정보 수정 실패");
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
