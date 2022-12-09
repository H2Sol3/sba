package chap5;

public class StudentTest {

	public static void main(String[] args) {
		if (args.length < 5) {
			System.out.println("최소 5명의 이름을 입력하셔야 합니다.");
			return;
		}
		String names[] = new String[5];
		for (int i = 0; i < names.length; i++) {
			names[i] = args[i] + " 응시자 ";
			System.out.println(names[i]);
		}

		int kor[] = new int[names.length];
		for (int i = 0; i < kor.length; i++) {
			kor[i] = (int) (Math.random() * 100) + 1;
			System.out.println(kor[i]);
		}

		int eng[] = { 96, 100, 66, 89, 49 };

		System.out.println();
		// 입력변수 이름이 홍길동 응시자의 국어, 영어점수, 합계 출력
		// 정수 평균은 국어 60%, 영어 40% 비율로 합계 계산
		int sum = 0;
		boolean condition = false;// 홍길동 찾으면 true로 변경할거임

		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동 응시자 ")) {// names[i].subString(0,3).equals("홍길동")
				sum = (int) ((kor[i] * 0.6) + (eng[i] * 0.4));
				System.out.println("홍길동은 " + i + "번째에 있고\n" + "국어 점수: " + kor[i] + "점\n" + "영어 점수: " + eng[i]
						+ "점.\n합계는 " + sum + "점");
				condition = true;
			}
		}
		if (condition == false) {
			System.out.println("그런 이름의 응시자는 없습니다.");
		}

		System.out.println("========2차배열 사용====");
		int[][] scores = new int[2][names.length]; // names길이의 2개 배열
		scores[0] = kor; // 선언은 2차 배열이지만 이렇게 나눠서 넣어줄때는 1차 배열임. 그대로 넣어주기
		scores[1] = eng;

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + ":" + scores[0][i] + ":" + scores[1][i]);
			if (names[i].equals("홍길동 응시자 ")) {// names[i].subString(0,3).equals("홍길동")
				sum = (int) ((kor[i] * 0.6) + (eng[i] * 0.4));
				System.out.println("홍길동은 " + i + "번째에 있고\n" + "국어 점수: " + kor[i] + "점\n" + "영어 점수: " + eng[i]
						+ "점.\n합계는 " + sum + "점");
				condition = true;
			}
		}
		if (condition == false) {
			System.out.println("그런 이름의 응시자는 없습니다.");
		}
	}

}
