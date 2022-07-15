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
 * Servlet implementation class JQueryAjaxServlet6
 */
@WebServlet("/jQuery7.do")
public class JQueryAjaxServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1, "강건강", "대한민국"));
		userList.add(new User(2, "타일러 라쉬", "미국"));
		userList.add(new User(3, "쯔위", "중국"));
		userList.add(new User(4, "모모", "일본"));
		userList.add(new User(5, "리사", "태국"));
		userList.add(new User(6, "알베르토 몬디", "이탈리아"));
		userList.add(new User(7, "조나단", "콩고"));
		
		//전달 받은 번호 문자열을 ','기준으로 배열로 저장
		String userNo = request.getParameter("userNo");
		String[] ids = userNo.split(",");
		
		//클라이언트로 전달할 JSONObject들을 담을 JSONArray 객체
		JSONArray userArr = new JSONArray();
		
		for(String id : ids) {
			for(int i = 0; i < userList.size(); i++) {
				if(Integer.parseInt(id) == userList.get(i).getUserNo()) {
					User user = userList.get(i);
					
					JSONObject userObj = new JSONObject();
					userObj.put("userNo", user.getUserNo());
					userObj.put("userName", user.getUserName());
					userObj.put("userNation", user.getUserNation());
					
					userArr.add(userObj);
				}
			}
		}
		
		// Servlet6에서는 userArray를 바로 보냈지만 여기서는 userArray를 JSONObject에 key값과 매칭해서 보내겠다!
		JSONObject result = new JSONObject();
		result.put("list", userArr);
		
		response.setContentType("application/json; charset=utf-8"); 
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
