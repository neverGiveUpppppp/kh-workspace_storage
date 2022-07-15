package com.kh.model.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Employee;

public class EmployeeDAO {
	// DAO : Date Access Object
//			 데이터를 외부에 저장해놓을 수 있는 파일,db
//			  서로 왔다갔다 할 수 있는 공간으로 사용됨
//	 		 외부 데이터 저장공간과 연결
//	 		 DAO는 DB의 data에 접근하기 위한 객체로 직접 DB에 접근하여 데이터를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행한다.
	
	
	// 목표 : 메뉴1.전체 사원 정보 조회
	public ArrayList<Employee> selectAll() {
		ArrayList<Employee> list = null;
		Connection conn = null;
		Statement stmt =  null;
		ResultSet rset =  null;
		
		// JDBC 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 드라이버 풀네임. 버젼마다 약간다름
			
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "qrwe"); // 디벨로퍼에서 계정등록 시에 세부정보에서 포트번호,SID에 있는걸로 맞추면된다. 19c는 orcl일 것임.
			// DriverManager.getConnection() 반환값이 객체 Connection이고, Connection conn으로 객체 커넥션의 변수 conn을 생성. 
			// DriverManager.getConnection()으로 연결할 계정 지정해주고 Connection conn으로 연결 통로 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "qrwe"); // 디벨로퍼에서 계정등록 시에 세부정보에서 포트번호,SID에 있는걸로 맞추면된다. 19c는 orcl일 것임. 
			// 고정 url: "jdbc:oracle:thin:@127.0.0.1:1521:xe"
			// jdbc:oracle:thin --> jdbc 드라이버 타입이 thin
			// @127.0.0.1 --> 접근해야하는 데이터베이스의 ip주소값 (내컴퓨터에 대한 주소값)
			// 1521 : 오라클 listener의 포트번호 
			// xe : 오라클 SID ← 오라클 계정등록할 때보면 하단에 있는 SID 
			
//			System.out.println(conn); // 주소값 반환 oracle.jdbc.driver.T4CConnection@f2a0b8e ← 모든 컴퓨터가 같게 뜬다
			
			// 쿼리를 보낼 예정
			// db에게 편지(쿼리) 보낼 예정. 쿼리는 String에 담는다
			String query = "SELECT * FROM EMP"; // SCOTT계정의 테이블정보 쿼리문 적기 // 주의 : 세미콜론 뒤에 안붙인다
			
//			Statement stmt = conn.createStatement(); // java.sql.statement 임포트
			stmt = conn.createStatement(); // java.sql.statement 임포트
			// stmt(우체부)가 움직이게 만들어서 편지(쿼리)를 전달하게 해야한다. 전달할려는게 셀렉트 -> executeQuery선택해야함
			stmt.executeQuery(query); // query = "SELECT * FROM EMP" -> 쿼리문 전달 // executeQuery 반환값 : ResultSet이라는 객체 반환
			// select문 - executeQuery() - 객체 ResultSet
//			ResultSet rset = stmt.executeQuery(query); //  ResultSet rset 안에 뭐가 들어있을까? 노션 스샷참조
			rset = stmt.executeQuery(query); //  ResultSet rset 안에 뭐가 들어있을까? 노션 스샷참조
			// 과정설명 요약 : query에서 작성한 쿼리문을  stmt.executeQuery(query)에서 보내고, ResultSet rset = stmt.executeQuery(query)에서 결과를 반환 받음
			
			
			
			// 왜 while문 돌릴까?
			// ResultSet 반환받은 값 상태로는 사용할 수 없어서 내가 사용할 수 있는 객체형태로 바꿔줘야한다. 내가 원하는 형태로 하나씩 담아주는 작업
			// ResultSet에 쿼리문에 대한 결과값이 담겨져 있는 상태이긴하나, ResultSet자체로 활용할 수 없어 ResultSet 안에 담겨있는 데이터를 다른 객체에 옮겨 담는 과정
			
			// ResultSet 안에 행의 개수? 몇개인지 모르나 0개이상인건 확실. 여러개의 가능성있음 --> 여러 개를 담을 수 있는 객체가 필요 
			// 배열과 컬렉션 둘 다 사용가능하나 배열단점을 보완한게 컬렉션이기에 컬렉션 사용
			// 컬렉션 안에 어떤 타입이 담길까?
			// list에서 arraylist에 Employee 객체가 담긴다 // 각 컬럼의 정보를 하나씩 담을 수 있게 employee객체가 좋다
			
			// dept_no의 10을 알고 싶은게 아닌 부서명 HR 같은 게 알고 싶은 것
			// 그럼 select * from emp
			//   		join dept using(deptno); 이 더 어울림
			
			// model.vo 클래스의 필드는 SELECT할  RESULTSET의 컬럼이랑 맞추는 것
			// 절대로 테이블의 컬럼이랑 맞추는게 아니다
			
			// 테이블의 모든 컬럼을 넣지 않고 선택해서 넣는 이유
			// 테이블은 왠만해서는 단독으로 잘 사용 안되고, 다른 테이블과 JOIN해서 필요한 정보만 뽑아옴. 그래서 모든 컬럼을 다 넣지 않는다
			
			// VO 데이터를 잠깐 담아두는 변수의 공간 // 자주 받아오는 구성으로 VO를 구성함 
			// Q.받아올 반환값(RESULTSET)에 맞춰 필드도 그렇게 맞춘다는거 맞나요? YES
			// Q.꼭 테이블a의 컬럼이 아닌 테이블b 테이블 c에서 자주 쓸 컬럼을 필드에 넣어두고 사용하고, 만약 추가로 필요하면 그때그때 추가하는 방식인거죠?
			// A.YES
			
			// Q.VO데이터가 잠깐 데이터를 담아두는 변수의 공간이니, 컨트롤러에서 다시 VO클래스에 받은 데이터들을 필요한 곳에 조작하는거인가요? yes
			// Q.시스템 내부에서 자바에서 쿼리 직접 써서 보내는건지?아니면 SQL에 코드를 쓰도록해서 받아오는건가요?
			// A.자바에서 써서 보냄
			
			
			// 몇개 받아올지 모르기에 WHILE문 사용
			// iterator.hasnext()로 다음값 있는지 확인하고 iterator.next() 사용처럼 해당값이 있는지 확인하고 다음 값을 가져오는 로직처럼
			// ResultSet.next()의 로직도 비슷하게 구현해서 ResultSet의 값을 받아올 예정 // hasNext는 iterator에서 사용할 수 있는거고 여기 next()는 ResultSet에서 사용 가능한 next
			list = new ArrayList<Employee>(); // 순서 지키기 위해 ArrayList 사용
			while(rset.next()) { // ResultSet.next() == 레퍼런스명.next()
				// ResultSet.next() : 다음 행이 존재하면 true반환, 없으면 false반환
				// 값 있냐고 물어보고 있으면 첫 행에 도달 : empno ename job mgr hireDate sal comm deptno의 컬럼들이 존재할 것
				// empno의 데이터타입 확인하고 number이니 model.vo에서 값을 저장할 필드도 int로 설정
				
				int empNo = rset.getInt("EMPNO"); // ResultSet 안에 있는 메소드 getInt() // SCOTT계정 EMP테이블의 empno컬럼 데이터 가져오기
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB"); 	// 컬렴명 소문자도 괜찮. 괄호 안 대소문자 관계x
				int mgr = rset.getInt("MGR");  
				Date hireDate = rset.getDate("HIREDATE"); 
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");		// model.vo로 데이터를 넘기는 코드
				// 여기까지 
				// 받아온 객체를 최종적으로 Employee 객체에 담아서 하나의 뭉탱이 데이터로 만들 것
				Employee e = new Employee(empNo, empName, job, mgr, sal, comm, deptNo);
				// empNo~deptNo까지의 데이터를 다 담아서 한 뭉텅이로 만든 코드
				
				// ArrayList<Employee> list에 Employee e 객체를 담을 것
				list.add(e); //  empNo~deptNo까지의 데이터가 담긴  Employee 객체를 list에 추가
				
				// ArrayList<Employee> list부터 while반복문 안 로직 정리
				// reset.next()로 가져올 값이 있나 확인하고,
				// .getInt()와 .getString() 한 행 전체 값을 가져와서 model.vo 필드의 변수에 넣어줌
				// empNo~deptNo까지의 데이터를 하나의 뭉탱이 데이터로 만들기 위해 Employee 객체에 넣어주고 이 Employee를 ArrayList의 변수인 list에 넣어서 SQL쿼리에서 받아온 데이터 값을 저장한다. 
				// 첫 행 다 값 가져왔으면 다음 값 있나 확인하고 2행도 있으니 다음 값 또 가져옴. 2행의 empNo~deptNo까지 또 가져옴. list에 2개의 행의 데이터가 담겨져있는 상태
				// SCOTT계정의 EMP 테이블의 데이터를 한 행씩 while문 반복을 통해 list에 받아서 저장함. 이렇게 5행까지 다 데이터를 가져오고 가져올 값이 더 없어서 while문 종료
				
			}
			System.out.println(list); // [7369 / SMITH / CLERK / 7902 / null / 800 / 0 / 20, 7499 / ALLEN / SALESMAN / 7698 / null / 1600 / 300 / 30, 7521 / WARD / SALESMAN / 7698 / null / 1250 / 200 / 30, 7566 / JONES / MANAGER / 7839 / null / 2975 / 30 / 20, 7654 / MARTIN / SALESMAN / 7698 / null / 1250 / 300 / 30, 7698 / BLAKE / MANAGER / 7839 / null / 2850 / 0 / 30, 7782 / CLARK / MANAGER / 7839 / null / 2450 / 0 / 10, 7788 / SCOTT / ANALYST / 7566 / null / 3000 / 0 / 20, 7839 / KING / PRESIDENT / 0 / null / 5000 / 3500 / 10, 7844 / TURNER / SALESMAN / 7698 / null / 1500 / 0 / 30, 7876 / ADAMS / CLERK / 7788 / null / 1100 / 0 / 20, 7900 / JAMES / CLERK / 7698 / null / 950 / 0 / 30, 7902 / FORD / ANALYST / 7566 / null / 3000 / 0 / 20, 7934 / MILLER / CLERK / 7782 / null / 1300 / 0 / 10]
			// 전체 사원 14명의 전체 정보를 가져옴 

			// rset.getInt("EMPNO");의 EMPNO은 뭘까?
			// ResultSet의 컬럼명을 가져온 것. select * from emp해서 전체를 오라클에서 다 가져왔기 때문에 ResultSet과 emp테이블의 각 컬렴명과 이름이 같지만, emp테이블의 컬럼명을 가리킨 것이 아님
			
			// 출력은 view에서 할거기에  return list; 해줘야하는데 selectAll( )가  void라 try문 안에 변수들을 밖에서 선언해주고 return을 try문 밖에 읽을 수 밖으로 빼준다
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			rset.close(); // 밑줄 에러 :rset  // 원인 : rset이 try문 안에 있어서 못찾은 것 // 해결 : 변수선언을 try문 밖으로 미리해준다
//			stmt.close(); // try문 밖으로 빼준 후 전체 rset.close() 밑줄 에러 // 해결 : try catch 해줘야함
//			conn.close();
			try {
				rset.close();	// 발생 시킨 객체들 전부 닫아줘야한다
				stmt.close();   // statement, resultset, connection 전부 닫아줘야함
				conn.close(); 	// 규칙 : 가장 나중에 발생한 것부터 닫아준다
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return list; // view로 데이터를 보내는 코드 
		// list 빨간줄 에러 이유 : try문 밖에서 리턴시켜서 찾을 수 없다는 것. 영역 밖이기에.
		// 해결 : ArrayList를 밖으로 빼준다
		
//		return list; 
		// 전체 밑줄 에러
		// 에러원인 : 이 코드 전체를 담고 있는 메소드 selectAll() 의 반환타입 지정이 void라 발생 
		// 해결 : public void selectAll() -> public ArrayList<Employee> selectAll() 으로 변경
		
		// 발생 시킨 객체들 전부 닫아줘야한다
		// 규칙 : 가장 나중에 발생한 것부터 닫아준다
		// statement, resultset, connection 전부 닫아줘야함
		
		
		// model.vo로 가서 ArrayList<Employee> list에 값을 받는다고 코드 지정해줄 것
		
	}
	
	public Employee selectEmployee(int empNo) {
		Employee emp = null;
		Connection conn = null;
//		Statement stmt =  null; 		// 1) Statement 버젼
		PreparedStatement pstmt = null; // 2) PreparedStatement버젼
		ResultSet rset =  null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "qrwe");
			// localhost가 바뀜. 둘 다 같은 의미. localhost = 내컴퓨터
			
			// 1) Statement버젼 : 완성된 query - 스테이트먼트를 쓸 때는 쿼리가 완벽해야한다
			// 2) PreparedStatement 버젼  : 비어있는 공간이 존재 query - 쿼리에 비어있는 공간을 만들어놓는 것이 가능
			
//			String query = "SELECT * FROM EMP WHERE EMPNO = empNO";  // empNO은 문자 그대로 empNO이라 제대로 적용X 
//			String query = "SELECT * FROM EMP WHERE EMPNO ="+ empNo; // empNO 앞까지 문자열 처리
			// SELECT * FROM EMP WHERE EMPNO = 3517
			

			// Statement & PreparedStatement 차이 
			// Statement : 완성된 쿼리라 손 볼 필요 x 따라서 보낼 때 한번에 쿼리만 전달하면 됨
			//				ex)conn.createStatement();
			// PreparedStatement : 미완성 쿼리 . 비워져있는 부분을 채울 것임. 공간을 확보에 해놓은 것. 미완성 쿼리보내면 에러나기에 채워줘야함.
			//					    위치홀더 때문에 미완성된 쿼리라 비어있는 값을 채우기 위해 String query를 집어 넣고서 만든다
			//				ex)conn.prepareStatement(query);


			
			// 1) Statement버젼 : 완성된 query - 스테이트먼트를 쓸 때는 쿼리가 완벽해야한다
//			String query = "SELECT * FROM EMP WHERE EMPNO ="+ empNo; // empNO 앞까지 문자열 처리
//			stmt = conn.createStatement(); // 인자x // statement에는 createStatement()만 사용
//			rset = stmt.executeQuery(query); 
			
			// 2) PreparedStatement 버젼  : 미완성 쿼리. 비어있는 공간이 존재 query - 쿼리에 비어있는 공간을 만들어놓는 것이 가능
			//		위치홀더(=?) : 값을 넣기 위한 공간 확보 // 기호 : ?
			String query = "SELECT * FROM EMP WHERE EMPNO = ?";	// 위치폴더 : ?
			pstmt = conn.prepareStatement(query); // PreparedStatement 인자 삽입 필요
			// 비어놓은 공간을 채워보자
			pstmt.setInt(1, empNo); // int타입 데이터 add // 인자는 zerobase가 아닌 1부터 시작하는 인덱스
					    // setInt(몇번째 존재하는 위치홀더인지, 앞에서 지정한 위치홀더에 어떤 값에 넣을건지)			
						// setInt(1, empNo) 의미 : 첫번째 위치홀더에 사용자가 입력한 사번(empNo)을 넣어라
						// 즉, pstmt에는 이미 "SELECT * FROM EMP WHERE EMPNO = ?" 이게 들어가있고 여기서 1번째 위치홀더 ? 대신 사원번호 넣으라는 것
						// 				  "SELECT * FROM EMP WHERE EMPNO = 사번"이 들어가게 되는 것
			
			rset = pstmt.executeQuery();   // 쿼리는 이미 위의 conn.prepareStatement(query);에서 보냈기에 여기서는 기술안함
			
			// Q.위치홀더 세우는 이유는 유저입력이 뭘 받을지 몰라서 해주는건가요?
			// A.yes. 위치폴더 세우거나 변수입력으로도 가능
			// Q."SELECT * FROM EMP WHERE EMPNO = ? AND ENAME = ? " 위치홀더 자리가 2번인건 ENAME =? 을 말하는거 맞죠?
			// A.yes
			// Q.보통 PreparedStatement는 조건식에 다수의 함수나 조건이 있을때 쓰겠네요?
			// A.yes. 동적인 값이 많이 들어갈 때 사용
			// Q.그럼 set자료형 메소드도 위치홀더 갯수만큼 만들어서 위치홀더 순번과 해당 값을 넣어주면 되는거죵?
			// A.yes

			
			// 이 리절트셋 안에 몇개의 데이터가 들어가 있을까?
			// 없거나 1개이거나 한 상황이 될 것 // not null로 들어가 있어 여러개 나올 수 있지만 주식별자 역할을 하도록 만들어놨을 것이라 중복이 되지 않게끔 하기 위해 
			
			// 0개나 1개여서 while문 사용 필요 x
			if(rset.next()) { 	// 있거나 없거나로 조건식
//				int empNo = rset.getInt("EMPNO");	// 받아온 변수와 empNo 변수명이 중복되서 밑줄에러 // 안받아올 것. selectEmployee(int empNo)에 입력한 사원값이 있으니까
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");  
				Date hireDate = rset.getDate("HIREDATE"); // java.sql.Date
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");	
				
				emp = new Employee(empNo, empName, job, mgr, sal, comm, deptNo);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			rset.close(); // 밑줄 에러 :rset  // 원인 : rset이 try문 안에 있어서 못찾은 것 // 해결 : 변수선언을 try문 밖으로 미리해준다
//			stmt.close(); // try문 밖으로 빼준 후 전체 rset.close() 밑줄 에러 // 해결 : try catch 해줘야함
//			conn.close();
			try {
				rset.close();	// 발생 시킨 객체들 전부 닫아줘야한다
//				stmt.close();   // statement, resultset, connection 전부 닫아줘야함
				pstmt.close();   
				conn.close(); 	// 규칙 : 가장 나중에 발생한 것부터 닫아준다
			} catch (SQLException e) {
				e.printStackTrace();
			}	

		} 
		
		return emp; // Employee e // return e; 전체 밑줄에러 : Employee e를 밖으로 뺴줘서 인식하게 해줘야한다
					// 근데 또 밑줄에러 : Void methods cannot return a value -> 반환타입 void라 에러
					// selectEmployee()메소드의 반환타입을 void to Employee로 변경
		
		
	}
	
	
	// 메뉴2.사번으로 사원 정보 조회
	public int insertEmployee(Employee e) {		// return타입 변경 : void to int
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SCOTT","qrwe");
//			conn.setAutoCommit(false); 		// 18c버젼에 추가해야하는 코드
			// 1) Statement 방식 쿼리문
			String query = "INSERT INTO EMP VALUES(" + e.getEmpNo() + ", "	// 완성된 쿼리이기에 -> Statement
													+ e.getEmpName() + ", "
													+ e.getJob() + ", "
													+ e.getMgr() + ", "
													+ "SYSDATE, "		    // 오늘 날짜 삽입
													+ e.getSal() + ", "
													+ e.getComnn() + ", "
													+ e.getDeptNo() + ") "; // 간단한 쿼리인데 자바로 옮겨쓰니 복잡해지고 길어짐.
			// Statement & PreparedStatement  둘 다 사용가능
			// 위의 쿼리처럼  동적인 값이 많다면,  PreparedStatement가 유리. 아래처럼 코드가 확 짧아짐
			
			// 2) PreparedStatement 방식 쿼리문
			String query2 = "INSERT INTO EMP VALUES(?, ?, ?, ?, SYSDATE, ? ,? ,?)"; // 
			pstmt = conn.prepareStatement(query2);
			pstmt.setInt(1, e.getEmpNo());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getMgr());
			pstmt.setInt(5, e.getSal());
			pstmt.setInt(6, e.getComnn());
			pstmt.setInt(7, e.getDeptNo());
			
			result = pstmt.executeUpdate(); // DML(insert,update,delete)문이라 executeUpdate():int 사용
			// 위의 conn.prepareStatement(query2); 이미 쿼리문을 보냈기 때문에 executeUpdate()안에 인자 필요x
			
			// 트랜젝션 처리
			// commit할지 rollback할지
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		
		return result;	// insertEmployee()의 반환타입 void to int로 변경
		
		// dml 삽입완료. 데이터 확정지을지 취소할지(커밋할지 말지) 정해야함.  
		
	}
	
	
	// 메뉴4.사번으로 사원 정보 수정
	public int updateEmployee(Employee emp) {		// job sal comm 수정할 것
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SCOTT","qrwe");
			String query = "UPDATE EMP SET JOB = ?, SAL = ?, COMM = ? WHERE EMPNO = ?"; // job sal comm 수정할 것
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getJob());
			pstmt.setInt(2, emp.getSal());
			pstmt.setInt(3, emp.getComnn());
			pstmt.setInt(4, emp.getEmpNo());
			
			result = pstmt.executeUpdate();	// DML문은 executeUpdate() 사용
			
			// 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	// 메뉴5.사번으로 사원 정보 삭제
	public int deleteEmployee(int empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SCOTT","qrwe");
			String query2 = "DELETE FROM EMP WHERE EMPNO = ?"; 
			pstmt = conn.prepareStatement(query2);
			pstmt.setInt(1, empNo);
			result = pstmt.executeUpdate();
			
			// 트랜잭션 처리
			if (result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;	
	}
	
	
}










