package chap6;

class A {
	
	int i; // 클래스 내부 변수
	public void test() {// 메소드(함수)
		int j = 20; //test메소드의 지역변수. 그래서 main에서는 사용 불가
		System.out.println(i + j);
	}
	
	public void test2() { 
		System.out.println(i); //i 변수 사용가능. j는 사용 불가능.
	}
}

public class MemberLocalTest { 
	public static void main(String[] args) {
		A a1 = new A();
		a1.i=10;
		System.out.println(a1.i); //ㅐ로 생성한 객체에 10을 넣어줬으니 10
		a1.test();//test함수 안에 j가 20이니가 20 출력
//		a1.j=200;//오류. j는 test함수의 지역변수가 다른 곳에서 사용 불가. i는 클래스 내부 변수라 어디서든 사용 가능
		
		
	}
}