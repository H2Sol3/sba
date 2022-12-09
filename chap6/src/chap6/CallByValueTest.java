package chap6;

class Data{
	int k = 10;
	
}

class C {
	void add(int i) { //기본형 매개변수=입력변수
		System.out.println(i++);	
	}
	void addData(Data d) {//참조형 매개변수 <매개변수를 Data타입으로(매개변수 타입에는 클래스타입도 가능!!!!!!)>
		System.out.println(d.k++);
	}
}

public class CallByValueTest {
	public static void main(String[] args) {
		C c = new C();
	//  기본형변수 전달 테스트 코드
//		int j = 10;
//		c.add(j);//인수: 실제로 매개변수로 전달하는 값
//		System.out.println("main에서 add종료 후 j = " + j);
		
	//  참조형변수 전달 테스트 코드
		Data main_d = new Data(); //Data 객체 생성
		c.addData(main_d);//appData 매개변수가 Data타입이니까 main_d 넘겨줌
		System.out.println("main에서 addData 종료 후 main_d = " + main_d.k);
	}
}
