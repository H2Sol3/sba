package chap9;

import java.util.Random;

public class RandomClassTest {

	public static void main(String[] args) {
		// 1-100
//		int mathran = (int) (Math.random() * 100) + 1;
//		System.out.println(mathran);
//		
//		Random ran = new Random();
//		System.out.println(ran.nextInt(100));
//		
//		ran.nextDouble(100.0);
//		System.out.println(ran.nextDouble(100.0));
		
		
		Random ran = new Random();
		for(int i=0;i<=5;i++) {
			System.out.println("Random 정수 = "+ran.nextInt(100));
		}
		System.out.println("===============================");
		
		Random ran2 = new Random(2);
		for(int i=0;i<=5;i++) {
			System.out.println("Random 정수 = "+ran2.nextInt(100));
		}
		
		
	}

}
