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
import member.model.vo.Reply;

/**
 * Servlet implementation class SelectBoardServlet
 */
@WebServlet("/detail.bo")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bId =Integer.parseInt(request.getParameter("bId"));
		
		Board board = new BoardService().selectBoard(bId);
		
		ArrayList<Reply> list =	new BoardService().selectReplyList(bId);

		String page = null;
		if(board != null) {
			page = "WEB-INF/views/board/boardDetail.jsp";
			request.setAttribute("board", board);
			request.setAttribute("list", list);
		}else {
			page = "WEB-INF/views/board/boardDetail.jsp";
			request.setAttribute("msg", "게시글 상세 조회에 실패하였습니다");
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
