package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.MZNoticeService;
import notice.model.vo.MZNotice;


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
		
//		request.getRequestDispatcher("WEB-INF/views/notice/mzNoticeList.jsp").forward(request, response);
		// 페이징 처리
//		MZNoticeService service = new MZNoticeService();
//		int listCount;
//		int currentPage;
//		int pageLimit;
//		int boardLimit;
//		int maxPage;
//		int startPage;
//		int endPage;
		
//		listCount = service.getListCount(); // 10:10
//		System.out.println(listCount);
//		
//		currentPage = 1;
//		if(request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//		
//		pageLimit = 10; // 한 페이지의 10개의 페이징
//		boardLimit = 10; // 한 페이지의 10개의 게시물
//		
//		maxPage = (int)Math.ceil((double)listCount/boardLimit);
//		
//		startPage = (currentPage - 1)/pageLimit * pageLimit + 1;
//		
//		endPage = startPage + pageLimit - 1;
//		if(maxPage < endPage) {
//			endPage = maxPage;
//		}
//		
//		PageInfoNum pin = new PageInfoNum(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<MZNotice> list = new MZNoticeService().selectList();
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/notice/mzNoticeList.jsp";
			request.setAttribute("list", list);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
