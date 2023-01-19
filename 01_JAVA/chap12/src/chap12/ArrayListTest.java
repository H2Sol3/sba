package chap12;

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
		
		//여러가지 타입도 같이 저장 가능하지만 동일 데이터타입만 저장하기위한 방법
		ArrayList<Employee> list = new ArrayList<Employee>(5);
//		list.add("java"); //문자
//		list.add(10);//정수
//		list.add(3.14);//실수
		
		Employee em1=new Employee(100, "이사원", 1000000);
		Employee em2=new Employee(200, "최대리", 1500000);
		Employee em3=new Employee(300, "김부장", 2000000);
		list.add(em1); //Employee타입 추가
		list.add(em2);
		list.add(em3);
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof Employee) {
				System.out.println(i+"번째 위치:"+list.get(i).name); //출력할때 toString은 자동으로 호출됨				
			}
			//Employee name만 출력
			
			
			
		}
	}

}
