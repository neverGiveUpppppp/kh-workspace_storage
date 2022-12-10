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
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/list.th")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		// 게시판 처리했던 것처럼 BoardService를 레퍼런스 변수로 만들것임
		// 이 의미는 db에 두번 왔다갔다 하겠다 
		// 어떨 때 레퍼런스 변수로 만드는가? 여러번 왔다갔다 할 때. 코드 중복 줄이고 심플하게 하기 위함
		BoardService service = new BoardService();

		
		// 게시글 리스트 가져오기
		ArrayList<Board> bList = service.selectFList(1); // FList = FileList
		// 파일 리스트 가져오기
		ArrayList<Attachment> fList = service.selectFList(2); // 게시글 리스트 가져오기의 selectFList와 같은 메소드
		// 둘이 같은 메소드 호출이나 Generic의 반환타입이 다름
		// 하나는 vo board타입 일반게시판용, 하나는 vo Attachemnt 사진파일용
		
		System.out.println("bList="+bList); // [Board [boardId=98, boardType=2, category=공통, boardTitle=1, boardContent=1, boardWriter=1, nickName=김이박최나, boardCount=0, createDate=2022-05-10, modifyDate=2022-05-10, status=Y]]
		System.out.println("fList="+fList); // [Attachment [fileld=0, boardId=98, originName=null, changeName=2022051003420789643973.png, filePath=null, uploadDate=null, fileLevel=0, downloadeCount=0, status=null]]
		
		String page = null;
		if(bList != null && fList != null) {
			request.setAttribute("bList", bList); 
			request.setAttribute("fList", fList); 
			page = "WEB-INF/views/thumbnail/thumbnailList.jsp";
			
		} else {
			request.setAttribute("msg", "사진 게시판 조회에 실패했습니다");
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
