package chap15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileTest {
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		// a.java
		Scanner scan = new Scanner(System.in);
		System.out.println("파일이나 디렉토리명을 입력하세요");
		String input = scan.next();
		File f = new File(args[0]);
		if (!f.exists()) {
			System.out.println("파일이나 디렉토리 존재하지 않습니다.");
			return;
		}
		if (f.isFile()) { // file이니?
			System.out.println("파일명 = " + f.getName());
			System.out.println("파일경로 = " + f.getAbsolutePath());
//			System.out.println("파일경로 = " + f.getCanonicalPath());
			System.out.println("파일크기(byte) = " + f.length());
			Date d = new Date(f.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일 hh시 mm분 ss초 yyyy년도");
			String dStr = sdf.format(d);
			System.out.println("파일수정시각 = " + dStr);
			System.out.println("파일수정시각 = " + f.lastModified());
			System.out.println("파일읽기여부 = " + f.canRead());
			System.out.println("파일읽기여부 = " + f.canWrite());
		} else {// 디렉토리명
//			String[] details = f.list();
//			for(String s : details) {
//				System.out.println(s);
//			}
			File[] details2 = f.listFiles();
			for(File s2:details2) {
				System.out.println(
				s2.isDirectory()?"{"+s2.getName()+"}" : "("+s2.getName()+")" ) ;
			}
		}
	}

}
