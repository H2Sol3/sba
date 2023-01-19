package constructor;

public class VarInitTest {
//객체 변수 선언
	int a;
	double b;
	String c;

	// 생성자 만들기
	//그럼 생성자 없이 그냥 객체변수한테 int a = 100;이렇게 초기화 해주면 생성자 필요없잖아1!!!할수도 있지만
	//값이 동일한 경우에는 필요 없음. 값이 계속 변동이 있으면 생성자 필수임!!!!!!!!
	public VarInitTest(int a,double b) {
		this.a = a;
		this.b=b;
	}
	
	//초기화 블록. 여러 객체 생성시 공통적으로 하나의 값으로 초기화될 필요가 있을때는 초기화 블록을 사용해도 됨.
	//생성자 내부에서 해도 되고 생성자 블록에서 사용해도 됨.
	{		
		c = "초기화블록에서 사용";
	}

	public static void main(String[] args) {
		int d;// 지역변수는 자동 초기화가 안됨. 사용자 초기화 필요
		d = 0; // 이렇게 초기화 필요
		System.out.println(d);
		VarInitTest test = new VarInitTest(100,100.9);
		VarInitTest test2 = new VarInitTest(1000,1000.9);
		
		
//		System.out.println(a);//static메소드에서는 static변수만 사용이 가능해서 오류가 남.
		System.out.printf("a = %d, b = %f, c  = %s \n", test.a, test.b, test.c);

	}
	
	
	
}
