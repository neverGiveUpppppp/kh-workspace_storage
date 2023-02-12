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
public class MemberController {
	
	// 강의 2:32
	@Autowired 
//	private MemberService mService = new MemberServiceImpl(); // 삭제 :  = new MemberServiceImpl()
	private MemberService mService; 
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login() {
//		System.out.println("로그인 처리");
//	}
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/*****************************파라미터 전송 받기 *****************************/
	// 1. HttpServletRequest 방식 : JSP/Servlet 방식
	// 2. @RequestParam방식 : 파라미터 1:1 매핑
	// 3. @RequestParam 생략방식
	// 4. @ModelAttribute 방식 : 객체매핑(ex:class vo)
	// 5. @ModelAttribute 생략방식 
	
	
	
	// 1. HttpServletRequest 방식 : JSP/Servlet 방식
	
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(HttpServletRequest request) {
//		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		System.out.println("id1 :" + id);
//		System.out.println("pwd1 : " + pwd);
//	}

	
	
	// 2.@RequestParam방식
	//  	스프링에서 좀 더 간단하게 파라미터를 받아올 수 있는 방법
	//		HttpServletRequest와 비슷하게 request객체를 이용하여 데이터를 전송받으나 원하는 데이터타입으로 자동형변환 가능
	//		
	//	@RequestParam의 사용가능한 속성들
	//		value : view에서 받아올 파라미터 이름, 어노테이션에 들어가는 속성이 하나 뿐이라면 자동으로 value로 인지하여 생략가능
	//		defaultValue : 값이 null이거나 들어오지 않았을 때, 기본적으로 들어갈 데이터 지정
	//		required : 해당 파라미터가 필수적인지 설정하는 속성. 기본값은 true
	
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	value 생략 방식 : public void login(@RequestParam("id") String id, @RequestParam("Pwd") String pwd) {
//	value 추가 방식 : public void login(@RequestParam(value="id") String id, @RequestParam(value="Pwd") String pwd) {
//	defaultValue 사용 : public void login(@RequestParam(value="id", defaultValue="hello") String id, @RequestParam(value="Pwd", defaultValue="world") String pwd) {	
//  required 사용 : public void login(@RequestParam(value="id", defaultValue="hello") String id, 
//									@RequestParam(value="Pwd", defaultValue="world") String pwd,
//									@RequestParam(value="test", required=false, defaultValue="spring") String test) {	
//		System.out.println("id2 :" + id);
//		System.out.println("pwd2 : " + pwd);
//		System.out.println("test : " + test);
//	}
	
	
	
	
	// 3.@RequestParam 생략방식
	// 생략 할려면 전제조건 
	// 		1) 매개변수명이 파라미터명과 동일해야함. 그래야 mapping 가능
	// 		2) @RequestParam에서 사용할 수 있는 속성 사용 불가
	// 지금 쓰는 매개변수가 뷰에서 받아온 매개변수인지 아니면  그냥 집어 넣은 매개변수를 구분하기 위해서라도 쓰는 생략방식 사용을 연습하는 걸 추천
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(String id, String pwd) {
//		
//		// 안써도 받아옴
//		System.out.println("id3 :" + id);
//		System.out.println("pwd3 : " + pwd);
//	}
	
	
	// 4. @ModelAttribute 방식
	//		요청 파라미터가 많은 경우 객체타입으로 넘겨 받음
	// 받아올 때마다 매개변수 추가해야되면 복잡하고 불편 ->
	// 엄청 많은 파라미터를 다뤄야한다면 이 어노테이션 사용 추천
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(@ModelAttribute Member m) { // ... 다르면 매핑이 안됨
//		System.out.println("m :" + m);
//	}
	
	
	// 5. @ModelAttribute 생략 방식
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(Member m) { // ... 다르면 매핑이 안됨
//		System.out.println("m :" + m);
		
//		MemberService mService = new MemberService(); // 서비스 객체를 개발자가 만들고 있음. 객체를 프레임워크가 만들어줘야하는데...
		// 개발자가 주도권을 가지고 객체생성하는게 왜 안되는가? 
		// 문제1: 내가 객체 주도권을 가지고 있으면 생명주기까지 관리해야되는데 프레임워크 쓰는 이유는 생명주기(Life Cycle)까지 관리안할려고 쓰는거라 프레임워크한테 넘기는게 맞음
		// 문제2: 요청할 떄마다 주소값이 다르게나옴. 계속 new MemberService로 new하기 대문에 새로운 주소값이 발생된 것.
		// 문제3: 서비스.java 파일명을 변경하면 생성한 클래스명까지도 변경되서 분리가 안됨 -> 이런거를 높은 결합도가 보인다라고 함.
		// 결합도가 높다는 의미: 이름 변경에 대해서 직접적인 영향을 받는 것. 요청할 때마다 계속 새로운 주소값을 반환해내는 것을 결합도가 높다고 얘기함
		// 		결합도가 높은 프로그램은 하나가 에러나거나 없으면 다 멈추기에 좋은 프로그램이라고 볼 수는 없음
		// 		결합도를 낮은 프로그래밍을 스프링 수업 시간에 해볼 것임
		
		// 해결 
		// 해결 1 : 클래스와 인터페이스 강의 ...
		// 			인터페이스 하나 생성. 멤버서비스 하나만 집어 넣음. 멤버서비스와 멤버서비스임플 간에 관계설정(implements)해주면 됨
		// 해결 2 : 주소값 하나만 나오는 방법 : 필드에다 옮기는 방법
//		System.out.println(mService);
//		Member loginMember = mService.login(m);
//
//		
//		
//		
//		
//	}
	
	
	/******************************** 데이터 전달하기 ********************************/
//	// 1. Model객체 사용
//	// 		Servlet에서 사용하던 requestScope와 비슷 = scope는 request
//	// 		뷰에 전달하고자 하는 데이터를 맵형식(key,value)으로 담을 때 사용
//	
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public String login(Member m, Model model, HttpSession session) {
//		// 강의 9:22 서블릿 때처럼 getsession할 필요 없는 이유
//		
//		Member loginMember = mService.login(m);
//
//		// 뷰에 보낼려고 담음
//		
//		// 현재 prefix : /WEB-INF/views/member/
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember);	
////			return "../home"; // /WEB-INF/views/member/../home.jsp //// ..은 이전폴더(상위폴더)를 의미함
//							  // /WEB-INF/views/home.jsp
//			return "redirect:home.do"; // sendRedirect와 같은 효과 // 로그인 후 login.me의 url이었던게 home.do로 그대로 유지됨
//		}else{
//			model.addAttribute("msg","로그인 실패하였습니다");
//			return "../common/errorPage";
//		}
//	}
	
	
	
	
	
//	// 2.ModelAndView 객체 사용
//	// 		Model + View --> 데이터와 뷰를 한 번에 담는 객체
//	
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public ModelAndView login(Member m, ModelAndView mv, HttpSession session) {
//		// 강의 9:22 서블릿 때처럼 getsession할 필요 없는 이유
//		
//		Member loginMember = mService.login(m);
//
//		// 뷰에 보낼려고 담음
//		
//		// 현재 prefix : /WEB-INF/views/member/
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember);	
////			mv.setViewName("../home"); // url이 드러나니 아래처럼 redirect 넣어주기
//			mv.setViewName("redirect:home.do"); // url 감추기
//		}else{
//			mv.addObject("msg","로그인 실패하였습니다");
//			mv.setViewName("../common/errorPage"); 
//		}
//		return mv;
//	}
	// mv를 쓰면 더이상 str으로 안씀. 뷰에대한 내용 누가 가지고 있음? 모델앤뷰가 가짐   강의 10:42
	// 그렇기에 반환값을 모델앤뷰로 바꿔줘야함.
	// 로그인 멤버가 .. 0608 10:43 강의
	// mv에는 뷰만 담으면 됨. setViewName으로 어디로 간다구요? 이렇게하면 로그인.미가 남게 되니까 리다이렉트:홈.두하면됨
	
	
	
//	// 로그아웃 (logout.me)
//	// ... 강의10:48  일단 기본적인 구조는 str으로 가져가라
//	@RequestMapping("logout.me")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:home.do";
//	}
	
	
	// + session에 저장할 때 @SessionAttributes사용
	// 사용 조건이 있음. 자동으로 키값을 찾아서 세션에 등록하는 기능
	// 어떤 키를 찾느냐? Model의 어트리뷰트가 추가가 될 때, 그떄 자동으로 키값을 찾아서 세션에 등록하는 기능
	// 모델에 “msg”라고 하는 값이 있기에 세션 영역에 올린다..? 강의 11:25
	// 		세션 어트리뷰트를 사용할려면 필수적으로 Model객체가 필ㅇ
	
//	
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public String login(Member m, Model model) {
//		
//		// HttpSession 대신 셋어트리뷰트 사용할거라 HttpSession 삭제 
//		
//		Member loginMember = mService.login(m);
//
//		if(loginMember != null) {
//			model.addAttribute("loginUser", loginMember);
//			return "redirect:home.do";
//		}else{
//			model.addAttribute("msg","로그인 실패하였습니다");
//			return "../common/errorPage"; 
//		}
//		// 이렇게만 쓰면 로그인 유지 안됨.
//		// 세션에 올라가있는게 아니라 한번 넣고 끝나서 로그인 유지 x
//		// @SessionAttributes 사용하면 해결됨
//		// 파일 최상단으로 가서 @Controller 위에 @SessionAttributes 적어줌
//		
//	}
	
	
	
	// 로그인 (최종버젼)
	@RequestMapping(value="login.me", method=RequestMethod.POST)
	public String login(Member m, Model model) {
		
		// 암호화 얻어서 db에 원본비번이랑 교체해줄 것
		System.out.println(bcrypt.encode(m.getPwd()));
		
		// HttpSession 대신 셋어트리뷰트 사용할거라 HttpSession 삭제 
		
		// DB로부터 유저 정보 가져오기
		Member loginMember = mService.login(m);
		
		// 유저가 입력한 비번과 DB에서의 유저 비번이 같은 지 검증
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
	
	
	
	// @SessionAttributes 사용과 함께 제대로 된 로그아웃
	@RequestMapping("logout.me")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:home.do";
	}
	
	
	
/************************************** 회원가입 ***************************************************/
	
	
	
	
	@RequestMapping("enrollView.me")
	public String enrollView() {
		if(logger.isDebugEnabled()) { 	// 로그에서 해당 패키지,클래스에있는 로그들을 뽑아내고 진행하는데 레벨을 debug, info 지정해두었는데, 
			logger.debug("회원등록페이지");	// info로 지정하고 debug나오길 기다리면 어차피 안나오기에 logger를 줄 필요 없으니 debug가 있을 때만 등록되서 로그가 찍히도록 불필요한 로그를 안적도록 적는 if문
		}
		return "memberJoin";
	}
	
	
	

	
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
	
	
	
	// 회원가입 (알맹이버젼) - 자세한건 위에 주석참조
	@RequestMapping(value = "minsert.me", method=RequestMethod.POST)
	public String insertMember(@ModelAttribute Member m, 
							   @RequestParam("post") String post,
							   @RequestParam("address1") String address1,
							   @RequestParam("address2") String address2) {
		
		m.setAddress(post +"/" + address1 + "/" + address2);
		String encPwd = bcrypt.encode(m.getPwd());
		m.setPwd(encPwd);
	
		int result = mService.insertMember(m);
		if(result > 0) {
			return "redirect:home.do";
		} else {
			throw new MemberException ("회원가입에 실패하였습니다.");
		}
		
	}	
	
	
	/************************************** 내정보보기 ***************************************************/
	
	
	@RequestMapping("myinfo.me") // menubar.jsp
	public String myInfo() {
		return "mypage";
	}
	
	
	@RequestMapping("mupdateView.me")
	public String updateView() {
		return "memberUpdateForm";
	}
	
	@RequestMapping("mupdate.me")
	public String updateMember(@ModelAttribute Member m,
							   @RequestParam("post") String post,
							   @RequestParam("address1") String address1,
							   @RequestParam("address2") String address2,
							   Model model) {
				
		m.setAddress(post +"/" + address1 + "/" + address2);
		
		int result = mService.updateMember(m);
		Member loginUser = mService.login(m); // Member m을 그대로 그냥가져오면 비번이 비어서 가기에 문제 발생 방지차 다시 넣어줌
											  // 여기 m은 null 뜨고 loginUser에 비번이 들어가있음
		if(result > 0) {
			model.addAttribute("loginUser",loginUser);
			return "redirect:myinfo.me";
		}else {
			throw new MemberException("회원정보 수정에 실패했습니다");
		}
	}

	
	
/****************************** 회원 비번변경 ******************************/	
	
	@RequestMapping("mpwdUpdateView.me") // mypage.jsp 비밀번호 수정하기 버튼 url
	public String pwdUpdateView() {
		return "memberPwdUpdateForm";
	}
	
	
	@RequestMapping("mPwdUpdate.me") // memberPwdUpdateForm.jsp의 폼태그 submit url
	public String updatePwd(@RequestParam("pwd") String oldPwd, 
						 	@RequestParam("newPwd1") String newPwd, Model model) {
		// 로그인 정보 가져오기
		// 비번을 바꿀려는 건 이미 로그인해야 가능한 상태이기 때문에 세션에서 로그인 정보를 가져오는 것
		Member m = (Member)model.getAttribute("loginUser"); // Member m에는 로그인한 사람의 정보가 들어있음
	
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
		// 바뀐 비번, DB로 저장
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
	
	
	/****************************** 회원 탈퇴 ******************************/	
	
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
		
	
	
}









