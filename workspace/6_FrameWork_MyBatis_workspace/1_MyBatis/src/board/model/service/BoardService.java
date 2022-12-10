package board.model.service;

import static common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.BoardException;
import board.model.vo.PageInfo;
import member.model.dao.MemberDAO;

public class BoardService {

	public int getListCount() throws BoardException {
		SqlSession session = getSqlSession();
		
		int listCount = new BoardDAO().getListCount(session);
		session.close();
		
		return listCount;
	}

	public ArrayList<Board> selectBoardList(PageInfo pi) throws BoardException {
		
		SqlSession session = getSqlSession();
		
		ArrayList<Board> list = new BoardDAO().selectBoardList(session, pi);
		session.close();
		return list;
		
	}

	
	public Board selectBoardDetail(int bId) throws BoardException {
		SqlSession session = getSqlSession();
		
		// 조회수 업데이트를 위해 2번 왔다갔다해야 하니 DAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		// 조회수 업데이트
		int result = dao.updateCount(session, bId);
		
		// 상세보기
		Board b = dao.selectBoardDetail(session, bId);
		
		session.commit();
		session.close();
		return b;
	}

	
	
	
	//  검색리스트1 : 전체 리스트 가져오기
	public int getSearchListCount(HashMap<String, String> map) throws BoardException {
		SqlSession session = getSqlSession();
		
		int listCount = new BoardDAO().getSearchListCount(session, map);
		session.close();
		
		return listCount;
	}
	
	// 검색리스트2 : 조건 검색리스트 가져오기
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) throws BoardException {

		SqlSession session = getSqlSession();
		
		ArrayList<Board> list = new BoardDAO().selectSearchList(session, map, pi);
		session.close();
		
		return list;
		
		
	}

	
	
}
