package chap10;

import java.util.Calendar;
import java.util.Date; // java.sql.Date는 데이터베이스 날짜정보가져오는 것.

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
//		date.getYear(); // 취소선 => deprecated메소드. 소스구현현상문제, 다른 메소드 충돌 등 이유로 사용 자제 권고
//		System.out.println(date.getYear());
		// 대체 메소드 알려줌

		
	}

}
