package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {

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

			
			// 여기부터 Update====================================================================================================
			Scanner key = new Scanner(System.in);
			System.out.println("수정 사번: ");
			int employee_id = key.nextInt();
			System.out.println("수정 이름: ");
			String name = key.next();
			System.out.println("인상할 급여: ");
			double salary = key.nextDouble();
			
			
			String first_name = name.substring(1);
			String last_name = name.substring(0, 1);
			
			
			String sql = "UPDATE emp_copy SET first_name = ?, last_name= ?, salary= ? WHERE employee_id=?";
			
			PreparedStatement pt = con.prepareStatement(sql); // sql저장-전송 객체
			pt.setString(1, first_name);
			pt.setString(2, last_name);
			pt.setDouble(3, salary);
			pt.setInt(4, employee_id);
			int rowcount = pt.executeUpdate();
			
			
			System.out.println("삽입행의 갯수=" + rowcount);
			// 여기까지============================================================================================================

			System.out.println("연결 해제 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}

	}

}
