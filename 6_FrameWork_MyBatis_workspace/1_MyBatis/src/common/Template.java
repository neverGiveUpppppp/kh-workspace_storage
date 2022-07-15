
package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public Template() {} // 기본 생성자
	
	public static SqlSession getSqlSession() {
		
		
		SqlSession session = null;
		
			try {
				// MyBatis 설정파일 읽어오기
				InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
				
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder(); // 객체생성
				SqlSessionFactory ssf = ssfb.build(stream); // 생성한 SqlSessionFactoryBuilder 객체(클래스)와 InputStream으로 읽어온 mybatis-config.xml
				session = ssf.openSession(false); // false : 자동 커밋 하지않겠다는 의미 // 이중안전장치로 false 세팅함
				// * 위의 세줄 한줄로 단축 가능

				// close, commit, rollback 메소드는 안써도 마이바티스에서 처리해줌
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return session;
	}
	
}





