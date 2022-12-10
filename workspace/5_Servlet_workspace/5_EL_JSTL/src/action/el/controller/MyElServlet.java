package action.el.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.model.vo.Person;

/**
 * Servlet implementation class MyElServlet
 */
@WebServlet("/myEL.do")
public class MyElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyElServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 01_1_EL.jsp에서 가져올 값 : 이름 성별 나이 음료 물건123 책 영화
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		
		Person p = new Person(name, gender, age);
		
		String beverage = request.getParameter("beverage");
		String products[] = request.getParameterValues("product"); // 받아오는 값이 3개니  배열로 받아오는 getParameterValues()
		String book = request.getParameter("book");
		String movie = request.getParameter("movie");
		
		
		request.setAttribute("person", p); // person 이름을 p객체에 담아준다
		request.setAttribute("beverage", beverage); 
		request.setAttribute("products", products); 
		request.setAttribute("year", 2022); 
		
		
		
		// book은 세션 영역에 넣고, movie는 어플리케이션 영역에 넣을 것임
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		session.setAttribute("beverage", "물");
		
		ServletContext application = request.getServletContext();
		application.setAttribute("movie", movie);
		application.setAttribute("beverage", "포카리");
		
		request.getRequestDispatcher("/02_el/01_2_elEnd.jsp").forward(request,response);
		
		// getParameter : 뷰에서 보낸 데이터를 리퀘스트를 통해 가지고 오는 역할 
		// getAttribute : 세션이나 어플 같은 경우 영역에 대해서 가지고 오는 것
		
		// 파이널 전에 실전대비면접도 들어갈 것임
		
		// 개발 관련 질문하는 방법 
		// 질문의 서론 : 현재는 뭘 하고있고, 뭘 알고 싶은데, 이걸 고치기 위해 무슨 시도들을 해봤는지
		// 잘못된 질문 : 코드 안써보고 이거 될까요? 써보고 되는지 안되는지 스스로 파악해야함
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
