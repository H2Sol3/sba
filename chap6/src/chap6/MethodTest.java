package chap6;

import java.util.Arrays;

class B{
	int m1(){ ///m1메서드. m1 메서드 앞에 리턴타입을 적어줘야 한다. 숫자 리턴이니까 int 작성
		int local = 10;
		return local*10;
	}
	
	int m2(int param) {
		return param * 10;
	}
	String m3(int param1, int param2){ //문자열 붙었으니까 int가 아니라 String임
		return param1*param2+"결과를 리턴합니다.";
	}
	int[] m4(int[] arr) {//arr 배열 각 요소에 *10 배열 저장해서 리턴
		int[] result =new int[arr.length];
		for(int i=0;i<arr.length;i++) { 
			result[i]=arr[i]*10;
		}
		return result;
	}
	void m5(){
		System.out.println("B클래스에서 메소드를 테스트합니다.");
		//리턴문 없이 끝남. void키워드 붙여주기
	}
	
}
public class MethodTest {
	public static void main(String[] args) {
		
		B b1 = new B();
		int result = b1.m1();
		System.out.println(result);
		
//		b1.m2(5);
		System.out.println(b1.m2(5));
		System.out.println(b1.m2(50));
		System.out.println(b1.m3(10, 20));
		
		int[] main_arr= {10,20,45,1,99};
		int[] main_result=b1.m4(main_arr);
		
		System.out.println(Arrays.toString(main_result));
		b1.m5();
	}
}
