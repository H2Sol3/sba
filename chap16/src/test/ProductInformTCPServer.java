package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductInformTCPServer {
	// product.txt 입력 ArrayList리턴
	static ArrayList getProductList(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		Scanner sc = new Scanner(fr);
		ArrayList<String> list = new ArrayList<String>(3);
		while (sc.hasNextLine()) {
			list.add(sc.nextLine());
		}
		fr.close();
		// System.out.println(list.size());//3
		return list;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<String> list = getProductList("product.txt");

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
			// 클라이언트 1개 " " = 입력스트림
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String name = sc.next();
			// System.out.println(name);
			String response = null;
			for (String product : list) {
				String pName = product.split(" -")[0];
				if (pName.equals(name)) {
					System.out.println(111);
					response = product;
				}
			}

			if (response == null) {
				response = "못찾았습니다.";
			}
			//
			// 클라이언트 요청-처리 응답 = 출력스트림
			OutputStream os = s.getOutputStream();
			byte[] by = response.getBytes();
			os.write(by);
			System.out.println("[서버는 클라이언트로 " + "응답을 전달합니다.]");
			/////////////////////////////////////////////////////////////////////////

			is.close();
			os.close();
			s.close();
			System.out.println("[서버는 클라이언트 접속 해제합니다. ]");
		}
	}

}
