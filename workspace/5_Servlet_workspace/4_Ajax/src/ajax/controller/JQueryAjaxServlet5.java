package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ajax.model.vo.User;

/**
 * Servlet implementation class JQueryAjaxServlet5
 */
@WebServlet("/jQuery5.do")
public class JQueryAjaxServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet5() {
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
		
		// 유저 찾을려면 반복문+조건문 필요
		User user = null;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserNo() == userNo) { // userList에 있는 전체 List 정보 중 
			// 1번째 유저의userNo의 정보를 가져와서 이게 userNo의 숫자랑 같으면 해당 객체의 정보를 user에 집어 넣어라  
				user = userList.get(i);	// user에 1번 유저 전체의 정보 담음
			}
		}
		
		// 찾은 유저 정보를 response해서 클라이언트에게 데이터를 보내기
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.print(user);
		// 서버에서 클라이언트로 보낼 데이터 존재o
		// 뷰에서 데이터 받아줘야함 
		// 서버에서 보낸 데이터를 뷰에서 받아와야하면 success,error 함수의 매개변수에 data 넣어줘야함
		// 서버에서 받아올 데이터 유무를 생각하고 쓰지는 않아서 매번 data를 써넣어도 됨. data 매개변수를 활용하지 않으면 그만이기떄문
		
		// PrintWriter의 한계
		// 뷰에서 받은 결과값 : User [userNo=1, userName=강건강, userNation=대한민국]
		// model.vo에서 적은 오버라이딩 toString의 폼으로 받아옴. 데이터처리가 엄청 힘들어져서 잘못된 방법임
		// 해결 : JSON
		
		JSONObject userObj = null; // 라이브러리 클래스라 라이브러리 필요. JSON simple 라이브러리 설치
		
		if(user != null) {
			userObj = new JSONObject();
			userObj.put("userNo",user.getUserNo());		// put()
			userObj.put("userName", user.getUserName());
			userObj.put("userNation", user.getUserNation());
			// user 객체 자체를 str으로 보낼려던거 안됬었음
			// json을 보내는거는 가능해서  user정보를 키와 밸류로 json에 담는 중임
			// json에 user객체 정보 담아서 뷰로 보낸다
			
		}
		
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8"); // 인코딩 & 데이터타입 객체 문제 해결방법
		PrintWriter pw = response.getWriter();
		pw.print(userObj);	// {"userNation":"????","userNo":1,"userName":"???"} <- Map이어서 순서x 
		// set 순서, 중복 x
		// map도 set 따라서 순서 x

		
		// 문제 2가지
		// 1) 글씨 깨짐 -> 인코딩 필요
		// 2) 뷰에서 받은 데이터가 객체가 아닌 str임. 개발자툴 콘솔보면 객체면 줄줄이 뭐가 많이 나오고 화살표표시가 있음
		// 뷰에서 typeof 찍어서 str 확인 가능
		// 문제 해결
		// response.setCharacterEncoding("UTF-8");써도 되지만 문제1,2를 한꺼번에 해결하는 방법
		// 해결방법 : response.setContentType("application/json; charset=UTF-8");
		// <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>에서
		// contentType="text/html"이여서 뭘로 보내도 이 옵션 때문에 str타입으로 가게 됬던 것
		
		
	    // Q. page지시자에서 charset이 UTF-8인데 왜 글씨가 깨져서 response.setCharacterEncoding은 왜 필요했던건가요?
		// A. page지시자 세팅은 뷰를 그렇게 하겠다는거니 넘기는 데이터까지 처리하는게 아니기 때문
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
