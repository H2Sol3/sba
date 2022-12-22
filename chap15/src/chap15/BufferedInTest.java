package chap15;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedInTest {
	public static void main(String[] args) throws Exception {
		FileReader fis = new FileReader("src/chap15/FileViewer.java"); // 경로는 현재 프로젝트 이름까지 생략된것!!!!!
		BufferedReader br = new BufferedReader(fis, 10);

		while (true) {
//				int data = br.read(); // 4byte중 1byte만 활용. 파일 입력
//				if (data == -1) {//파일 끝이면 중단
//					break;
//				}
//				System.out.print((char)data);//파일 입력 내용을 모니터에 출력
			String line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		br.close();
	}

}
