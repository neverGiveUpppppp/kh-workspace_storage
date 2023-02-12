package com.kh.Spring.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.Spring.member.model.exception.MemberException;
import com.kh.Spring.member.model.service.MemberService;
import com.kh.Spring.member.model.vo.Member;

@SessionAttributes("loginUser")
@Controller // 컨트롤러의 역할을 갖는 객체를 생성 = 빈bean(객체) 등록
public class MemberControllerArranged {
	
	// 강의 2:32
	@Autowired 
	private MemberService mService; 
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private Logger logger = LoggerFactory.getLogger(MemberControllerArranged.class);
	
/*****************************파라미터 전송 받기 *****************************/
// 1. HttpServletRequest 방식 : JSP/Servlet 방식
// 2. @RequestParam방식 : 파라미터 1:1 매핑
// 3. @RequestParam 생략방식
// 4. @ModelAttribute 방식 : 객체매핑(ex:class vo)
// 5. @ModelAttribute 생략방식 

// 세부코드 및 부연설명은 MemberController 참조


/******************************** 데이터 전달하기 ********************************/
// 1. Model객체 사용
// 2.ModelAndView 객체 사용
// 		Model + View --> 데이터와 뷰를 한 번에 담는 객체

/***************************************************************************/
	
	
	/** 로그인
	 * @param m
	 * @param model
	 * @return
	 */
	@RequestMapping(value="login.me", method=RequestMethod.POST)
	public String login(Member m, Model model) {
		
		// 암호화 얻어서 db에 원본비번이랑 교체해줄 것
		System.out.println(bcrypt.encode(m.getPwd()));
		
		// HttpSession 대신 셋어트리뷰트 사용할거라 HttpSession 삭제 
		
		Member loginMember = mService.login(m);
		
		
		boolean match = bcrypt.matches(m.getPwd(), loginMember.getPwd()); // 원본코드와 db의 비번컬럼값 넣기
		// 어떻게 비교하는지는 보안상 비밀. matches가 내부 로직으로 비교해줌

		if(match) {
			model.addAttribute("loginUser", loginMember);
			logger.info(loginMember.getId());
			return "redirect:home.do";
		}else{
//			model.addAttribute("msg","로그인 실패하였습니다");
//			return "../common/errorPage"; 
			// 예외 클래스 만들었으니 써보자
			throw new MemberException("로그인에 실패하였습니다");
		}
		// 이렇게만 쓰면 로그인 유지 안됨.
		// 세션에 올라가있는게 아니라 한번 넣고 끝나서 로그인 유지 x
		// @SessionAttributes 사용하면 해결됨
		// 파일 최상단으로 가서 @Controller 위에 @SessionAttributes 적어줌
		
		// 비밀번호 로그인 받아온 걸 콘솔찍는데 암호화한걸
		// db의 암호를 암호화된 암호로 바꿀 것
	}

	/** 연습 텍스트**/
	// 로그인 할려는 유저 정보 받아오기
	// 로그인할려는 유저와 db에 해당 유저와의 정보 비교
	// 맞다면, 데이터를 뷰로 보내기
	// 해당 유저id정보 로그 남기기
	// 어떤 뷰로 갈지 지정
	
	
	
	
	/** 로그아웃
	 * @param status
	 * @return
	 * 
	 * @SessionAttributes 사용과 함께 제대로 된 로그아웃
	 */
	@RequestMapping("logout.me")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:home.do";
	}
	
	/** 연습 텍스트**/
	// 세션 종료 선언
	// 어떤 뷰로 갈지 지정
	
	
/************************************** 회원가입 ***************************************************/
	
	
	
	
	/** 회원등록 페이지 전환
	 * @return
	 */
	@RequestMapping("enrollView.me")
	public String enrollView() {
		if(logger.isDebugEnabled()) { 	// 로그에서 해당 패키지,클래스에있는 로그들을 뽑아내고 진행하는데 레벨을 debug, info 지정해두었는데, 
			logger.debug("회원등록페이지");	// info로 지정하고 debug나오길 기다리면 어차피 안나오기에 logger를 줄 필요 없으니 debug가 있을 때만 등록되서 로그가 찍히도록 불필요한 로그를 안적도록 적는 if문
		}
		return "memberJoin";
	}
	
	/** 연습 텍스트**/
	// 로그 남기기
	// 회원등록 버튼 눌렀을 때 해당 페이지로 이동하도록
	

	
	// 회원가입
//	@RequestMapping("minsert.me")
//	public void insertMember(@RequestParam(value="id", required=true) String id, 
//							   @RequestParam(value="name", required=true) String name, 	
//							   @RequestParam(value="pwd", required=true) String pwd,
//							   @RequestParam(value="pwd2", required=true) String pwd2,
//							   @RequestParam(value="nickName", required=true) String nickName,
//							   @RequestParam(value="gender", required=true) String gender,
//							   @RequestParam(value="age", required=true) int age,
//							   @RequestParam(value="email", required=true) String email,
//							   @RequestParam(value="phone", required=true) String phone,
//							   @RequestParam(value="post", required=true) String post,
//							   @RequestParam(value="address1", required=true) String address,
//							   @RequestParam(value="address2", required=true) String address2) {	
		// @ModelAttribute와 @RequestParam 두가지 방법으로 뷰 데이터 받아올 수 있음
		// 뷰에서 파라미터 받아올게 많기에 기본적으로 방법4모델어트리뷰트 쓰면된다
////////// 			여기서 @ModelAttribute와 @RequestParam 두가지 섞어 써야하는 이유  //////////////
		// vo 필드명이랑 뷰의 name속성이랑 강사님이 맞춰둠
		// but 우편번호, 도로명주소, 상세주소는 못받아옴
		// vo의 필드명 address 하나에 우편번호, 도로명주소, 상세주소의 3개 인자를 다 넣을 수가 없어서 리퀘스트파램으로 따로 받아왔어야했음
	
	
	
	// 뷰에서 데이터 받아오기
//	@RequestMapping("minsert.me") // 속성 생략
//	@RequestMapping(value = "minsert.me", method=RequestMethod.POST)
//	public String insertMember(@ModelAttribute Member m, 
//							   @RequestParam("post") String post,
//							   @RequestParam("address1") String address1,
//							   @RequestParam("address2") String address2) {
//		
//		System.out.println(m);
//		System.out.println("id" + m.getId());
//		System.out.println(post +"/" + address1 + "/" + address2);
//
//		m.setAddress(post +"/" + address1 + "/" + address2); // m에 리퀘스트파램으로 받은 정보까지 채워줌. 전체회원정보가 다들어가있는 상태
//		// 비밀번호가 그대로 개발자에게 노출되기 때문에 문제됨
//		// 스프링이 쓰는 보안이 뛰어난 방식 : BCrypt 암호화 방식
//		// 		원본 데이터 --> salting, salt값 --> 암호화 데이터
//		//						(random)
////		원본 데이터에서 솔팅을 진행하면 얘는 암호화가 된 데이터가 발생함(다이제스트라고 부름)
////		sha512도 마찬가지고 중간에 솔팅값이 들어가면서 원본 데이터가 암호화가 되는건데 솔팅값이 계쏙 동일하게 되면 a라는 데이터가 들어가면 게속 똑같은 암호화된 데이터가 들어가게 되면서 일정 패턴이 생기는 것
////		비크립트는 솔팅값을 랜덤하게 생성
////		그러다보니 똑같이 비밀번호를 집어넣어도 암호화된 데이터가 다 다르게 나옴
////		jsp때는 항상 암호화가 같아서 db와 값을 비교만 했으면 됬으나 스프링에서는 다름
//		
//		String encPwd = bcrypt.encode(m.getPwd()); // encode() : 암호화가 된 비번을 반환하는 메소드
//		// m.getPwd() : 원본 비번을 넘기는 역할. ex) pass01
//		System.out.println(encPwd);
//		
//		m.setPwd(encPwd); // m에 다시 넣어주기
//		System.out.println(m);
//		
//		int result = mService.insertMember(m);
//		if(result > 0) {
//			return "redirect:home.do";
//		} else {
//			throw new MemberException ("회원가입에 실패하였습니다.");
//		}
//	}
	
	
	
	/** 회원 등록
	 * @param m
	 * @param post
	 * @param address1
	 * @param address2
	 * @return
	 */
	@RequestMapping(value = "minsert.me", method=RequestMethod.POST)
	public String insertMember(@ModelAttribute Member m, 		// 회원가입하는 유저에 대한 객체 정보 받기
							   @RequestParam("post") String post,
							   @RequestParam("address1") String address1,
							   @RequestParam("address2") String address2) {
		
		// 상세주소 포함해서 주소 다시 저장
		m.setAddress(post +"/" + address1 + "/" + address2);
		
		// 유저 정보 중 비번을 암호화하는 작업
		String encPwd = bcrypt.encode(m.getPwd());
		m.setPwd(encPwd);
	
		// DB처리
		int result = mService.insertMember(m);
		if(result > 0) {
			return "redirect:home.do";
		} else {
			throw new MemberException ("회원가입에 실패하였습니다.");
		}
		
	}	
	/** 연습 텍스트**/
	// 회원가입하는 유저에 대한 객체 정보 받기
	// 상세주소 포함해서 주소 다시 저장
	// 유저 정보 중 비번을 암호화하는 작업
	// DB처리
	
	
	/********************************* 내정보보기 & 회원정보 변경 ***************************************************/
	
	
	/** 내정보보기
	 * @return
	 */
	@RequestMapping("myinfo.me") // menubar.jsp
	public String myInfo() {
		return "mypage";
	}
	/** 연습 텍스트**/
	// 내정보보기 눌렀을 때 해당 페이지로 넘겨주기
	
	
	
	
	/**회원 수정폼
	 * @return
	 */
	@RequestMapping("mupdateView.me")
	public String updateView() {
		return "memberUpdateForm";
	}
	/** 연습 텍스트**/
	// 회원정보 수정 눌렀을 때 해당 페이지로 넘겨주기
	
	
	
	/** 회원정보 수정
	 * @param member
	 * @param post
	 * @param address1
	 * @param address2
	 * @param model
	 * @return
	 */
	@RequestMapping("mupdate.me")
	public String updateMember(@ModelAttribute Member m,
							   @RequestParam("post") String post,
							   @RequestParam("address1") String address1,
							   @RequestParam("address2") String address2,
							   Model model) {
		
		// 상세주소들(adres1,2) 포함해서 주소정보 다시 유저정보(MemberVO)에 넣기
		m.setAddress(post +"/" + address1 + "/" + address2);
		
		// 유저정보 업데이트 실행 : vo값 -> DB로 저장
		int result = mService.updateMember(m);
		
		// 업뎃한 정보를 클라이언트한테 보여주기 위해 최신정보를 select 해오기 위한 select문
		Member loginUser = mService.login(m); // Member m을 그대로 그냥가져오면 비번이 비어서 가기에 문제 발생 방지차 다시 넣어줌
											  // 여기 m은 null 뜨고 loginUser에 비번이 들어가있음
		if(result > 0) {
			model.addAttribute("loginUser",loginUser); // 최신정보인 select문을 뷰로 보내주기
			return "redirect:myinfo.me";
		}else {
			throw new MemberException("회원정보 수정에 실패했습니다");
		}
	}

	/** 연습 텍스트**/
	// 회원정보 수정
	// 상세주소들(adres1,2) 포함해서 주소정보 다시 유저정보(MemberVO)에 넣기
	// 유저정보 업데이트 실행 : vo값 -> DB로 저장
	// 업뎃한 정보를 클라이언트한테 보여주기 위해 최신정보를 select 해오기 위한 select문
	// 최신정보인 select문을 뷰로 보내주기
	
	
/****************************** 회원 비번변경 ******************************/	
	
	
	
	
	
	/** 비번 수정폼
	 * @return
	 */
	@RequestMapping("mpwdUpdateView.me") // mypage.jsp 비밀번호 수정하기 버튼 url
	public String pwdUpdateView() {
		return "memberPwdUpdateForm";
	}
	/** 연습 텍스트**/
	// 비번수정 요청이 왔을 때 해당 페이지로 넘겨주기
	
	
	
	
	/** 비번 수정
	 * @param oldPwd
	 * @param newPwd
	 * @param model
	 * @return
	 */
	@RequestMapping("mPwdUpdate.me") // memberPwdUpdateForm.jsp의 폼태그 submit url
	public String updatePwd(@RequestParam("pwd") String oldPwd, 
						 	@RequestParam("newPwd1") String newPwd, Model model) {
		// 로그인 정보 가져오기
		// 비번을 바꿀려는 건 이미 로그인해야 가능한 상태이기 때문에 세션에서 로그인 정보를 가져오는 것
		Member m = (Member)model.getAttribute("loginUser"); 
	
	// 받아와야할 데이터 : 현재비번, 새비번, 누구의 비번을 바꿀지에 대한 id
	// 뷰(memberPwdUpdateForm.jsp)에 id 넘기는 부분이 없음. -> session 이용하면 됨
	// id를 session을 이용해서 가져올건데 HttpSession을 이용해도 좋지만, Model model에 loginUser로 넣어놨기에
	// model 이용해서도 가지고 올 수 있음. 값을 저장하는 setAttribute와 반대로 getAttribute로 값을 가져올 수 있음
	
	// 비밀번호 확인 시, 맞는 비번인지 비교하는게 암호화 때문에 불가능해짐
	// jsp때는, 쿼리문이 db에 가서 update member set pwd = newpwd where id = ? and pw = ?  
	// where문에서 id랑 구비번이 이런 사람을 찾아서 비번변경해라가 쿼리문 내용이었으나, 비번을 BCrypt로 암호화했기 때문에 이 방식은 이제 불가능

	// 해결책 
	// bcrypt.matches()
	// 컨트롤러에서 먼저 비교해줘야함. 암호화 된 비번과 되지않은 비번 둘을 matches()를 사용하여 비교하는거 배웠었음
	// bcrypt.matches(rawPassword, encodedPassword)	: 집어넣은 비번이랑 db에 들어가있는 비번이랑 같은지 matches를 통해 비교해볼 것임
		
		int result = 0;
		String encode = null;
		// 전 비번과 새 비번 일치하는 지 비교
		if(bcrypt.matches(oldPwd, m.getPwd())) {  // oldPwd(기존비번)과 m.getPwd(세션에 있는 로그인중인 유저의 비번정보)를 비교하여 일치하는지 확인
			// bcrypt.matches(rawPassword, encodedPassword) 
			// getPwd() 설명 : Member m에 담겨있는데 model.getAttribute("loginUser")가 담겨있고,  
			//  model에는 세션정보가 담겨있어 결국 로그인유저의 getPwd()를 하게 되는 것임 
			
		// 바뀐 비번 저장하기
			HashMap<String, String> map = new HashMap<>(); // db에 수정될 비번값을 보내야하니 HashMap으로 처리
			map.put("id", m.getId()); // 어떤 id의 pw를 바꾸는지 알아야하기에 id도 저장
			encode = bcrypt.encode(newPwd);
			map.put("newPwd", encode);
		// 바뀐 비번, DB에 업데이트 저장
			result = mService.updatePwd(map);
		}
		
		if(result > 0) {
//			return "redirect:logout.me"; // 로그아웃 안하고 마이페이지로 넘어가도 됨
// 비번 변경하면 로그아웃 되게도 만들 수 있음. 세션에 값을 넣는게 귀찮을 때 로그아웃시키기도함. 개발자 편한방법			
			m.setPwd(encode);
			model.addAttribute("loginUser",m);
			return "redirect:myinfo.me";
		}else {
			throw new MemberException("비밀번호 변경에 실패했습니다");
		}
	}
	
	
	/** 연습 텍스트**/
	// 로그인 정보 가져오기
	// 전 비번과 새 비번 일치하는 지 비교
	// 바뀐 비번 저장하기
	// 바뀐 비번, DB에 업데이트 저장
	// 새 비번 정보를 뷰에 보내기
	
	
	/****************************** 회원 탈퇴 ******************************/	
	
	
	
	
	/** 회원 탈퇴
	 * @param model
	 * @return
	 */
	@RequestMapping("mdelete.me") // member - mypage.jsp에서 79번째라인 mdelete.me
	public String deleteMember(Model model){

		// 세션에서 id값 가져와서 저장 : 어느 id를 삭제할 지 알아야하니 id 필요
		String id = ((Member)model.getAttribute("loginUser")).getId();
			
		// DB 처리
		int result = mService.deleteMember(id);
		
		if(result > 0) {
			return "redirect:logout.me";
		} else {
			throw new MemberException("회원 탈퇴에 실패했습니다");
		}
	}
	
	/** 연습 텍스트**/
	// 세션에서 id값 가져와서 저장 : 어느 id를 삭제할 지 알아야하니 id 필요
	// DB 처리
	// 리턴

	
/************************************** ajax ***************************************************/
	
	// ajax 회원가입 id중복체크
	// 아디인풋창 아래 글씨쓰면 바로 알려주는 그 ajax id중복확인
	@RequestMapping("dupId.me")
	public void duplicateId(@RequestParam("id") String id, HttpServletResponse response) {
		
		System.out.println(id);
		
		// id 중복체크
		int result = mService.checkIdDup(id);
		
		try {
			// 뷰에 중복확인결과 전송 : 하나만 보낼꺼니 그냥 printWrtier 써보겠다
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	/** 연습 텍스트**/
	// id 중복체크
	// 뷰에 중복확인결과 전송 
	
}









