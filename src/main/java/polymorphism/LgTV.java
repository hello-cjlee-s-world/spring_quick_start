package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	// 어노테이션 의존성 주입 1. 
	// Autowired는 변수의 타입(이 클래스에서는 Speaker)을 기준으로 객체를 탐색하여 의존성 주입을 한다.
	 @Autowired
	//@Qualifier("apple")
	// 어노테이션 의존성 주입 2. 
	// Autowired는 객체의 이름(apple --> applicationContext.xml에 apple 이라고 설정해놓았다)
	// 을 기준으로 객체를 탐색하여 의존성 주입을 한다.
	//@Resource(name="sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("======> LgTV 객체 생성");
	}
	 @Override
	public void powerOn() {
		System.out.println("LgTV--전원을 켭니다.");
	}
	 @Override
	public void powerOff() {
		System.out.println("LgTV--전원을 끕니다.");
	}
	 @Override
	public void volumeUp() {
		 speaker.volumeUp();
		//System.out.println("LgTV--볼륨을 높입니다.");
	}
	 @Override
	public void volumeDown() {
		 speaker.volumeDown();
		//System.out.println("LgTV--볼륨을 낮춥니다..");
	}
}
