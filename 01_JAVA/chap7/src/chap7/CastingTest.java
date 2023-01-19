package chap7;

import java.net.MulticastSocket;

class Parent {
	int su = 10;

	void print() { // 메서드
		System.out.println(su); // 10
	}

	void mp() {
		System.out.println("Parent클래스"); // non-overriding메소드
	}
}

class Child1 extends Parent {
	int su = 20;

	void print() {
		System.out.println(su); // 20. overriding 메소드
	}

	void mc() {
		System.out.println("child1 클래스"); // 오버라이딩이 아닌 자식이 추가한 메서드
	}
}

class Child2 extends Parent {
	int su = 30;

	void print() {
		System.out.println(super.su + su);
	}
	
	void mc2() {
		System.out.println("child2 클래스"); // 오버라이딩이 아닌 자식이 추가한 메서드
	}
}

public class CastingTest {
	public static void main(String[] args) {
		Parent p1 = new Parent(); // 형변환발생X
		System.out.println(p1.su);
		p1.print();
		p1.mp();
//		p1.mc(); 메모리 존재X

		Child1 c1 = new Child1();// 형변환발생X
		System.out.println(c1.su);
		c1.print();
		c1.mp();
		c1.mc();

		Parent p2 = new Child1();// 자동형변환발생
		System.out.println(p2.su); // 사용변수-Parent
		p2.print();// 오버라이딩 메소드-Child1
		p2.mp(); // 사용메소드-Parent
//		p2.mc(); 메모리 생성

//		mc - 원래 자식클래스 포함 메서드
//		Child1 c2=Child1(Child1)p2;
//		c2.mc();
//		instanceof => t/f
		if(p2 instanceof Child1) {//객체를 갖고있습니까(=형변환이 가능한지 물어보는 것)
			((Child1) p2).mc();			
		}else {
			System.out.println("p2 Child1타입 형변환 불가");
		}
		
		

		Parent p3 =new Child2();
		System.out.println(p3.su);
		p3.print();
		if(p3 instanceof Child2) { //형변환하려고 하는 타입을 물어봐야 함(?)
			
		}
		((Child1)p3).mc();
	}
}











