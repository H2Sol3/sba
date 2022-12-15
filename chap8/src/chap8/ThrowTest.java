package chap8;

class Test2 {
	void m1(int i) throws NumberFormatException{
		// i소수인지 판단
		// 소수 - 1과 자신수로만 나누어지는 자연수
		// 1-자신수 나머지 0인경우 2개 -> 소수
//		try {}
		if(i<0) {//예외발생조건식 필수
			throw new NumberFormatException();
			//예외발생 - 처리블록 없을땐 중단됨.
		}
			int count = 0;
			for (int index = 1; index <= i; index++) {
				if (i % index == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.println(i + "소수이다.");
			} else {
				System.out.println(i + "소수 아니다.");
			}			
		
	}
}

public class ThrowTest {
	public static void main(String[] args) {
		Test2 t2 = new Test2();
		try {
			t2.m1(-13);//음수. 예외발생-try중단-catch이동
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		t2.m1(13);

	}

}
