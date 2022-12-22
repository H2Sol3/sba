package chap16;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpTest {

	public static void main(String[] args) {
		// 다른 컴퓨터 정보 알아보기
		// windows ipconfig
		try {
			InetAddress[] iparr = InetAddress.getAllByName("");
			for (InetAddress ip : iparr) {
				System.out.println(ip.getHostAddress()); // getHostAddress() : ip주소만
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		// 내 컴퓨터 정보 알아보기
		try {
			InetAddress iparr = InetAddress.getLocalHost();
			System.out.println(iparr.getHostAddress()); // getHostAddress() : ip주소만
			System.out.println(iparr.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
