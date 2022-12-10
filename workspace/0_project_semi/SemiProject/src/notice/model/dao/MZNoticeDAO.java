package notice.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import notice.model.vo.MZNotice;

public class MZNoticeDAO {

	private Properties prop = new Properties();
	
	public MZNoticeDAO() {
		String fileName = MZNoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MZNotice> selectList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MZNotice> list = new ArrayList<MZNotice>();
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) { 
				list.add(new MZNotice(rset.getInt("NOTICE_NO"),
									  rset.getString("NOTICE_TITLE"),
									  rset.getString("NOTICE_CONTENT"),
									  rset.getString("NOTICE_WRITER"),
									  rset.getInt("NOTICE_COUNT"),
									  rset.getDate("NOTICE_DATE"),
									  rset.getString("STATUS")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

	public int insertNotice(Connection conn, MZNotice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getNoticeWriter());
			pstmt.setDate(4, n.getNoticeDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public MZNotice detailNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MZNotice mnotice = null;
		
		String query = prop.getProperty("detailNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mnotice = new MZNotice(rset.getInt("NOTICE_NO"),
									   rset.getString("NOTICE_TITLE"),
									   rset.getString("NOTICE_CONTENT"),
									   rset.getString("NOTICE_WRITER"),
									   rset.getInt("NOTICE_COUNT"),
									   rset.getDate("NOTICE_DATE"),
									   rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mnotice;
	}

	public int checkCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("chekcCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateNotice(Connection conn, MZNotice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setDate(3, n.getNoticeDate());
			pstmt.setInt(4, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
	
		
		return result;
	}

//	public int getListCount(Connection conn) {
//		Statement stmt = null;
//		ResultSet rset = null;
//		int result = 0;
//		
//		String query = prop.getProperty("getListCount");
//		
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
//			
//			if(rset.next()) {
//				result = rset.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(stmt);
//		}
//		
//		return result;
//	}


}
