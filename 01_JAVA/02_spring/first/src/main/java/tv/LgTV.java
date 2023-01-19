package tv;

public class LgTV implements TV {
	
	@Override
	public void powerOn() {
		System.out.println("LgTV:전원 켜다");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV:전원 끄다");
	}

	public void soundUp(int v) {
		System.out.println("LgTV: " + v + "만큰 볼륨 높이다");
	}
	
	public void soundDown(int v) {
		System.out.println("LgTV: " + v + "만큰 볼륨 낮추다");
	}
}
