package board.model.dao;
import static common.MZTemplate.close;

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

import board.model.vo.MZBoard;
import board.model.vo.Pagination;


public class BoardDAO {

	Properties prop = new Properties();
	
	// 외부 파일 경로지정
	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName)); // load
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	// 페이징 처리 : 1st 게시판 불러오기
	public int getBoardCount(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("getBoardCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	
	
	
	
	
	// 페이징 처리 : 2nd 불러온 전체 게시판 중 필요한 일부만 가져오기
	public ArrayList<MZBoard> selectList(Connection conn, Pagination pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MZBoard> list = new ArrayList<>();
		
		String query = prop.getProperty("selectList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;  
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new MZBoard(rset.getInt("BOARD_NO"),
						   rset.getInt("BOARD_TYPE"),
						   rset.getString("BOARD_TITLE"),
						   rset.getInt("REF_RESTAURANT_NO"),
						   rset.getString("RESTAURANT_NAME"),
						   rset.getString("RESTAURANT_ADDRESS"),
						   rset.getString("RESTAURANT_PHONE"),
						   rset.getString("RESTAURANT_INTRO"),
						   rset.getString("RESTAURANT_CONTENT"),
						   rset.getInt("REF_FOOD_NO"),
						   rset.getString("FOOD_NAME"),
						   rset.getString("FOOD_TYPE"),
						   rset.getString("REF_USER_ID"),
						   rset.getInt("BOARD_COUNT"),
						   rset.getString("BOARD_CONTENT"),
						   rset.getDate("BOARD_DATE"),
						   rset.getDate("MODIFY_DATE"),
						   rset.getString("STATUS")));
	}
		} catch (SQLException e) {
	 		e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

		
		
		
		// 게시판 조회
		public MZBoard selectBoard(Connection conn, int num) {

			PreparedStatement pstmt = null;
			ResultSet rset = null;
			MZBoard boardNum = null;
			
			String query = prop.getProperty("selectBoard"); 
			// selectNotice=SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, NICKNAME, NOTICE_COUNT, NOTICE_DATE, NOTICE.STATUS FROM NOTICE JOIN MEMBER ON(NOTICE_WRITER = USER_ID) WHERE NOTICE.STATUS = 'Y' AND NOTICE_NO = ?
			
			System.out.println("num="+num);
			System.out.println("str query="+query);
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, num);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					boardNum = new MZBoard(rset.getInt("BOARD_NO"),
							   rset.getInt("BOARD_TYPE"),
							   rset.getString("BOARD_TITLE"),
							   rset.getInt("REF_RESTAURANT_NO"),
							   rset.getString("RESTAURANT_NAME"),
							   rset.getString("RESTAURANT_ADDRESS"),
							   rset.getString("RESTAURANT_PHONE"),
							   rset.getString("RESTAURANT_INTRO"),
							   rset.getString("RESTAURANT_CONTENT"),
							   rset.getInt("REF_FOOD_NO"),
							   rset.getString("FOOD_NAME"),
							   rset.getString("FOOD_TYPE"),
							   rset.getString("REF_USER_ID"),
							   rset.getInt("BOARD_COUNT"),
							   rset.getString("BOARD_CONTENT"),
							   rset.getDate("BOARD_DATE"),
							   rset.getDate("MODIFY_DATE"),
							   rset.getString("STATUS"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);
			}
			System.out.println("boardNum="+boardNum);
			return boardNum;
		}

		
		
		// 조회수 카운트 업데이트
		public int updateCount(Connection conn, int num) {

			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = prop.getProperty("updateCount"); 
			// updateCount=UPDATE NOTICE SET NOTICE_COUNT = NOTICE_COUNT + 1 WHERE NOTICE_NO = ?
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, num);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}


		public int insertBoard(Connection conn, MZBoard b) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = prop.getProperty("insertBoard");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, b.getBoardTitle());
				pstmt.setString(2, b.getUserId());
				pstmt.setString(3, b.getBoardContent());
				pstmt.setDate(4, b.getBoardDate());
				// 쿼리문
				// insertNotice=INSERT INTO NOTICE VALUES(SEQ_NNO.NEXTVAL, ?, ?, ?, DEFAULT, ?, DEFAULT)
				// 최신 글이 올라가게 해주고 싶다면 쿼리문 끝에 ORDER BY  NOTICE_NO DESC 강의시간5:48
				
				result = pstmt.executeUpdate();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
	
	
	
	
}
