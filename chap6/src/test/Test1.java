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
class Student {

	static String academy = "새싹"; // 교육기관(공유)
	final int plus_money = 5000; // 부가금(고정)
	int return_money = 0; // 환급비

	int calc(String class_name, int money) {
		if (class_name.equals("자바")) {
			return_money = (int) (money * 0.2 + plus_money);
		} else if (class_name.equals("jsp")) {
			return_money = (int) (money * 0.15 + plus_money * 2);
		} else if (class_name.equals("spring")) {
			return_money = (int) (money * 0.1 + plus_money);
		} else {
			return_money = 0;
		}
		return return_money;
	}
}

 
public class Test1 {
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

		Student std = new Student();

		String name = args[0]; // 이름
		String class_name = args[1]; // 과정명
		int money = Integer.parseInt(args[2]); // 교육비

		std.calc(class_name, money);

		System.out.println("이름: " + name + "\n과정명: " + class_name + "\n교육비: " + money + "\n교육기관: " + std.academy
				+ "\n부가금: " + std.plus_money + "\n환급비: " + std.return_money);
			
	}
}









































