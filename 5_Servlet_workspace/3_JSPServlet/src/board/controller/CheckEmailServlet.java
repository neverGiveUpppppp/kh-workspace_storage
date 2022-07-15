package board.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckEmailServlet
 */
@WebServlet("/checkEmail.me")
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 보내는 쪽의 이메일 주소
		// 진짜 이메일 아디 비번 필요함
		// 네이버랑 지메일 방법이 달라서 네이버로 고정할 것임
		String sender = "보낼 이메일 아이디 기입";	// 인증 보내는 사람
		String password = "보낼 메일 비번 기입";	// 진짜 메일 비번
		
		String receiver = request.getParameter("email"); // 인증 받는 사람
		String title = "[JSP/Servelt] 이메일 인증";
//		String content = "이메일이 정상적으로 도착했습니다."; // 내용 자체를 css나 html로 꾸며서 코드로 보내기도 가능
		String content = "<b>이메일이 <span style='color:red;'>정상적으로 도착했습니다.</span></b>"; // 내용 자체를 css나 html로 꾸며서 코드로 보내기도 가능
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com"); // smtp.naver.com : smtp를 네이버로 지정해서 사용하겠다
		prop.put("mail.smtp.auth", "true");	// 네이버 api 가져다 쓰는 것
		// 프로퍼티즈 만든 이유
		// smtp 메일 관련된 프로토콜 관련된 것 
		// 간이 우편 전송 프로토콜(Simple Mail Transfer Protocol)
		
		Session session = Session.getDefaultInstance(prop, new Authenticator(){ // 두번쨰 매개변수에는  원래는 객체를 상속받아서 집어넣어야함. 지금은 익명 클래스로 만들 것임
		// 인터페이스 / abstract는 바로 객체 생성해서 못쓰기 때문에 상속해서 객체 생성할 수 있음. 이 코드 Session.getDefaultInstance(prop, )
		// 하나 쓰자고 상속하기에는 번거로우니 마치 누군가가 상속받은걸 써오는 것이 익명 클래스. 마치 상속 받은 것처럼 쓰는 것을 익명 클래스라고 함. 
		// 실제로는 상속 받은게 아님. 자바 gui, event 부분에 나오는 개념임
			
			// 상속 받은 것처럼 한거니까 이 안에서 메소드(getPassword)를 오버라이딩할 것임
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password); // 보내는 사람의 아이,비번 
			}
		}); // 여기까지 계정 설정 작업
		
		
		
		
		// 여기부터 이메일 보내기
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			
			// 제목, 내용 설정
			message.setSubject(title);
			message.setText(content, "UTF-8", "html"); // 보내는게 html 형식이라 .. 강의 5:33
			
			// 메일 보내기
			Transport.send(message);
			// 보내는 사람으로 만들 때, 네이버 멜 들어가서 좌측 하단에 환경설정- pop3IMAP설정에서 사용함 체크 그리고 로그인보안2단계에서는 안되므로 풀어줘야한다
			
			// 에이젝스 해야한다는 이유
			// 회원가입 페이지에 입력했던 내용이 지워지거나 다시 써줘야하니까 불편함
			
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
