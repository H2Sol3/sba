package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	
	public static void main(String[] args) {
		Connection con = null; // finally에서 사용해야할때 이자리에서 선언하기 약속~!~!~
		try {
			// 0. jdbc driver 호출
			Class.forName(ConnectionInform.DRIVER_CLASS);
			// 1. db연결
			con = DriverManager.getConnection
					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD); // final변수에 경로 저장해놓고 경로를 JDBC_URL로 변경해주기
			// mariadb저장소/id/pw
			System.out.println("연결 성공");

			con.close();
			System.out.println("연결 해제 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");
		} catch (SQLException e) {
			System.out.println("연결정보를 확인하세요.");
		}finally {
			try {
				con.close();				
			}catch(SQLException e) {
				//비워두기
			}
		}

	}

}
