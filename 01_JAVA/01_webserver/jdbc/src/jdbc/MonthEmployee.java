package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class MonthEmployee {
	
	ArrayList getEmployees() {
 
		Connection con = null; // finally에서 사용해야할때 이자리에서 선언하기 약속~!~!~
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> al = new ArrayList<String>();
		try {
			// 0. jdbc driver 호출
			Class.forName(ConnectionInform.DRIVER_CLASS); 
			// 1. db연결
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, 
					ConnectionInform.PASSWORD); // final변수에 경로 저장해놓고 경로를 JDBC_URL로 변경해주기
			// mariadb저장소/id/pw
			System.out.println("연결 성공");

			
			Scanner scan = new Scanner(System.in);
			System.out.print("제외할 월 입력:");
			int month = scan.nextInt();
			
			String sql = "SELECT month(hire_date),sum(salary) FROM emp_copy "
					+ "WHERE MONTH(hire_date) != ? "
					+ "GROUP BY month(hire_date)"; 
			
			PreparedStatement pt = con.prepareStatement(sql); 
			pt.setInt(1, month);
			
			rs = pt.executeQuery();
			while(rs.next()) {
				int mon = rs.getInt("month(hire_date)");
				int salary = rs.getInt("sum(salary)");
				al.add(mon+"월: "+salary);
	//			System.out.printf("%d    %d  \n",  mon, salary); 
			}
			System.out.println("연결 해제 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}
		
		return al;
	}
	
	public static void main(String[] args) {
		ArrayList<String> arr = new MonthEmployee().getEmployees();
		for(String a : arr) {
			System.out.println(a);
		}
		
		/* preparestatement 사용
		 * 키보드로 입력.
		 * 월별 입사자들의 총 급여 조회
		 * 
		 * 01-12 사이의 값 입력 시 월별 입사자 총 급여 조회
		 * 제외할 월: 3
		 * 01 : xxx
		 * 02 : xxx
		 * 04 : xxx
		 * 05 : xxx
		 * ....  
		 * */
		
		
		
		
		
		
	}

}
