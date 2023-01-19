package chap13;

class TimeThread extends Thread{
	public void run() {
		
	}
}

public class ThreadTest2 {
	public static void main(String[] args) {
		//현재 시각 1/1000초
		long startTime = System.currentTimeMillis();
		//작업 소요 시간
		for(int i=1;i<=300;i++) {
			System.out.print("-");
		}
		System.out.println("소요시간1(1/1000)="+(System.currentTimeMillis()-startTime));
		
		
		for(int i=1;i<=300;i++) {
			System.out.print("|");
		}
		System.out.println("소요시간2(1/1000)="+(System.currentTimeMillis()-startTime));
	}

}
