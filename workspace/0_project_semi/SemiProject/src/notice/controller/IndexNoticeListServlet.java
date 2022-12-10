package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import notice.model.service.MZNoticeService;
import notice.model.vo.MZNotice;

/**
 * Servlet implementation class IndexNoticeListServlet
 */
@WebServlet("/NoticeList.in")
public class IndexNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexNoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	      ArrayList<MZNotice> list = new MZNoticeService().selectList();
	         
	         System.out.println(list);

	      JSONArray listArr = new JSONArray();
	      JSONObject listObj = null;
	      for(MZNotice notice : list) {
	    	 Date date = notice.getNoticeDate();
	    	 
	    	 String ndate = notice.getNoticeDate().toString();
	    	 
	    	 System.out.println(ndate);
	    	 
	         listObj = new JSONObject();
	         listObj.put("listTitle", notice.getNoticeTitle());
	         listObj.put("listDate", ndate);
	         
	         System.out.println(listObj);
	         
	         listArr.add(listObj);
	         
	         
	      }
	      response.setContentType("application/json; charset=UTF-8");
	      response.getWriter().print(listArr);      
	      System.out.println(listArr);

			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
