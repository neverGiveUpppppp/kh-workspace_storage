package com.kh.model.DAO;
import static com.kh.common.JDBCTemplate.close; // JDBCTemplate.close 불러오는 줄임용 임포트

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

/*
 	JDBC 연결 및 데이터 받아오기
 	
	<이전 프로젝트에서 DAO가 맡은 업무>
	1.JDBC 드라이버 등록,생성 & 실행
	2.DB연결 Connection 객체 생성
	3.SQL문 실행 : 쿼리작성하고 executeQuery등 실행해서 resultset으로 받아오는 과정까지
	4.트랜젝션 기능 생성 및 실행 : commit/rollback
	5. 자원반납 : ex)return list;

	--> 실제로는 DAO가 처리해야할 업무는 3번 업무 뿐
	
	1,2,4,5번 업무는 DAO의 역할이 아니며 어디서든 공통적으로 이루어지는 업무이기 때문에 역할 분리
	분리역할은 com.kh.common.JDBCTemplate이 맞아서 할 것임
	
		<쿼리문에 따른 반환 타입>
       1.회원추가 : int
       2.SELECT 회원 : Member
       3.SELECT 전체 회원 : ArrayList<Member>
/
*/
public class MemberDAO {
	
	private Properties prop = null;
	public MemberDAO() {	// 기본 생성자 만드는 이유 : 09:41,45...  메소드에다 써도 무상관. ... 서비스에서 dao 넘어갈 때 객체생성하니 이때 기능을 첨부해두는 것
		// 프로티즈안에 생성? 담겨있어야하니 .. 그 메소드를 호출해야한다는건데 굳이 그래야하나? 서비스에서 dao 넘어갈 때 기본 생성자 생성하는데 ...
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties")); // prop변수에 쿼리문 넣어진 상태
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 메뉴1. 새회원 등록
	public int insertMember(Member mem, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getGender()+""); // 데이터타입이char라 str로 전환함. +""으로
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhone());
			pstmt.setString(7, mem.getAddress());
			pstmt.setInt(8, mem.getAge());
			
			result = pstmt.executeUpdate();	// int result를 try문 밖으로 빼서 아래 return문에서 읽을 수 있게하자
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// close 처리 방법1
//			JDBCTemplate.close(pstmt); // JDBCTemplate클래스에서 쓴 close처리 메소드를 호출해와서 close처리한 것
			// close 처리 방법2
			close(pstmt); // 위에 import static com.kh.common.JDBCTemplate.close;추가
		}
		return result;	
	}
	
	
	
	// 메뉴2. 모든 회원 조회
	public ArrayList<Member> selectAll() {
		// 쿼리 생각 후 어떤 객체(클래스)들이 필요할까 생각해보고 작성할 것
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		
		// 쿼리문 방법1 : 쿼리문 내부 관리
		String query = "SELECT * FROM MEMBER";
		// 쿼리문 방법2 : 외부파일 관리
		String query2 = prop.getProperty("selectAll"); // selectAll키에 해당하는 값으로 알맞은 쿼리작성 from 파일 query.properties
		
		
		try {
//			stmt = conn.createStatement();
			stmt = JDBCTemplate.getConnection().createStatement();
			rset = stmt.executeQuery(query2);
			
			list = new ArrayList<>();
			while(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address= rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				Member mem = new Member(memberId,memberPwd,memberName,gender,email,phone,age,address,enrollDate);
				list.add(mem);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;	
	}


		
		
	// 메뉴3. 특정 조건 회원 조회  - 아이디 조회
	public ArrayList<Member> selectMemberId(Connection conn, String id) {
		// 2가지 유형의 쿼리가 나올 수 있음
		// 유형1 : SELECT * FROM MEMBER WHERE MEMBER_ID LIKE '%?%'		 -> 미완성형 쿼리
		// 유형2 : SELECT * FROM  MEMBER WHERE MEMBER_ID LIKE '%" + id + "%'" -> 완성형 쿼리
		
		// 완성형 쿼리
		Statement stmt = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>(); // 리턴하기 위해서 같이 만들어두자
		
		// 쿼리문 방법1 : 쿼리문 내부 관리
		String query = "SELECT * FROM  MEMBER WHERE MEMBER_ID LIKE '%" + id + "%'";
		String query2 = "SELECT * FROM MEMBER WHERE MEMBER_ID LIKE ?";//LIKE의 와일드카드에 싱글쿼테이션 '이 없는데 문제x // why?
																	// 프리페어드 위치홀더 쓸 때 setString식으로 값을 넣을 때, 이때 알아서 싱글쿼테이션을 넣은 상태로 쿼리를 전송해줌.  
		// 쿼리문 방법2 : 외부파일 관리										// 즉, PreparedStatement에서 위치홀더 값 삽입 시, 알아서 싱글쿼테이션을 채워서 쿼리를 보낸다 	
		String query3 = prop.getProperty("selectMemberId");
		
		
		// Statement에서의 외부파일 사용 코드
		// String query = prop.getProperty("selectMemberId");
		// query += "'%" + id + "%'";

		try {
			// 방법1 : Statement
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			// 방법2 : PreparedStatement	
			pstmt = conn.prepareStatement(query3);
			pstmt.setString(1, "%" + id + "%");
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				Member m = new Member(rset.getString("MEMBER_ID"),	// 컬럼의 순서는 insert시에만 맞추면 된다
									  rset.getString("MEMBER_PWD"), // 순서의 맞춰서 데이터가 들어가기 때문
									  rset.getString("MEMBER_NAME"), // 가져온 셀릭트 결과값을 멤버생성자에 넣을꺼기 때문에 순서는 상관x
									  rset.getString("GENDER").charAt(0), // 
									  rset.getString("EMAIL"),
									  rset.getString("PHONE"),
									  rset.getInt("AGE"),
									  rset.getString("ADDRESS"),
									  rset.getDate("ENROLL_DATE"));
				list.add(m);
			}	

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
//			close(pstmt); // 프리페어드가 스테이트먼트의 자식이라 다형성 때문에 따로 클로즈 설정안해도 바로 사용가능
		}
		return list;
	}
	// 메뉴3. 특정 조건 회원 조회 - 성별 조회
	public ArrayList<Member> selectGender(Connection conn, char gen) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>(); // 리턴하기 위해서 같이 만들어두자

		// 쿼리문 방법1 : 쿼리문 내부 관리
		String query = "SELECT * FROM MEMBER WHERE GENDER = ?"; // 프리페어드는 위치홀더 시에 LIKE 와일드카드에 싱글쿼터 ' 자동으로 넣어준다
		// 쿼리문 방법2 : 외부파일 관리									 	
		String query3 = prop.getProperty("selectGender");
		
		
		try {
			// 방법1 : Statement
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
			
			// 방법2 :PreparedStatement
			pstmt = conn.prepareStatement(query3);
			pstmt.setString(1, gen+""); // 숫자+문자=문자를 이용해서 뒤에 ""을 붙여줘서 char를 str로 변환
			pstmt.setString(1, String.valueOf(gen));
			// 위의 gen+"" 대신 String.valueof()도 가능 
			// String.valueof() : char를 문자열 표현으로 반환하는 String 메서드


			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getString("MEMBER_ID"),	// 컬럼의 순서는 insert시에만 맞추면 된다
						  rset.getString("MEMBER_PWD"),  	// 순서의 맞춰서 데이터가 들어가기 때문
						  rset.getString("MEMBER_NAME"), 	// 가져온 셀릭트 결과값을 멤버생성자에 넣을꺼기 때문에 순서는 상관x
						  rset.getString("GENDER").charAt(0), // 
						  rset.getString("EMAIL"),
						  rset.getString("PHONE"),
						  rset.getInt("AGE"),
						  rset.getString("ADDRESS"),
						  rset.getDate("ENROLL_DATE"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset); // JDBCTemplate 클래스에서 close처리
		}
		return list;
	}


	
	// 메뉴4. 회원 정보 수정 - 아이디 매칭 여부 확인
	public int checkMember(Connection conn, String memberId) {
		// 체크할려는 아이디가 db에 존재하는지 확인이 목표
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		// 쿼리문 두가지 나옴
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		String query2 = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ?";
		String query3 = prop.getProperty("checkMember"); // 위의 count 쿼리문 적용
		// 카운트를 썼기에 리절트셋에서 받는 반환값은 숫자일 것임. 사원수조회시 카운트로 20명 받아오는 것처럼.
		// select문으로 조회할 때 결과를 ResultSet으로 받는데 데이터 타입이 객체가 아닌 int로 받게되는 케이스
		
		// SELECT문 사용 시, ResultSet은  무조건 사용. 셀렉트문은 결과가 무조건 ResultSet 일 수 밖에 없다
		// 그동안 수업에서 셀렉트 할 때마다 객체에 옮겨 담아왔는데, 쿼리문에 따라서 값을 받아오는게 객체가 아닌 인트가 될 수 있다
		
		
		try {
			pstmt = conn.prepareStatement(query3);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();	// 리절트셋의 반환행 개수는 1개 // why? count에서 0명이라도 1행을 반환하기 때문
			
			if(rset.next()) {
				result = rset.getInt("count(*)"); // 컬럼명이 count(*)이므로 이걸 넣어준다
				// 어차피 1행만 받을 것이고 
				result = rset.getInt(1); // 첫번째 컬럼의 값을 가져오겠다는 의미 
				// getInt()메소드가 2가지인데 컬럼 순번으로 값을 가져오는 것과 컬럼명을 가져오는 2가지가 있다. 컬럼 순번은 추천하지 않는 방식.
				// getInt(String columnLabel),getInt(int columnIndex)
			}
			System.out.println(result); 	// 리절트셋 반환행 개수의 디버깅을 위한 println
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return result;
	}

	
	// 메뉴4. 회원 정보 수정
	public int updateMember(Connection conn, int sel, String input, String memberId) {
		// int sel : 비번 이메일 전번 주소 중 선택
		// String input : 수정할 값
		// String memberId : 아이디 존재여부 확인했던 아이디정보
		
//		<쿼리문에 따른 반환 타입>
//	       1.회원추가 : int
//	       2.SELECT 회원 : Member
//	       3.SELECT 전체 회원 : ArrayList<Member>
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember"+sel); // 받아온 int sel : 비번 이메일 전번 주소 중 선택 데이터로 쿼리문까지
//		updateMember1=UPDATE MEMBER SET MEMBER_PWD = ? WHERE MEMBER_ID = ?
//		updateMember2=UPDATE MEMBER SET EMAIL = ? WHERE MEMBER_ID = ?
//		updateMember3=UPDATE MEMBER SET PHONE = ? WHERE MEMBER_ID = ?
//		updateMember4=UPDATE MEMBER SET ADDRESS = ? WHERE MEMBER_ID = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,input);
			pstmt.setString(2,memberId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	
/*		
		// 아래의 로직이 안되는 이유
		 * 
		// input값의 싱글퀘테이션 누락?
		// 프리페어의 위치홀더에 각각 값을 하나씩 넣고 있는건데 싱글 쿼테이션 들어가도 try문 안에 2,3번은 문제가 없는데 1번은 안됨. 
		// 컬럼명에 싱글쿼테이션이 자동으로 들어가기 때문. 컬럼명에 '이 들어가니 당연히 안되는 것
		String selS = null;
		if(sel == 1) {
			selS = "MEMBER_PWD";
		} else if(sel == 2) {
			selS = "EMAIL";
		} else if(sel == 3) {
			selS = "PHONE";
		} else if(sel == 4) {
			selS = "ADDRESS";
		}
		
		String query = "UPDATE MEMBER SET ? = ? WHERE MEMBER_ID = ?"; // 안되는 이유
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, selS);	// 프리페어 위치홀더에 각각 값을 하나씩 넣고 있는건데 싱글 쿼테이션 들어가도 2,3번은 문제가 없는데 1번은 안됨. 	
			pstmt.setString(2, input);	// 컬럼명에 싱글쿼테이션이 자동으로 들어가기 때문. 컬럼명에 '이 들어가니 당연히 안되는 것
			pstmt.setString(3, memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

*/
		
		
	}

	
	// 메뉴5. 회원 탈퇴
	public int deleteMember(Connection conn, String id) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

	
	
	
	


	
	
	

}
