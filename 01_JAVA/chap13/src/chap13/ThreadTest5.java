package chap13;

class JoinThread extends Thread {
	int i = 1;

	public void run() {
		int i = 10;
		System.out.println("run메서드 내부= " + i);
	}
}

public class ThreadTest5 {

	public static void main(String[] args) {
		JoinThread t = new JoinThread();
		t.start();
		try {
			t.join();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(t.i);
		System.out.println("main 종료");
	}
}
