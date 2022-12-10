package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;

/**
 * Servlet implementation class SelectFileServlet
 */
@WebServlet("/detail.th")
public class SelectFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bId = Integer.parseInt(request.getParameter("bId"));
		
		// 두번 왔다갔다 할거라 레퍼런스 선언
		BoardService service = new BoardService();
		Board board = service.selectBoard(bId);
		
		// 사진 가져오기
		ArrayList<Attachment> fileList = service.selectFile(bId);
		
		
//		System.out.println(board);
//		System.out.println(fileList);
		
		String page = null;
		if(board != null && fileList != null) {
			request.setAttribute("board", board); 
			request.setAttribute("fileList", fileList); 
			page = "WEB-INF/views/thumbnail/thumbnailDetail.jsp";
			
		} else {
			request.setAttribute("msg", "사진 게시판 상세보기에 실패했습니다");
			page = "WEB-INF/views/common/errorPage.jsp";
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
