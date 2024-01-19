package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	//@Around("allPointcut()")
	// 다른 클래스의 포인트컷 설정도 가져올 수 있다.
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		/*
		 * System.out.println("[Around---Before] 비즈니스 메소드 수행 전에 처리할 내용..."); Object
		 * returnObj = pjp.proceed();
		 * System.out.println("[Around---After] 비즈니스 메소드 수행 후 처리할 내용...");
		 */
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj= pjp.proceed();
		
		stopWatch.stop();
		System.out.println("[Around]" + method + "메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	}
}
