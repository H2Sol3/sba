package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 0. jdbc driver 호출 : jdk 미포함되어서 호출한다.
			Class.forName(ConnectionInform.DRIVER_CLASS);
			// 1. db 연결
			con = DriverManager.getConnection
			(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			System.out.println("연결 성공");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("이름: ");
			String name = sc.next();
			
			// employees 테이블에서 사원명을 입력한다.
			// 사원명, 부서명, 도시명을 입력한다.
			// 만약 부서명 혹은 도시명이 null인 경우 부서명:부서이동중, 도시명:이사중으로 출력한다.
			st = con.createStatement();// SQL 저장 - 전송객체;
			String sql = "SELECT e.first_name, IFNULL(d.department_name, '부서이동중') 부서명, ifnull(l.city, '이사중') 도시명 "
					+ "FROM employees e "
					+ "left outer JOIN departments d ON e.department_id = d.department_id "
					+ "left outer JOIN locations l ON d.location_id = l.location_id "
					+ "WHERE e.first_name = '"+ name +"'";
			rs = st.executeQuery(sql);		
			int line = 0;
			while (rs.next()) {
				line++;
				String first_name = rs.getString("e.first_name");
				String department_name = rs.getString("부서명");
				String city = rs.getString("도시명");
				System.out.printf("%d 이름 :%s, 부서명: %s, 도시: %s \n",
						line, first_name, department_name, city);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("해당 드라이버가 발견되지 않았습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
				con.close();		// throws SQLException
				System.out.println("연결 해제 성공");
			} catch(SQLException e) {
				
			}
		}
	}

}
