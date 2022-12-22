package chap16;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPReceiver {
	public static void main(String[] args) throws Exception {

		DatagramSocket ds = new DatagramSocket(15000);
		System.out.println("[수신자 : 수신 시작]");
		/*
		 * String data = "오늘 오후 5시반에 종료합니다."; byte by[] = data.getBytes();
		 * DatagramPacket dp = new DatagramPacket (by, by.length, // 1: byte배열 1만큼 보내면 돼, by.length: byte배열 몽땅 보내면 돼.
		 * new InetSocketAddress("127.0.0.1", 15000)); ds.send(dp);//전송해야 할 상대방의 ip와 port번호
		 * System.out.println("[발신자 : 발신 처리]");
		 */

		byte b[] = new byte[1000];// 수신받은 내용 저장 배열
		// 한글 영문 숫자 --> 1 문자 2바이트
		// getBytes() --> 영문 숫자 특수문자 - 1바이트, 한글 - 3바이트
		DatagramPacket dp = new DatagramPacket(b, b.length);
		ds.receive(dp);
		String s = new String(b);

		System.out.println(dp.getAddress() + " 주소의 " + dp.getPort() + " 포트에서 " + s.trim() + " 받았습니다.");
		System.out.println("[수신자 : 수신 종료]");

		// 응답 send
		String time = new SimpleDateFormat("HH시 mm분 ss초").format(new Date());
		DatagramPacket timedp = new DatagramPacket(time.getBytes(), time.getBytes().length, dp.getAddress(),
				dp.getPort());
		ds.send(timedp);

		ds.close();
	}
}
//DatagramPacket dp = new DatagramPacket(by, by.length, // 
//		new InetSocketAddress("127.0.0.1", 15000)); 