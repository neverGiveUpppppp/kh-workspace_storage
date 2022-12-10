package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	// Template의 필드와 메소드는 static
	
	
	
	private JDBCTemplate(){}
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		// 외부 지정 방식
		String fileName = JDBCTemplate.class.getResource("/sql/driver.properties").getPath(); // getResource() : 프로젝트 익스플로러에서 자바 리소스 안에 src 폴더 의미

				
		if(conn == null) { // 접속안될 때만 작동하는 이프문
			try {
				prop.load(new FileReader(fileName));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"),
													prop.getProperty("username"),
													prop.getProperty("password")); 
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	

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
