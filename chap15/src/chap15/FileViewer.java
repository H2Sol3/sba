package chap15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileViewer {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			// '\'특수문자 표현은 \\ 2개나 / 1개 해줘야 함
			// 파일-windows 에서는 \
			// linux에서는 파일 구분을 /로 함.
//			FileInputStream fis = new FileInputStream("‪C:/Users/user/Desktop/test.txt");
			fis = new FileInputStream("src/chap15/FileViewer.java"); //경로는 현재 프로젝트 이름까지 생략된것!!!!!
			while (true) {
				int data = fis.read(); // 4byte중 1byte만 활용. 파일 입력
				if (data == -1) {//파일 끝이면 중단
					break;
				}
				System.out.print((char)data);//파일 입력 내용을 모니터에 출력

			}
		}
//		 CATCH (FILENOTFOUNDEXCEPTION E) {
//			SYSTEM.OUT.PRINTLN("해당 파일은 존재하지 않습니다.");
//		} 
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (Exception e) {

			}
		}
	}

}
