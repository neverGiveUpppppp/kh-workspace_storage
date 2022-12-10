package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class MemberService {

	
	
	public Member loginMember(Member member) {
//		Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		
		Member loginMember = new MemberDAO().loginMember(conn, member);
		close(conn);
		return loginMember;
	}

	
	
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn, member);
		
		// 트랜잭션 관리
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result; // insertMember. jsp로 
	}

	public int checkId(String inputId) {

		Connection conn = getConnection();
		int result = new MemberDAO().checkId(conn, inputId);
		
		close(conn);
		
		return result;
	}



	public Member selectMember(String loginUserId) {
		
		Connection conn = getConnection();
		Member member = new MemberDAO().selectMember(conn, loginUserId);
		
		close(conn);
		
		return member;
	}



	public int updateMember(Member m) {
		Connection conn = getConnection();
		
		System.out.println("service"+m);
		int result = new MemberDAO().updateMember(conn, m);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	

	public int updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().updatePwd(conn, userId, userPwd, newPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	
	
	public int deleteMember(String userId) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().deleteMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
}






