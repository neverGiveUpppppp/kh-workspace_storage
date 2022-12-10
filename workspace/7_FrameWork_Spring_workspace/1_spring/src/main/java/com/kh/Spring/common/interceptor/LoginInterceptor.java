package com.kh.Spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.Spring.member.model.vo.Member;

public class LoginInterceptor implements HandlerInterceptor {
	
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	// post나 after 둘 중 하나 사용가능
	// 로그인은 뷰까지 다 됐다는 얘기니 after 사용할 것임. post 사용도 문제는 없음
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
			logger.info(loginUser.getId());
		}
		
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
