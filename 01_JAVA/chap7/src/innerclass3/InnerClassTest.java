package innerclass3;

class Outer {
	void test() {
		// 내부클래스에 아래 modifier사용가능. 외부클래스는 불가
		/* public / protected / private / static / final */
		class LocalInner { // 멤버변수 유사 취급
			int j = 20;

			void mi() {
				System.out.println(j); // 내부클래스 메소드는 외부클래스 요소 접근 가능
			}
		}
		new LocalInner().mi();
	}

}

public class InnerClassTest {
	public static void main(String[] args) {
		Outer o = new Outer();
		// Out객채를 만들고 그 안에 들어있는 Inner객체를 만들어라
		o.test();

	}

}
