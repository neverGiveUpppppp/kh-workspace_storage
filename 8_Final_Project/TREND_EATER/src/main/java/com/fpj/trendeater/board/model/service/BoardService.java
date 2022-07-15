package com.fpj.trendeater.board.model.service;
import java.util.ArrayList;

import com.fpj.trendeater.board.model.vo.Board;
import com.fpj.trendeater.board.model.vo.BoardQnA;
import com.fpj.trendeater.board.model.vo.PageInfo;
import com.fpj.trendeater.board.model.vo.Reply;

public interface BoardService {
	
/********************************** notice *********************************/	
	int getListCount(); // 페이징처리1 :총게시물수 가져오기
	ArrayList<Board> getBoardList(PageInfo pi);	// 페이징처리2 : 필요한 게시판 가져오기
	Board selectBoard(int bId);
	int insertNotice(Board b);	// notice(공지사항) 쓰기
	int updateNotice(Board b);	// notice(공지사항) 수정
	int deleteNotice(Board b);	// notice(공지사항) 삭제
	
/********************************** QnA *********************************/	
	int getQnaListCount();
	ArrayList<BoardQnA> getBoardQnaList(PageInfo pi);
	int insertBoardQna(BoardQnA b);		// 문의사항 게시판 글쓰기
	int updateBoardQna(BoardQnA b);
	int deleteBoardQna(BoardQnA b);
	
	
	
/***********************************************************************/	
//	int insertReply(Reply r);
//	ArrayList<Reply> selectReplyList(int bId);
//	ArrayList<Board> topList();				// Top-N 분석 : select
	
}
