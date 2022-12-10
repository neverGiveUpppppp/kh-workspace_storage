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
 * Servlet implementation class BoartDetailServlet
 */
@WebServlet("/selectOne.bo")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		
		try {
			Board b = new BoardService().selectBoardDetail(bId);
			
			int rCount = 0;
			if( !b.getReplyList().isEmpty()) {
				rCount = b.getReplyList().size(); // 갯수 집어 넣기
			}
			
			request.setAttribute("b", b);
			request.setAttribute("rCount", rCount);
			request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp").forward(request, response);
			
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
