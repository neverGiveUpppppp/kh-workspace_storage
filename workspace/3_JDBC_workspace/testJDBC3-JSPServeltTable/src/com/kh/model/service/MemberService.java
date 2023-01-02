package com.kh.model.service;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.DAO.MemberDAO;
import com.kh.model.vo.MemberJSPTable;

/*
	   <Service의 역할>
	 1.controller로부터 인자 전달 받음
	 2.Connection 객체 생성
	 3.DAO 객체 생성 후 controller로부터 전달 받은 인자와 conn을 Service가 전달
	 4. 트랜젝션 관리,실행
	 
*/

public class MemberService {
	private MemberDAO mDAO = new MemberDAO();
	
	// 메뉴1. 새회원 등록
	public int insertMember(MemberJSPTable mem) {

		// 방법1 : 정석
//			Connection conn = JDBCTemplate.getConnection(); 
		// 방법2
		Connection conn = getConnection(); // import static com.kh.common.JDBCTemplate.getConnection; 위에 추가
	
		int result = mDAO.insertMember(mem, conn); // 인서트멤버에 빨간줄 났던 이유 : DAO의 메소드인 insertMember(Member mem)에서
												   //인자를 하나만 받아서임. 보내는 곳은 2개(mem,con)인데 받는 곳에서 mem만 받았어서 에러발생
		if(result > 0) {
			commit(conn);   // JDBCTemplate에서 호출해오는 commit() 메소드     // 위에 improt 해줄 것
		}else {
			rollback(conn); // JDBCTemplate에서 호출해오는 rollback() 메소드 // 위에 improt 해줄 것
		}
		return result;
	}
	
	
	// 메뉴2. 모든 회원 조회
	public ArrayList<MemberJSPTable> selectAll() {
		// Service에 들어와서 먼저 해야하는 일 : Connection 생성
		Connection conn = JDBCTemplate.getConnection(); // getConnection()은 static메소드여서 앞에 클래스명.하면서 경로지정하는게 맞는데 
//		Connection conn = getConnection();				// 위에 import static을 해둔 상태이기 때문에 메소드만 호출해도 문제없는 상태
		ArrayList<MemberJSPTable> list = mDAO.selectAll();
		return list;
	}
	
	
	
	// 메뉴3. 특정 조건 회원 조회  - 아이디로 조회
	public ArrayList<MemberJSPTable> selectUserId(String id) { 
		
		Connection conn = getConnection();
		ArrayList<MemberJSPTable> list = mDAO.selectUserId(conn,id);	// 받아온 거를 dao로 넘기기
		return list;
	}
	// 메뉴3. 특정 조건 회원 조회  - 성별로 조회
	public ArrayList<MemberJSPTable> selectNickname(String nickname) {
		
		Connection conn = getConnection();
		ArrayList<MemberJSPTable> list = mDAO.selectNickname(conn,nickname);
		
		return list;
	}


	
	// 메뉴4. 회원 정보 수정 - 중복 아이디 확인
	public int checkMember(String memberId) {
		// Service에 들어와서 먼저 해야하는 일 : Connection 생성
		Connection conn = getConnection();
		int result = mDAO.checkMember(conn, memberId); // (JDBCTemplate 클래스에서 만들어 여기에 붙인)sql연결 코드도 같이 아이디정보를 dao로 넘기자
		
		return result;
	}
	// 메뉴4. 회원 정보 수정 - 수정값 포함
	public int updateMember(int sel, String input, String memberId) {
		Connection conn = getConnection();
		int result = mDAO.updateMember(conn, sel, input, memberId);
		
		// 트랜잭션 처리
		if (result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	
	// 메뉴5. 회원 탈퇴
	public int deleteMember(String id) {
		// Connection 방법1
		Connection conn = JDBCTemplate.getConnection();
		// Connection 방법2
		// Connection conn = getConnection(); 
		int result = mDAO.deleteMember(conn, id);
		
		// 트랜잭션 처리
		if (result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}


	public void exitProgram() {
		
		Connection conn = getConnection();
		close(conn); // JDBCTemplate클래스의 close() 메소드 import 시킬 것. 
		// 프로그램 종료한다는 전제하에, Connection을 프로그램 종료 시에 close처리
		
	}

	
	

	
	


	
	
}	
	
	
	