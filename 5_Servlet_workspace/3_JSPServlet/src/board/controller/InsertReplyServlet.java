package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import board.model.service.BoardService;
import member.model.vo.Reply;

/**
 * Servlet implementation class InsertReplyServlet
 */
@WebServlet("/insertReply.bo")
public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    // 댓글 쓰기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 강의 4:26
		// post 보내줬으나 필터해줘서 인코딩 필요x
		// 응답 받아줄 때는 json으로 받는다 해도 깨져서 넘어온거를 원복시킬 수는 없음. 애초에 응답이라 json 필요x
		// 리스폰스에서 응답할 때 인코딩 하는 것
		String writer = request.getParameter("writer");
		int bId = Integer.parseInt(request.getParameter("bId"));
		String content = request.getParameter("content");
	
		Reply r = new Reply();
		r.setRefBoardId(bId);
		r.setReplyWriter(writer);
		r.setReplyContent(content);
		
		
		// 받아온 값을 뷰에 뿌리기 위해 Arraylist 사용
		// 어레이리스트 사용이유 
		// 4:35 강의
		ArrayList<Reply> list = new BoardService().insertReply(r);
		
		// 받은 걸 뷰로 뿌려줄려면 
		// json array
		// json object = null
		// reply r = "";
		// new json object
		// obj.  r.get replyId
//		ojb.get replyContent
//		nickname
//		creat_date
//		modify_date
//		최종적으로 제이슨 어레이에 집어 넣기
//		첫번째 댓글 추가
//		두번째 댓글 추가 ...bId
//		
//		여러 댓글을 프린트라이터를 뷰로 보내주면 됨
//		그냥 프린라이터로 보내면 인코딩 깨져서
//		setcontentType써서 json방식이랑 인코딩 설정
		response.setContentType("application/json; charset=UTF-8");
//		Gson gson = new Gson();
//		gson.toJson(list, response.getWriter()); // 매개변수(어떤 데이터를 보낼건지,누구를 통해서 보낼 것이냐)
		// 현재까지 댓글 추가되나 새로고침 해야 작성된게 보이는 상태
		// 콘솔 확인하면 댓글이 배열 안에 객체로 담겨져 있음.
		
		// 문제 발생 : 날짜 형식 이상
		// gson에서 쓰는 기본적인 날짜 형태가 이렇다
		// 새로고침하면 2022-05-17 다시 이렇게 바뀜
		// 작성하자마자 날짜형식 원하는 데로 2022-05-17 이렇게 나오게 만듦 
		GsonBuilder gb = new GsonBuilder();
		GsonBuilder dateGb = gb.setDateFormat("yyyy-MM-dd"); // 데이터 원하는 형식으로 바꿔주는 메소드
		Gson gson = dateGb.create(); // 생성
		gson.toJson(list, response.getWriter());
		
		// 한줄 코드로 쓰기 : method chaining
//		new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
