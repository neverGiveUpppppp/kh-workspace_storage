package notice.model.dao;

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

import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class NoticeDAO {

	// 외부파일 로드용 클래스 Properties 선언
	Properties prop = new Properties();
	
	// 외부 파일 경로지정
	public NoticeDAO() {
		String fileName = NoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public ArrayList<Notice> selectList(Connection conn) {
		// 고정값(공지사항)을 조회하는 거기에 Statement 사용
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<>();
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
									rset.getString("NOTICE_TITLE"),
									rset.getString("NOTICE_CONTENT"),
									rset.getString("NOTICE_WRITER"),
							//		null, // SQL컬럼에는 없지만 Model.vo의 필드에는 NICKNAME이 있어서 NULL추가 
									// 멤버라고 하는 테이블의 컬럼이 멤버라고하는 클래스의 필드와 일치하다보니까 여러분들이 셀렉트해올 때
									// 테이블의 컬럼만 보시는데 내가 셀렉트를한 리절트셋의 컬럼을 봐야함.
									// 그런데 우리가 항상 셀렉트 아스트로프롬 테이블 이렇게만 할리는 없기에 단일 테이블에서 셀렉트 해오는 것보다
									// 조인해서 가지고 오는 경우가 훨씬 많기에, 테이블을 쪼개놔야한다는 얘긴데 테이블 쪼개놓은거를 가지고서 
									// 내가 원하는 정보들을 다 얻을려면 조인하고 조인하고 여러개를 겹쳐놔야만 원하는 정보를 얻을 수 있을거임
									// 공지사항도 마찬가지임. 중간에 닉네임 집어놓은 이유는 공지사항 글쓴이가 아이디일 수도 있지만, 닉네임일것임.
									// 앞으로 작성자란에는 아디가 아닌 닉네임을 보여주고 싶은것.
									// 그럼 SQL에서는 MEMBER테이블과 NOTICE테이블 2개를 조인해서 끌어와야함
									// MODEL.VO에 NOTICE테이블에는 없는 nickName필드를 추가한 것임. 
									// vo의 필드는 내가 넣고 싶은 항목을 만든 것. vo의 필드와 테이블 컬럼이 매번 완전히 같아야한다? x
									// vo 저장하고 싶은 값을 생각해서 '내가 필요한 것들'로 '구성'해둬야한다.
									// 테이블 '데이터 무결성'의 기준으로 '구성'
									
									rset.getString("NICKNAME"), // 두테이블 조인해서 nickname을 MEMBER컬럼에서 가져올 수 있게되면서 NULL대신 NICKNAME값 가져옴
									
									
									rset.getInt("NOTICE_COUNT"),
									rset.getDate("NOTICE_DATE"),
									rset.getString ("STATUS")));
			}
		// 두 테이블(MEMEBER, NOTICE) 조인하려면 쿼리문을 어찌써야할까? 
		// SELECT * FROM NOTICE
		// 		JOIN MEMBER ON (NOTICE_WRITER = USER_ID)
		// WHERE STATUS = 'Y';   <- 이렇게만 쓰면 STATUS가 양쪽에 다 있기에 NOTICE테이블의 STATUS라는 것을 명시해줘야함
			
		// SELECT * FROM NOTICE 
		//		JOIN MEMBER ON(NOTICE_WRITER = USER_ID) 
		// WHERE NOTICE.STATUS = 'Y';
			
		// 근데 위에처럼 쓰면 공지사항에 필요없는 정보들도 다 가져와버리니 필요한 것만 셀렉트(조회)
		// SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, 
		//	      NICKNAME, NOTICE_COUNT, NOTICE_DATE, NOTICE.STATUS
		// FROM NOTICE
		// 		JOIN MEMBER ON(NOTICE_WRITER = USER_ID)
		// WHERE NOTICE.STATUS = 'Y';	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		return list;
	}


	// 공지사항 게시판 삽입(글쓰기)
	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getNoticeWriter());
			pstmt.setDate(4, n.getNoticeDate());
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


	// 공지사항 게시판 조회
	public Notice selectNotice(Connection conn, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice not = null;
		
		String query = prop.getProperty("selectNotice"); // selectNotice=SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, NICKNAME, NOTICE_COUNT, NOTICE_DATE, NOTICE.STATUS FROM NOTICE JOIN MEMBER ON(NOTICE_WRITER = USER_ID) WHERE NOTICE.STATUS = 'Y' AND NOTICE_NO = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				not = new Notice(rset.getInt("NOTICE_NO"), 
							     rset.getString("NOTICE_TITLE"),
							     rset.getString("NOTICE_CONTENT"),
							     rset.getString("NOTICE_WRITER"),
							     rset.getString("NICKNAME"),
							     rset.getInt("NOTICE_COUNT"),
							     rset.getDate("NOTICE_DATE"), 
							     rset.getString("STATUS"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return not;
	}


	// 조회수 카운트 업데이트
	public int updateCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount"); // updateCount=UPDATE NOTICE SET NOTICE_COUNT = NOTICE_COUNT + 1 WHERE NOTICE_NO = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	// 공지사항 게시판 수정
	public int updateNotice(Connection conn, Notice n) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateNotice"); // updateNotice=UPDATE NOTICE SET NOTICE_TITLE = ?, NOTICE_DATE = ?, NOTICE_CONTENT = ? WHERE NOTICE_NO = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle()); // Notice n에 객체로 여러 데이터를 받아왔으므로 n.get해서 하나씩
			pstmt.setDate(2, n.getNoticeDate());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setInt(4, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	// 공지사항 게시판 삭제
	public int deleteNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteNotice"); // deleteNotice=UPDATE NOTICE SET STATUS = 'N' WHERE NOTICE_NO = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	
	
	
	
}








