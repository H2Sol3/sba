//package test;
//
//import java.util.Scanner;
//
//class Calculator {
//	int data1;
//	int data2;
//	String operator;
//
//	// 생성자
//	public Calculator(int data1, int data2, String op) {
//		this.data1 = data1;
//		this.data2 = data2;
//		this.operator = op;
//	}
//
//	int calc() {
//		int sum = 0;
//
//		if (operator.equals("1")) {
//			sum = data1 + data2;
//		} else if (operator.equals("2")) {
//			sum = data1 - data2;
//		} else if (operator.equals("3")) {
//			sum = data1 * data2;
//		} else if (operator.equals("4")) {
//			sum = data1 / data2;
//		}
//		return sum;
//	}
//}
//
//public class CalculatorTest {
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		while (true) {
//			System.out.println("=======================================");
//			System.out.println("계산기를 시작합니다.\n종료하려면 q를 입력하세요.\n메뉴\n1.덧셈\n2.뺄셈\n3.곱셈\n4.나눗셈\n5.프로그램 종료");
//			System.out.println("선택번호 입력: ");
//			String op = scan.next();
//			if (op.equals("5") || op.equals("q")) // 종료
//				break;
//			System.out.println("데이터1 입력: ");
//			int data1 = scan.nextInt();
//			System.out.println("데이터2 입력: ");
//			int data2 = scan.nextInt();
//
//			Calculator cal = new Calculator(data1, data2, op);
//			System.out.println("결과: " + cal.calc());
//		}
//
//	}
//
//}
