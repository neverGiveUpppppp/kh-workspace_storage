package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert.no")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");	  // noticeWriteFrom.jsp로부터의 name속성값 : title
		String date = request.getParameter("date");		  // noticeWriteFrom.jsp로부터의 name속성값 : date
		String content = request.getParameter("content"); // noticeWriteFrom.jsp로부터의 name속성값 : content
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId(); // jsp에서 받아온 데이터가 아닌 세션에서 로그인유저 정보를 가져온 것
		// 관리자가 한명이면,  UserId = admin해서 그냥 String값을 넣어도 상관없으나 
		// 나중에 웹사이트가 커지면 관리자가 여러명이 될 때는,  
		// 계속해서 admin이라는 사람만 집어넣게 되므로 코드를 바꿔줘야한다. 따라서 login한 사람에 대한 ID를 추출하는게 맞다
		
		// String타입인 date을 Date클래스로 형변환할 수 없으니 split(”-”)으로하나씩 쪼갤 것임
		// String date = request.getParameter("date")에서 date의 원본데이터는 날짜Date이고 Date클래스의 날짜 Date로 받아와야하나 
		// getParameter 특성상 str로 가져올 수 밖에 없다. 날짜 Date로 써야하는데 형변환이 불가능하니 split으로 쪼개고 년,월,일 별로 하나씩 받을 것임
		
		Date dat = null;	/// sql Date 임포트
//		System.out.println(date); // 아무것도 입력하지 않으면 ""로 들어옴. 아무것도 안찍힘. 공백. 내가 작성일을 넣지 않았을 때 
								//비어있는 공간이 들어오는구나 null이 아니구나를 알았으니까 아무것도 입력하지 않으면 ""로 들어옴
		if(date.equals("")) { // Date dat 값이 비어 있는지 if조건
			// 작성자가 시간 설정 안하면 현재 시간이 나오게끔 GregorianCalendar()로 현재시간 표시
			dat = new Date(new GregorianCalendar().getTimeInMillis()); // 현재 시간에 대한 밀리세컨즈에
		}else {
			// jsp에서 받아온 날짜 데이터인 date는 대쉬가 들어간 상태로 올거기에 대쉬(-) 기준으로 split
			String[] dateArr = date.split("-");
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1])-1; // month는 제로베이스로 5하면  4가 나오므로 -1해줘야 현재 달(month)가 출력됨
			int day = Integer.parseInt(dateArr[2]);
			// Date 클래스 쓸 때 주의해야할 것
			// 월(month)만 zero-base : 0부터 시작
			// 22-05-03이라고 입력하면 컴퓨터는 뭐라고 받아들일까?
			// 2022-06-03이라고 받아들임. 
			// 1월 -> 0
			// 2월 -> 1
		
			// date의 날짜데이터를 split("-")로 조개서 각각 int year, int month, int day 받은 것을 하나의 객체에 다시 저장 
			dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			
		}
		
		// noticeWriteForm.jsp뷰에서 데이터 + str date에서 Date dat으로 정제된 날짜데이터 + session의 로그인유저 정보 
		// 위의 3종류 데이터를 Notice n에  데이터 저장
		Notice n = new Notice();
		n.setNoticeContent(content);//  noticeWriteForm.jsp뷰에서 받아온 데이터 : 글 내용
		n.setNoticeDate(dat);		//  noticeWriteForm.jsp뷰에서 받아온 데이터 : 글 쓴 날짜
		n.setNoticeTitle(title);	//  noticeWriteForm.jsp뷰에서 받아온 데이터 : 글 제목 
		n.setNoticeWriter(userId);	// session에서 로그인한 정보를 받아온 데이터 : 글쓴이
			
		int result = new NoticeService().insertNotice(n); // 위의 4개의 내용(Notice n)을 담아 service에 insertNotice()메소드 호출
		
		if(result > 0) {
			response.sendRedirect("list.no"); // 공지사항 게시판 // list.no == NoticeListServlet
		} else {
			request.setAttribute("msg", "공지사항 등록에 실패하였습니다.");
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
