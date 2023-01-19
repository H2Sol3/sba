package chap16;

import java.io.OutputStream;
import java.net.Socket;

public class TCPClientTest {

	public static void main(String[] args) throws Exception{
		Socket s = new Socket("127.0.0.1", 10000);
		String serverip=s.getInetAddress().getHostAddress();
		System.out.println("==클라이언트가 서버로 접속했습니다.==");
		//클라이언트가 먼저 1번 게시물주세요 요청 = 출력스트림
		OutputStream os = s.getOutputStream();
		String request = "1번게시물\n";
		byte[] by = request.getBytes();
		os.write(by);
		
		
		
		s.close();
		System.out.println("==클라이언트가 서버의 접속 해제했습니다.==");
	}

}
