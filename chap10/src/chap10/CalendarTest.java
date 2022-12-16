package chap10;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Calendar - 추상클래스
				// 구현 자식클래스들 제공 - "한국"
//				Calendar cal = new Calendar(); 오류

				// 캘린더 객체 생성 리턴 메소드
				Calendar cal = Calendar.getInstance();
				System.out.println(cal);
				int year = cal.get(Calendar.YEAR);
				System.out.println(year);
				
				//년도 월 일 시 분 초
				System.out.println(year);
				System.out.println(cal.get(Calendar.MONTH )+ 1);
				System.out.println(cal.get(Calendar.DAY_OF_MONTH));
				System.out.println(cal.get(Calendar.HOUR_OF_DAY));
				System.out.println(cal.get(Calendar.MINUTE));
				System.out.println(cal.get(Calendar.SECOND));
	}

}
