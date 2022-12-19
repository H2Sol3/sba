package chap12;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		//map은 식별자-데이터값으로 구성
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		map.put("hong@email.com", 
				new String[] { "홍길동", "010-2222-2222", "031-1111-2222", "02-2222-2222" });
		map.put("lee@email.com", 
				new String[] { "이자바", "2000-12-12" });
		map.put("lee@sba.net", 
				new String[] { "김새싹", "용산캠퍼스" });
		map.put("hong@email.com", 
				new String[] { "홍길동", "010-2222-2222", "031-1111-2222", "02-2222-2222" }); // key중복=>수정 효과 홍길동->홍자바																																																						
		System.out.println(map.size());

		Object o = map.get("hong@email.com");
		System.out.println(o);

		// 조회
		// key조회
		Set<String> keys = map.keySet();
		for (String onekey : keys) {
			String[] value = map.get(onekey); // 명시적형변환
			System.out.println("키: " + onekey);
			for (String one : value) {
				System.out.println(one + ":");
			} // key값은 set에서 값은 map에서 가져옴
			System.out.println();
		}

	}

}
