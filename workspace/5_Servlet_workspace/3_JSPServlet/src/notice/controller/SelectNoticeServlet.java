package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class SelectNoticeServlet
 */
@WebServlet("/detail.no")
public class SelectNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// url로 누구 보냈죠? 데이터 no를 받아와야함
		int no = Integer.parseInt(request.getParameter("no"));
		
		Notice not = new NoticeService().selectNotice(no);
		
		
		// 데이터 넘어가야하기에 FORWARD 사용
		String page = null;
		if(not != null) {
			page = "WEB-INF/views/notice/noticeDetail.jsp";
			request.setAttribute("not", not);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 조회에 실패하였습니다");
		}
		request.getRequestDispatcher(page).forward (request, response);
		
		// Q. 강의 11:30
		// A. 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
