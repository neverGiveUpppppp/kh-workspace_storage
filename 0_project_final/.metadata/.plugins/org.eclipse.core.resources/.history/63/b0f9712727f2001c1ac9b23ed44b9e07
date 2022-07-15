package com.kh.Spring.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.Spring.board.model.dao.BoardDAO;
import com.kh.Spring.board.model.vo.Board;
import com.kh.Spring.board.model.vo.PageInfo;
import com.kh.Spring.board.model.vo.Reply;

@Service("bService")
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	private BoardDAO bDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession; // 임포트하고 어노테이션 autowired까지 해야 사용가능

	
	
	// 페이징처리1 :총게시물수 가져오기
	@Override
	public int getListCount() {
		return bDAO.getListCount(sqlSession);
	}


	// 페이징처리2 : 필요한 게시판 가져오기
	@Override
	public ArrayList<Board> getBoardList(PageInfo pi) {
		return bDAO.getBoardList(sqlSession, pi);
	}


	// 게시판 글쓰기
	@Override
	public int insertBoard(Board b) {
		return bDAO.insertBoard(sqlSession, b);
	}


   @Override
   @Transactional
   public Board selectBoard(int bId) {
      int result = bDAO.addReadCount(sqlSession, bId);
      
      Board b = null;
      if(result > 0 ) {
         b = bDAO.selectBoard(sqlSession,bId);
      }
      return b;
   }

   	// 게시판 수정 + 파일수정
	@Override
	public int updateBoard(Board b) {
		return bDAO.updateBoard(sqlSession, b);
	}

	// 게시글 삭제 + 파일삭제
	@Override
	public int deleteBoard(int bId) {
		return bDAO.deleteBoard(sqlSession, bId);
	}

	// 댓글 쓰기 : insert
	@Override
	public int insertReply(Reply r) {
		return bDAO.insertReply(sqlSession, r);
	}


	@Override
	public ArrayList<Reply> selectReplyList(int bId) {
		return bDAO.selectReplyList(sqlSession, bId);
	}

	// Top-N 분석 : select
	@Override
	public ArrayList<Board> topList() {
		return bDAO.topList(sqlSession);
	}

	
	
}
