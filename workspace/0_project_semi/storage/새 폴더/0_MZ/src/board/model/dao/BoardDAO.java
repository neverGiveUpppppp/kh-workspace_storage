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

	public int getBoardCount(Connection conn) {
		
		// 쿼리문 SELECT * 사용
		// SELECT COUNT(*) FROM BOARD WHERE STATUS = 'Y' AND BOARD_TYPE = 1
		
		// 쿼리문 select + count 사용
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
		System.out.println("dap = "+result);
		return result;
	}
	
	// 전체 게시물 중 필요한 일부만 가져오기
		public ArrayList<MZBoard> selectList(Connection conn, Pagination pi) {


			
			// 페이징 처리된 게시물 가져오기
			//전체가 아닌 필요한 일부만 가져와야함
			
			// 1.게시판에 들어갈 게시물에 필요한 것 select (가지고 오기 위해 필요한 것 모두 적어보자)
//			SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, B.MODIFY_DATE, B.STATUS
//			FROM BOARD B
//				JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//				JOIN CATEGORY USING(CATE_ID);
//			WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//			ORDER BY BOARD_ID DESC; // 최근꺼 나오게 정렬
			// 여기까지 필요한거 다나오게함
			
			
			// 2. 위에서 최근 10개의 게시물 가져오기
			// 위의 값이 인라인뷰로 들어가면 됨
//			SELECT *
//			FROM (SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, b.MODIFY_DATE, b.STATUS
//				FROM BOARD b
//			    JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//			    JOIN CATEGORY USING(CATE_ID)
//				WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//				ORDER BY BOARD_ID DESC)
//			WHERE ROWNUM <= 10; // 조회수 10개나옴
			
//			WHERE ROWNUM <= 20 AND ROWNUM >= 11; 
//			ROWNUM은 ~이하는 먹는데 이상 이하 같은 조건은 작동X
//			ROWNUM을 안쓰면 간단하게 해결 가능

			
			// 3. M이상 N이하에 있는 게시물 가져오기
//			SELECT *
//			FROM(SELECT ROWNUM RNUM, DESCBOARD.* -- 아스트로라고만 하면 에러남. 별칭 꼭 .찍어서 명시해줄 것
//				 FROM (SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, b.MODIFY_DATE, b.STATUS
//			    	   FROM BOARD b
//			        		JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//			       			JOIN CATEGORY USING(CATE_ID)
//				       WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//				    ORDER BY BOARD_ID DESC) 
//				DESCBOARD)
//			WHERE ROWNUM <= 20 AND RNUM >= 11; -- ROWNUM의 별칭 RNUM이 ROWNUM 대체 안되는 이유 : SELECT보다 WHERE가 먼저 읽히기 때문
//			                                -- 이렇기 때문에 한번 더 SELECT로 또 인라인뷰를 넣어주면 됨
//			-- 강의시간 3:06
//			-- 20이랑 11의 숫자만 위치홀더로 바꿔서 자바코드에 넣으면 됨
//			-- 코드가 길어서 심플하게 해보자
			
			
			// 4.VIEW 활용한 심플화된 코드
//			 뷰를 사용할려면 먼저 권한부여가 필요
//			 인라인뷰 한번 사용하고 뷰를 이용한 코드
//			GRANT CREATE VIEW TO JSP_Servlet; -- 시스템계정으로 가서 권한부여
//			CREATE OR REPLACE VIEW BLIST
//			AS
//			SELECT ROWNUM RNUM, DESCBOARD.*
//			FROM (SELECT BOARD_ID, BOARD_TYPE, CATE_ID, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, NICKNAME, BOARD_COUNT, CREATE_DATE, b.MODIFY_DATE, b.STATUS
//			    FROM BOARD b
//			        JOIN MEMBER ON(USER_ID = BOARD_WRITER)
//			        JOIN CATEGORY USING(CATE_ID )
//			    WHERE B.STATUS = 'Y' AND BOARD_TYPE = 1
//			    ORDER BY BOARD_ID DESC) DESCBOARD;
	//
//			SELECT * FROM BLIST
//			WHERE ROWNUM <= 11 AND RNUM <= 20;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<MZBoard> list = new ArrayList<>();
			
			
			String query = prop.getProperty("selectList");
			
			
			
//			int startRow = pi.getCurrentPage() * pi.getBoardLimit(); // startRow가 1 11 21
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; // 위에서 추가로... 강의 3:39 // 1일 때 1 2일때 11 3일 때 21 나와야함. cpx10 1일 때 10 2일때는 20 3일 때는 30의 스타트로우가 발생할 것임. cp자체에다가 -1먼저 해주게 되면 1이 아니라 0 2가 아니라 1 3이 아니라 2가 들어가게 됨. 곱하기 10을 하는 것도 0 10 20이 들어가게됨 여기에 마지막에 +1만 하면 1 11이 나옴 
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			
			
			try {
				pstmt = conn.prepareStatement(query);
//				pstmt.setInt(1, startRow);
//				pstmt.setInt(2, endRow);
			
				pstmt.setInt(1, 1);
				pstmt.setInt(1, 3);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new MZBoard(rset.getInt("BOARD_NO"),
									   rset.getInt("BOARD_TYPE"),
									   rset.getString("BOARD_TITLE"),
									   rset.getInt("REF_RESTAURANT_NO"),
									   rset.getString("RESTAURANT_ADDRESS"),
									   rset.getString("RESTAURANT_PHONE"),
									   rset.getString("RESTAURANT_INTRO"),
									   rset.getString("RESTAURANT_CONTENT"),
									   rset.getInt("REF_FOOD_NO"),
									   rset.getString("FOOD_NAME"),
									   rset.getString("FOOD_TYPE"),
									   rset.getString("REF_USER_ID"),
									   rset.getInt("BOARD_COUNT"),
									   rset.getString("BOARD_COTENT"),
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
			
			System.out.println("dao = "+list);
			return list;
		}
	
	
	
	
}
