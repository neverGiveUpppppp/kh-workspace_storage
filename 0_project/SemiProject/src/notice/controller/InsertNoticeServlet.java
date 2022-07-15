package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.MZNoticeService;
import notice.model.vo.MZNotice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert.no1")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String date = request.getParameter("date");
		String writer = request.getParameter("writer");
		
		Date ndate = null;

		if(date.equals("")) {
			ndate = new Date(new GregorianCalendar().getTimeInMillis());
		} else {
			String[] dateArr = date.split("-");
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1])-1;
			int day = Integer.parseInt(dateArr[2]);
			
			ndate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());		
		}
		
		MZNotice no = new MZNotice();
		no.setNoticeTitle(title);
		no.setNoticeContent(content);
		no.setNoticeDate(ndate);
		no.setNoticeWriter(writer);
		
		int result = new MZNoticeService().insertNotice(no);
		
		if(result > 0) {
			response.sendRedirect("list.no");
		} else {
			request.setAttribute("msg", "공지사항 작성에 실패하였습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/ePage.jsp").forward(request, response);
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
