package tv;

public class SamsungTV implements TV {
	public void powerOn() {
		System.out.println("SamaungTV:전원 켜다");
	}
	
	public void powerOff() {
		System.out.println("SamaungTV:전원 끄다");
	}
	
	public void soundUp(int v) {
		System.out.println("SamaungTV: " + v + "만큰 볼륨 높이다");
	}
	
	public void soundDown(int v) {
		System.out.println("SamaungTV: " + v + "만큰 볼륨 낮추다");
	}

}
