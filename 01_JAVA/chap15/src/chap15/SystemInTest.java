package chap15;

import java.io.IOException;
import java.util.Scanner;

public class SystemInTest {
	public static void main(String[] args) throws IOException {
		System.out.println("키보드 입력을 대기중입니다.");
//		while(true) {
//			int data = System.in.read();//읽어오기
//			System.out.println((char)data);
//		}

		Scanner key = new Scanner(System.in);
		while(key.hasNextInt()) {
			int first = key.nextInt();
			int second = key.nextInt();
			System.out.println("값: "+(first + second));			
		}
		
		while(key.hasNextInt()) { //공백이전 문자열
			String first = key.next();
			String second = key.next();
			System.out.println("값: "+(first + second));			
		}

		// "자바 프로그램 진행중"
			String first = key.nextLine();
			System.out.println(first);

	}
}
