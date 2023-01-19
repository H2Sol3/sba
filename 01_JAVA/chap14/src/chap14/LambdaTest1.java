package chap14;

//1. Runnable 구현 클래스 생성
class MyThread implements Runnable {

	// 변수 생성자 메서드 추가
	// 반드시 해야하는 것! => 메서드 오버라이딩!!!!!!!
	@Override
	public void run() {
		System.out.println("Runnable 구현자식클래스 실행");

	}

}

public class LambdaTest1 {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();

		// 2.
		class MyInnerThread implements Runnable {
			@Override
			public void run() {
				System.out.println("Runnable 구현내부클래스 실행");

			}
		}// MyInnerThread

		Thread t2 = new Thread(new MyInnerThread());
		t2.start();

		// 3. 무명 클래스 정의 동시에 객체 생성
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable 구현익명클래스 실행");

			}
		}).start();

		// 람다식 - 함수형인터페이스(=추상메서드 1개만 포함)/ 구현인터페이스이름,객체생성,오버라이딩메서드 이름 생략
		Runnable r4 =()->{ System.out.println("람다식 실행");}; //Runnable의 run메서드 오버라이딩했다는 의미(????????????)
		Thread t4 = new Thread(r4);
		t4.start();

	}
}
