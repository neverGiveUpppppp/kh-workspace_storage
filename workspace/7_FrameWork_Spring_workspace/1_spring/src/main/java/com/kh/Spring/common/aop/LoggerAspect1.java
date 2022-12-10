package com.kh.Spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect1 {

	private Logger logger = LoggerFactory.getLogger(LoggerAspect1.class);
	
//	public void loggerAdvice (JoinPoint joinPoint) { // Before용
	public Object loggerAdvice (ProceedingJoinPoint  joinPoint) { // Around용
		
		// Sign org.aspectj.lang.Signature 인터페이스를 임포트
		
			Signature signature = joinPoint.getSignature();
			logger.debug("signature : " + signature);
			
			
			String type= signature.getDeclaringTypeName(); // 메소드가 있는 클래스 풀네임
			String methodName = signature.getName(); 		// 타깃 객체 메소드
			
			logger.debug("type : " + type);
			logger.debug("methodName : " + methodName);
		
			
			String componentName = null;
			if(type.indexOf("Controller") > -1) {
				componentName = "Controller  \t: ";
			}else if(type.indexOf("Service") > -1) {
				componentName = "ServiceImpl  \t: ";
			}else if(type.indexOf("DAO") > -1) {	
				componentName = "DAO  \t\t: ";
			}
			
			logger.debug("[Before] " + componentName + type + "." + methodName + "()");
			Object obj = null;
			try {
				obj = joinPoint.proceed(); //계속 진행시키라는 의미의 proceed메소드
			} catch (Throwable e) {
				e.printStackTrace();
			} 
			
			logger.debug("[After] " + componentName + type + "." + methodName + "()");
			
			return obj;
	}		
}
