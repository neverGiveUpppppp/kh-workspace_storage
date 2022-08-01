package board.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.MZBoard;
import member.model.vo.Member;



/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/insert.no")  
// /boardInsert.bo
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");	  
		String date = request.getParameter("date");		  
		String content = request.getParameter("content"); 
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
	
		Date dat = null;
		
		if(date.equals("")) { // Date dat 값이 비어 있는지 if조건
			// 작성자가 시간 설정 안하면 현재 시간이 나오게끔 GregorianCalendar()로 현재시간 표시
			dat = new Date(new GregorianCalendar().getTimeInMillis()); 
		}else {
			// jsp에서 받아온 날짜 데이터인 date는 대쉬가 들어간 상태로 올거기에 대쉬(-) 기준으로 split
			String[] dateArr = date.split("-");
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1])-1;
			int day = Integer.parseInt(dateArr[2]);
			// 월(month)만 zero-base : 0부터 시작
		
			// date의 날짜데이터를 split("-")로 조개서 각각 int year, int month, int day 받은 것을 하나의 객체에 다시 저장 
			dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			
		}
		
		MZBoard b = new MZBoard();
		b.setBoardTitle(title);		
		b.setBoardDate(dat);		
		b.setBoardContent(content);	
		b.setUserId(userId);		
			
		int result = new BoardService().insertBoard(b); 
		
		if(result > 0) {
			response.sendRedirect("boardWriteForm.jsp"); // "/board2Ch.bo"
		} else {
			request.setAttribute("msg", "글쓰기 등록에 실패하였습니다.");
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
