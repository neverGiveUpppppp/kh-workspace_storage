package com.fpj.trendeater.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpj.trendeater.admin.model.dao.AdminDAO;
import com.fpj.trendeater.admin.model.vo.Admin;
import com.fpj.trendeater.member.model.vo.Member;

@Service("aService")
public class AdminServiceImpl implements AdminService {
	
	
	  @Autowired
	   private AdminDAO aDAO;
	   
	  @Autowired
	  private SqlSessionTemplate sqlSession;
	
	
	//회원 리스트
	@Override
	public ArrayList<Member> selectMember() {
	      
	   return aDAO.selectMember(sqlSession);
	}
	
    //회원 상태 변경
    @Override
    public int updateMember(HashMap<String, String> map) {
   
       return aDAO.updateMember(sqlSession,map);
    }
    //회원 리스트 총 명 수 
    @Override
    public int memberCount() {
      
       return aDAO.memberCount(sqlSession);
    }
   
    //관리자 로그인
    @Override
    public Admin adminlogin(Admin admin) {
       
       return aDAO.adminlogin(sqlSession,admin);
    }
	
}
