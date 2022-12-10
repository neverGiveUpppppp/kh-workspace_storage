package com.kh.Spring.member.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.Spring.member.model.vo.Member;

@Repository("mDAO")
public class MemberDAO {

	public Member login(SqlSessionTemplate sqlSession, Member m) {

		return sqlSession.selectOne("memberMapper.login",m); // 쿼리에 보낼 데이터 있으므로 인자2개
	}

	// 회원가입
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {

		return sqlSession.insert("memberMapper.insertMember",m);
//		 스프링에서 알아서 잡아줘서 트랜잭션 할 필요x
//		 다만 완벽하지는 않아서 따로 해줘야할 때가 있음. 
//		 tx모듈이나 aop를 이용해서 트랜젝션을 처리하기도 함
//		 aop 안에 tx를 쓰는 것. aop랑 로깅도 쓸 수 있고 aop와 인코딩도 같이 쓸 수 있고 여러가지 합쳐서 사용가능
		
	}

	public int updateMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.updateMember",m);
	}

	public int updatePwd(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.update("memberMapper.updatePwd",map);
	}

	public int deleteMember(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.update("memberMapper.deleteMember", id);
	}

	// ajax 회원가입 id중복체크
	public int checkIdDup(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.selectOne("memberMapper.checkIdDup", id);
	}
	
	
	

	
}
