package chap5;

public class MainTest {
	public static void main(String[] args) {
		System.out.println("입력한 변수의 갯수 = "+args.length);
		System.out.println("입력한 내용은 다음과 같습니다.");
		
		for(int i=0;i<args.length;i++) { 
			System.out.println(args[i]);
		}
		
		System.out.println("==========");
		//입력변수 갯수 + 1
		String userarray[] = new String[args.length+1];
		for(int i=0;i<args.length;i++) {
			userarray[i]=args[i];
			System.out.println(userarray[i]);
		}
//		
//		System.out.println("==========");
//		userarray[args.length] = "내가 추가한 문자열";
//		for(int i=0;i<userarray.length;i++) {
//			userarray[i] = args[i];
//			System.out.println(userarray[i]);
//		}
//		
//		
//		System.out.println("==========");
//		userarray[args.length] = "내가 추가한 문자열";
//		for(int i=0;i<userarray.length;i++) {
//			System.out.println(userarray[i]);
//		}
//		
		System.out.println(args[0]+args[1]);
		System.out.println(Integer.parseInt(args[0])+Integer.parseInt(args[1]));
		
		String s1 ="java";
		String s3=new String("java");
		String s4=new String("java");
		String s2 ="java";
		
		s2="jsp";
		//명령행 매개변수, 문자열은 메모리가 한 번 생성되면 바꿀 수 없다.
		if(s1 == s2) {
			System.out.println("s1==s2 결과는 같다.");
		}
		if(s3 == s4) { //false
			System.out.println("s3==s4 결과는 같다.");
		}
		if(s1.equals(s2)) {
			System.out.println("s1==s2 결과는 같다.");
		}
		if(s3.equals(s4)) {
			System.out.println("s3==s4 결과는 같다.");
		}
	}

}
