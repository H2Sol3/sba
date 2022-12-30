package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest5 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st= null;
		ResultSet rs = null;
		try {
		Class.forName(ConnectionInform.DRIVER_CLASS);
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		System.out.println("연결 성공");
		System.out.println(con.getAutoCommit());
		
		st = con.createStatement();//sql저장-전송객체
		
		// 집계함수 null 처리법
		// 존재만 파악하고 싶다면 굳이 while 사용할 필요 없이 if문을 사용하면 된다.
//		String sql = "show databases";
//		String sql = "show tables";
		String sql = "desc employees";
		rs = st.executeQuery(sql);// rs 이전위치
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + " : " + rs.getString(2)+ " : " + rs.getString(3));
		}
		
		System.out.println("연결 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");//?????
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			//rs.close();	
			st.close();	
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}
	}

}
