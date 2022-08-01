package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.BoardException;
import board.model.vo.PageInfo;
import common.Pagination;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/selectList.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardService service = new BoardService(); // 객체를 레퍼런스변수로 만들어서 사용 for 2번 왕복용 
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null ) { // 위의 url에 cp가 존재한다면
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
	
		try {
			int listCount = service.getListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = service.selectBoardList(pi);
			
			System.out.println(pi);
			System.out.println(list);
			
			request.setAttribute("list", list); // request스코프영역에 값을 저장함
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("WEB-INF/views/common/boardList.jsp").forward(request, response);
			
		} catch (BoardException e) {
			request.setAttribute("message", e.getMessage());
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
