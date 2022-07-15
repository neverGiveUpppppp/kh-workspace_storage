package board.model.service;

import static common.MZTemplate.close;
import static common.MZTemplate.getConnection;

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
		
		System.out.println("boardCount = "+boardCount);
		return boardCount;
	}

	public ArrayList selectList(Pagination pi) {

		Connection conn = getConnection();
		ArrayList<MZBoard> list = new BoardDAO().selectList(conn, pi); 
		
		close(conn);
		
		System.out.println("service = "+list);
		return list;
	}



	
	
	
}
