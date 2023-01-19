package chap4;

public class WhileTest {

	public static void main(String[] args) {
		//
		int i = 1;
		while(i <= 10) {//50이 아니면 반복
			int test = (int)(Math.random()*100)+1;
			System.out.println(test);
			//50이 나오면 중단
			if(test==50) {
				System.out.println("==중단==");
				break;
			}
			//3의 배수면 종료
			if(test%3==0) {
				System.out.println("==중단==");
				break;
			}
		}

	}

}
