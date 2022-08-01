package member.controller;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmailCheckNumber
 */
@WebServlet("/checkNumber.do")
public class EmailCheckNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckNumberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//에이잭스로 idFindPage에서 보낸 data 사용하기 편한 변수에 저장
		String emailId = request.getParameter("emailId");
		String email = request.getParameter("email");
		
		int emailLength = emailId.length();
//		System.out.println(emailId.length());		
		
		HttpSession checkNumSession = null; //if문 밖에서 사용한 checkNumSession인식용
		//임시 비밀번호로 변경, 조건에 맞는 회원 모두 찾았을 경우 메일 전송
			if(emailLength != 0) {
				//인증번호 난수로 만들고 세션에 저장 후 메일로 인증번호 보내기
				Random rd = new Random();
			
				int checkNumber = Math.abs(rd.nextInt());
				
				System.out.println(checkNumber);
				
				checkNumSession = request.getSession();
				checkNumSession.setAttribute("checkNumber", checkNumber);
				checkNumSession.setMaxInactiveInterval(120); 

				
				String sender = "itkw87@naver.com"; //보내는 이메일 주소
				String password = "79*MAst8546";
				
				
				String receiver = request.getParameter("email"); //받는 사람
				String title = "[대한민국 대표 맛집 커뮤니티 맛조!] 회원가입을 위한 인증번호 안내";
				String content = "<div style='background:white; width:100%; height:100%;'><b>인증번호는  <span style='color:red;'>" + checkNumSession.getAttribute("checkNumber")+ " 입니다.</span></b>"
						+ " 항상 저희 맛조를 이용하여주시는 회원 여러분들께 <br>감사의 말씀을 드리며 앞으로도 변함없는 최고의 서비스를 제공해 드리기위해 최선을 다하겠습니다.</div>";
				
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.naver.com");
				prop.put("mail.smtp.auth", "true");
				
				Session session = Session.getDefaultInstance(prop, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(sender, password);
					}
				});
				
				MimeMessage message = new MimeMessage(session);
				
				try {
					message.setFrom(new InternetAddress(sender)); //보내는 이
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); //받는이
					
					message.setSubject(title);
					message.setText(content, "UTF-8", "html");
					
					Transport.send(message);
					
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				} 
			
			} 
			//if문 조건식에 맞지 않아도 세션은 무조건 전송되게 밖으로 빼줌(에이잭스 통신실패 유도)
			int hiddenNumber = (int)checkNumSession.getAttribute("checkNumber");
			
			PrintWriter pw = response.getWriter();
			pw.print(hiddenNumber);
		}
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
