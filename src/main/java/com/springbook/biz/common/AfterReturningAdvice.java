package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	//@AfterReturning(pointcut="allPointcut()", returning="returnObj")
	// 다른 클래스의 포인트컷 설정도 가져올 수 있다.
	@AfterReturning(pointcut="PointcutCommon.allPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName()+" 로그인(admin)");
			}
			System.out.println("[After-returning] " + method +"() 메소드 리턴값: "+ user.toString());
		}
		if(returnObj instanceof BoardVO) {
			BoardVO board = (BoardVO) returnObj;
			System.out.println("[After-returning] " + method +"() 메소드 리턴값: "+ board.toString());
		}
		
		
	}
}
