package chap7;

abstract class Shape {
	abstract void area(); // 면적

	abstract void circum(); // 둘레

	void print() { // 자식클래스 반드시 오버라이딩 필요
		System.out.println("면적과 둘레 출력 기능");
	}
}

class Rectangle extends Shape {
	int width, height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	void area() {
		System.out.printf("면적: %d \n",width*height);
	}

	@Override
	void circum() {
		System.out.printf("둘레: %d \n",width+height);
	}
}

class Circle extends Shape {
	int radius;
	static final double pi = 3.14;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	void area() {
		System.out.printf("면적: %.2f \n",radius*radius*pi);
	}

	@Override
	void circum() {
		System.out.printf("둘레: %.2f",2*radius*pi);
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		// 명령행 매개변수 입력
		// rect 6 8 - 3개 입력
		// Rectangle객체 생성
		// 면적-area호출 - 두,세번째 가로,세로 면적 출력
		// 둘레 - ...

		// cir 5 - 2개 입력받고 첫번째 문자열이 "cir"이면
		// Circle객체 생성.
		// 두번째 반지름, 면적 둘레

		// 면적, 둘레 구할 수 있어야 함. 구현 필수
		Shape s = null;
 
		if (args.length == 3 && args[0].equals("rect")) {
			System.out.println("사각형");
			s = new Rectangle(Integer.parseInt(args[1]), Integer.parseInt(args[2])); // 상속필요

		} else if (args.length == 2 && args[0].equals("cir")) {// cir
			System.out.println("원");
			s = new Circle(Integer.parseInt(args[1]));

		} else {
			System.out.println("계산 불가");
		}
		
		
		s.area();
		s.circum();

	}
}
