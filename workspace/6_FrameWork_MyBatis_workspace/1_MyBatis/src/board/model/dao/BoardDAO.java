package board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.vo.Board;
import board.model.vo.BoardException;
import board.model.vo.PageInfo;

public class BoardDAO {

	
	
	// 페이징 처리1 : 총 게시판 조회
	public int getListCount(SqlSession session) throws BoardException {

		int listCount = session.selectOne("boardMapper.selectListCount"); // 쿼리에 보낼 데이터가 없으므로 인자1개(어떤 매퍼의 어떤 쿼리문 연결할지)
		// selelctOne(어떤 매퍼의 어떤 쿼리문 연결할지)
		// selectOne인 이유 : (면접 질문에 대한 대답식으로)
		// 전체게시글 가져오는 필요가 있기에 셀렉트 카운트 * 사용하게 되면 쿼리에 대한 발생 리절트 ... 강의9:43
		// 한개의 행이 나오기 때문에 제가 가지고 오는 행의 개수가 최대1개라서 셀렉트원 메소드 사용을 예상했습니다
		
		if(listCount <= 0) {
			session.close(); // select이므로 트랜잭션 롤백은 필요x
			throw new BoardException("게시물 조회에 실패하였습니다.");
		}
		return listCount;
	}
	
	
	// 페이징 처리2 : 원하는 게시판 번호 조회
	public ArrayList<Board> selectBoardList(SqlSession session, PageInfo pi) throws BoardException {

		// 시작행(startRow) 끝행(endRow) 만든이유
		// 몇번째부터 몇번째행까지 가져올지 정하기 위해서 startRow, endRow 만듬
		// ex) 2페이지 11-20 가져오기
//		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;  
//		int endRow = startRow + pi.getBoardLimit() - 1;
		/* 1일 때 1 2일때 11 3일 때 21 나와야함. cpx10 1일 때 10 2일때는 20 3일 때는 30의 스타트로우가 발생할 것임. 
		   cp자체에다가 -1먼저 해주게 되면 1이 아니라 0 2가 아니라 1 3이 아니라 2가 들어가게 됨. 곱하기 10을 하는 것도
		   0 10 20이 들어가게됨 여기에 마지막에 +1만 하면 1 11이 나옴 */
		
		
		/*
		 myBatis에서의 페이징처리 수 계산    		 강의 11:26-35
		 
		 RowBounds
		 jdbc에서 몇번째부터 몇번째행까지 가져올지 정하기 위해서 시작행(startRow) 끝행(endRow) 만들었다. 
		 jdbc꺼랑 마이바티스랑 계산이 다름
		 
		 
		 RowBounds는
		 1페이지 5개 그다음꺼 5개면 10, 그다음꺼 5개 가져올려면 15 
		  	- RowBounds 계산 key포인트 : 앞에 몇개를 건너뛴 다음에 몇개를 가져올지
		 
		 RowBounds(m,n) :  m개를 건너 뛰고 n개의  게시물을 가져오겠다
		
			5(n-1)
		 1page - 0개         0개 건너띔
		 2page - 5개         5개 건너뜀 (2-10) * 5개
		 3page - 10개	10개 건너뜀 (3-1) * 5개
		 
		 5는 보드리미트. 한페이지에 5개가 보이니까 5개를 건너뛰는것
		 
		 ROWNUM과 인라인뷰 쓸 필요 없이 Rowbounds로 해결가능
		 
		 */
		
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());  // RowBounds : import org.apache.ibatis.session.RowBounds; // import org.apache.ibatis.session.SqlSession;
		
		// selectList( , 어떤 데이터를 넣을 것인가, RowBounds )
		ArrayList<Board> list = (ArrayList)session.selectList("boardMapper.selectBoardList", null, rowBounds); // 쿼리문에 데이터 넣을만한 위치홀더가 없어서 null
		// 전달할게 없는데 로우바운즈는 필요하니까 인자3개짜리 쓴 것

		
		
		
		if(list == null) {
			session.close(); // select이므로 트랜잭션 롤백은 필요x
			throw new BoardException("게시물 조회에 실패하였습니다.");
		}
		
		return list;
	}


	
	// 조회수 업데이트
	public int updateCount(SqlSession session, int bId) throws BoardException {

		int result = session.update("boardMapper.updateCount",bId);
		// mapper.xml에 쿼리문 연결 및 쿼리문 작성
		
		if(result <= 0) {
			session.rollback(); 
			session.close(); 
			throw new BoardException("게시물 조회에 실패하였습니다.");
		}
		return result;
	}

	// 상세보기
	public Board selectBoardDetail(SqlSession session, int bId) throws BoardException {
		
		Board b = session.selectOne("boardMapper.selectBoard",bId);
		
		if(b == null) {
			session.close(); 
			throw new BoardException("게시물 조회에 실패하였습니다.");
		}
		return b;
	}

	
	

	
	
	// 검색리스트1 : 검색 조건 검색리스트 가져오기
	public int getSearchListCount(SqlSession session, HashMap<String, String> map) throws BoardException {


		int listCount = session.selectOne("boardMapper.getSearchListCount",map); 
		// 쿼리에 보낼 데이터가 있으므로 인자2개(어떤 매퍼의 어떤 쿼리문 연결할지, 보낼 데이터)
		
		
		if(listCount <= 0) {
			session.close(); // select이므로 트랜잭션 롤백은 필요x
			throw new BoardException("검색 결과 개수 조회에 실패하였습니다.");
		}
		return listCount;
	}

	// 검색리스트2 : 조건 검색리스트 가져오기
	public ArrayList<Board> selectSearchList(SqlSession session, HashMap<String, String> map, PageInfo pi) throws BoardException {
		
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();		// 현재를 기준으로 몇개를 .. 강의 10:14
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit()); // 게시물 몇개를 건너 뛸 것인가, 게시물 몇개를 가져올 것인가
		ArrayList<Board> list =  (ArrayList)session.selectList("boardMapper.selectSearchList", map, rowBounds); // 페이징처리 계산을 위한 rowbounds 때문에 인자3개
		// 어떤 조건으로 어떤 값을 넣을지 map 담겨 있기에 db로 보내줘야함

		if(list == null) {
			session.close(); // select이므로 트랜잭션 롤백은 필요x
			throw new BoardException("검색 결과 개수 조회에 실패하였습니다.");
		}
		return list;
	}



	
	
	
	
	
	
	
}


