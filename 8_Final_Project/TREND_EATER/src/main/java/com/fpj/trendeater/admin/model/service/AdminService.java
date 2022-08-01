package com.fpj.trendeater.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.fpj.trendeater.admin.model.vo.Admin;
import com.fpj.trendeater.member.model.vo.Member;


public interface AdminService {


	   //관리자 로그인
	   Admin adminlogin(Admin admin);
	   //회원 리스트의 총 명 수 
	   int memberCount();
	   //회원 리스트 뿌리기
	   ArrayList<Member> selectMember();
	   //회원 상태 변경
	   int updateMember(HashMap<String, String> map);
	   
	
	
}
