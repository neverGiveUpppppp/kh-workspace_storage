package member.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member member) {
		Connection conn = getConnection();
		
		Member loginMember = new MemberDAO().loginMember(conn, member);
		
		close(conn);
		
		return loginMember;

	}

	public Member selectMember(Member member) {
		Connection conn = getConnection();
		
		Member selectMember = new MemberDAO().selectMember(conn, member);
		
		close(conn);
		
		return selectMember;

	}

	public Member findMember(Member member) {
		Connection conn = getConnection();
		
		Member findMember = new MemberDAO().findMember(conn, member);
		
		close(conn);
		
		return findMember;
		
	}

	public int changeMemberPwd(Member member, String newPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().changeMemberPwd(conn, newPwd, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int insertMember(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}


	public int checkId(String inputId) {
		
		Connection conn = getConnection();
		
		int result = new MemberDAO().checkId(conn, inputId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Member selectMemberPage(String loginUserId) {
		
		Connection conn = getConnection();
		
		Member member  = new MemberDAO().selectMemberPage(conn, loginUserId);
		
		close(conn);
		
		return member;
	}

	public int updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDAO().updateMember(conn, m);
		
		if(result > 0) {
			commit(conn);
			
		} else {
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

	public int checkPw(String inputPw) {
		
		Connection conn = getConnection();
		
		int result = new MemberDAO().checkPw(conn, inputPw);
		
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
		
		if(result < 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
