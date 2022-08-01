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
@WebServlet("/board1Kor.bo")
public class Board1KorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Board1KorServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request.getRequestDispatcher("WEB-INF/views/board/foods_review_Korean.jsp").forward (request, response);
		
		BoardService service = new BoardService();	
		
		
		int boardCount;		// 게시물 총 개수
		int currentPage;	// 현재 페이지 표시
		int pageLimit;		// 한 페이지에 표시될 페이징 수
		int boardLimit;		// 한 페이지에 보일 게시글 최대 개수
		int lastPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지

		boardCount = service.getBoardCount();
		System.out.println("servlet boardcount ="+boardCount); // 8
		

		
		currentPage = 1; 
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		pageLimit = 5;		// 한 페이지에 표시될 페이징 수	10개
		boardLimit = 4;		// 한 페이지에 보일 게시글 최대 개수 10개
		
		// 여분 게시물의 페이지수(maxPage) 처리 방법 3가지
		// 방법1 : 마지막페이지 = 총 게시물 수 / 한 페이지 보일 최대 게시글 수 +1 + if문(나머지 없이 몫만 떨어질 경우)
		// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
		// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
		
		// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
//		LastPage = (int)Math.ceil((double)BoardCount/boardLimit); // 하나가 소수점이라 둘을 계산하면 소수점이 나옴. 10.0 이런식으로
		// ceil로 올림을 추가하므로써 나머지가 1이라도 있으면 게시판 +1구현
		// int형변환한 이유 : maxPage가 인트라 다시 인트로 형변환 해준 것
		// 다른 방법 : 다른거를 더해서 사용. 많이 복잡함.
		// maxPage = (int)Math.ceil((double)listCount/boardLimit); 
		
		// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
		// (int)((double)listCount/boardLimit + 0.9); 올림할 수 있는 최소값이 0.9 
		lastPage =  (int)((double)boardCount/boardLimit + 0.9);
		
		
		//startPage
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1; // 노션 필기참조
		
		//endPage
		endPage = startPage + pageLimit - 1;
		if(lastPage < endPage) {		// maxPage가 endPage보다 작을 경우가 있음. 이럴 때는 ... 강의2:16
			endPage = lastPage; // 맥스페이지를 엔드페이지 안으로 집어 넣으면 된다
		}
		
		
		// 데이터가 많아서 객체에 하나로 담아 전송할 것임
		
		Pagination pi = new Pagination(boardCount, currentPage, pageLimit, boardLimit, lastPage, startPage, endPage);
		
		ArrayList<MZBoard> list = service.selectList(pi); // 게시물 가져올 것
		
		
		System.out.println("servlet = "+list);
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/foods_review_Korean.jsp";
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
