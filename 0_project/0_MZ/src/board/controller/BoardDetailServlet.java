package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.MZBoard;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/detail.bo")
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

		
		// 상세보기 게시판 구별용 num(pk역할) 뭘로 받아와야할까?
		
		request.getRequestDispatcher("WEB-INF/views/board/foods_review_detail.jsp").forward(request, response);
		
//		System.out.println("jsp-> num1="+request.getParameter("no"));
//		
//		int num = Integer.parseInt(request.getParameter("no"));
//		
//		
//		MZBoard boardNum = new BoardService().selectBoard(num);
//		
//		System.out.println(boardNum);
//		
//		String page = null;
//		if(boardNum != null) {
//			page = "WEB-INF/views/board/foods_review_detail.jsp";
//			request.setAttribute("boardNum", boardNum);
//		} else {
//			page = "WEB-INF/views/common/errorPage.jsp";
//			request.setAttribute("msg", "리뷰 상세보기 조회에 실패하였습니다");
//		}
//		request.getRequestDispatcher(page).forward (request, response);
		
		

//		request.getRequestDispatcher("WEB-INF/views/board/foods_review_detail.jsp").forward (request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
