package chap7;

//import java.lang.Math;  Math변수와 메소드 사용 허락
import static java.lang.Math.*; //Math static변수와 메소드 사용 허라
import static java.lang.Integer.*;

public class StaticImportTest {
	public static void main(String[] args) {

		int ran = (int) (random() * 100) + 1;// 1~100난수 발생 //Math import했으니 앞에 Math안붙여도 됨
		System.out.println(ran);
		System.out.println(MAX_VALUE);
		
	}

}
