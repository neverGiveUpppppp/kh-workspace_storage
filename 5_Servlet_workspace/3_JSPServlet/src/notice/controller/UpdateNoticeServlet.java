package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/update.no")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		int no = Integer.parseInt(request.getParameter("no"));
		String date = request.getParameter("date");	// 데이터타입이 날짜인데 getParameter 특성상 str로 받으므로 아래에서 데이터처리 필요  
		String content = request.getParameter("content");
		
		request.setAttribute("title", title);
		request.setAttribute("no", no);
		request.setAttribute("date", date);
		request.setAttribute("content", content);
		

		Date date_c = null;	/// sql Date 임포트 // db연결되는거면 Date는 전부 sql.Date
		System.out.println(date); // 아무것도 입력하지 않으면 ""로 들어옴. 아무것도 안찍힘. 공백. 내가 작성일을 넣지 않았을 때 
		
		if(date.equals("")) { // Date date_c 값이 비어 있는지 if조건
			// 작성자가 시간 설정 안하면 현재 시간이 나오게끔 GregorianCalendar()로 현재시간 표시
			date_c = new Date(new GregorianCalendar().getTimeInMillis()); // 현재 시간에 대한 밀리세컨즈에========
		}else {
			// jsp에서 받아온 날짜 데이터인 date는 대쉬가 들어간 상태로 올거기에 대쉬(-) 기준으로 split
			String[] dateArr = date.split("-");
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1])-1; // month는 제로베이스로 5하면  4가 나오므로 -1해줘야 현재 달(month)가 출력됨
			int day = Integer.parseInt(dateArr[2]);
			// Date 클래스 쓸 때 주의해야할 것
			// 월(month)만 zero-base : 0부터 시작
		
			// date의 날짜데이터를 split("-")로 조개서 각각 int year, int month, int day 받은 것을 하나의 객체에 다시 저장 
			date_c = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			
		}
		
		// noticeWriteForm.jsp뷰에서 데이터 + str date에서 Date dat으로 정제된 날짜데이터 + session의 로그인유저 정보 
		// 위의 3종류 데이터를 Notice n에  데이터 저장
		Notice n = new Notice();
		n.setNoticeTitle(title);	//  noticeWriteForm.jsp뷰에서 받아온 데이터 : 글 제목 
		n.setNoticeNo(no);			// session에서 로그인한 정보를 받아온 데이터 : 글쓴이
		n.setNoticeDate(date_c);	//  noticeWriteForm.jsp뷰에서 받아온 데이터 : 글 쓴 날짜
		n.setNoticeContent(content);//  noticeWriteForm.jsp뷰에서 받아온 데이터 : 글 내용
			
		int result = new NoticeService().updateNotice(n); // 위의 4개의 내용(Notice n)을 담아 service에 insertNotice()메소드 호출
		
		if(result > 0) {
//			response.sendRedirect("list.no"); // 공지사항 게시판 // list.no == NoticeListServlet
			response.sendRedirect("detail.no?no=" + no); // noticeList.jsp의 /detail.no?no= // location.href = '<%= request.getContextPath() %>/detail.no?no=' + num; 
		} else {
			request.setAttribute("msg", "공지사항 수정에 실패하였습니다.");
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
