package board.model.dao;

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

import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Reply;

public class BoardDAO {
	
	private Properties prop = new Properties();
	
	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public int getListCount(Connection conn) {
		Statement stmt = null;
		int result = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("getListCount"); 
		//getListCount의 쿼리문의 WHERE절의 BOARD_TYPE컬럼은 지금은 그냥 게시글이지만 
		//뒤에서 다룰 이미지 있는 게시글과 구별하기 위하여 타입을 나눴다 BOARD_TYPE을 제외한 나머지 컬럼은 공용으로 사용한다.
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
//				result = rset.getInt("count(*)");
				result = rset.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rset);
			close(stmt);
		}

		return result;
	}


	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<>();
		
		String query = prop.getProperty("selectList");
		
		int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1; //1, 11, 21, 31...
		// 현재 페이지에가 1이고 BoardLimit가 10개 라고 가정할 때  pi.getCurrentPage() -1) * pi.getBoardLimit() + 1; 을 해주면 
		// 결과 값으로 11이 도출되어 버린다. 즉, 1페이지를 보고 있을 때 게시글의 시작행이  11행이 되어버리는 셈이므로 연산을 할 때 식에서 pi.getCurrentPage()에서 -1을
		// 해주어야 0 * 10 + 1 의 식이 세워지기 때문에 내가 1페이지를 보고 있을 때 startRow가 1행이 된다. 
		
		int endRow = startRow + pi.getBoardLimit() - 1; //10, 20, 30 ...
		// BoardLimit가 10이라고 가정할 때 endRow를 도출하는법은 startRow에 pi.getBoardLimit()를 더하고 -1을 해주면 된다. 
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Board(rset.getInt("board_id"),
								   rset.getInt("board_type"),
								   rset.getString("cate_name"),
								   rset.getString("board_title"),
								   rset.getString("board_content"),
								   rset.getString("board_writer"),
								   rset.getString("nickname"),
								   rset.getInt("board_count"),
								   rset.getDate("create_date"),
								   rset.getDate("modify_date"),
								   rset.getString("status")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} close(rset);
		  close(pstmt);
		

		
		return list;
	}


	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, Integer.parseInt(b.getCategory()));
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());
			pstmt.setString(5, b.getBoardWriter());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		return result;
	}


	public ArrayList selectBList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectBList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("board_id"),
								   rset.getInt("board_type"),
								   rset.getString("cate_name"),
								   rset.getString("board_title"),
								   rset.getString("board_content"),
								   rset.getString("board_writer"),
								   rset.getString("nickname"),
								   rset.getInt("board_count"),
								   rset.getDate("create_date"),
								   rset.getDate("modify_date"),
								   rset.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}


	public ArrayList<Attachment> selectFList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectFList"); //게시글 안에 들어가는 이미지는 가져올 필요없이 썸네일만 가져오게 쿼리문 작성
		
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Attachment>();
			while(rset.next()) {
				Attachment a = new Attachment();
				a.setBoardId(rset.getInt("board_id"));
				a.setChangeName(rset.getString("change_name"));
				
				list.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}


	public int insertFile(Connection conn, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFile");
		
		try {//ArrayList<Attachment> fileList객체에는  많은 Attachment타입의 객체 들어 있을 수 있으므로 반복문으로 돌려준다.
			for(int i = 0; i < fileList.size(); i++) { 
				Attachment a = fileList.get(i);
				
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, a.getOriginName());
				pstmt.setString(2, a.getChangeName());
				pstmt.setString(3, a.getFilePath());
				pstmt.setInt(4, a.getFileLevel());
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	}
	
	public int updateCount(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public Board selectBoard(Connection conn, int bId) { //넘겨받은 클릭한 게시글번호에 해당하는 게시글의 DB를 반환한 ResultSet을  Board객체에 담아 넘겨준다.
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Board(rset.getInt("board_id"),
							   rset.getInt("board_type"),
							   rset.getString("cate_name"),
							   rset.getString("board_title"),
							   rset.getString("board_content"),
							   rset.getString("board_writer"),
							   rset.getString("nickname"),
							   rset.getInt("board_count"),
							   rset.getDate("create_date"),
							   rset.getDate("modify_date"),
							   rset.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}


	public ArrayList<Attachment> selectAttachment(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectFiles");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				
				Attachment a = new Attachment();
				
				a.setFildId(rset.getInt("file_id"));
				a.setOriginName(rset.getString("origin_name"));
				a.setChangeName(rset.getString("change_name"));
				a.setFilePath(rset.getString("file_path"));
				a.setUploadDate(rset.getDate("upload_date"));
				
				list.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	
		return list;
	}


	public int updateBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(board.getCategory()));
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, board.getBoardId());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int deleteBoard(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<Reply> selectReply(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Reply>();
			
			while(rset.next()) {
				list.add(new Reply(rset.getInt("REPLY_ID"), 
						rset.getString("REPLY_CONTENT"), 
						rset.getInt("REF_BID"),
						rset.getString("REPLY_WRITER"),
						rset.getString("NICKNAME"),
						rset.getDate("CREATE_DATE"),
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


	public int insertReply(Connection conn, Reply r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBoardId());
			pstmt.setString(3, r.getReplyWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
