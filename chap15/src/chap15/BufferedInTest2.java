package chap15;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedInTest2 {
	public static void main(String[] args) throws Exception {
		// 1.파일로부터 직접입력 소요 시간
		long start = 0, end = 0;
		FileReader fis = new FileReader("C:\\Users\\user\\Desktop\\JAVA\\2. 예제\\2-1. 문제 실습 파일/컬렉션프레임워크실습예제.pdf");
		// 경로는 현재 프로젝트 이름까지 생략된것!!!!!
		start = System.currentTimeMillis();
		while (true) {
			int data = fis.read();

			if (data == -1)
				break;
		}
		end = System.currentTimeMillis();
		System.out.println("버퍼 비사용시 소요시간 = " + (end - start) + "ms");
		start = System.currentTimeMillis();
		// 2. 버퍼 저장 입력 소요 시간
		fis = new FileReader("C:\\Users\\user\\Desktop\\JAVA\\2. 예제\\2-1. 문제 실습 파일/컬렉션프레임워크실습예제.pdf");
		BufferedReader br = new BufferedReader(fis, 100);
		while (true) {
			int data = br.read();
			if (data == -1) {
				break;
			}
		}
		end = System.currentTimeMillis();
		System.out.println("버퍼 사용시 소요시간 = " + (end - start) + "ms");
		br.close();

	}

}
