package ajax.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ajax.model.vo.User;

/**
 * Servlet implementation class jQueryAjax5
 */
@WebServlet("/jQueryAjax5")
public class jQueryAjax7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jQueryAjax7() {
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
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// 유저 찾기 : 반복문+조건문
		User user = null;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserNo() == userNo) {
				user = userList.get(i);
			}	
		}
		
		JSONObject jobj = null;
		if(user != null) {
			jobj = new JSONObject(); 
			jobj.put("userNo",user.getUserNo());
			jobj.put("userName",user.getUserName());
			jobj.put("userNation",user.getUserNation());
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
