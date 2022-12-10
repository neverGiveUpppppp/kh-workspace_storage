package member.model.service;

import org.apache.ibatis.session.SqlSession;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
import member.model.vo.MemberException;

import static common.Template.*;

import java.util.HashMap;

public class MemberService {

	public Member selectMember(Member m) throws MemberException {
		
		SqlSession session = getSqlSession();
		
		Member member = new MemberDAO().selectMember(session, m);
		
		session.close();
		
		return member;
	}

	public void insertMember(Member m) throws MemberException {

		SqlSession session = getSqlSession();
		
		new MemberDAO().insertMember(session, m);
		
		// 인서트가 잘안됬으면 롤백해야함. 롤백은 dao에서 해야함. 제대로 잘안됬으면 익셉션 발생할거고, 서비스에서 나눠봤자 의미x
		// throw때문임 강의 12:28
		session.commit();
		session.close();
		
	}

	public void updateMember(Member m) throws MemberException {
		SqlSession session = getSqlSession();
		
		new MemberDAO().updateMember(session, m);
		session.commit();
		session.close();
	}

	public void updatePwd(HashMap<String, String> map) throws MemberException {
		SqlSession session = getSqlSession();
		
		new MemberDAO().updatePwd(session, map);
		session.commit();
		session.close();
		
	}

	public void deleteMember(String userId) throws MemberException {
		SqlSession session = getSqlSession();
		
		new MemberDAO().deleteMember(session, userId); // 누구꺼를 탈퇴처리할지 id 필요해서 userId 데이터 전송
		session.commit();
		session.close();
	}

	
	
}

