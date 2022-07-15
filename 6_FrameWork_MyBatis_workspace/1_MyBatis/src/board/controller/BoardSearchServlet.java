package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/search.bo")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// boardList.jsp에서 보내온 데이터 받기
		String condition = request.getParameter("searchCondition");
		String value = request.getParameter("searchValue");
		
		// 검색도 페이징처리 필요함
		BoardService service = new BoardService();
		
		// 페이징처리 받아오기
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//listCount는 게시물 전체 다 가지고 오지만, 검색은 필요한 것만 가져옴
		// 즉, select * 아님
		// 제목에 게시글이 들어가있는거를 검색하면 제목에 게시글이라고하는 문자열이 들어간 그 게시글 갯수를 가져오는 것
		// 검색 조건에 맞춰서 가져오는 것
		
		// String condition, value도 같이 db로 데이터를 넘겨야함
		// 쿼리에 데이터 넘기는 방법 2가지
		// 		1) vo클래스 객체
		// 		2) 컬렉션(collection)
		// dao에서 쿼리문 적는 코드의 인자 자리가 한개라 하나의 객체에 담아서 보내야하는데 
		// 이게 가능한 2가지가  vo클래스 객체와 컬렉션
		
		// 지금 수업에서는 HashMap 사용할 것임
		// HashMap을 사용하는 이유 : 키와 밸류. 밸류의 구분점으로 키가 들어가게 때문에 HashMap을 쓰는 것
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition); // condition : 검색 조건
		map.put("value", value);		 // value : 검색 값. 검색 뭘로 할지
	
		try {
			int listCount = service.getSearchListCount(map);
			// 리스트를 다 가져오는게 아니라 페이징 처리해야함
			// 페이징처리의 계산을 위한 pagination 클래스를 호출해야함
			Pagination.getPageInfo(currentPage, listCount);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			service.selectSearchList(map,pi); // map을 또 보내는 이유 : 뭘 검색하는지 알아야하기 때문
			ArrayList<Board> list = service.selectSearchList(map,pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("condition", condition);
			request.setAttribute("value", value);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardList.jsp").forward(request, response);
			
			
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
