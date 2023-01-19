package chap16;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPClient {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

//		while(true) {
//			System.out.print("상품추가\n상품명: ");
//			String product = scan.next();
//			System.out.print("가격: ");
//			int price=scan.nextInt();
//			System.out.print("재고량: ");
//			int inventory=scan.nextInt();
//			
//			
//			Socket s = new Socket("127.0.0.1", 10000);
//			System.out.println("==상품 내용 서버로 전송==");
//			
//			OutputStream os = s.getOutputStream();
//			String request = product+" "+price+"원 "+inventory+"개";
//			byte[] by = request.getBytes();
//			os.write(by);
//			
//			s.close();
//			System.out.println("==클라이언트가 서버의 접속 해제했습니다.==");			
//		}

		// 강사님 코드
		System.out.println("상품 정보를 입력하세요");
		Scanner key = new Scanner(System.in);
		System.out.print("상품명 : ");
		String name = key.next();// 공백 엔터 구분자 (제외)
		System.out.print("가격 : ");
		String price = key.next();
		System.out.print("수량 : ");
		String balance = key.next();

		Socket s = new Socket("127.0.0.1", 10000);
		String serverip = s.getInetAddress().getHostAddress();

		System.out.println("==클라이언트가 " + serverip + " 서버로 접속했습니다. ==");
		OutputStream os = s.getOutputStream();
		// String request = name + "-" price + "-" + balance ;
		// byte [] by = request.getBytes();
		// os.write(by);

		name = name + " ";
		price = price + " ";
		balance = balance + " ";
		os.write(name.getBytes());
		os.write(price.getBytes());
		os.write(balance.getBytes()); // name price balance
		////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////
		// 서버로부터 응답 = 입력스트림
		InputStream is = s.getInputStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// String request = br.readLine();

		Scanner sc = new Scanner(is);
		String response = sc.nextLine();
		System.out.println("[클라이언트가 서버로부터 " + response + " 응답을 전달받았습니다.]");
		/////////////////////////////////////////////////////////////////////////

		s.close();
		System.out.println("==클라이언트가 서버의 접속 해제했습니다. ==");

	}

}
