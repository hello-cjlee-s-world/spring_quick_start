package polymorphism;

public class SamsungTV implements TV{
	// 객체 생성 시점을 알기 위해 생성자에 메세지 출력 코드 추가
	public SamsungTV() {
		System.out.println("======> SamsungTV 객체 생성");
	}
	// applicationContxt.xml의 init-method, destroy-method 확인을 위한 method들
	public void initMethod(){
		System.out.println("객체 초기화 작업 처리.."); 
	}
	public void destroyMethod(){
		System.out.println("객체 삭제 전에 처리할 로직 처리.."); 
	}
	 @Override
	public void powerOn() {
		System.out.println("SamsungTV--전원을 켭니다.");
	}
	 @Override
	public void powerOff() {
		System.out.println("SamsungTV--전원을 끕니다.");
	}
	 @Override
	public void volumeUp() {
		System.out.println("SamsungTV--볼륨을 높입니다.");	
	}
	 @Override
	public void volumeDown() {
		System.out.println("SamsungTV--볼륨을 낮춥니다.");
	}
}
