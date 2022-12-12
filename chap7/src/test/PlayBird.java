package test;

class Bird {
	String name;
	int legs;
	int length;

	void fly() {

	}

	void sing() {

	}

	void setName(String name) {
		this.name=name;
	}

	void print() {
		
	}
}

class Duck extends Bird {
	int web;// 물갈퀴 수

	//@Override
	void fly() {
		System.out.println("오리("+name+")는 날지 않습니다.");
	}

//	@Override
	void sing() {
		System.out.println("오리("+name+")가 소리내어 웁니다.");
	}

//	@Override
	void print() {
		System.out.printf("오리의 이름은 %s 입니다. \n", name);
	}

	void swim(int web) {
		this.web = web;
		System.out.printf("오리("+name+")가 %d개의 물갈퀴로 수영합니다.\n", this.web);
	}
}

class Sparrow extends Bird {
	String friend;

	void makeFriend() {
		friend = "허수아비";
		System.out.printf("참새의 친구는 %s입니다.\n", this.friend);
	}

//	@Override
	void fly() {
		System.out.println("참새("+name+")가 날아다닙니다.");
	}

//	@Override
	void sing() {
		System.out.println("참새("+name+")가 소리내어 웁니다.");
	}

//	@Override
	void print() {
		System.out.println("참새의 이름은 짹짹 입니다. ");
	}
}

public class PlayBird {
	public static void main(String[] args) {
		Duck duck = new Duck();
		Sparrow sparrow = new Sparrow();

		duck.setName("꽥꽥이");
		duck.fly();
		duck.sing();
		duck.swim(2);
		duck.print();

		sparrow.setName("짹짹");
		sparrow.fly();
		sparrow.sing();
		sparrow.makeFriend();
		sparrow.print();
	}

}
