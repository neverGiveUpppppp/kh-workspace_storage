package member.model.dao;

import static common.JDBCTemplate.close;

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
		String fileName = MemberDAO.class.getResource("/sql/member-query.properties").getPath();
		
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
		
		String query = prop.getProperty("loginUser");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getString("user_id"),
									   rset.getString("user_pwd"),
									   rset.getString("user_name"),
									   rset.getString("phone"),
									   rset.getString("user_email"),
									   rset.getString("gender"),
									   rset.getString("address"),  
									   rset.getDate("born_date"),
									   rset.getDate("enroll_date"),
									   rset.getDate("modify_date"),
									   rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	public Member selectMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member selectMember = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserEmail());
			pstmt.setDate(3, member.getBornDate());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				selectMember = new Member(rset.getString("user_id"),
									   rset.getString("user_pwd"),
									   rset.getString("user_name"),
									   rset.getString("phone"),
									   rset.getString("user_email"),
									   rset.getString("gender"),
									   rset.getString("address"),  
									   rset.getDate("born_date"),
									   rset.getDate("enroll_date"),
									   rset.getDate("modify_date"),
									   rset.getString("status"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return selectMember;
	}

	public Member findMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member findMember = null;
		
		String query = prop.getProperty("findMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserEmail());
			pstmt.setDate(3, member.getBornDate());
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				findMember = new Member(rset.getString("user_id"),
									   rset.getString("user_pwd"),
									   rset.getString("user_name"),
									   rset.getString("phone"),
									   rset.getString("user_email"),
									   rset.getString("gender"),
									   rset.getString("address"),  
									   rset.getDate("born_date"),
									   rset.getDate("enroll_date"),
									   rset.getDate("modify_date"),
									   rset.getString("status"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return findMember;
	}

	public int changeMemberPwd(Connection conn, int newPwd, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changeMemberPwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newPwd);
			pstmt.setString(2, member.getUserId());
			pstmt.setString(3, member.getUserEmail());
			pstmt.setDate(4, member.getBornDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getUserEmail());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getUserEmail());
			pstmt.setDate(8, member.getBornDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} close(pstmt);
		
		
		
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
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMemberPage(Connection conn, String loginUserId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		String query = prop.getProperty("selectMember2");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginUserId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member(rset.getString("USER_ID"),
								    rset.getString("USER_PWD"),
								    rset.getString("USER_NAME"),
								    rset.getString("PHONE"),
								    rset.getString("USER_EMAIL"),
								    rset.getString("GENDER"),
								    rset.getString("ADDRESS"),  
								    rset.getDate("BORN_DATE"),
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
			pstmt.setString(1, m.getPhone());
			pstmt.setString(2, m.getUserEmail());
			pstmt.setString(3, m.getUserAddress());
			pstmt.setDate(4, m.getBornDate());
			pstmt.setString(5, m.getUserId());
	
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
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

	public int checkPw(Connection conn, String inputPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkPwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputPw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
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
