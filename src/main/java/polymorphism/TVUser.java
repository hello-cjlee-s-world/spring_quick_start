package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		
		// 현재 클래스에서 직접 TV 인스턴스를 생성하는것이 아닌 BeanFactory를 만들어 args 매개변수를 통해 
		// 객체를 반환받도록 함 --> 느슨한 결합, 추후 lg에서 samsung 으로 바꾸게 되어도 
		// 클라이언트 소스 수정 필요 없음
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
