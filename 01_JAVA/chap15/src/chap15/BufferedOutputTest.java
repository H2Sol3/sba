package chap15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputTest {
	public static void main(String[] args) throws IOException{
		//원본스트림
		FileOutputStream fos = new FileOutputStream("buffer.txt"); //파일명만 주면 파일은 현재 프로젝트 바로 밑에 생김
		//보조스트림-메모리 복사
		BufferedOutputStream bos = new BufferedOutputStream(fos, 5);//5: 메모리버퍼 크기
		for(int i=48;i<=57;i++) { //0유니코드: 48임. txt에 01234출력됨
			bos.write(i);// write(i) -> int타입에 해당되는 문자가 저장됨. 1유니코드 문자, 2유니코드문자 등등이 저장됨.
		}
		bos.close(); //닫을때는 bos부터 닫아야함. fos부터 닫으면 연결이 끊겨서 bos닫기 못함
		fos.close();
	}

}
