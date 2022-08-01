package com.kh.Spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect2 {

	private Logger logger = LoggerFactory.getLogger(LoggerAspect2.class);
	
//	@Pointcut("execution(*com.kh.Spring..*(..))")
	public void pcForAll() {} // pointcut을 부를 이름을 쓰는 것. 받아주거나 호출하거나 등등 아무런 역할 없이 부를 이름으로만 쓰임. 비어있는 메소드로 존재해야함
	
//	public void loggerAdvice (JoinPoint joinPoint) { // Before용
//	@Around("pcForAll")
	@Around("execution(* com.kh.Spring..*(..))") // 한번에 부르기. @Pointcut이랑 @Around랑 합친 것
	public Object loggerAdvice (ProceedingJoinPoint  joinPoint) throws Throwable { // Around용
		
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
//			Object obj = null;
//			try {
//				obj = joinPoint.proceed(); //계속 진행시키라는 의미의 proceed메소드
//			} catch (Throwable e) { // try catch가 아닌 throws를 해줘야 제대로 작동
//				e.printStackTrace();
//			} 
			Object obj = joinPoint.proceed();	
			logger.debug("[After] " + componentName + type + "." + methodName + "()");
			
			return obj;
	}		
}
