package com.kh.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


// 반복되는 JDBC 과정을 수행하는 역할을 하는 클래스
// 싱글톤 패턴과 유사하게 코딩할 것임
// 싱글톤 패턴
// 프로그램 시작 시 메모리에 객체를 딱 한 개만 기록하게 하는 패턴(static 영역에 올리는 것)   ex)Math

public class JDBCTemplate {

	// 기본 생성자의 접근 제한자는 private, 모든 필드/메소드 static

	private static Connection conn = null; // 퍼블릭 스태틱이 정상적이긴 하나 거기까지 필요없기에 프라이빗으로
	
	
	// 기본생성자
	
	private JDBCTemplate(){} 
	
	// 내부 지정 방식
	public static Connection getConnection2() { // Connection을 얻기 위한 메소드

		if(conn == null) { // 접속안될 때만 작동하는 이프문
			try {
				// 내부 지정 방식
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MEMBER", "qrwe"); 
				//
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	// 외부파일 방식
	public static Connection getConnection() { // Connection을 얻기 위한 메소드

		if(conn == null) { // 접속안될 때만 작동하는 이프문
			try {
				// 외부파일 방식
				Properties prop = new Properties(); // collection-Map-properties의 properties //  Properties는 HashTable을 상속받아 구현한 컬렉션의 한 종류
				prop.load(new FileReader("driver.properties")); // driver.properties에 적어둔 url,username,pw등 불러오는 코드
				
				
				Class.forName(prop.getProperty("driver")); // "driver"라고 하는 값을 키로 가져오겠다는 의미의 코드. 여기서 driver는 외부파일에서 driver 뭐쓰는지의 driver ex)오라클 쓰겠다고 드라이버
				conn = DriverManager.getConnection(prop.getProperty("url"), 
												   prop.getProperty("username"), 
												   prop.getProperty("password"));
				
			} catch (ClassNotFoundException e) { // 클래스가 없는 경우 발생하는 에러메세지 
				e.printStackTrace();
			} catch (SQLException e) {			 // DB 또는 드라이버로 인해 발생하는 에러메세지
				e.printStackTrace();
			} catch (FileNotFoundException e) {	 // 파일 못 찾을 경우
				e.printStackTrace();
			} catch (IOException e) {			 // 입출력할 때 실패하거나 중단된 I/O작업 때문에 에러메시지 발생
				e.printStackTrace();
			}	
		}
	
		return conn;
	}
	
	// close()랑 rollback/commit을 해줘서 코드 길이 줄여볼 것 임
	
	
	// commit()
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) { // conn.isClosed()은 SQLException 필요함
				conn.commit();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// rollback()
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) { // conn.isClosed()은 SQLException 필요함
				conn.rollback();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Connection의 close처리
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) { // conn.isClosed()은 SQLException 필요함
				conn.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet의 close처리
//	public static void close(ResultSet rset) { 
//		// close(ResultSet rset)만 적었는데 위의 close와 다르게 에러 안나는 이유
//		// 답 : 오버로딩이 적용되었기 때문
//	}
	public static void close(ResultSet rset) { 
		try {
			if(rset != null && !rset.isClosed()) { // conn.isClosed()은 SQLException 필요함
				rset.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Statement의 close처리
	public static void close(Statement stmt) { 
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 위의 같은 이름인 3개의 close()메소드는 오버로딩 된 것
	
	// PreparedStatement는 close처리 메소드 안만들 것임
	// 이유 : PreparedStatement는 Statement의 자식 클래스이기 때문. 
	// Q.then, 안닫아주는게 상속관계랑 무슨 상관일까?
	// A.다형성 때문. 부모타입은 자식 객체 다 받을 수 있기 때문에 스테이트먼트에 프리페어드가 들어갈 수 있어 프리페어드도 처리가됨. 이는 동적바인딩으로 들어가게됨
	
	
	
}














