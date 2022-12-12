package constructor;

class Employee {
	// 자바 자동 포함(생성자). 써도 되고 안써도 됨. 항상 들어가있음
	// 사용자 정의 생성자(매개변수 추가, 문장 추가)
	public Employee(int id, String name, String title, String dept, double salary) {
//		System.out.println("Employee생성자 호출");
//		그럼 매개변수랑 변수 이름을 다르게 해주면 this안붙여도 되잖아!
//		=> 이름을 같게 해둬야 아~ id를 초기화 하는구나~ 하고 흐름 구분을 할 수 있음.
		this.id = id;// 매개변수와 변수의 이름이 같으니 this키워드 사용해서 구분해줘야 함.
		this.name = name;
		this.title = title;
		this.dept = dept;
		this.salary = salary;
	}

	// 생성자 오버로딩
	public Employee(int id, String name) {
		//생성자 안에서 생성자 호출할때는 new 필요.
//		new Employee(id,name,"직급미정","배치이전",-1);//생성자에서 생성자 호출(위쪽 생성자 호출.) title,dept,salary는 매개변수가 없으니 값 전달.
		this(-1, "미상","직급미정","배치이전",-1);
		
//		this.id = id;
//		this.name = name;
//		title = "직급미정"; // 같은 이름의 매개변수가 없으니까 this없어도 됨.
//		dept = "배치이전";
//		salary = -1;

	}

	// 생성자 오버로딩
	public Employee() {
		this(-1, "미상","직급미정","배치이전",-1); //생성자 호출하면 아래처럼 초기화 불필요.
//		
//		id = -1;// 같은 이름의 매개변수가 없으니까 this없어도 됨.
//		name = "미상";
//		title = "직급미정"; 
//		dept = "배치이전";
//		salary = -1;

	}

	int id;
	String name;
	String title;
	String dept;
	double salary;

	void printInform() {
//		int id=1000; 값을 넣어줬기때문에 this를 써야한다. 
		System.out.printf("사원명: %d 이름: %s 직급: %s 부서명: %s 급여: %.2f \n\n", this.id, name, title, dept, salary);// id는 this
																												// 붙여주기
	}
}

public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] arr = new Employee[10];

		Employee em1 = new Employee(100, "이사원", "사원", "it개발부", 10000); // 값을 생성자한테 전달하기
//		em1.id = 100;  없애도 됨. 값만 전달해줘도 ㄱㅊ. 왜? 생성자에서 초기화 해주니까!!!!!!
//		em1.name = "이사원";
//		em1.title="사원";
//		em1.dept="it개발부";
//		em1.salary=10000;
//		
		em1.printInform();

		Employee em2 = new Employee(200, "박대리");
//		em2.id = 200;
//		em2.name = "박대리";
//		em2.title = "대리";
//		em2.dept = "인재개발부";
//		em2.salary = 15000;

		em2.printInform();

		// 신입사원이라 현재 매개변수 없음
		Employee em3 = new Employee();
		em3.printInform();

	}

}
