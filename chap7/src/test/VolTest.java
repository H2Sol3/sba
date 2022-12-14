package test;


interface Volume {
	void volumeUp(int vol);

	void volumeDown(int vol);
	
	static void print1(String name) {
		System.out.println(name+"클래스가 볼륨업 수행중");
	}
	static void print2(String name) {
		System.out.println(name+"클래스가 볼륨다운 수행중");
	}
	default void print3() {
		System.out.println("뒤늦게 메소드 추가 - 자식클래스 오버라이딩 선택적");
	}
}

class Speaker implements Volume {
	int volLevel;

	public Speaker() {
	}

	public void volumeUp(int volLevel) {
		Volume.print1("speaker");
		
		this.volLevel += volLevel;
		if (volLevel > 100) {
			this.volLevel = 100;
			System.out.println("1+현재 VolLevel: " + this.volLevel);
		} else {
			System.out.println("1-현재 VolLevel: " + volLevel);
		}
	}

	public void volumeDown(int volLevel) {
		Volume.print2("speaker");
		
		this.volLevel -= volLevel;
		if (this.volLevel < -100) {
			this.volLevel = -100;
			System.out.println("2+현재 VolLevel: " + this.volLevel);
			System.out.println();
		}else {
			System.out.println("2-현재 VolLevel: " + this.volLevel);
			System.out.println();
		}
	}
	
	public void print3() {
		System.out.println("Speaker클래스에서 오버라이딩하는 중");
	}
}

class TV implements Volume {
	int tvLevel;

	public TV() {
	}

	public void volumeUp(int tvLevel) {
		Volume.print1("TV");
		this.tvLevel += tvLevel;
		System.out.println("+현재 tvLevel: " + this.tvLevel);
	}

	public void volumeDown(int tvLevel) {
		Volume.print2("TV");
		
		this.tvLevel -= tvLevel;
//		System.out.println("현재 tvLevel: "+this.tvLevel);

		if (this.tvLevel < 0) {
			this.tvLevel = 0;
			System.out.println("-현재 tvLevel: " + this.tvLevel);
			System.out.println();
		}
	}
}

class Radio implements Volume {
	int radioLevel;

	public Radio() {
	}

	public void volumeUp(int radioLevel) {
		Volume.print1("Radio");
		this.radioLevel = radioLevel;
		System.out.println("+현재 radioLevel: " + this.radioLevel);
	}

	public void volumeDown(int radioLevel) {
		Volume.print2("Radio");
		this.radioLevel -= radioLevel;
		System.out.println("-현재 radioLevel: " + this.radioLevel);
		System.out.println();
	}
}

public class VolTest {
	public static void main(String[] args) {
		Volume v[] = new Volume[3];
		//서로 다른 클래스를 Volume을 통해 관계를 맺어줌
		v[0] = new Speaker();
		v[1] = new TV();
		v[2] = new Radio();
		for (int i = 0; i < v.length; i++) {
			v[i].volumeUp(200);
			v[i].volumeDown(300);
			v[i].print3();
		}
		
		
	}

}
