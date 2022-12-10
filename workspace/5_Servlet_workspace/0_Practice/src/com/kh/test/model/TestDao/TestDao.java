package com.kh.test.model.TestDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.kh.test.model.Test;

public class TestDao {

	
	public List<Test> selectList() {
		
		List<Test> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("Oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.3:1521:xe","kh","kh");
			
			String query = "SELECT * FROM TEST";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				int seq = rset.getInt("SEQ");
				String writer = rset.getString("WRITER");				
				String title = rset.getString("TITLE");				
				String content = rset.getString("CONTENT");				
				Date regDate = rset.getDate("DATE");		
				
				list.add(new Test(seq, writer, title, content,regDate));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rset.close();	
				stmt.close();   
				conn.close(); 	
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return list;
	}
	
}
