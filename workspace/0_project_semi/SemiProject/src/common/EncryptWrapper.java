package common;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//요청을 하여 가공을 들어가야되면 HttpServletRequestWrapper를 상속받고 
//응답을 받아 가공을 해야하면 HttpServletResponseWrapper를 상속받아 사용해야한다.
//EncryptWrapper클래스는 HttpServletRequestWrapper를 상속받아 사용해야하는데 
//HttpServletResponseWrapper에는 기본생성자가 존재하지 않아 상속받아서 자식클래스로 상속 받을때 에러가 발생한다.
//원래 조상클래스를 상속받는 자식클래스는 객체 생성시 자신의 객체안에 일정영역에 상속받은 부모의 객체를 생성해 놓는다.
//근데 상속받는 부모 클래스가 기본생성자가 없으니 부모클래스의 객체를 생성할 수 없어 다음과 같은에러가 나는것
//Implicit super constructor HttpServletRequestWrapper() is undefined for default constructor. 
//Must define an explicit constructor
//그냥 추가해주면 에러 해결!
public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
@Override
public String getParameter(String name) {
	String value = null;
	
	
	
	if(name != null && (name.equals("inputPwd") || name.equals("newPwd1") || name.equals("newPwd2"))) {
		//name속성이 inputPwd이면 암호화진행
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			String pwd = super.getParameter(name);
			byte bytes[] = pwd.getBytes(Charset.forName("UTF-8")); // String을 Byte배열로 만듬
			md.update(bytes); //MessageDigest update()의 매개변수로 넣어주기 위해 bytes배열로 만둘어 준것임 
			
			value = Base64.getEncoder().encodeToString(md.digest()); //digest()는 암호화된 패스워드를 bytes배열로 
			//반환하는데 암호화된 패스워드가 bytes형식이 아닌 String형식으로 필요하므로 바꿔줌
		} catch (NoSuchAlgorithmException e) {//그런 알고리즘은 없어라는 예외 즉, "SHA-512"가 아닌 다른 알고리즘 넣었을때 발생할 수 있는 예외를 처리하기위함
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		value = super.getParameter(name);
	}	//원래대로 진행해서 반환값 받겠다
	
	return value;
	
}
	
}
