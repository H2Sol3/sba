package test;

import java.util.ArrayList;
import java.util.Scanner;

class Calculator {
	int data1, data2;
	String op;

	public Calculator(int data1, int data2, String op) {
		this.data1 = data1;
		this.data2 = data2;
		this.op = op;
	}

	@Override
	public String toString() {
		int result = 0;
		if (op.equals("+")) {
			result = data1 + data2;
		} else if (op.equals("-")) {
			result = data1 - data2;
		} else if (op.equals("*")) {
			result = data1 * data2;
		} else if (op.equals("/")) {
			result = data1 / data2;
		}
		return data1 + op + data2 + "=" + result;
	}

}

public class CalculatorTest_review {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("덧셈");
		menu.add("뺄셈");
		menu.add("곱셈");
		menu.add("나눗셈");
		menu.add("프로그램 종료");

		while (true) {
			System.out.println("계산기를 시작합니다.\n종료하려면 q를 입력하세요.\n메뉴");

			for (int i = 0; i < menu.size(); i++) {
				System.out.println((i + 1) + ". " + menu.get(i));
			}
			System.out.println("선택번호입력: ");
			String num = scan.next();
			if (num.equals("5") || num.equals("q") || num.equals("quit") || num.equals("exit")) {
				// return; //main메서드 종료 = 클래스 종료
				// System.exit(0); // 프로그램 종료
				break;
			} else {
				System.out.println(menu.get(Integer.parseInt(num) - 1) + "할 데이터1 입력: ");
				int first = scan.nextInt();
				System.out.println(menu.get(Integer.parseInt(num) - 1) + "할 데이터2 입력: ");
				int second = scan.nextInt();
				String operator = null;
				if (num.equals("1")) {
					operator = "+";
				} else if (num.equals("2")) {
					operator = "-";
				} else if (num.equals("3")) {
					operator = "*";
				} else if (num.equals("4")) {
					operator = "/";
				}
				Calculator calc=new Calculator(first, second, operator);
				System.out.println(calc.toString());
			}

		}

	}// main

}
