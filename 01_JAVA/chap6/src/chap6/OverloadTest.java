package chap6;

//오버로딩 연습
//같은 이름의 함수 여러개 정의 가능.
//단, 매개변수 갯수, 타입, 순서 등 하나 이상 다르게 정의해야 한다.
class D {
	int add(int i, int j) {
		return i + j;
	}

	String add(String i, String j) {
		return i + j;
	}

	double add(double i, double j) {
		return i + j;
	}
}

public class OverloadTest {
	public static void main(String[] args) {
		D d1 = new D(); 
		String result1 = d1.add("Spring ", "framework");
		double result2 = d1.add(2.5, 1.1);
		int result3 = d1.add(4, 5);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);

		d1.add(3.14, 5); // 오류 날것같지만 오류 안남. 왜냐? 자동형변환 되니까 int는 double로 형변환 가능하다.
//		d1.add(3.14, true); 오류. boolean은 형변환 불가
//		d1.add(3, 'a'); //맞는 데이터타입이 없다면 형변환을 함.

		System.out.println();

		int dec = Integer.parseInt("100"); // 문자열을 정수형으로 변환
		// "100" => 10진수 정수 변환
		int bin = Integer.parseInt("100", 2); // 2진수 100 - 10진수 4
		System.out.println(dec);
		System.out.println(bin);
	}

}
