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
import board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
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
		
		// 페이징 처리가 들어가면 Service를 두 번 요청하기 때문에 레퍼런스 변수로 생성
		
		// 서비스 요청하는 경우 2가지
		// 1.게시글 전체 개수를 가져올 때 : 페이징 처리 계산에 사용
		// 2.게시글 가져올 때
		BoardService service = new BoardService();
	
		// 페이징 처리의 각 정보를 담는 변수들
		int listCount;		// 게시물 총 개수
		int currentPage;	// 현재 페이지 표시
		int pageLimit;		// 한 페이지에 표시될 페이징 수
		int boardLimit;		// 한 페이지에 보일 게시글 최대 개수
		int maxPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지

		// 게시물 총 개수를 가져오는 listCount를 계산 때문에 먼저 가져와야한다
		listCount = service.getListCount();
		System.out.println(listCount); // Board nav바 눌러야 이 자바파일이 실행되어 println도 콘솔에 찍힘
		
		// db Board테이블에 더미 데이터 넣어줌.  board테이블 데이터가 없어 프로젝트 파일의 board코드가 잘 작동하는지 알 수 없기 때문 
		
		// 더미 파일 저장 이후 println에 97 찍힘
		
		currentPage = 1; // currentPage는 무조간 1값을 가지고 있어야함. 그래야 처음에 막 들어가도 1페이지에 대해 보여줄 수 있기 때문 
		if(request.getParameter("currentPage") != null) { // currentPage값이 값이 있다면
			// 내가 페이지를 처음 들어간게 아니고 페이징 처리된 다른 페이지 버튼을 눌렀을 때의 상황
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
			// url요청에서 ?currentPage=3이던 4이던 뭐를 요청하던지 간에 currentPage = 1; 변수에 들어갈 것이기 때문
			// if문에 안걸리면 currentPage가 1이 되는거고 url request가 와서 값이 있으면 그 값이 되는 것.
			// 즉 요청 없으면 첫페이지 머물고 request 들어오면 해당 페이지 있다는 의미(?)
		}
		pageLimit = 10;		// 한 페이지에 표시될 페이징 수	10개
		boardLimit = 10;	// 한 페이지에 보일 게시글 최대 개수 10개
		
		// 여분 게시물의 페이지수(maxPage) 처리 방법 3가지
		// 방법1 : 마지막페이지 = 총 게시물 수 / 한 페이지 보일 최대 게시글 수 +1 + if문(나머지 없이 몫만 떨어질 경우)
		// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
		// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
		
		
		// 방법1 : 마지막페이지 = 총 게시물 수 / 한 페이지 보일 최대 게시글 수 +1 + if문(나머지 없이 몫만 떨어질 경우)
		// 97개의 게시물이니 최대 10페이지 나옴. 9개 10개씩 꽉차고 7개 담아서 총10페이지
		// 9 나누기 10 = 9...7  나머지
		// listCount(총개수)로 boardLimit로 나눠야함.
		// 둘을 나누면 몫이 나오고 두 값이 int기에 반환도 int값으로 반환됨
		
//			maxPage = listCount/boardLimit + 1; // +1 하는건  나머지가 없이 딱 떨어지면 식이 안맞음
		// +1에 조건문 나머지가 없을시를 넣어서 해도 됨
		
		// 나머지가 1이라도 있으면 올림해야함. 남은 1개의 게시글을 위해서.
		// 나머지가 나와야함. 9.7 12.3 소수점이 나오게 하고 싶다. 그럼 둘중 하나를 형변환 시키면 됨
		
		
		// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
		maxPage = (int)Math.ceil((double)listCount/boardLimit); // 하나가 소수점이라 둘을 계산하면 소수점이 나옴. 10.0 이런식으로
		// ceil로 올림을 추가하므로써 나머지가 1이라도 있으면 게시판 +1구현
		// int형변환한 이유 : maxPage가 인트라 다시 인트로 형변환 해준 것
		// 다른 방법 : 다른거를 더해서 사용. 많이 복잡함.
		// maxPage = (int)Math.ceil((double)listCount/boardLimit); 
		
		// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
		// (int)((double)listCount/boardLimit + 0.9); 올림할 수 있는 최소값이 0.9 
		// 내가 올림을 해야하는 최소값이 0.1
		// 한 페이지를 더해줘야하는 가장 최소값 0.1
		// 이 최소값 마저도 올려줄려면 더할 수 있는 값은 0.9
		// ex) 121개의 게시물이면 12.1이고 
		// 12.1 + 0.9하면 13.0
		// 12.9 + 0.9하면 13.8
		// 다시 (int) 형변환 과정에서 소수점은 어차피 짤리므로 자연스럽게 나머지 페이스도 처리 가능
		
		
		
		//startPage
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1; // 노션 필기참조
		
		//endPage
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {		// maxPage가 endPage보다 작을 경우가 있음. 이럴 때는 ... 강의2:16
			endPage = maxPage; // 맥스페이지를 엔드페이지 안으로 집어 넣으면 된다
		}
		
		
		// 데이터가 많아서 객체에 하나로 담아 전송할 것임
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = service.selectList(pi); // 게시물 가져올 것
		
		
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/boardList.jsp";
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
