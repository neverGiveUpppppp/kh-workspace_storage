package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import oracle.net.aso.a;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);	// 
	}

	
	public String getParameter(String name) { // html의 name속성값
//		return super.getParameter(name); // 오버라이딩할거면 앞에거 쓰는 의미가 없으니 삭제해줄 것
		
		
		// id,address,date 등 다른건 필요없이 pw일 때만 암호화해주면 됨
		// 유저가 회원가입할 때 적는 많은 항목 중 pw만 골라서 암호화해야함
		String value = null;
		
		
		// 비번과 관련된 모든 폼들의 name속성값이 있으면 암호화 하겠다는 조건
		if(name != null && (name.contentEquals("userPwd") || name.equals("joinUserPwd") || name.equals("newPwd"))){
			// 암호화 진행 : SHA-512
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				// 암호화가 된거를 Digest라고 부름
				String pwd = super.getParameter(name);
				byte[] bytes = pwd.getBytes(Charset.forName("UTF-8")); // str자체를 바이트 배열로 바꿔주는 메소드
				// 그냥 하면 깨지니 Charset.forName("UTF-8") 바꿔줌
				md.update(bytes); // 여기까지 암호화를 할려는 준비단계		강의2:17
				
				
				// 본격적인 암호화 단계
				md.digest(bytes);
						
				value = Base64.getEncoder().encodeToString(md.digest()); // 암호화 완료
				//실제 암호화는 digest()가 해주는 것
				
				// 오버라이딩 ..bytes. 반환되서 네임값 중 userPwd,joinuser,newpwd에서 받으면 암호화 진행하고
				// 아니면 else로 들어감 강의 2:20
				
				
				// Q.encodeToString이 String값으로 암호화하라는 건가요?
				// A.강의 2:22		
				// 
				// Q.byte배열로 반환된것을 encodeToString()으로 String값으로 바꿔주는거맞나여?
				// A.yes
				
				
				// extends HttpServletRequestWrapper
				// 래퍼는 필터로 부터 전달된 값을 가공하기 위해서 쓰는게 래퍼기 때문에 래퍼랑 필터랑 같이써야함
				// 필터 만들러가자
				// common 패키지 필터에 필터 생성 ㄱ
				
				
				
				
			} catch (NoSuchAlgorithmException e) { // NoSuchAlgorithmException : 이런 알고리즘은 없다는 예외
				e.printStackTrace();
			}
			
			
		}else {
			value = super.getParameter(name);
		}
		
		
		return value;
		
		
		
		
	}
	
	
	
	
	
	
	
}





