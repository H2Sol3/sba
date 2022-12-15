package chap8;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Test {
	void m1(int i) throws FileNotFoundException {
		System.out.println(10 / i);
		// ArithmeticException - 반드시 처리구문이 존재하진않는다.
		FileReader fr = new FileReader("none.txt");
		// FileNotFoundException - 반드시 처리구문이 필요함.

	}

	void m2() {
		try {
			m1(0);
		} catch (ArithmeticException e) {
			try {
				m1(10);
			} catch (FileNotFoundException e2) {
				System.out.println("파일명 재확인 필요");
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일명 재확인 필요");
		}

	}
	
	void m3() throws FileNotFoundException{
		m1(10);
	}
}

public class ThrowsTest {
	//main을 호출한 자비시스템으로 전달 - 예외 메세지만 출력
	public static void main(String[] args) throws FileNotFoundException{
		Test test = new Test();
		test.m2();
		test.m3();
	}
}
