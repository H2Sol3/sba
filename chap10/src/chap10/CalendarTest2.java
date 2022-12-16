package chap10;

import java.util.Calendar;

public class CalendarTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Calendar - 추상클래스
		// 구현 자식클래스들 제공 - "한국"
//				Calendar cal = new Calendar(); 오류

		// 캘린더 객체 생성 리턴 메소드
//		Calendar cal = Calendar.getInstance();// 현재시각
//		
//		
//		
////		cal.set(2023, 0, 11); //2023/1/11
//		cal.set(Calendar.YEAR, 2024); //년도 변경
//		cal.add(Calendar.MONTH, 1 ); //1로 변경이 아니라 1을 더하라는 의미. 그래서 25년 1월 나온 것.
//		System.out.println(cal);
//		int year = cal.get(Calendar.YEAR);
//		System.out.println(year);
//
//		// 년도 월 일 시 분 초
//		System.out.println(year);
//		int month=cal.get(Calendar.MONTH) + 1;
//		int day=cal.get(Calendar.DAY_OF_MONTH);
//		int hour=cal.get(Calendar.HOUR_OF_DAY);
//		int min=cal.get(Calendar.MINUTE);
//		int second=cal.get(Calendar.SECOND);
//		int date = cal.get(Calendar.DAY_OF_WEEK);
//		final String weekdays[]= {"","일","월","화","수","목","금","토"};
//		//0 -? 1-일 2-월 3-화 4-수 5-목 6-금 7-토
//
//		System.out.printf("현재 년도=%d 월=%d 일=%d 시간=%d 분=%d 초=%d %s요일",year,month,day,hour,min,second,weekdays[date]);

		
		
		
		Calendar now = Calendar.getInstance();// 현재시각
		Calendar end = Calendar.getInstance();// 
		end.set(2023, 2,3);
		
		long nowmil=now.getTimeInMillis();
		long endmil=end.getTimeInMillis();
		System.out.println(Math.abs(nowmil-endmil)+"(1/1000)초 단위");
		System.out.println((Math.abs(nowmil-endmil))/1000+"초 단위");
		//일단위
//		초 - ? /1000	
//		1분 - 60초, 1시간 - 60분
//		1시간 - 60 * 60초
//		1일 - 24시간 - 24 * 60*60초
		System.out.println(Math.abs(nowmil-endmil)/1000/(60*60*24)+"일 단위");
		
		//경매사이트
		//2개월 1일 23시간 11분 남았습니다.
		
		
	}

}
































