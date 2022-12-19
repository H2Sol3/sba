package chap11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		// 만약 22명 성적 저장이 필요할땐 ArrayList사용(동점때문에)
		// 100사이 소수 저장, 로또번호 생성(6개 중복값x) => HashSet사용

		HashSet set = new HashSet(5); // 뒤에 숫자는 의미 없음. 항상 변동 가능함. 일단 시작은 이 정도로 할게~ 라는 의미임
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(5);// 중복 저장 불가하니 무시해버림.그래서 저장 안됨
		System.out.println(set.size());

		System.out.println("=============================");
		HashSet lottoSet = new HashSet(6);

		while (true) {// 중복때문에 얼마나 반복할지 모르니 무한반복 해주기
			int ran = (int) (Math.random() * 45) + 1;
			System.out.println(ran);
			// lottoset에 ran변수 저장
			// lottoSet 크기 6개면반복문 끝

			lottoSet.add(ran);

			if (lottoSet.size() == 6)
				break;

		}

		System.out.println("=============반복1================");

		// LOTTOSET 데이터조회
		// 순서없다
		// Iterator는 데이터 반복적으로 조회 기능만 있는 컬렉션 종류
		// 방법 1.
		Iterator it = lottoSet.iterator(); // 조회만 가능
		while (it.hasNext()) {// 다음 데이터가 있니?
			System.out.print(it.next() + " "); // 저장한 순서와 조회순서는 동일하지않음.
		}

		// 방법 2. 이게 좀 더 간편
		System.out.println("\n=============반복2================");
		for (Object oneLotto : lottoSet) {// 데이터타입 변수명 : 배열
			System.out.print(oneLotto+" ");
		}

//		String[] s=new String[] {"a","b","c"};
//		for(int i=0;i<s.length;i++) {
//			System.out.println(s[i]);
//		}
//		개선된 for문 예제		
//		for(String one : s) {
//			System.out.println(one);
//		}

	}

}
