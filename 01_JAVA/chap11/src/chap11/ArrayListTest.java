package chap11;

import java.util.ArrayList;

class Employee{
	//toString
	//패키지명.클래스명
	int id;
	String name;
	double pay;
	
	public Employee(int id, String name, double pay) {
	//	super();
		this.id = id;
		this.name = name;
		this.pay = pay;
	}

	@Override
	public String toString() {
		return id + "-" + name + "-" + pay;
	}
	
	
	
}

public class ArrayListTest {
	public static void main(String[] args) {
		//배열 차이점: 동일 타입만 가능, 저장 길이 수정 불가[5](배열)
		//ArrayList: 서로 다른 타입도 저장 가능. 생성+동적 크기 수정 가능
//		ArrayList list = new ArrayList(5);
		ArrayList list = new ArrayList();
		list.add("java"); //문자
		list.add(10);//정수
		list.add(3.14);//실수
		
		Employee em1=new Employee(100, "이사원", 1000000);
		Employee em2=new Employee(200, "최대리", 1500000);
		Employee em3=new Employee(300, "김부장", 2000000);
		list.add(em1); //Employee타입 추가
		list.add(em2);
		list.add(em3);
//		list.set(5, "new문자열"); //기존 데이터를 수정
//		list.remove(1);
		list.add(em3); //list는 중복 가능
		
		System.out.println(list.size());

		System.out.println(list.contains("java")); //true=>"java"문자열이 list에 포함되어있다.
		System.out.println(list.indexOf("java"));
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getClass().getName()+":");//i데이터의 클래스 이름을 알려달라
			System.out.println(i+"번째 위치:"+list.get(i)); //출력할때 toString은 자동으로 호출됨
			
			// id-name-pay로 출력
			
		}
	}

}
