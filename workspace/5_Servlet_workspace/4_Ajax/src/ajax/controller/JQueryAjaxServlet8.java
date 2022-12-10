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
@WebServlet("/jQuery8.do")
public class JQueryAjaxServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet8() {
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
		
		String userName = request.getParameter("userName");
		String[] names = userName.split(",");
		
		User user = null;
		JSONObject userObj = null; //user를 담을 jsonObj
		JSONObject userMap = new JSONObject(); //클라이언트로 보낼 맵형태의 객체
		
		for(String name : names) {
			for(int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getUserName().equals(name)) {
					user = userList.get(i);
					
					userObj = new JSONObject();
					userObj.put("userNo", user.getUserNo());
					userObj.put("userName", user.getUserName());
					userObj.put("userNation", user.getUserNation());
					
					// json배열이 아니라 jsonObject를 이용하여 key값은 "user-이름", value는 해당 회원정보 json객체
					userMap.put("user-"+name, userObj);
					//순서대로 조회가 되지 않는다고 이상한게 아니다! 왜냐하면 JSONObject도 Map처럼 내부적으로 Hash값으로 저장이 됨
					//그래서 내가 넣은 순서대로 들어갔다고 할 수 없음 !! 
				}
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(userMap);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
