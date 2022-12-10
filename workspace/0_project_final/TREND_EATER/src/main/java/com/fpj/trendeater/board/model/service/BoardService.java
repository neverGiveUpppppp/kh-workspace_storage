package com.fpj.trendeater.board.model.service;
import java.util.ArrayList;

import com.fpj.trendeater.board.model.vo.Board;
import com.fpj.trendeater.board.model.vo.PageInfo;
import com.fpj.trendeater.board.model.vo.Reply;

public interface BoardService {
	
	int getListCount(); // 페이징처리1 :총게시물수 가져오기
	ArrayList<Board> getBoardList(PageInfo pi);	// 페이징처리2 : 필요한 게시판 가져오기
//	int insertBoard(Board b);		// 게시판 글쓰기
//	Board selectBoard(int bId);
//	int updateBoard(Board b);
//	int deleteBoard(int bId);
//	int insertReply(Reply r);
//	ArrayList<Reply> selectReplyList(int bId);
//	ArrayList<Board> topList();				// Top-N 분석 : select
	
}
