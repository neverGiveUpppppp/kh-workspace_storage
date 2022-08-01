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
@WebServlet("/jQuery6.do")
public class JQueryAjaxServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 원래는 userNo 정보를 받아오기 위해 db가서 가져와야하나, ajax배우는게 포인트라 간단하게 하기 위해 
		// 임시로 ArrayList로 임시데이터 추가시킴. db에 가져오는 효과가 있음
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1,"강건강","대한민국"));
		userList.add(new User(2,"타일러 라쉬","대한민국"));
		userList.add(new User(3,"쯔위","대한민국"));
		userList.add(new User(4,"모모","대한민국"));
		userList.add(new User(5,"리사","대한민국"));
		userList.add(new User(6,"김건모","대한민국"));
		userList.add(new User(7,"김건강","대한민국"));
		
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
	
		
		// 데이터가 없는 경우 전체 정보 가져오기
		
		// 방법1
//		User user = null;
//		for(int i = 0; i < userList.size(); i++) {
//			if(userList.get(i).getUserNo() == userNo) {
//				user = userList.get(i);
//			}
//		} // 아까는 객체 하나만 보내는거여서 괜찮지만 데이터가 복수면 다른 로직 써야하는가 아닌가요? 이 코드도 가능
		  // 데이터 수가 많지않아서 이렇게 써도 큰 문제는 없다
			// 데이터가 없는 경우 전체 정보 가져오는 거기에 userlist만 있어도 상관없다는 의미
		

		// 방법2
		User user = null;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserNo() == userNo) {
				user = userList.get(i);
			}
		}	
		
		
		
		// 뷰로 데이터 전송하기
		
//		// 방법1 : JSON Object 중첩방식
//		JSONObject userObj = new JSONObject(); // 제이슨오브제안에 또 다른 오브제 넣어서 중복 하거나 안하거나 했음
//		if(user != null) {
//			// user 1개 => 해당 user 전송
//			userObj.put("userNo",user.getUserNo());		// put()
//			userObj.put("userName", user.getUserName());
//			userObj.put("userNation", user.getUserNation());
//			
//		}else {
//			// user null => 전체 user 전송
//			// 강의 3:19 ==============
//			// ... 원시타입 말고도 객체,배열도 가능
//			// json object 안에 json object 들어갈 수 있을까? 가능
//			// 한사람 한사람 정보를 담을 json obj를 만들고 다시 이 전체 정보를 담을 json obj를 생성할 수 있다
//			for(int i = 0; i < userList.size(); i++) {
//				JSONObject obj = new JSONObject();	// 1명 데이터 담을 json 오브젝트 생성
//				obj.put("userNo",userList.get(i).getUserNo());		// put()
//				obj.put("userName", userList.get(i).getUserName());
//				obj.put("userNation", userList.get(i).getUserNation());
//				
//				userObj.put(i, obj); // user 1명 1명 모두의 json을 담을 json 객체
//			}
//			// Q. rset에서 while로 resultset값을 객체에 넣고 그 객체를  리스트에 넣는 원리랑 비슷한거죠?
//			//		객체를 리스트에 넣는게 obj를 obj에 넣는거로 바뀌는거 뺴고
//			// A. yes
//			
//		}
		
		// 방법2 : JSONArray 사용
		// ArrayList 비슷
		
		JSONArray userArr = new JSONArray(); // 멤버 객체 만들어놓고 리스트 담아 놓는 dao에서 했던거랑 비슷함
		JSONObject userObj = null;
		if(user != null) {
			userObj = new JSONObject();
			userObj.put("userNo",user.getUserNo());		// put()
			userObj.put("userName", user.getUserName());
			userObj.put("userNation", user.getUserNation());
			
			userArr.add(userObj); // 강의 5:08
		}else {
			for(User userInfo : userList) {
				userObj = new JSONObject();
				userObj = new JSONObject();
				userObj.put("userNo",userInfo.getUserNo());		   // put()
				userObj.put("userName", userInfo.getUserName());
				userObj.put("userNation", userInfo.getUserNation());
				
				userArr.add(userObj);
				
			}
		}
		
		
		
		response.setContentType("application/json; charset=UTF-8"); // 인코딩 & 데이터타입 객체 문제 해결방법
		// setCharacterEncoding처럼 setContentType도 보내기 전에만 세팅해주면 되서 순서는 상관x
//		PrintWriter pw = response.getWriter();
//		pw.print(userObj);
		
		// 방법1의 응답
//		response.getWriter().print(userObj);
		// 방법2의 응답
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
