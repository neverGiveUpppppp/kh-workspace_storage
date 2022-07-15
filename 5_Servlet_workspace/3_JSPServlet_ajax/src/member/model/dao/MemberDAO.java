package member.model.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;


public class MemberDAO {

	
	private Properties prop = new Properties();

	public MemberDAO() {
		// 쿼리문 외부 지정
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		// class : 상위폴더 가르킴(?)
		// src폴더는 내장이라 따로 경로에서 안적어줘도 됨.
		// getResource() : src
		// getPath() : 경로를 리턴한다. File에 입력된 경로 리턴해주는데, 만약에 인자로 전달된 경로가 상대경로라면 상대경로 리턴
		
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	public Member loginMember(Connection conn, Member member) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("loginUser"); // 키이름을 넣어야함. member-query.properties 안에 있는 키값
		// 탈퇴 회원 중에서 일치한 사람이 아닌 사람 가져오기
		// STATUS : 가입했는지 안했는지 알아보는 SQL명령어
		// Y이면 탈퇴 안한 사람 // N이면 탈퇴한 사람
		// 아이디는 중복x가 전제라 쿼리문 결과의 개수는 0 or 1개 일 것임
		// count(*) 안쓰는 이유는 로그인 정보를 유지하면서 카페,블로그, 글쓰기 등을 할 수 있게 유저정보를 전체 받아와야하기 때문
		
		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				loginUser = new Member(rset.getString("USER_ID"),
									  rset.getString("USER_PWD"),
									  rset.getString("USER_NAME"),
							     	  rset.getString("NICKNAME"),
									  rset.getString("PHONE"),
									  rset.getString("EMAIL"),
									  rset.getString("ADDRESS"),
									  rset.getString("INTEREST"),
									  rset.getDate("ENROLL_DATE"),
									  rset.getDate("MODIFY_DATE"),
									  rset.getString("STATUS"));
				// rset.getString(매개변수 컬럼 순번 혹은 컬럼명) 리절트셋에 대한 컬럼명
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}




	public int insertMember(Connection conn, Member member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("inserMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getNickName());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getInterest());
			
			result = pstmt.executeUpdate();	// DML은 executeUpdate
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}




	public int checkId(Connection conn, String inputId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("count(*)"); 
						// getInt(1)도 가능
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}




	public Member selectMember(Connection conn, String loginUserId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null; 
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginUserId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) { // while문도 가능
				member = new Member(rset.getString("USER_ID"),
						  rset.getString("USER_PWD"),
						  rset.getString("USER_NAME"),
				     	  rset.getString("NICKNAME"),
						  rset.getString("PHONE"),
						  rset.getString("EMAIL"),
						  rset.getString("ADDRESS"),
						  rset.getString("INTEREST"),
						  rset.getDate("ENROLL_DATE"),
						  rset.getDate("MODIFY_DATE"),
						  rset.getString("STATUS"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}




	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0; 
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getNickName());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getInterest());
			pstmt.setString(7, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("DAO"+result);
		return result;
		
		
	}

	
	
	

	public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	

	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
