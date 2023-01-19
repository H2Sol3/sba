package chap16;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPServer {

	public static void main(String[] args) throws Exception {
//		ServerSocket ss = new ServerSocket(10000);
//
//		while(true) {
//			Socket s = ss.accept();
//			//클라이언트 요청받는다 = 입력스트림
//			InputStream is = s.getInputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			String request = br.readLine();
//			
//			FileOutputStream fos = new FileOutputStream("product.txt", true);
//			PrintWriter pw = new PrintWriter(fos);
//			
//			pw.println(request);
//			System.out.println(request+" 추가 완료되었습니다~!~!");
//			
//			s.close();
//			pw.close();
//			fos.close();
//			
//		}
//		
		// 강사님 코드

		ServerSocket ss = new ServerSocket(10000);
		System.out.println("[서버는 10000 포트에서 대기중입니다]");
		int cnt = 0;
		while (true) {
			Socket s = ss.accept();// 실행x/10/...
			String clientip = s.getInetAddress().getHostAddress();
			System.out.println("[서버는 " + clientip + " 클라이언트 접속 허용합니다. ]");
			cnt++;
			if (cnt == 4) {
				break;
			}
			FileWriter fw = new FileWriter("product.txt", true);

			// 클라이언트 3개 " " = 입력스트림
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String name = sc.next();
			String price = sc.next();
			String balance = sc.next();
			fw.write(name + " - " + price + " - " + balance + "\n");
			fw.close();

//클라이언트 요청-처리 응답 = 출력스트림
			String response = "추가 완료되었습니다";
			OutputStream os = s.getOutputStream();
			byte[] by = response.getBytes();
			os.write(by);
			System.out.println("[서버는 클라이언트로 " + "응답을 전달합니다.]");
/////////////////////////////////////////////////////////////////////////			

			// fw.close();
			is.close();
			os.close();
			s.close();
			System.out.println("[서버는 클라이언트 접속 해제합니다. ]");
		}

	}

}
