package inter;

class StudentWorker implements Worker, Student {
//	String dept = "전산학과"; =>상속받았으니 포함되어있음
//	double score=4.5; =>상속받았으니 포함되어있음

	String title = "조교";

	@Override
	public void work() { // 오버라이딩 받을때는 public키워드 필요. 왜먀면 Worker의 work()가 public으로 정의되었기 때문. 같거나 더 넓은
							// 접근제어자를 사용해야하는데 public보다 큰건 없으니 public으로 기재해주기
		System.out.println("학교에서 일하다");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("도서관에서 공부하다");
	}

	@Override
	public void lunch() {
		// TODO Auto-generated method stub
		System.out.println("학생식당이나 교직원식당에서 점심먹다");
	}

	// 생성자 변수 메서드 추가 가능함.
	void team() {
		System.out.println("조교모임 참석하다 -> 오버라이딩X, 추가한 메서드");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
//		Worker w=new Worker(); 인터페이스 객체 생성 불가
//		Student s=new Student(); 인터페이스 객체 생성 불가
		StudentWorker sw = new StudentWorker(); // 인터페이스는 객체 생성 불가하지만 상속받은 class는 객체 생성 가능~~~!(아마도)
		sw.study();
		sw.lunch();
		sw.work();
		sw.team();

		sw.title = "조교 아님";
//		sw.dept="국문학"; final이라 수정 불가

		System.out.println(sw.title);

		System.out.println(sw.dept); // Worker 상속
//		System.out.println(Worker.dept); //이렇게 해도 동일함

		System.out.println(sw.score); // Student 상속
//		System.out.println(Student.score); //이렇게 해도 동일함

		Worker w = new StudentWorker(); //StudentWorker객체를 Worker타입으로 변환??????????
		/*
		 * 1. 자동형변환 이후에
		 * 2. w.non-overriding메서드 --> Worker인터페이스
		 * 3. w.overriding메서드 --> StudentWorker클래스
		 * 4. 
		 * */
//		w.study(); //Worker와 관련된 메서드가 아니니 불가. Worker w = new StudentWorker();
		w.lunch(); //Worker메서드만 가능. 
		w.work();
//		w.team(); //오버라이딩된 메서드가 아니니 w.team 사용 불가
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}




























