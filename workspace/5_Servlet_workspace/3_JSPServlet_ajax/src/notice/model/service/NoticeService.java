package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import static common.JDBCTemplate.*; // static이랑 .* 필히. 


public class NoticeService {

	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDAO().selectList(conn);
		
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDAO().insertNotice(conn, n);

		
		// insert했기에 트랜잭션
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int no) {
		Connection conn = getConnection();
		
		// 조회수 카운트 업데이트
		int result = new NoticeDAO().updateCount(conn, no);
		
		
		
		// 공지사항 상세보기
		Notice not = null;
		if(result >0) {
			not = new NoticeDAO().selectNotice(conn, no); 
			commit(conn);
		}else {
			rollback(conn);
		}
//		Notice not = new NoticeDAO().selectNotice(conn, no); // 조회수 업데이트 코드 작성하면서 위의 코드로 변경
		
		close(conn);
		
		return not;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDAO().updateNotice(conn, n);
		
		// update했기에 트랜잭션
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn); // if문 트랜젝션보다 close가 아래여야 트랜잭션 작동
		
		return result;
	}

	public int deleteNotice(int no) {
		Connection conn = getConnection();
		int result = new NoticeDAO().deleteNotice(conn, no);
		
		// delete했기에 트랜잭션
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	

}



