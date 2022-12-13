package test;

public class PlayBird_review {

	public static void main(String[] args) {
		Duck1 d = new Duck1("오리(꽥꽥이)", 2);
		Sparrow1 s = new Sparrow1("참새(짹짹)");
		d.setName("오리(꽥꽥이)");
		d.fly();
		d.sing();
		d.swim();
		d.print();
		s.setName("참새(짹짹)");
		s.fly();
		s.sing();
		s.makeFriend();
		s.print();

		
	}
}


class Bird1 {//Duck, Sparrow 클래스 반드시 fly 구현 공통 
	String name;
	int legs;
	double length;
	Bird1(String name){
		this.name = name;
	}
	public void fly(){
		System.out.println(name + " 가 날아다닙니다.");
	}
	public void sing(){
		System.out.println(name + " 가 소리내어 웁니다.");
	}
	public void setName(String name){
		this.name = name;
	}
	public void print(){
		String subnames[] = name.split("[()]");
		System.out.println
		(subnames[0] + "의 이름은 "  + subnames[1] + "입니다");
	}
}


class Duck1 extends Bird1 {
	//물갈퀴 변수
	int web = 2;
	public Duck1(String name, int web) {
		super(name);
		this.web = web;
	}
	public void swim(){		
		System.out.println
		(name + " 가 " + web + " 개의 물갈퀴로 수영합니다.");}
	public void fly() {
		System.out.println(name + " 가 날지 않습니다.");
	}
}



class Sparrow1 extends Bird1 {
	
	public Sparrow1(String name) {
		super(name);
	}
	String friend ;
	void makeFriend() {
		friend = "허수아비";
		System.out.println("참새의 친구는 " + friend + " 입니다");
	}
	public void live(){}
	public void fly(){
		System.out.println
		(name + "는 날 수 있습니다.");
	}
}

















