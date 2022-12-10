package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import member.model.vo.Reply;

import static common.JDBCTemplate.*; // static이랑 .* 필히. 


public class BoardService {

	public int getListCount() {

		Connection conn = getConnection();
		
		int listCount = new BoardDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList selectList(PageInfo pi) {

		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDAO().selectList(conn, pi); 
		
		close(conn);
				
		return list;
	}
	

	
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int updateCount(int bId) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateCount(conn, bId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	

	public ArrayList selectFList(int i) { // 반환타입 제네릭 부분 삭제. 이 메소드를 2번 호출할껀데 각각 반환타입이 다르기에 제네릭만 삭제

		Connection conn = getConnection();
		BoardDAO dao = new BoardDAO(); 		// 두번 왔다갔다 할거라 객체선언
		ArrayList list = null; 
		
		if(i==1) {
			list = dao.selectBList(conn); // 1이면 보드리스트를 가져와라
		}else {
			list = dao.selectFList(conn); // 1이 아니면(2이면) 파일리스트를 가져와라 
		}
		
		close(conn);
				
		return list;
	}

	public int insertFile(Board b, ArrayList<Attachment> fileList) {

		Connection conn = getConnection();
		BoardDAO dao = new BoardDAO(); 		// 두번 왔다갔다 할거라 객체선언

		int result1 = dao.insertBoard(conn, b);
		int result2 = dao.insertFile(conn, fileList);
		
		// 트랜잭션
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 + result2;
	}
	
	
	
	

	public Board selectBoard(int bId) {
		Connection conn = getConnection();
		BoardDAO dao = new BoardDAO(); 		// 두번 왔다갔다 할거라 객체선언

		int result = new BoardDAO().updateCount(conn, bId);
		Board board = null;
		
		if(result > 0) {
			board = new BoardDAO().selectBoard(conn, bId);
			commit(conn);
		}else {
			rollback(conn);
		}
//		int board = new BoardDAO().selectBoard(conn, bId);
		
		close(conn);
		
		return board;
	}

	
	

	public ArrayList<Attachment> selectFile(int bId) {

		Connection conn = getConnection();
		ArrayList<Attachment> list = new BoardDAO().selectFiles(conn,bId);
		close(conn);
		
		
		return list;
	}


	public int updateBoard(Board board) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	

	public int deleteBoard(int bId) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().deleteBoard(conn, bId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	// 댓글 리스트 전체 불러오기
	public ArrayList<Reply> selectReplyList(int bId) {
		
		Connection conn = getConnection();
		// BoardDAO dao = new BoardDAO(); 		// 댓글 수정삭제는 수업 진행 안할거기에 기능 만들려면 두번왔따갔다 필요한 객체 선언하면 됨

		ArrayList<Reply> list = new BoardDAO().selectReplyList(conn, bId);
		
		close(conn);
		
		return list;
		
	}

	public ArrayList<Reply> insertReply(Reply r) {
		Connection conn = getConnection();
		BoardDAO dao = new BoardDAO(); 		// 두번 왔다갔다 할거라 객체선언

		int result = dao.insertReply(conn, r);
		ArrayList<Reply> list = null;
		
		if(result > 0) {
			commit(conn);
			list = dao.selectReplyList(conn, r.getRefBoardId());
		}else {
			rollback(conn);
		}
		
		close(conn);
		return list;
	}

	
	
	
}








