package chap15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) throws IOException{
		//1. (입력파일 없는 오류) a.txt b.txt 
		//2. (출력파일 없으면 copy.txt 파일 자동생성) src/chap15/FileCopy.java    copy.txt
		//실행결과 새로 파일생성 - refresh 또는 Preferences-workspace-> refresh어쩌고 클릭 => run-여기서 args입력하면 바로 폴더에 파일생성됨
		//3. (다른파일 복사-기존내용 유지x)src/chap15/FileViewer.java    copy.txt => 기존 내용 삭제되고 FileViewer내용 복사됨
		//3. (다른파일 복사-기존내용 유지o <true>)../chap14/src/chap14/LambdaTest1.java copy.txt    copy.txt
		FileInputStream fis = new FileInputStream(args[0]);
		FileOutputStream fos = new FileOutputStream(args[1], true); //기존 내용 삭제없이 뒤에 추가해주기(true)
		while(true) {
			int data = fis.read(); //1byte만 활용
			if(data == -1) break;
			fos.write(data);			
		}
		
		fis.close();
		fos.close();
	}

}
