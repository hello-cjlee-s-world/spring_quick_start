package polymorphism;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	// 객체 생성 시점을 알기 위해 생성자에 메세지 출력 코드 추가
	public SamsungTV() {
		System.out.println("======> SamsungTV(1) 객체 생성");
	}

	// 의존성 주입 1. 생성자로 의존성 주입, applicationContent.xml 파일 수정 필요
	//public SamsungTV(Speaker speaker) {
	//	System.out.println("======> SamsungTV(2) 객체 생성");
	//	this.speaker=speaker;
	//}	
	//public SamsungTV(Speaker speaker, int price) {
	//	System.out.println("======> SamsungTV(3) 객체 생성");
	//	this.speaker = speaker;
	//	this.price = price;
	//}
	
	// 의존성 주입 2. setter로 의존성 주입, applicationContent.xml 파일 수정 필요
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// applicationContxt.xml의 init-method, destroy-method 기능 확인을 위한 method들
	public void initMethod(){
		System.out.println("객체 초기화 작업 처리.."); 
	}
	public void destroyMethod(){
		System.out.println("객체 삭제 전에 처리할 로직 처리.."); 
	}
	
	 @Override
	public void powerOn() {
		System.out.printf("SamsungTV--전원을 켭니다.(가격 : %d)" , price);
		System.out.println();
	}
	 @Override
	public void powerOff() {
		System.out.println("SamsungTV--전원을 끕니다.");
	}
	 @Override
	public void volumeUp() {
		 speaker.volumeUp();
		System.out.println("SamsungTV--볼륨을 높입니다.");	
	}
	 @Override
	public void volumeDown() {
		 speaker.volumeDown();
		System.out.println("SamsungTV--볼륨을 낮춥니다.");
	}
}
