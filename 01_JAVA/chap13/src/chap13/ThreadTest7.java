package chap13;

class Buffer{
	int value;
	synchronized int getValue() {
		System.out.println("조회 : " + value);
		return value;
	}synchronized void setValue(int value) {
		this.value=value;
		System.out.println("저장: " + value);
	}
}


class Producer extends Thread{
	
}
class Consumer extends Thread{
	
}
public class ThreadTest7 {
	public static void main(String[] args) {

		Buffer buf=new Buffer();
//		Producer p=new Producer(buf);
//		Consumer c=new Consumer(buf);
//		p.start();//저장
//		c.start();//조회
		
		
	}
}
