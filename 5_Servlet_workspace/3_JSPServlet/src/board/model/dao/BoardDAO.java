package board.model.dao;

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

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import board.model.vo.Attachment;
import board.model.vo.Board;
import static common.JDBCTemplate.*;
import board.model.vo.PageInfo;
import member.model.vo.Reply;

public class BoardDAO {

	// 외부파일 로드용 클래스 Properties 선언
	Properties prop = new Properties();
	
	// 외부 파일 경로지정
	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName)); // load
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getListCount(Connection conn) {
		
		// 쿼리문 SELECT * 사용
		// SELECT COUNT(*) FROM BOARD WHERE STATUS = 'Y' AND BOARD_TYPE = 1
		
		// 쿼리문 select + count 사용
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("getListCount");
		
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
	
	
	
	// 전체 게시물 중 필요한 일부만 가져오기
	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {


		
		// 페이징 처리된 게시물 가져오기
		//전체가 아닌 필요한 일부만 가져와야함
		
		// 1.게시판에 들어갈 게시물에 필요한 것 select (가지고 오기 위해 필요한 것 모두 적어보자)
//		SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, B.MODIFY_DATE, B.STATUS
//		FROM BOARD B
//			JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//			JOIN CATEGORY USING(CATE_ID);
//		WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//		ORDER BY BOARD_ID DESC; // 최근꺼 나오게 정렬
		// 여기까지 필요한거 다나오게함
		
		
		// 2. 위에서 최근 10개의 게시물 가져오기
		// 위의 값이 인라인뷰로 들어가면 됨
//		SELECT *
//		FROM (SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, b.MODIFY_DATE, b.STATUS
//		FROM BOARD b
//		    JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//		    JOIN CATEGORY USING(CATE_ID)
//		WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//		ORDER BY BOARD_ID DESC)
//		WHERE ROWNUM <= 10; // 조회수 10개나옴
		
//		WHERE ROWNUM <= 20 AND ROWNUM >= 11; 
//		ROWNUM은 ~이하는 먹는데 이상 이하 같은 조건은 작동X
//		ROWNUM을 안쓰면 간단하게 해결 가능

		
		// 3. M이상 N이하에 있는 게시물 가져오기
//		SELECT *
//		FROM(SELECT ROWNUM RNUM, DESCBOARD.* -- 아스트로라고만 하면 에러남. 별칭 꼭 .찍어서 명시해줄 것
//		FROM (SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, b.MODIFY_DATE, b.STATUS
//		    FROM BOARD b
//		        JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//		        JOIN CATEGORY USING(CATE_ID )
//		    WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//		    ORDER BY BOARD_ID DESC) DESCBOARD)
//		WHERE ROWNUM <= 20 AND RNUM >= 11; -- ROWNUM의 별칭 RNUM이 ROWNUM 대체 안되는 이유 : SELECT보다 WHERE가 먼저 읽히기 때문
//		                                -- 이렇기 때문에 한번 더 SELECT로 또 인라인뷰를 넣어주면 됨
//		-- 강의시간 3:06
//		-- 20이랑 11의 숫자만 위치홀더로 바꿔서 자바코드에 넣으면 됨
//		-- 코드가 길어서 심플하게 해보자
		
		
		// 4.VIEW 활용한 심플화된 코드
//		 뷰를 사용할려면 먼저 권한부여가 필요
//		 인라인뷰 한번 사용하고 뷰를 이용한 코드
//		GRANT CREATE VIEW TO JSP_Servlet; -- 시스템계정으로 가서 권한부여
//		CREATE OR REPLACE VIEW BLIST
//		AS
//		SELECT ROWNUM RNUM, DESCBOARD.*
//		FROM (SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, b.MODIFY_DATE, b.STATUS
//		    FROM BOARD b
//		        JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//		        JOIN CATEGORY USING(CATE_ID )
//		    WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//		    ORDER BY BOARD_ID DESC) DESCBOARD;
//
//		SELECT * FROM BLIST
//		WHERE ROWNUM <= 11 AND RNUM <= 20;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<>();
		
		
		String query = prop.getProperty("selectList");
		
//		cp(currentPage) 1 1~10
//						2 11~20
//						3 21~30
//					startRow endRow	
		
		
//		int startRow = pi.getCurrentPage() * pi.getBoardLimit(); // startRow가 1 11 21
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; // 위에서 추가로... 강의 3:39 // 1일 때 1 2일때 11 3일 때 21 나와야함. cpx10 1일 때 10 2일때는 20 3일 때는 30의 스타트로우가 발생할 것임. cp자체에다가 -1먼저 해주게 되면 1이 아니라 0 2가 아니라 1 3이 아니라 2가 들어가게 됨. 곱하기 10을 하는 것도 0 10 20이 들어가게됨 여기에 마지막에 +1만 하면 1 11이 나옴 
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		
		
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
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	
	
	
	// 조회 : 보드 게시판
	public ArrayList selectBList(Connection conn) {
		
			Statement stmt = null;
			ResultSet rset = null;
			ArrayList<Board> list = null;
			
			String query = prop.getProperty("selectBList");
			
		// 10:14 강의시간 코드 작성 방식 뭘로할지 고민중
		
		// 쿼리문
		// 쿼리문 :기존 selectList 쿼리문을 사용해도 되나 분리
		// 보드, 카테고리, 멤버 테이블 조인
		// SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, 
		//    NICKNAME, BOARD_COUNT, CREATE_DATE, B.MODIFY_DATE, B.STATUS 
		// FROM BOARD B
		//        JOIN MEMBER ON(USER_ID = BOARD_WRITER)
		//        JOIN CATEGORY USING(CATE_ID)
		// WHERE B.STATUS = 'Y' AND BOARD_TYPE = 2;	
		
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
	
	
	
	// 조회 : 사진 게시판
	public ArrayList selectFList(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectFList");
		// SELECT * FROM ATTACHMENT WHERE STATUS='Y' AND FILE_LEVEL = 0

		// Q. ....? 10:38 강의시간
		// 리스트에 보일 사진들만 가져오면 되니 그래서 파일레벨은 0
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Attachment>();
			while(rset.next()) {
				Attachment a = new Attachment();
				a.setBoardId(rset.getInt("BOARD_ID"));
				a.setChangeName(rset.getString("CHANGE_NAME"));
				// Attachment 세팅 2가지
//				어떤 사진이 들어가야하는지 알아야하니 보드아이디 
//				사진 변경 파일명, 불러와서 써야하니 어떤 이름으로 들어가있었는지 어떻게 바꼈는지 알 수 있게 체인지네임 집어넣어서 사용할 것임
//				강의내용10:40 대강 다 이해하고 적긴했는데 확인사살 필요
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

	
	
	
	
	// insertFile
	public int insertFile(Connection conn, ArrayList<Attachment> fileList) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		String query = prop.getProperty("insertFile");
//		
//		
//		try {
//			
//			// fileList 값이 많아서 for문 돌림
//			for(int i = 0; i < fileList.size(); i++) {
//				Attachment a = fileList.get(i);
//				pstmt = conn.prepareStatement(query);
//				pstmt.setString(1, a.getOriginName());
//				pstmt.setString(2, a.getChangeName());
//				pstmt.setString(3, a.getFilePath());
//				pstmt.setInt(4, a.getFileLevel());
//				
//				result += pstmt.executeUpdate();
//			}
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFile");
		// INSERT INTO ATTACHMENT VALUES(SEQ_FID.NEXTVAL, SEQ_BID.CURRVAL, ?, ?, ?, SYSDATE, ?, DEFAULT)
		
		
		// fileList 값이 많아서 for문 돌림
		try {
			for (int i = 0; i < fileList.size(); i++) {
				Attachment a = fileList.get(i);
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, a.getOriginName());
				pstmt.setString(2, a.getChangeName ());
				pstmt.setString(3, a.getFilePath());
				pstmt.setInt(4, a.getFileLevel());
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	
	// insertBoard
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

	
	
	public Board selectBoard(Connection conn, int bId) {

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
	
	
	
	public ArrayList<Attachment> selectFiles(Connection conn, int bId) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectFiles");
		// selectFiles=SELECT * FROM ATTACHMENT WHERE BOARD_ID = ? AND STATUS = 'Y' ORDER BY FILE_ID
		// 내용 전체를 다 가져올거라 파일레벨 설정 필요X
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				Attachment a = new Attachment();
				a.setFileId(rset.getInt("FILE_ID"));
				a.setOriginName(rset.getString("ORIGIN_NAME"));
				a.setChangeName (rset.getString("CHANGE_NAME"));
				a.setFilePath(rset.getString("FILE_PATH"));
				a.setUploadDate(rset.getDate("UPLOAD_DATE"));

				list.add(a);
			}
			
				
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
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
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, Integer.parseInt(board.getCategory()));
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

	public ArrayList<Reply> selectReplyList(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> list = null;
		
		String query = prop.getProperty("selectReplyList"); 
		// 댓글은 사진,일반 게시판 둘 다 달 수 있어야할테니 boardtype 지정 필요x
		// REF_BID : 어떤 게시글에 포함되어 있는 댓글을 의미. ex)13번째 게시판에 달려있는 댓글
		// 다른 방법 쿼리문 설명 : 강의 3:28
		// select * from rlist where ref_bid = 8; 이런식으로 조회하게 될 것임(?)
		
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
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
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






