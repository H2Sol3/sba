package innerclass;


class Outer {
	int i = 10; // 멤버변수
	
	void mo() {
		System.out.println(i); //외부클래스 메소드는 내부클래스 요소 접근 불가
	}
	
	//내부클래스
	class Inner { // 멤버변수 유사 취급
		int j = 20;

		void mi() {
			System.out.println(i - j); //내부클래스 메소드는 외부클래스 요소 접근 가능
		}
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		Outer o = new Outer();
		// Out객채를 만들고 그 안에 들어있는 Inner객체를 만들어라
		Outer.Inner inner = o.new Inner();// outer에 포함되이ㅓ있는
		System.out.println(o.i);
		System.out.println(inner.j);

	}

}
