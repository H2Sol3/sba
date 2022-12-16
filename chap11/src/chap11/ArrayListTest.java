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
		ArrayList list = new ArrayList();
		list.add("java");
		list.add(10);
		list.add(3.14);
		
		Employee em1=new Employee(100, "이사원", 1000000);
		Employee em2=new Employee(200, "최대리", 1500000);
		Employee em3=new Employee(300, "김부장", 2000000);
		list.add(em1);
		list.add(em2);
		list.add(em3);
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getClass().getName());//i데이터의 클래스 이름을 알려달라
			System.out.println(list.get(i)); //출력할때 toString은 자동으로 출력됨
			
			// id-name-pay로 출력
			
		}
	}

}
