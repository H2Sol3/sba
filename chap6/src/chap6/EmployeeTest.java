package chap6;

// 자바 클래스명 = 자바 파일명이 기본
// 아닌 경우도 가능하긴 함. 단, public 키워드 1개 클래스에만 선언한다. 메인메소드
// Employee 클래스에는 public을 붙이지 않는다. 
// 만약 붙여아 한다면 따로 클래스 파일 생성하기.


//회사원 변수 5개(지역변수X,매개변수X,클래스변수X)를 가진 "클래스" 정의
class Employee{
	int id;
	String name;
	String title;
	String dept;
	double salary;
	void printInform() {
		int id=1000;
		System.out.printf("사원명: %d 이름: %s 직급: %s 부서명: %s 급여: %.2f \n\n",this.id,this.name,
				title,dept,salary);//id는 this 붙여주기
	}
}

public class EmployeeTest {
	//class 안에는 변수+메소드 필요
	public static void main(String[] args) {
		//사원수가 10명일땐 객체를 10개 생성해야 함. 너무 비효율적이니 배열에다 저장
		//배열-Employee객채만 10 저장
		Employee[] arr = new Employee[10];//arr에 Employee객체 10개를 저장하겠다는 배열 선언. 객체 선언 아님.
		

		
		Employee em1 = new Employee(); //객체 생성해서 복사하기
		em1.id = 100;  //객체주소참조 변수명.객체변수명
		em1.name = "이사원";
		em1.title="사원";
		em1.dept="it개발부";
		em1.salary=10000;
//		System.out.printf("사원명: %d 이름: %s 직급: %s 부서명: %s 급여: %.2f \n\n",em1.id,em1.name,
//				em1.title,em1.dept,em1.salary);//em은 참조형변수가 된 것.
		
		em1.printInform();
		
		Employee em2 = new Employee();
		em2.id = 100;  //객체주소참조 변수명.객체변수명
		em2.name = "박대리";
		em2.title="대리";
		em2.dept="인재개발부";
		em2.salary=15000;
//		System.out.println("사원명: "+em2.name);//em은 참조형변수가 된 것.
//		System.out.printf("사원명: %d 이름: %s 직급: %s 부서명: %s 급여: %.2f",em2.id,em2.name,
//				em2.title,em2.dept,em2.salary);//em은 참조형변수가 된 것.
		
		em2.printInform();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
