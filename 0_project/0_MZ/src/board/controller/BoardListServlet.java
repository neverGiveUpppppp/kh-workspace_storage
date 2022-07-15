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
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardListServlet")
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

	

		BoardService service = new BoardService();	
//		request.getRequestDispatcher("WEB-INF/views/board/foods_review_Korean1.jsp");
		
		int boardCount;		// 게시물 총 개수
		int currentPage;	// 현재 페이지 표시
		int pageLimit;		// 한 페이지에 표시될 페이징 수
		int boardLimit;		// 한 페이지에 보일 게시글 최대 개수
		int LastPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지

		boardCount = service.getBoardCount();
		System.out.println(boardCount); // Board nav바 눌러야 이 자바파일이 실행되어 println도 콘솔에 찍힘
		
		// db Board테이블에 더미 데이터 넣어줌.  board테이블 데이터가 없어 프로젝트 파일의 board코드가 잘 작동하는지 알 수 없기 때문 
		
		// 더미 파일 저장 이후 println에 97 찍힘

		
//		
//		currentPage = 1; // currentPage는 무조간 1값을 가지고 있어야함. 그래야 처음에 막 들어가도 1페이지에 대해 보여줄 수 있기 때문 
//		if(request.getParameter("currentPage") != null) { // currentPage값이 값이 있다면
//			// 내가 페이지를 처음 들어간게 아니고 페이징 처리된 다른 페이지 버튼을 눌렀을 때의 상황
//			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
//			// url요청에서 ?currentPage=3이던 4이던 뭐를 요청하던지 간에 currentPage = 1; 변수에 들어갈 것이기 때문
//			// if문에 안걸리면 currentPage가 1이 되는거고 url request가 와서 값이 있으면 그 값이 되는 것.
//			// 즉 요청 없으면 첫페이지 머물고 request 들어오면 해당 페이지 있다는 의미(?)
//		}
//		pageLimit = 3;		// 한 페이지에 표시될 페이징 수	10개
//		boardLimit = 4;	// 한 페이지에 보일 게시글 최대 개수 10개
//		
//		// 여분 게시물의 페이지수(maxPage) 처리 방법 3가지
//		// 방법1 : 마지막페이지 = 총 게시물 수 / 한 페이지 보일 최대 게시글 수 +1 + if문(나머지 없이 몫만 떨어질 경우)
//		// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
//		// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
//		
//		// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
////		LastPage = (int)Math.ceil((double)BoardCount/boardLimit); // 하나가 소수점이라 둘을 계산하면 소수점이 나옴. 10.0 이런식으로
//		// ceil로 올림을 추가하므로써 나머지가 1이라도 있으면 게시판 +1구현
//		// int형변환한 이유 : maxPage가 인트라 다시 인트로 형변환 해준 것
//		// 다른 방법 : 다른거를 더해서 사용. 많이 복잡함.
//		// maxPage = (int)Math.ceil((double)listCount/boardLimit); 
//		
//		// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
//		// (int)((double)listCount/boardLimit + 0.9); 올림할 수 있는 최소값이 0.9 
//		LastPage =  (int)((double)boardCount/boardLimit + 0.9);
//		
//		
//		//startPage
//		startPage = (currentPage - 1) / pageLimit * pageLimit + 1; // 노션 필기참조
//		
//		//endPage
//		endPage = startPage + pageLimit - 1;
//		if(LastPage < endPage) {		// maxPage가 endPage보다 작을 경우가 있음. 이럴 때는 ... 강의2:16
//			endPage = LastPage; // 맥스페이지를 엔드페이지 안으로 집어 넣으면 된다
//		}
//		
//		
//		// 데이터가 많아서 객체에 하나로 담아 전송할 것임
//		
//		Pagination pi = new Pagination(currentPage, boardCount, pageLimit, boardLimit, LastPage, startPage, endPage);
//		
//		ArrayList<MZBoard> list = service.selectList(pi); // 게시물 가져올 것
//		
//		
//		
//		String page = null;
//		if(list != null) {
//			page = "WEB-INF/views/board/boardList.jsp";
//			request.setAttribute("list", list); 
//			request.setAttribute("pi", pi); 
//			
//		} else {
//			page = "WEB-INF/views/common/errorPage.jsp";
//			request.setAttribute("msg", "게시판 조회에 실패했습니다");
//		} 
//		 
//		request.getRequestDispatcher(page).forward(request, response);
//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
