package chap8;

public class ClassInformationTest {
	public static void main(String[] args) {
//	 	java.lang.Object - 존재합니다
//		chap8.A - 존재하지않습니다.
//		chap8.ChecktestTest - 존재합니다
		try {
			Class.forName(args[0]);
			System.out.println(args[0]+" - 존재합니다.");
		} catch (ClassNotFoundException e) {
			System.out.println(args[0]+" - 존재하지 않습니다.");
		}

	}

}