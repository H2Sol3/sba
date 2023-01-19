package chap9;

public class WrapperTest {
	public static void main(String[] args) {
//		int i = 10;
//		System.out.println(Integer.toBinaryString(i));
//		System.out.println(Integer.toOctalString(i));
//		System.out.println(Integer.toHexString(i));

		Integer in = new Integer(10); // 여러 메소드들을 사용하려면 객체 생성해줘야 함.
		int i = 10;
		// in는 메소드 이용해서 연산 가능, i는 연산자 사용해서 가능

		
		
		//jdk 1.5추가. autoboxing / auto unboxing
		int i2 = new Integer(10);
		Integer in2 = 10;
		
		

		//jdk 1.9추가. Integer 사용 자제 권고
		int i3 =10;
		Integer in3 = 10;

	}

}