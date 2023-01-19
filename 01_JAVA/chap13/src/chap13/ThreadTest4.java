package chap13;

import javax.swing.JOptionPane;

class NumThread extends Thread{
	public NumThread(String name) {//Thread(String)생성자 호출 - 이름
		super(name);
	}
	
	public void run() {
		for (int i = 1; i <= 10; i++) {
			//1초마다 1~10 숫자를 출력			
			System.out.println(getName()+": "+i);
//			try {
//				Thread.sleep(1000);				
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
		}
	}
}


public class ThreadTest4 {

	public static void main(String[] args) {
		
		NumThread nt1 = new NumThread("nt1");
		NumThread nt2 = new NumThread("nt2");
		nt1.start();
		nt2.start();
	}
}
