package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.impl.UserService;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. spring container를 구동한다.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. spring container로부터 UserServiceImpl를 Lookup 한다.
		UserService service = (UserService)container.getBean("userService");
		
		// 3. 로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = service.getUser(vo);
		if(user != null) {
			System.out.println("유저 정보 ===> "+ user.toString());
			System.out.printf("%s님 환영합니다.", user.getName());
		} else {
			System.out.println("로그인 실패");
		}
		// 4. spring 컨테이너를 종료한다.
		container.close();
		
		
	}

}
