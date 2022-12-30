package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

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
			Statement st = con.createStatement(); // sql저장-전송 객체

//			Scanner key = new Scanner(System.in);
//			System.out.println("수정 사번: ");
//			int employee_id = key.nextInt();
//			System.out.println("수정 이름: ");
//			String name = key.next();
//			System.out.println("인상할 급여: ");
//			double salary = key.nextDouble();
			
			
//			String first_name = "'"+name.substring(1)+"'";
	//		String last_name = "'"+name.substring(0, 1)+"'";
			
			

			String sql = "Select employee_id, first_name, last_name, salary, hire_date from employees";
			ResultSet rs = st.executeQuery(sql);
			System.out.println("삽입행의 갯수=" + rs);
			int line =0;
			while(rs.next()) {
				++line;
				int id = rs.getInt(1);
				String name = rs.getString(2)+"-"+rs.getString(3);
				double salary = rs.getDouble("salary");
				java.sql.Date d = rs.getDate("hire_date");
				String d2 = rs.getString("hire_date");
				System.out.printf("%d 사번: %d 이름: %s 급여: %.2f 입사일: %s \n",line, id, name,salary,d);
			}

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
