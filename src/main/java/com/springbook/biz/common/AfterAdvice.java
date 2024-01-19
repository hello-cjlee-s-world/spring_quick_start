package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	//@After("allPointcut()")
	// 다른 클래스의 포인트컷 설정도 가져올 수 있다.
	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.out.println("[After] 비즈니스 로직 수행 후 무조건 동작");
	}
}
