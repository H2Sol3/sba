package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest3 {

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
			st = con.createStatement(); // sql저장-전송 객체
			// jdbc sql - create table(ddl 가능 - 권고X)
//			String sql = "create table maxtest(a int)";
//			int rowcount = st.executeUpdate(sql);
//			System.out.println(rowcount);
			
			
			String sql = "select max(a) from maxtest";
			st.executeQuery(sql);
			if(rs.getString("max(a)") != null) {
			System.out.println("최대값="+rs.getString("max(a)"));	
			}
			System.out.println(rs.getString("a"));
			
			System.out.println("연결 해제 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}

	}

}
