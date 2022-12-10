package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns="/login.me", name="LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8"); // doPost로 받아와서 글자가 깨지니 다시 인코딩해주는 것 
		
		
		// 차이
		// HttpServletRequest.getParameter(String name) VS HttpServletRequest.getAttribute(String name)
		// 반환 타입            String											Object
		// 사용 용도	뷰에서 보낸 데이터를 가져올 때						(뷰외에 다른 곳 서블릿 등) 서블릿에서 보낸 데이터를 가져올 때
		
		// getParameter()  뷰에서 데이터 가져오기 때문에 겟파라미터 사용
		// getAttribute() 데이터를 가져올 때 서블릿으로부터 가지고 오기 때문에 얘를 사용
		
		
		
		// 내가 전송한 값 받아올것임
		String userId = request.getParameter("userId"); 	// view의 input태그 name속성값에서 가져오는 userId
		String userPwd = request.getParameter("userPwd");   // view의 input태그 name속성값에서 가져오는 userPwd
		Member member = new Member();
		member.setUserId(userId);	// view에서 유저로부터 받은 id데이터를 setter에 저장하는 코드
		member.setUserPwd(userPwd); // view에서 유저로부터 받은 pw데이터를 setter에 저장하는 코드
		
		Member loginUser = new MemberService().loginMember(member); // mvc패턴의 controller이므로 데이터를 service로 넘겨줘야함, loginMember()가 서비스
		// 목적 : 로그인 ( 디비에 해당 아이디 비번이 있는지 확인 )
		// id,pw일치하는 회원 정보 db랑 비교하여 확인하는 작업 필요. 쿼리문 반환값. 로그인을 위해서 넘기는 id,pw이 있느냐 없느냐 체크하는거니까
//		그거에 해당하는 사람이 있는지 체크하는거니 쿼리를 셀렉트 *도 괜찮고 셀렉트 카운트(*)도 괜찮고 있는지 없는지만 확인하면 되니
//		셀렉트 아스트로한다고 치면 다나올테니 카운트 *로 반환값 인트값 얻고 0,1만 나눠서 받으면 코드가 간단해지니 이걸 쓰자
//		if문으로 0이면 없는 유저니 로그인실패 1이상이면 있는 유저니 로그인 성공
//		일련의 과정 설명 블라블라 강의시간 11:25
// 반환값이 멤버 객체라는건 select *를 사용하겠다는 것
// 로그인 상태가 유지되는건 내 회원정보가 유지되는 것이니 이를 코드로 만들어줘야함
// 간단 코드 때문에 카운트(*)로 받아오면 유저의 id,pw,이름등을 못가져오고 인트값만 받아오니 로그인만 하는게 아닌 로그인을 유지하고 가입된 카페를 이용한다던가
//	블로그를 쓴다던가 하는 것들을 할 수 있기에 쿼리문을 select *로 쓰고 객체로 받아와야한다 
// 로그인할 때는 카운트(*) 안쓰고 다른거 할 때 쓰니 그때가서 보기로 하자
		

//		 하얀 화면 뜬게 get방식의 이게 뜬 것
//		 get 방식으로 보내면 doGet()이 실행되고 post방식으로 보내면 doPost()가 실행 디어야하는데
//		 포스트방식으로 보냈는데 doGet()방식으로 실행이 되고 있다. why?
//		 두포스트에서 두겟 메소드를 호출하고 있어서 두겟으로 넘어가면서 안에 있는 내용을 실행한 것
//		 왜그랬을까? 강의시간 10:40
//		 백단입장에서는 신경쓰임 어떻게 들어왔는지를 알아야함. 
//		 겟방식으로 들어오면 겟방식으로 들어오면 그리하면되는데
//		포스트로 오면 다시 두겟으로 가서 어떻게든 다 실행할 수 있게 만들어주는 것
//		중복되는 내용 
//		두개를 한번에 같이 써놓고 한번에 같은 효과를 내기 위해서 두겟에서 두포스트를 ...?
//		두겟에서 실행하는거니까 포스트방식으로 보낼 때 리퀘스트.셋캐릭터인코딩(utf-8) 안해줘도 되는건가요?라고 생각할 수 있으나
//		....겟방식에서는 캐릭터 인코딩 겟방식 넘어와서 캐릭터
//	포스트 방식으로 보내는거는 유지되있기 대문에 캐릭터인코딩은 계속 유지를 해줘야한다
		
		
//내가 post방식으로 보냈는데도 불구하고, 지금 doGet메소드가 실행되고 있어.. 왜그럴까? [화면에 Served at: /3_JSPServlet 뜨지? 그럼 get방식으로 표현된거야]
//doPost로 온건 맞아 doGet메소드를 호출하고 있어 do Get으로 넘어가면서 안에 있는 내용을         실행하고 있기 때문에
//왜 이렇게 했을까? 어떻게든 다 실행되도록 하기 위해.. 
//get방식에서는 request.setCharacterEncoding(UTF-8) 안해줘도 되는건가요?
//Post방식으로 넘어온건 맞긴해서 UTF-8 설정해줘야해..
//request.setCharacterEncoding(UTF-8)은 내가 doPost로 받아온 데이터들을 UTF-8로 (영        어나 숫자는 문제가 없었는데, 한글은 깨졌기 때문에) 변경
		System.out.println(userPwd);
		
		if (loginUser != null) { // null 아니면 유저정보의 반환값이 있다는 뜻이므로 로그인 성공
			// 로그인하면 메인페이지로 돌아감
			// 서블릿 페이지? 강의시간 4:16
			
		// 	RequestDispatcher.forward() 	vs 	HttpServletResponse.sendRedirect()
		// 	뷰에 보낼 데이터 존재할 때 사용				뷰에 보낼 데이터가 존재하지 않을 때 사용
		//  뷰에 데이터 전송 가능(뷰에 보낼 데이터 존재할 때)	뷰의 데이터 전송 불가 - request/response객체에 데이터 담아도 날아갈거기에 전송이 불가한 것
		// 		URL유지								지정 URL로 변경
//이리 되는 이유 //  request/response 객체유지해서 전송 	request/response 객체를 새로 생성해서 전송
			
		// 로그인하고 나면 메인페이지로 간다고 했는데 우리한테 메인페이지는 인덱스 =======강의시간4:20 
		// 뷰에 보낼 데이터가 있는 상태. 여기서 뷰는 인덱스 -> 뷰에 보낼 데이터가 존재하므로 RequestDispatcher.forward()사용
			
			HttpSession session = request.getSession();	// 리퀘스트 통해서 세션 객체 만드는 것. 
			// request는 HttpServletRequest의 객체변수명이고 이 객체의 정보를 통해 세션을 get하는 것

			session.setAttribute("loginUser", loginUser); // loginUser에서 로그인유저 정보를 받아옴
			session.setMaxInactiveInterval(600); // 세션이 무효화 되는 시간 설정, 기본값 30분 // 최대 10분까지 로그인 유지한다는 의미 
			// 은행 로그인 같은데서 로그인 시간 연장 종료 같은거에서 세선이 만료되었습니다의 세션이 이 서블릿에서의 세션
			// 뷰로 넘어갈 예정
//			response.sendRedirect("index.jsp"); 
			response.sendRedirect(request.getContextPath()); // 개발 경로 url을 안보여주는 request.getContextPath() 사용
			// .sendRedirect() : 데이터전송 불가라 데이터없을 때 사용. 지정 URL로 변경하고 request/response 객체를 새로 생성해서 전송함
			// 로그인했다는 정보를 session에 담고 있음. 즉, response객체 새로 생성되도 session은 사라지는게 아니기 때문에 상관x 
			// 그래서 forward() 안쓰고 sendRedirect()를 사용하는 것. session에 데이터가 담겨있고 request/response 같은 객체도 여기에 담겨있는 것
			

			
		}else {	// 로그인 실패
			request.setAttribute("msg", "로그인 실패"); // msg라는 변수에 로그인실패라는 값을 request영역에 담아두는 것
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
			/*
			 * 강의시간5:40 센드리다이렉를 꼭 해야되 리퀘스트에는 없으니까 포워드로 ..loginUser.?
			 * URL에 로그인 url이 그대로 유지된 걸 볼 수 있음
			 * 
			 */
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// 두포스트에서 두겟 메소드를 호출하고 있어서 두겟으로 넘어가면서 안에 있는 내용을 실행한 것
	}

}
