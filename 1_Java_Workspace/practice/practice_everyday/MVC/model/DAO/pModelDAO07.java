package MVC.model.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MVC.model.vo.pModelVo07;

public class pModelDAO07 {

// DAO : Date Access Object
//		 데이터를 외부에 저장해놓을 수 있는 파일,db
//	 	 서로 왔다갔다 할 수 있는 공간으로 사용됨
//	 	외부 데이터 저장공간과 연결
//	 	DAO는 DB의 data에 접근하기 위한 객체로 직접 DB에 접근하여 데이터를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행한다.

	
	
	// 메뉴1.전체 사원 정보 조회
	public ArrayList<pModelVo07> selectAll() {
		ArrayList<pModelVo07> al = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "qrwe"); 
			String query1 = "SELECT * FROM EMP";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query1);
			
			al = new ArrayList<pModelVo07>();
			while(rset.next()) {
				
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				
				pModelVo07 pv07 = new pModelVo07(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				
				al.add(pv07);
						
				System.out.println(al);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return al;
	}
	
	
	
}
