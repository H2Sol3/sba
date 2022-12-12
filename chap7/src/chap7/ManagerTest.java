package chap7;

//자바 자동 포함 - 생성자, 상속
//java.lang.Object 클래스 라이브러리가 있다

class Employee {
	// 사원
	/* private */String title = "사원";
	int id;
	String name;
	String dept;
	double salary;

	// 접근제어자(defalut)
	void calcSalary(int salary) {
		this.salary = salary * 2;
	}

	void printAll() {
		System.out.printf("사번=%d 이름=%s 부서명=%s 급여=%.2f \n", id, name, dept, salary);
	}

}

class Manager extends Employee { // 관리직 사원
	Manager(int id, String name, String dept, String job) { //생성자
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.job = job;
	}

	String title = "관리직";

	void test() { // 상속받지않았으니 오버라이딩 아님. 현재 추가된 메소드일뿐
		System.out.println(title); // 지역변수
		System.out.println(this.title);// Manager
		System.out.println(super.title);// 상속
	}

	String job; // 자식클래스 변수는 부모에서 사용 불가
	// calcSalary, printAll 메소드 Employee 정의한대로 상속받아 사용
	// 메소드 내용 수정 필요
	// 상속 후에 하위클래스에서 메소드 내용 재정의 => 메소드 overriding

	// 오버라이딩
	@Override // @:자바컴파일러에게 알려주는 주석문
	void printAll() { // public은 ㄱㅊ지만 private은 안됨. modifier가 다르니까&넓은건 되지만 더 좁아지는 건 안됨.(제한범위)
		super.printAll(); // 상속관계라서 여기선 super되는건가봐~~~~~
		System.out.printf("사번=%d 이름=%s 부서명=%s 급여=%.2f 관리직종=%s\n", id, name, dept, salary, job);
	}

}

//인터페이스 => 클래스 돌연변이-> 다중상속 가능
//class A {
//	int i = 10;
//}
//
//class B {
//	int i = 20;
//}
//
//class C extends A,B{//2개 이상 클래스 동시 상속 불가하지만 가능하다고 가정했을때
//	int k=30;
//	//A.i B.i 같은 이름의 변수가 2개라서 혼란. 그래서 2개 이상은 불가하도록 해둔 것.
//}
//

public class ManagerTest {
	public static void main(String[] args) {
		Manager m = new Manager(100, "홍길동", "영업부", "영업관리"); // 자식클래스 객체 생성
		m.id = 100; // 상속
		m.name = "홍길동";// 상속
		m.dept = "영업부";// 상속
		m.job = "영업관리";// 자식클래스 변수
		m.calcSalary(50000);// 상속받은 그대로 사용
		m.printAll();// 상속받은 후 메소드 재정의(overriding)

		m.test();

//		System.out.printf("사번: %d 이름:%s 부서명:%s 관리직종:%s \n", m.id, m.name, m.dept, m.job);
	}

}
