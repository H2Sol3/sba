package spring.tv;
// 여러개 클래스의 공통 기능(메소드) 스펙을 명세하는 것이다. 다중상속 가능.
public interface TV {
	void powerOn();
	void powerOff();
	void soundUp(int v);
	void soundDown(int v);

}
