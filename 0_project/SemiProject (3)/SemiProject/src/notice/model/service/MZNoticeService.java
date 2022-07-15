package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import notice.model.dao.MZNoticeDAO;
import notice.model.vo.MZNotice;

public class MZNoticeService {

	public ArrayList<MZNotice> selectList() {
		Connection conn = getConnection();
		
		ArrayList<MZNotice> list = new MZNoticeDAO().selectList(conn);
		
		close(conn);
		
		return list;
	}

	public int insertNotice(MZNotice n) {
		Connection conn = getConnection();
		
		int result = new MZNoticeDAO().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		
		return result;
	}

	public MZNotice detailNotice(int no) {
		Connection conn = getConnection();
		int result = new MZNoticeDAO().checkCount(conn, no);
		
		MZNotice mnotice = null;
		
		if(result > 0) {
		mnotice = new MZNoticeDAO().detailNotice(conn, no);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return mnotice;
	}

	public int updateNotice(MZNotice n) {
		Connection conn = getConnection();
		
		int result = new MZNoticeDAO().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteNotice(int no) {
		Connection conn = getConnection();
		
		int result = new MZNoticeDAO().deleteNotice(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}








}
