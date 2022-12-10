package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.MZBoard;
import board.model.vo.Pagination;


/**
 * Servlet implementation class Board1KorServlet
 */
@WebServlet("/board2Ch.bo")
public class Board2ChServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Board2ChServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		BoardService service = new BoardService();																			
		
		int boardCount;		// 게시물 총 개수
		int currentPage;	// 현재 페이지 표시
		int pageLimit;		// 한 페이지에 표시될 페이징 수
		int boardLimit;		// 한 페이지에 보일 게시글 최대 개수
		int lastPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지

		boardCount = service.getBoardCount();

		
		currentPage = 1; 
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		pageLimit = 5;		
		boardLimit = 4;		
		
		lastPage =  (int)((double)boardCount/boardLimit + 0.9);
	
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		if(lastPage < endPage) {		
			endPage = lastPage; 
		}
		
		Pagination pi = new Pagination(boardCount, currentPage, pageLimit, boardLimit, lastPage, startPage, endPage);
		ArrayList<MZBoard> list = service.selectList(pi); 
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/foods_review_Chinese.jsp";
			request.setAttribute("list", list); 
			request.setAttribute("pi", pi); 
			
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회에 실패했습니다");
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
