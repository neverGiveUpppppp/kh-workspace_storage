package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;

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

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class pwdCheckEmailServlet
 */
@WebServlet(urlPatterns="/pwdCheckEmail.me", name="pwdEmailServlet")
public class PwdCheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdCheckEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//에이잭스로 idFindPage에서 보낸 data 사용하기 편한 변수에 저장
				String userId = request.getParameter("id");
				String strBornDate = request.getParameter("strBornDate");
				String userEmail = request.getParameter("email");

				//생년월일 타입을 java.sql.Date형식으로 변환
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						
				java.sql.Date sdate = null;	
				java.util.Date udate = null;
						
				try {
						udate = sdf.parse(strBornDate);
						sdate = new java.sql.Date(udate.getTime());
							
					} catch (ParseException e) {
						e.printStackTrace();
					}
				
				//임시비밀번호 생성하고 받아온 회원정보로 Member객체 생성해서 DAO로 넘겨주고 해당하는 회원의 Pwd를 임시Pwd로 변경해주기
			
				String newPwd = request.getParameter("inputPwd");
				String emailPwd = request.getParameter("emailPwd");
				
				System.out.println(newPwd);
				System.out.println(emailPwd);
				
				HttpSession newPwdSession = request.getSession();
				newPwdSession.setAttribute("emailPwd", emailPwd);
				newPwdSession.setMaxInactiveInterval(600);
				
				//멤버객체 생성해서 에이잭스로 보낸 데이터 대입 후 아이디 조회해서 객체 가져오기 
				Member member = new Member();
					
				member.setUserId(userId);
				member.setBornDate(sdate);
				member.setUserEmail(userEmail);
				
				//일치하는 멤버 객체 selectMember레퍼런스에 저장 
				int changePwd = new MemberService().changeMemberPwd(member, newPwd);
				Member findMember = new MemberService().findMember(member);
						
				//임시 비밀번호로 변경, 조건에 맞는 회원 모두 찾았을 경우 메일 전송
				if(changePwd > 0 && findMember != null) { 
					String sender = "itkw87@naver.com"; //보내는 이메일 주소
					String password = "79*MAst8546";
					
					
					String receiver = request.getParameter("email"); //받는 사람
					String title = "[대한민국 대표 맛집 커뮤니티 맛조!]" + findMember.getUserName() + " 회원님의 임시 비밀번호 안내";
					String content = "<div style='background:white; width:100%; height:100%;'><b>" + findMember.getUserName()+ 
							" 회원님의 임시비밀번호는 <span style='color:red;'>" + newPwdSession.getAttribute("emailPwd")+ " 입니다.</span></b>"
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
				
				
				
					
				
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
