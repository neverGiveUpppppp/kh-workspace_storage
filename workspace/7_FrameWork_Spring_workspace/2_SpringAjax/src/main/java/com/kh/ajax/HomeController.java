package com.kh.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		 * logger.info("Welcome home! The client locale is {}.", locale);
		 * 
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 */
		
		return "home";
	}
	
	// 1.서버 쪽 컨트롤러로 값 보내기
	@RequestMapping("test1.do")
	public void test1(@RequestParam("name") String name, @RequestParam("age") int age, HttpServletResponse response) {
		System.out.println(name);
		System.out.println(age);
		
		
		// ajax에서 뷰에 뭔가 보내고 싶을 때 사용하는 것 : PrintWriter class
		// gson, json은 객체로 보낼 때 유리한 것

		try {
			PrintWriter out = response.getWriter();
			
			if(name.equals("강건강") && age == 20) {// 들어온 데이터가 강건강,20이 맞으면 ok 전송, 맞지 않으면 fail 전송
				out.print("ok");
			} else {
				out.print("fail");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return 지우는 이유 : 강의 10:46 0613
		// 
	}
	
/***************************************************************************************************/
	
	// 2.컨트롤러에서 리턴하는 JSON객체 받아 출력하기
	// (기존과 다르게)비동기 방식으로 진행하기에 반환값은 void로 놓고 진행
//	@RequestMapping("test2.do")
//	public void test2(/* HttpServletResponse response */) {
//		// json 라이브러리 설치 -> pom.xml 메이븐
//		
//		JSONObject job = new JSONObject();
//		job.put("no", 123);							// 뷰에서 보내오는 데이터 없고, 임의로 데이터 넣어주고 있는 것
//		job.put("title","return json object test");
//		job.put("writer", "남나눔");
//		job.put("content", "JSON객체를 뷰로 리턴합니다.");
//		
////		try {
////			response.setContentType("applicaion/json; charset=UTF-8");
////			response.getWriter().print(job);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//	}
//	// 2.컨트롤러에서 리턴하는 JSON객체 받아 출력하기 - json str타입 반환
//	// (기존과 다르게)비동기 방식으로 진행하기에 반환값은 void로 놓고 진행
//	@RequestMapping("test2.do")
//	@ResponseBody
//	public String test2(/* HttpServletResponse response */) {
//		// json 라이브러리 설치 -> pom.xml 메이븐
//		
//		JSONObject job = new JSONObject();
//		job.put("no", 123);							// 뷰에서 보내오는 데이터 없고, 임의로 데이터 넣어주고 있는 것
//		job.put("title","return json object test");
//		try {
//			job.put("writer", URLEncoder.encode("남나눔","UTF-8")); // URLEncoder.encode()로 한글만 인코딩함. 뷰에서 디코딩해야 제대로 보임.
//			job.put("content", "JSON객체를 뷰로 리턴합니다.");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		
//		return job.toString(); // json을 통해서 str타입으로 값 반환할 것임
//		// 에러메시지
//		// 파일 [/WEB-INF/views/{"no":123,"writer":"남나눔","title":"return json object test","content":"JSON객체를 뷰로 리턴합니다."}.jsp]을(를) 찾을 수 없습니다.
//		// toString으로 보냈음 
//		// 뷰리졸버에서 prefix와 suffix를 붙여서 해당 경로를 찾음
//		// 뷰리졸버에서 뷰를 리턴해서 뷰리졸버가 완성시키니까 jsp파일을 못찾겠다는 것
//
//		// 뷰리졸버가 경로가 아닌 보내고 싶은 데이터라는걸 알려줘야함
//		// 뷰이름이 아닌 데이터로 보낼려는 걸 뷰리졸버에게 인지시켜야함
//		
//		// 해결책 : 리퀘스트매핑 아래 @ResponseBody 어노테이션 추가
//		// @ResponseBody : 응답하는 것에 대한 데이터를 보내는 것. 리스폰스객체에 바디부분에 모든 리퀘스트와 리스폰스는 바디영역이 있는데 해당 데이터를 보내라는 의미
//		// 뷰이름으로 보내는게 아니라 리스폰스 객체에다가 해당 데이터를 보내라고 지시하는 것. (여기서 리스폰스 객체는 클라이언트가 요청한 것에 대해 응답하는 그 리스폰스트의 부분. 리스폰스 객체로 응답을 해주는건데 거기에 데이터를 넣어보내라는 것) 강의 12:10 0613
//		
//	}
	// 2번 방법4
	// 2.컨트롤러에서 리턴하는 JSON객체 받아 출력하기 - 방법4
	// (기존과 다르게)비동기 방식으로 진행하기에 반환값은 void로 놓고 진행
	@RequestMapping(value="test2.do", produces="application/json; charset=UTF-8")
	public String test2(/* HttpServletResponse response */) {
		// json 라이브러리 설치 -> pom.xml 메이븐
		
		JSONObject job = new JSONObject();
		job.put("no", 123);							// 뷰에서 보내오는 데이터 없고, 임의로 데이터 넣어주고 있는 것
		job.put("title","return json object test");
		job.put("writer", "남나눔");
		job.put("content", "JSON객체를 뷰로 리턴합니다.");
		
		return job.toString(); 
	}

//	강의 정리 12:43 중요 0613
// <데이터 전송 안정성 및 인코딩 호환 문제>
//	1.dataType:'json'
//		데이터타입을 많이 추천하지 않는 이유 : 가끔씩 먹히지 않는 경우가 있음. 항상 먹히는 방법은 방법4에
//	2.데이터파싱방법 : data=JSON.parse(data) - json 타입으로는 잘나오나 인코딩이 안됨
//	3.한글부분만 컨트롤러에서 인코딩하고 뷰에서 디코딩하는 방법
//		URLEncoder.encode("남나눔","UTF-8")) & decodeURIComponent(data.writer)
//			- 띄어쓰기 시에 +로 나오므로 replace를 사용하여 공백으로 변환해주어야함 
// 		1,2번의 방법을 보완한 문제없는 방법이나 단점은 좀 번거로움
//	4.RequestMapping의 속성 produces
//	   		@RequestMapping(value="url", produces="application/json; charset=UTF-8")
// 		... 리퀘스트매핑의 value는 자동으로 매칭되는거 들어가기 때문이고 method속성 생략하면 포스트방식이고 겟,포스트방식 결정가능. 제이슨 오트젝트를 utf-8방식으로 적용할껀데...
// 			jsonArray도 같은 방식으로 가능	
	
	
//	 Ajax를 Spring에서 사용할 수 있는 새로운 방법  강의 12:49 0613
//	1)@ResponseBody
//	2)@RequestMapping의 속성 produces
//	@RequestMapping(value="url", produces="application/json; charset=UTF-8")
//	내가 보내는 제이슨객체가 제이슨객체로 잘 들어가고 한글도 잘 인코딩 되었으면 좋겠다 produces 사용
	

	
	
	/****************************************************************************************************/
	
	
	
	
	
}




