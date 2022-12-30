package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null; // finally에서 사용해야할때 이자리에서 선언하기 약속~!~!~
		try {
			// 0. jdbc driver 호출
			Class.forName(ConnectionInform.DRIVER_CLASS);
			// 1. db연결
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD); // final변수에 경로 저장해놓고 경로를 JDBC_URL로 변경해주기
			// mariadb저장소/id/pw
			System.out.println("연결 성공");

			// 여기부터 insert====================================================================================================
			Statement st = con.createStatement(); // sql저장-전송 객체
			// 100 길동 홍 1000 now()
			// String sql = "insert into emp_copy values(400,'길동','홍',1000,now(),50)";

			Scanner key = new Scanner(System.in);
			System.out.println("상품명: ");
			String p_name = key.nextLine();
			System.out.println("가격: ");
			int price = key.nextInt();
			System.out.println("수량: ");
			int balance = key.nextInt();

			String sql = "insert into product(p_name, price, balance) values(?,?,?)";
			PreparedStatement pt = con.prepareStatement(sql); // sql저장 - 전송 - 컴파일 - 저장
			pt.setString(1, p_name);
			pt.setInt(2, price);
			pt.setInt(3, balance);
			int rowcount = pt.executeUpdate();
			System.out.println("삽입행의 갯수=" + rowcount);
			// 여기까지============================================================================================================

	//		con.close();
			System.out.println("연결 해제 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");
		} catch (SQLException e) {
			System.out.println("연결정보를 확인하세요.");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}

	}

}
