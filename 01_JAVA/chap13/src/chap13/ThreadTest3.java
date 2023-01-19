package chap13;

import javax.swing.JOptionPane;

class NumberThread extends Thread{
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}


public class ThreadTest3 {

	public static void main(String[] args) {
		
		NumberThread nt1 = new NumberThread();
		nt1.start();
		String input = JOptionPane.showInputDialog("값 입력해 보세요");
		System.out.println("입력값=" + input);
		//1초마다 1~10 숫자를 출력
//		for (int i = 1; i <= 10; i++) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);				
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
//		}
	}

}
