package tv;

public class TvMain {

	public static void main(String[] args) {
		TVFactory factory = new TVFactory();
		TV tv = factory.getTV("삼성");
		tv.powerOn();
		tv.soundUp(10);
		tv.soundDown(4);
		tv.powerOff();
		
		tv = new SamsungTV();
		tv.powerOn();
		tv.soundUp(10);
		tv.soundDown(4);
		tv.powerOff();
//		만약 SamsungTv를 LgTV로 바꾼다면?
// 		개발자 : 인터페이스를 사용하면 고쳐야 할 코드가 줄어든다.
//		인터페이스에 공통 기능 명세를 줘서 각각의 tv가 tv 인터페이스를 확장하여 공통 메소드를 구현하도록 한다.
//		직접 필요한 객체를 만들어서 썼다.
		
//		factory.getTV("삼성");
//		이제 외부 공장에서 전달받은 TV를 이용하겠다는 것이다.
//		main에서 객체 생성 제어권을 포기한 것이다.
//		이것을 inversion of control
	}
}
