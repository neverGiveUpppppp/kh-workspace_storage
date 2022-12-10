package com.fpj.trendeater.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.fpj.trendeater.admin.model.vo.Admin;
import com.fpj.trendeater.member.model.vo.Member;

@Repository("aDAO")
public class AdminDAO {

/////김주희 
   //회워 리스트
   public ArrayList<Member> selectMember(SqlSessionTemplate sqlSession) {
      
      return (ArrayList)sqlSession.selectList("adminMapper.selectMember");
   }
   //회원 상태 변경
   public int updateMember(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
      
      return sqlSession.update("adminMapper.updateMember",map);
   }
   //회원 리스트 총 명 수
   public int memberCount(SqlSessionTemplate sqlSession) {
      return sqlSession.selectOne("adminMapper.memberCount");
   }
	
   //관리자 로그인
   public Admin adminlogin(SqlSessionTemplate sqlSession, Admin admin) {
      
      return sqlSession.selectOne("adminMapper.selectAdmin", admin);
   }
	
	
	
	
}
