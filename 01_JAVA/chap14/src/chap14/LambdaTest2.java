package chap14;

//함수형 인터페이스(추상메서드 하나만 가지고 있음)
@FunctionalInterface
interface Calculable {
	int sum(int a, int b);
//  int sum2(int a, int b); 두개 들어가면 함수형 인터페이스가 될 수 없음.	
}

//함수형 인터페이스
@FunctionalInterface
interface MyFunction {
	public int getValue(int x, int y);
}

@FunctionalInterface
interface GenericInterdace<T> {
	public T getValue(T x, T y);
}

public class LambdaTest2 {
	static int test(MyFunction fu, int a, int b) {
		return fu.getValue(a, b);
	}

	public static void main(String[] args) {
		// test3(T를 String으로 해준것)
		GenericInterdace<String> gen = (str1, str2) -> str1 + str2; //String타입, return 생략
		GenericInterdace<Integer> gen2 = (str1, str2) -> str1 + str2; //Integer타입, return 생략
		String result = gen.getValue("람다", "식");
		int result2 = gen2.getValue(10,20);
		System.out.println(result);
		System.out.println(result2);

		// test2
		MyFunction mf = (x, y) -> x > y ? x : y;
		int maxValue = test(mf, 10, 5);// test((x,y)->x>y?x:y, 10, 5); 람다식 전체를 넣어도 가능
		System.out.println(maxValue);

		// test1
		Calculable calc = null;
		// 1. 함수형 인터페이스 무명 클래스 구현
		calc = new Calculable() { // 내부익명클래스

			@Override
			public int sum(int a, int b) {
				return a + b;
			}
		};
		System.out.println(calc.sum(11, 22));

		// 2. 람다식.
		calc = (int a, int b) -> {
			return a + b;
		};// 자바의 모든 문장은 ;로 끝나야 함. 식이 끝나면; 붙여주기
		System.out.println(calc.sum(11, 22));

		// 매개변수 타입 유추 가능하니 생략
		calc = (a, b) -> a + b;// return 1줄이니까 블록, return키워드 생략 가능.
		System.out.println(calc.sum(11, 22));

	}
}
