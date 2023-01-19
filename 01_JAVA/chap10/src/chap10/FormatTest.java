package chap10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatTest {
	public static void main(String[] args) {
		double d = 3.14 * 10;
		d = 1234.5678;
		d = -12.5678;
		d = 1234567.89;
		System.out.println(d);

		// # - 1자리 10진수. 0표시 X
		// 0 - 1자리 10진수. 0표시 O
		// DecimalFormat df = new DecimalFormat("##.#");
		// DecimalFormat df = new DecimalFormat("##.00");//뒷자리가 0이면 안보이니까 0이어도 보이게 00으로
		// DecimalFormat df = new DecimalFormat("000.00");
		// DecimalFormat df = new DecimalFormat("0##.#");
		// DecimalFormat df = new DecimalFormat("##.00+;000.00-");
		DecimalFormat df = new DecimalFormat("#,###,###.00");
		String dstr = df.format(d);
		System.out.println(dstr);

		// y-연도 M-월 d-일 D(연도) H-24시간 m-분 s-초 E-요일
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd / DDD(1년 중 몇번째일) / HH:mm:ss E");
//		Calendar date = Calendar.getInstance();
//		String dateStr = sdf.format(date.getTime());
//		System.out.println(dateStr);

		
		
		
		// 명령행ㅁ 매갭ㄴ수 날짜데이터입력 받기 2023 1 2 3 4 5
		// 2023년 1우럴 2일 3시 4분 5초 생성
		// 1년 중 몆주째인지/해당월의 몇주째인지/ 요일출력
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 M월 d일 H시 m분 s초 E요일");
		Calendar date = Calendar.getInstance();
		date.set(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]),
				Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]));
		String dateStr = sdf1.format(date.getTime());
		System.out.println(dateStr);

		// review
		if (args.length < 6) {
			return;
		}

		int[] arr = new int[args.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		Calendar date2 = Calendar.getInstance();
		date2.set(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년의 w번째 주이고 MM월의 W번째 주입니다. d일 H시 m분 s초 E요일");
		System.out.println(sdf2.format(date2.getTime()));
	}

}























