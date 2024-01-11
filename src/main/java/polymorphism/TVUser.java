package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		/*
		 * // 현재 클래스에서 직접 TV 인스턴스를 생성하는것이 아닌 BeanFactory를 만들어 args 매개변수를 통해 // 객체를 반환받도록
		 * 함 --> 느슨한 결합, 추후 lg에서 samsung 으로 바꾸게 되어도 // 클라이언트 소스 수정 필요 없음 BeanFactory
		 * factory = new BeanFactory(); TV tv = (TV)factory.getBean(args[0]);
		 * tv.powerOn(); tv.volumeUp(); tv.volumeDown(); tv.powerOff();
		 */
		
		// applicationContext.xml에 SamsungTV 등록한뒤 소스
		// 1. spring 컨테이너를 구동한다
		// 아래 소스는 환경설정 파일인 applicationContext.xml을 로딩하여 
		// 스프링 컨테이너 중 하나인 GenericXmlApplicationContext 을 구동한다
		// applicationContext를 매개변수로 GenericXmlApplicationContext 인스턴스를 생성하기만 해도
		// applicationContext의 beans에 등록된 객체들이 생성된다
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("ApplicationContextPolymorphism.xml");
		
		
		// 2. spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다 
		// 이떄 main 메서드에 들어가는 매개변수는
		///applicationContext.xml 에 등록된 id 를 넣어준다. 
		TV tv1 = (TV)factory.getBean(args[0]);
		//TV tv2 = (TV)factory.getBean(args[0]);
		//TV tv3 = (TV)factory.getBean(args[0]);
		tv1.powerOn(); 
		tv1.volumeUp(); 
		tv1.volumeDown(); 
		tv1.powerOff();
		 
		 // 3. Spring 컨데이너를 종료한다. 
		 factory.close();
		 
	}

}
