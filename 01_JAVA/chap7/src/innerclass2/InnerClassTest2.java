package innerclass2;

class Outer {
//	int i = 10; // 멤버변수
	static int i = 10;
	
	void mo() {
		System.out.println(i); //외부클래스 메소드는 내부클래스 요소 접근 불가
	}
	
	//내부클래스에 아래 modifier사용가능. 외부클래스는 불가
	/*public / protected / private / static / final */
//	class Inner { // 멤버변수 유사 취급
//		int j = 20;
//		void mi() {
//			System.out.println(i - j); //내부클래스 메소드는 외부클래스 요소 접근 가능
//		}
//	}
	
	static class Inner { // 멤버변수 유사 취급
		static int j = 20;
		static void mi() {
			System.out.println(i - j); //static 내부클래스 메소드는 외부클래스 static 요소 접근 가능. i변수에 static이 붙어있으면 오류 없음. static없으면 오류. static은 static끼리만~
		}
	}
}

public class InnerClassTest2 {
	public static void main(String[] args) {
//		Outer o = new Outer();
		// Out객채를 만들고 그 안에 들어있는 Inner객체를 만들어라
//		Outer.Inner inner = o.new Inner();// outer에 포함되이ㅓ있는
		Outer.Inner.mi();
//		System.out.println(o.i);
//		System.out.println(inner.j);

	}

}
