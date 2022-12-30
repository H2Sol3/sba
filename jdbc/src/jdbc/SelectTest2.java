package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {

	public static void main(String[] args) {
		Connection con = null; // finally에서 사용해야할때 이자리에서 선언하기 약속~!~!~
		Statement st = null;
		ResultSet rs = null;
		try {
			// 0. jdbc driver 호출
			Class.forName(ConnectionInform.DRIVER_CLASS);
			// 1. db연결
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD); // final변수에 경로 저장해놓고 경로를 JDBC_URL로 변경해주기
			// mariadb저장소/id/pw
			System.out.println("연결 성공");

			// 여기부터 Update====================================================================================================
			String sql = "select user_id, address from users where address like '%용산구%'";
			PreparedStatement pt = con.prepareStatement(sql); // sql저장-전송 객체
			pt.setString(1, "%"+"용산구"+"%");
			
			rs = pt.executeQuery();
			int line =0;
			while(rs.next()) {
				++line;
				String id = rs.getString("user_id");
				String address = rs.getString("address"); 
				System.out.printf("%d 아이디: %s 주소: %s \n", line, id, address);
			}
			System.out.println("연결 해제 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			//	pt.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}

	}

}
