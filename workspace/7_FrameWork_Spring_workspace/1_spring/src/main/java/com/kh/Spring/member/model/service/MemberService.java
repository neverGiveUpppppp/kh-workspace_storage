package com.kh.Spring.member.model.service;

import java.util.HashMap;

import com.kh.Spring.member.model.vo.Member;




public interface MemberService {

	Member login(Member m);
	int insertMember(Member m);
	int updateMember(Member m);
	int updatePwd(HashMap<String, String> map);
	int deleteMember(String id);
	int checkIdDup(String id);			// ajax 회원가입 id중복체크
}
