package chap13;

class MyThread1 extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("a");
		}
	}
}

class MyThread2 implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("b");
		}
	}
}

public class ThreadTest1 {
	public static void main(String[] args) {
		MyThread1 mt = new MyThread1();
		MyThread2 mt2 = new MyThread2();
		Thread t2 = new Thread(mt2);
		t2.start();
		mt.start();
		System.out.println("main종료");
	}
}
