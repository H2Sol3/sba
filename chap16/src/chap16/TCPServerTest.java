package chap16;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest {

	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(10000);
		System.out.println("서버는 10000포트에서 대기중입니당");
		while(true) {
			Socket s = ss.accept();
			String clientip=s.getInetAddress().getHostAddress();
			System.out.println("[서버는"+clientip+"클라이언트 접속 허용합니당.]");
			
			//클라이언트 요청받는다 = 입력스트림
			InputStream is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String request = br.readLine();
			System.out.println("[서버는 클라이언트부터 "+" 요청을 전달 받았습니다.]");
			
			
			s.close();
			System.out.println("[서버는 클라이언트 접속 해제합니당.]");			
		}
	}

}
