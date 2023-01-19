package chap4;

public class ScoreTest {

	public static void main(String[] args) {

//		String name = "홍길동";
//		int kor = 100, eng = 87, math = 75;
//		int sum = 0;
//		double avg = 0;// 실수평균
//		int avgInt = 0;// 정수평균
//		String grade;
//		/*
//		 * 조건 avgint 90이상 100이하 a등급
//		 */
//
//		sum = kor + eng + math;
//		avg = (double) sum / 3;
//		avgInt = (int) avg;
//
//		if (avgInt >= 90) {
//			grade = "A";
//
//		} else if (avgInt >= 80) {
//			grade = "B";
//		} else if (avgInt >= 70) {
//			grade = "C";
//		} else if (avgInt >= 60) {
//			grade = "D";
//		} else {
//			grade = "낙제";
//		}
//
//		System.out.println("1. if문");
//		System.out.printf("%s학생은 국어=%2d점, 영어=%2d점, 수학=%2d점입니다.\n총점은 %d고 평균(실수평균)은 %.2f입니다.\n등급은 %s등급입니다.\n", name, kor,
//				eng, math, sum, avg, grade);
//		
//		System.out.println();

		
//
//		String name = "홍길동";
//		int kor = 100, eng = 87, math = 75;
//		int sum = 0;
//		double avg = 0;// 실수평균
//		int avgInt = 0;// 정수평균
//		String grade;
//		/*
//		 * 조건 avgint 90이상 100이하 a등급
//		 */
//
//		sum = kor + eng + math;
//		avg = (double) sum / 3;
//		avgInt = (int) avg;
//		
//		System.out.println("2. switch문");
//		int avgInt2 = avgInt / 10;
//		switch (avgInt2) {
//		case 10:
//			grade = "A";
//			break;
//		case 9:
//			grade = "A";
//			break;
//		case 8:
//			grade = "B";
//			break;
//		case 7:
//			grade = "C";
//			break;
//		case 6:
//			grade = "D";
//			break;
//		default:
//			grade = "낙제";
//
//		}
//		
//		System.out.printf("%s학생은 국어=%2d점, 영어=%2d점, 수학=%2d점입니다.\n총점은 %d고 평균(실수평균)은 %.2f입니다.\n등급은 %s등급입니다.\n", name, kor,
//				eng, math, sum, avg, grade);
		
		
		String name = "홍길동";
		// 1~100사이 난수 생성
	//	double d= Math.random();//0.0<= ? < 1.0 난수 생성
	//	double d= Math.random()*100; //0.0<= ? < 100.0 난수 생성 => 99까지만 나옴
	//	(int)(Math.random()*100)+1; //1 <= ? <=100
		
		int kor = (int)(Math.random()*100)+1;
		int eng =(int)(Math.random()*100)+1;
		int math =(int)(Math.random()*100)+1;
		
		int sum = 0;
		double avg = 0;// 실수평균
		int avgInt = 0;// 정수평균
		String grade;
		/*
		 * 조건 avgint 90이상 100이하 a등급
		 */

		sum = kor + eng + math;
		avg = (double) sum / 3;
		avgInt = (int) avg;

		if (avgInt >= 90) {
			grade = "A";

		} else if (avgInt >= 80) {
			grade = "B";
		} else if (avgInt >= 70) {
			grade = "C";
		} else if (avgInt >= 60) {
			grade = "D";
		} else {
			grade = "낙제";
		}

		System.out.println("1. if문");
		System.out.printf("%s학생은 국어=%2d점, 영어=%2d점, 수학=%2d점입니다.\n총점은 %d고 평균(실수평균)은 %.2f입니다.\n등급은 %s등급입니다.\n", name, kor,
				eng, math, sum, avg, grade);
		
		System.out.println();

	}

}
