package chap6;

// 자바 클래스명 = 자바 파일명이 기본
// 아닌 경우도 가능하긴 함. 단, public 키워드 1개 클래스에만 선언한다. 메인메소드
// Employee 클래스에는 public을 붙이지 않는다. 
// 만약 붙여아 한다면 따로 클래스 파일 생성하기.


//회사원 변수 5개를 가진 "클래스" 정의
//class Employee{ //오류. 왜냐면 EmployeeTest안에 같은 이름을 가진 class가 존재하기때문임. 같은 폴더 안에서는 동명 불가
// Eployee클래스 없어도 이미 생성해둔 class가 있기때문에 문제 없음.
//	int id;
//	String name;
//	String title;
//	String dept;
//	double salary;
//}

public class EmployeeArrayTest {
	//class 안에는 변수+메소드 필요 
	public static void main(String[] args) {
		//사원수가 10명일땐 객체를 10개 생성해야 함. 너무 비효율적이니 배열에다 저장
		//배열-Employee객채만 10 저장
		Employee[] arr = new Employee[2];
		
		Employee em1 = new Employee(); //객체 생성해서 복사하기
		em1.id = 100;  //객체주소참조 변수명.객체변수명
		em1.name = "이사원";
		em1.title="사원";
		em1.dept="it개발부";
		em1.salary=10000;
		
		arr[0]=em1; //위에 넣은 값들을 배열[0]에 저장.
		
		
		Employee em2 = new Employee();
		em2.id = 100;  //객체주소참조 변수명.객체변수명
		em2.name = "박대리";
		em2.title="대리";
		em2.dept="인재개발부";
		em2.salary=15000;
		
		arr[1]=em2; //위에 넣은 값들을 배열[1]에 저장.

		
		for(int i=0;i<arr.length;i++) {
			System.out.printf("사원명: %d 이름: %s 직급: %s 부서명: %s 급여: %.2f \n\n",arr[i].id,arr[i].name,
					arr[i].title,arr[i].dept,arr[i].salary);		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
