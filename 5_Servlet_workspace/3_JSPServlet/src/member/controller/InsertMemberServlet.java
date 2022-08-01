package member.controller;

import java.io.IOException;

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
		
		request.setCharacterEncoding("UTF-8");	// post방식으로 보내왔기에 글씨가 깨지니 인코딩 처리 필요
		
		String userId = request.getParameter("joinUserId");
		String userPwd = request.getParameter("joinUserPwd");	// signUpForm.jsp에서 name 속성값 받아온 것
		String userName = request.getParameter ("userName");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String email = request.getParameter ("email");
		String address = request.getParameter("address");
		String[] iArr = request.getParameterValues("interest");

		String interest = ""; // 회원가입 페이지에서 관심분야 체크 부분, 처리 코드
		// 배열 자체가 널이 들어간 상태에서 .랭쓰 해버리면 널포인터익셉션 나는거니 먼저 처리해주는 것
		if(iArr != null) {
			for (int i = 0; i < iArr.length; i++) {
				if(i == iArr.length - 1) {
					interest += iArr[i];
				} else {
					interest += iArr[i] + ", ";
				}
			}
		}
		
		// 유저에게 받은 전체 데이터(id,pw,email,add,phone등)을 하나의 Member 객체에 담고 db로 보내야한다
		Member member = new Member(userId, userPwd, userName, nickName, phone, email, address, interest, null, null, null);
		int result = new MemberService().insertMember(member); // db에서 반환값은 int인데 최종반환값은 int가 아닐 수도 있음
		
		System.out.println(userPwd);
		
		// forward vs sendRedirect ?
		if(result > 0) {
			response.sendRedirect(request.getContextPath()); // 루트컨텍스트로 url 바꿔도 상관없고 보낼 데이터도 없음
			// 회원가입 성공했음 메세지를 보내고 싶으면 이때는 forward 사용
			// Q.WEB-INF로 가는건데도 redirect쓰나요?
			// A.루트 컨텍스트로 가는 것. url이에요. .. index고 web-inf로 ... 강의시간 2:31
			// request.getContextPath()가 web-inf가 아니잖아요.
			// Q. 보내고 싶은 데이터 존재해도 session에 저장하고 센으로 하면 안되나요?
			// A. 가능. 근데 아무나 접근 가능해서 remove로 지워줘야함
			
		}else {
			request.setAttribute("msg", "회원가입에 실패하였습니다");
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
