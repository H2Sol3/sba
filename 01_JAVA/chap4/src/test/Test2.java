package test;

public class Test2 {

	public static void main(String[] args) {
		int time = 10000;//10000초
		
		int hour = time/3600;
		int min = (time%3600)/60;
		int sec = time%60; 
		
		System.out.println(time+"초는 "+hour+"시간 "+min+"분 "+sec+"초 입니다");
		
		
		//10000초는 xx시 xx분 xx초입니다.
		
	}

}
