package test;
// 교육생 객체 표현 클래스

// 1. 변수 - 이름, 과정명, 교육기관, 교육비, 부가금, 환급비
// 2. 단, 교육기관 = 새싹 으로 교육생 동일함.(공유할수 있으니 static!!)
// 3. 단, 부가금 = 5000원 수정 불가능(final쓰기)
// 4. 메소드 - calc() 리턴타입 줄건지 말건지 고민해보기 
// 4-1. 과정명이 자바 이면 환급금 = 교육비의 20% + 부가금 
// 4-2. 과정명이 jsp면 환급금 = 교육비의  15%+부가금*2
// 4-3. 과정명이 spring이면 환급금 = 교육비의 10%+부가금
// 4-4. 그 외의 과정명은 환급금 = 0;
class Trainee {
	String name, subject;
	static String location = "새싹";
	int fee, returnFee;
	final int addFee = 5000;
	int return_money = 0; // 환급비

// subject.equalsIgnoreCase() => 대,소문자 모두 무시	
//	
//	
	void calcReturnFee() { // 만약 매개변수가 있으면 this.xxx라고 하기
		if (subject.equals("자바")) {
			returnFee = (int) (fee * 0.2 + addFee);
		} else if (subject.toLowerCase().equals("jsp")) {//toLowerCase(): 입력한 글자를 모두 소문자로 바꿔줌. 만약 JsP이렇게 하면 if조건에 맞지않으니 다 소문자로 바꿔서 비교
			returnFee = (int) (fee * 0.15 + addFee * 2);
		} else if (subject.toUpperCase().equals("spring")) {
			returnFee = (int) (fee * 0.1 + addFee);
		} else {
			System.out.println("과정명은 없습니다.");
		}

		System.out.printf("이름: %s\n과정명: %s\n교육비: %d\n교육기관: %s\n부가금: %d\n환급비: %d", name, subject, fee,
				Trainee.location, addFee, returnFee);
	}
}

public class Test1_review {
	public static void main(String[] args) {
//		교육생 a1 = new 교육생();
//		이름, 과정명, 교육비 명령행 매개변수로 입력값 할당(args) & 초기값은 String일테니 형변환도 필요
//	 	교육생 환급비 계산 메소드 호출
//		이름: xxx
//		과정명: xxx
//		교육비: xxx
//		교육기관: 새싹
//		부가금:5000		
//		환급비: xxx(리턴결과)

		Trainee t1 = new Trainee();
		t1.name = args[0];
		t1.subject = args[1];
		t1.fee = Integer.parseInt(args[2]);

		t1.calcReturnFee();

	}
}
