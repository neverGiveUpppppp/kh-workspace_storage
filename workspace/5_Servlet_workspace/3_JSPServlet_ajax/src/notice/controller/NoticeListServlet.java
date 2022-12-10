package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/list.no")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 공지사항 글은 앞으로 계속 늘어날 건데 객체로 받으면 너무 일회성 코드이기이고 계속 공지사항 글을 받을 수 있게 ArrayList처리
		ArrayList<Notice> list = new NoticeService().selectList();
		
		// 뷰로 넘어가는 코드 2가지
		// 1)forward
		// 2)sendRedirect
		// 위에서 공지사항 누르면 공지사항 리스트 가져올 때 이것도 데이터가 있다고 했으니 forward 사용

		String page = null;
		if(list != null) {
			// 경로 지정에 WebContent를 안써줘도 되는 이유
			// forward 자체가 루트컨텍스트를 바라보는건데 지금 루트설정이 WebContent이기 때문에 루트인 WebContent를 경로에 안써줘도 됨
			page = "WEB-INF/views/notice/noticeList.jsp";
			request.setAttribute("list", list);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 조회에 실패하였습니다");
		}

		request.getRequestDispatcher(page).forward (request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
