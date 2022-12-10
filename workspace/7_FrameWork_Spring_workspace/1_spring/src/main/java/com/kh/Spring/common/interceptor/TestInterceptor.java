package com.kh.Spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//public class TestInterceptor extends HandlerInterceptorAdapter { // 취소선 : deprecated 곧 사용못하니 쓰지말라고 알려주는 것
public class TestInterceptor implements HandlerInterceptor { 

	
	private Logger logger = LoggerFactory.getLogger(TestInterceptor.class);
	
	// preHandle : 서블릿 들어가기 전(컨트롤러 들어가기 전) 로그 찍을 것
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// if( isDebug ...) 써도 됨
		logger.debug("============== START ==============");
		logger.debug(request.getRequestURI());
		return HandlerInterceptor.super.preHandle(request, response, handler);
		// return 값은 항상 true가 되어야함. 그래야 진행 가능
		// return 값 다 지우고 return true해도 상관x
	}
	
	// postHandle : 다 반환하고 나서 로그 찍을 것
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("-------------- view --------------");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		// 이 메소드의 반환값이 void여서 기존에 있는 것들을 가져와서 수행시킨다고 하는 오버라이딩임 
		// 오버라이딩 하는 이상 기존에 있는 것들을 굳이 실행할 필요x -> 지워도 상관없음
	}
	
	// afterCompletion : 모든 걸 수행하고 나서 로그 찍을 것
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("-------------- END --------------");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}



