package chap2;


public class VariableTest {

	public static void main(String[] args) {
		int score = 100;
		System.out.println(score);
		
		score =score+100;
		System.out.println(score);
		
		int score2 = 95, score3=60;
		//정수 평균
		System.out.println((score + score2 + score3) / 3);
		//실수 평균
		System.out.println((score + score2 + score3) / 3.0);
		//반올림
		System.out.println(Math.round((score + score2 + score3) / 3.0));
		
		
		
		
		
		//상수
		final int score5 = 100;
		
		int r = 5;//반지름
		final double  pi = 3.14;
		double area =r*r*pi;
		
		
		
		System.out.println(10); //int
		System.out.println(100000000L);//Long
		System.out.println(true); //boolean
		System.out.println('a'); //char
		
		
		
		int a1 =10;
		int a2 =20;
		int c =a2;
		a1 =c;
		System.out.println(a1);
		
		
		int i = 10;
		String s ="java";
		double d = 3.14;
		i+=1;
		s = "servlet";
		d=d*2;
		
		
		
		
		System.out.printf("%d를 표현합니다.\n", 10);
		System.out.printf("%f를 표현합니다.\n", 10.99);
		System.out.printf("%s를 표현합니다.\n","홍길동");
		System.out.printf("%c를 표현합니다.\n",'웅');
		
		String loc = "새싹 용산캠퍼스";
		String title ="클라우드 기반 웹서버 과정";
		int week =3;
		System.out.println("우리는 "+ loc +"에서"+ title+"을 수강합니다.\n 현재 "+week+"주째 시작합니다.");
		System.out.printf("우리는 %s에서 %s을 수강합니다.\n 현재 %d주째 시작합니다.",loc,title,week);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
