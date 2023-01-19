package test;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExpTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expressions[] = { "(5-(2+3)*2)/4", "(2+3)*1)+3", "((2+3)*1)+3", "(5-(2+3)*2)/4)" };
//
//		for (int i = 0; i < expressions.length; i++) {
//			int cnt1 = 0;
//			int cnt2 = 0;
//			for (int j = 0; j < expressions[i].length(); j++) {
//				if (expressions[i].charAt(j) == '(') {
//					cnt1++;
//				}
//				if (expressions[i].charAt(j) == ')') {
//					cnt2++;
//				}
//			}
//
//			if (cnt1 == cnt2)
//				System.out.println("괄호 일치 수식: " + expressions[i]);
//		}

//============망한 코드
//스택		

		Stack<Integer> stack = new Stack();
		for (int i = 0; i < expressions.length; i++) {
			for (int j = 0; j < expressions[i].length(); j++) {
				if (expressions[i].charAt(j) == '(') {
					stack.push(7);
					System.out.println("push"+stack);
				}
				if (expressions[i].charAt(j) == ')') {
					try {
						stack.pop();
						System.out.println("pop"+stack);
					} catch (EmptyStackException e) {
						stack.push(4);
					}

				}
			}
			if (stack.isEmpty()) {
				System.out.println("괄호 일치 수식:"+expressions[i]);
			}else System.out.println("괄호 불일치 수식:"+expressions[i]);
			stack.clear();
		}

	}
}
