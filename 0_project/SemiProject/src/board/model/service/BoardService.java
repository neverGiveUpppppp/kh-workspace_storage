package board.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.MZBoard;
import board.model.vo.Pagination;


public class BoardService {

	public int getBoardCount() {

		Connection conn = getConnection();
		
		int boardCount = new BoardDAO().getBoardCount(conn);
		
		close(conn);
		
		return boardCount;
	}

	public ArrayList selectList(Pagination pi) {

		Connection conn = getConnection();
		ArrayList<MZBoard> list = new BoardDAO().selectList(conn, pi); 
		
		close(conn);
		
		System.out.println("service = "+list);
		return list;
	}

	// 게시판 상세보기
	public MZBoard selectBoard(int num) {
		Connection conn = getConnection();
		
		// 조회수 카운트 업데이트
		int result = new BoardDAO().updateCount(conn, num);
		
		// 게시판 조회
		MZBoard boardNum = null;
		if(result >0) {
		boardNum = new BoardDAO().selectBoard(conn, num); 
			commit(conn);
		}else {
			rollback(conn);
		}
	
		close(conn);
		return boardNum;
	}

	public int insertBoard(MZBoard b) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn, b);

		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}



	
	
	
}
