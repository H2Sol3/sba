package chap8;

public class ClassInformationTest {
	public static void main(String[] args) {

		try {
			Class.forName(args[0]);
		} catch (Exception e) {

		}

	}

}

class Solution {
	public long solution(int a, int b) {
		long answer = 0;
		if (a == b) {
			answer = a;
		} else if (a > b) {
			for (int i = b; i <= a; i++) {
				answer += i;
			}
		} else {
			for (int i = a; i <= b; i++) {
				answer += i;
			}
		}
		return answer;
	}
}