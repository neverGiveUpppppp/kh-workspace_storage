package ajax.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ajax.model.vo.User;

/**
 * Servlet implementation class JQueryAjaxServlet7
 */
@WebServlet("/jQuery10.do")
public class JQueryAjaxServlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1,"강건강","대한민국"));
		userList.add(new User(2,"타일러 라쉬","대한민국"));
		userList.add(new User(3,"쯔위","대한민국"));
		userList.add(new User(4,"모모","대한민국"));
		userList.add(new User(5,"리사","대한민국"));
		userList.add(new User(6,"김건모","대한민국"));
		userList.add(new User(7,"김건강","대한민국"));
		
		
		JSONArray userArr = new JSONArray();
		JSONObject userObj = null;
		
		for(User user : userList) {
			userObj = new JSONObject();
			userObj.put("userNo",user.getUserNo());		// put()
			userObj.put("userName", user.getUserName());
			userObj.put("userNation", user.getUserNation());
			
			userArr.add(userObj); 
		}
		
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(userArr);
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
