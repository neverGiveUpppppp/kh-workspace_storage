package board.model.vo;

import org.apache.ibatis.session.SqlSession;

public class BoardException extends Exception {

	public BoardException()	{}
	public BoardException(String msg) {
		super (msg);
	}
	
}
