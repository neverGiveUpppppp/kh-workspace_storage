package com.kh.Spring.member.model.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.Spring.member.model.dao.MemberDAO;
import com.kh.Spring.member.model.vo.Member;


@Service("mService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession; // 임포트하고 어노테이션 autowired까지 해야 사용가능
	
	
	@Override
	public Member login(Member m) {
// db 연결을 위해 sqlSession을 해야하니 마이바티스가 필요하고 라이브러리 관리하는 메이븐의 pom.xml 파일로 가서 라이브러리 추가 코드 작성해야함
// https://mvnrepository.com/
		
		return mDAO.login(sqlSession, m);
	}


	@Override
	public int insertMember(Member m) {
		return mDAO.insertMember(sqlSession, m);
	}


	@Override
	public int updateMember(Member m) {
		return mDAO.updateMember(sqlSession, m);
	}

	// 비번 변경
	@Override
	public int updatePwd(HashMap<String, String> map) {
		return mDAO.updatePwd(sqlSession, map);
	}

	// 회원 삭제
	@Override
	public int deleteMember(String id) {
		return mDAO.deleteMember(sqlSession, id);
	}

	// ajax 회원가입 id중복체크
	@Override
	public int checkIdDup(String id) {
		return mDAO.checkIdDup(sqlSession, id);
	}
	
	
	
}
