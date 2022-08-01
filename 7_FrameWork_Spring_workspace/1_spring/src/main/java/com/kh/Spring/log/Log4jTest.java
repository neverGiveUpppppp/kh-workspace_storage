package com.kh.Spring.log;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.Spring.HomeController;

public class Log4jTest {

	// 로거 쓸려면 항상 로거 인터페이스가 필요. 필드로 설정할 것
//	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	// 메소드 안에 작성한 로거가 아닌 홈컨트롤러클래스에 있는 로거를 가져오게됨. 
	private Logger logger = LoggerFactory.getLogger(Log4jTest.class);
	// getLogger에 현재 클래스를 써야 현재 클래스 안에 이쓴 메소드의 로그를 가져옴
	// Logger 임포트는org.slf4j
	
	public static void main(String[] args) {

		new Log4jTest().test();

	} 
		
	public void test() {
		logger.error("error"); // fatal은 접근불가. error까지면 접근가능
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
	}	
		
		
	
		

}
