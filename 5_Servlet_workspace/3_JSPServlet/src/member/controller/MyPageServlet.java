package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage.me")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	// 이 페이지를 호출한 menubar.jsp 라인61에서 method를 명시하지 않아 디폴트값인 doGet으로 호출했기에 
	// 바로 아래의 메소드인 doGet호출되었고, doPost가 아니기에 setCharacterEncoding() 사용x
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession(); // 세션의 값(세션 객체)을 서버에 요청해서 받아와서 HttpSession타입의 session 변수에 넣는다
//		Member member = (Member)session.getAttribute("loginUser"); 
		// 세션에서 로그인 유저의 속성값을 가져오고 Member타입으로 형변환해서 member 변수에 넣어준다
//		// 세션에서 로그인유저에 있는 member속성을 뽑아옴
//		String loginUserId = member.getUserId(); // member에서 db의 user_id 컬럼 정보를 
		
		// 위 3줄의 1줄 줄임코드
		String loginUserId = ((Member)(request.getSession().getAttribute("loginUser"))).getUserId();
		
		Member member = new MemberService().selectMember(loginUserId);
		
		
		
		// Member member에 데이터 있으면 조회 결과가 있는거고 없으면 null
		String page = null;
		if(member != null) {
			page = "WEB-INF/views/member/mypage.jsp";
			request.setAttribute("member", member); 
			// 위에서 db로부터 받아온 데이터인 member변수의 데이터를 setAttribute()로 request객체에 담았음. 
			// 아래 request.getRequestDispatcher(page)에서 요청을 실행하면서 mypage.jsp를 호출과 함께 이 데이터를 보낸다
			
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원조회에 실패했습니다");
		}
		
		// if문 else문 둘 다 뷰로 보낼 데이터가 있음. 둘 다 리퀘스트 디스패쳐+forward 사용해야함
		// if안 esle안 둘다 들어가야함. 같은 코드고 경우만 다르니 경로만 분리하고 공통 코드는 밖으로 빼면 된다
		// 경로 분리한 코드는 
		// request.setAttribute("member", member); 
		// request.setAttribute("msg", "회원조회에 실패했습니다");
		request.getRequestDispatcher(page).forward(request, response); // 공통 코드. 이렇게 할려고 page변수 만든 것
		// setAttribute()로 매개변수 속성값을 request에 넣고 요청하는 것이므로 redirect가 아닌 forward
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
