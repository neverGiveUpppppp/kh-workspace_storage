package com.fpj.trendeater.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpj.trendeater.board.model.dao.BoardDAO;
import com.fpj.trendeater.board.model.vo.Board;
import com.fpj.trendeater.board.model.vo.BoardQnA;
import com.fpj.trendeater.board.model.vo.PageInfo;
import com.fpj.trendeater.board.model.vo.Reply;

@Service("bService")
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	private BoardDAO bDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession; // 임포트하고 어노테이션 autowired까지 해야 사용가능

	
/********************************* notice *********************************/
	
	// Notice 읽기(조회) - 페이징처리1 :총게시물수 가져오기
	@Override
	public int getListCount() {
		return bDAO.getListCount(sqlSession);
	}

	// Notice 읽기(조회) - 페이징처리2 : 필요한 게시판 가져오기
	@Override
	public ArrayList<Board> getBoardList(PageInfo pi) {
		return bDAO.getBoardList(sqlSession, pi);
	}
	
	// Notice 상세보기
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
   	
   // Notice 쓰기
   @Override
   public int insertNotice(Board b) {
	   int result = bDAO.insertNotice(sqlSession, b);
   }
   
   // Notice 수정
	@Override
	public int updateNotice(Board b) {
		int result = bDAO.updateNotice(sqlSession, b);
	}
	
	// Notice 삭제
	@Override
	public int deleteNotice(Board b) {
		int result = bDAO.deleteNotice(sqlSession, b);
	}

/******************************** QnA **********************************/
	
	// Qna 읽기(조회) - 페이징처리1 :총게시물수 가져오기
	@Override
	public int getQnaListCount() {
		return bDAO.getQnaListCount(sqlSession);
	}
	// Qna 읽기(조회) - 페이징처리2 : 필요한 게시판 가져오기
	@Override
	public ArrayList<BoardQnA> getBoardQnaList(PageInfo pi) {
		return bDAO.getBoardQnaList(sqlSession, pi);
	}
	
	// QnA 쓰기
	@Override
	public int insertBoardQna(BoardQnA b) {
		return bDAO.insertBoardQna(sqlSession, b);
	}

   	// QnA 수정 
	@Override
	public int updateBoardQna(BoardQnA b) {
		return bDAO.updateBoardQna(sqlSession, b);
	}

	// QnA 삭제 
	@Override
	public int deleteBoardQna(BoardQnA b) {
		return bDAO.deleteBoardQna(sqlSession, b);
	}








/***********************************************************************/
	


	   
//	// 댓글 쓰기 : insert
//	@Override
//	public int insertReply(Reply r) {
//		return bDAO.insertReply(sqlSession, r);
//	}
//
//
//	@Override
//	public ArrayList<Reply> selectReplyList(int bId) {
//		return bDAO.selectReplyList(sqlSession, bId);
//	}
//
//	// Top-N 분석 : select
//	@Override
//	public ArrayList<Board> topList() {
//		return bDAO.topList(sqlSession);
//	}
//
//
//	@Override
//	public ArrayList<com.fpj.trendeater.board.model.vo.Board> getBoardList(
//			com.fpj.trendeater.board.model.vo.PageInfo pi) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public int insertBoard(com.fpj.trendeater.board.model.vo.Board b) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//	@Override
//	public com.fpj.trendeater.board.model.vo.Board selectBoard(int bId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public int updateBoard(com.fpj.trendeater.board.model.vo.Board b) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//	@Override
//	public int insertReply(com.fpj.trendeater.board.model.vo.Reply r) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	



}
