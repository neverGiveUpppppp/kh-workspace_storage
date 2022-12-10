package com.kh.Spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kh.Spring.member.model.vo.Member;

public class BoardEnterInterceptor implements HandlerInterceptor {

	// 실습 2 : BoardEnterInterceptor 만들기
	// 로그인을 하지 않은 상태로 게시글 리스트 보기를 요청하게 되면
	// "로그인 후 이용하세요"라는 경고메세지와 메인화면으로 redirect하기
	
	
	
	// 어떤 메소드를 오버라이딩해서 불러올 것인가?
	// 프리핸들 preHandle()
	private Logger logger = LoggerFactory.getLogger(BoardEnterInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { // 윗줄에 HttpServletRequest이 있기 때문에 세션정보를 불러올 수 있음
		
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		
		
		if(loginUser == null) {
//			session.setAttribute("msg", "로그인 후 이용하세요"); //
//			response.sendRedirect("home.do"); // 메인화면으로 넘어가야하니 home.do
			request.setAttribute("msg","로그인 후 이용하세요"); 	
			request.getRequestDispatcher("WEB-INF/views/home.jsp"); 
			return false;
		}
		
		// preHandle부분만 return부분이 존재함
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
}
