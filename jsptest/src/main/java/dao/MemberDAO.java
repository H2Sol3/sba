package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	public int insertMember(MemberDTO dto) {

		// dto 전달 내용을 member 테이블에 입력
		// 회원가입일은 now()로 설정
		PreparedStatement pt = null;
		Connection con = null;
		int cnt = 0;
		MemberDTO selecteddto = getMember(dto.getId(), dto.getPw()); // 알아서 연결해주고 끝나면 해제해줌

		if (selecteddto != null) {
			System.out.println("아이디 중복입니다. 다른 아이디를 입력하세요.");
			return 0; // 메서드 중단하겠다는 의미
		} else {
			try {
				Class.forName(ConnectionInform.DRIVER_CLASS);
				con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
						ConnectionInform.PASSWORD);

				// 중복 아이디 거르기
				// MemberDTO dto = getMember(id,pw)
				// dto == null => 정상 insert
				// dto !- null => "아이디 중복입니다. 다른 아이디를 입력하세요."
				String sql = "insert into member values(?,?,?,?,?,?,now())";
				pt = con.prepareStatement(sql);

				pt.setString(1, dto.getId());
				pt.setString(2, dto.getPw());
				pt.setString(3, dto.getName());
				pt.setString(4, dto.getPhone());
				pt.setString(5, dto.getEmail());
				pt.setString(6, dto.getAddress());

				cnt = pt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pt.close();
					con.close();
				} catch (SQLException e) {
					// 비워두기
				}
			}

		}

		return cnt;
	} // insert

	int getTotalMember() { // 저장된 회원수 조회 메서드
		// dto 전달 내용을 member 테이블에 입력
		// 회원가입일은 now()로 설정
		PreparedStatement pt = null;
		Connection con = null;
		int cnt = 0;
		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD);

			String sql = "select count(*) from member";

			pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			rs.next();

			if (rs.getString("count(*)") == null) {
				cnt = 0;
			} else {
				cnt = rs.getInt("count(*)") / 3 + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}

		return cnt; 
	} // getTotalMember

	public ArrayList<MemberDTO> getMemberList(int currentpage, int memberPerPage) { // 클릭한 페이지에 저장된 회원 목록 조회
		ResultSet rs = null;
		PreparedStatement pt = null;
		Connection con = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); // 오른쪽에는 제네릭 있어도 되고 없어도 됨<MemberDTO>
		int cnt = 0;
		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD);

			// insert(pw,1,2,repeat('*',2)) : 1번 인덱스부터 2개까지 내용 비우기, * 2개 반복
			String sql = "select id, insert(pw,2,char_length(pw)-1,repeat('*',char_length(pw)-1)) as pw, "
					+ "name, indate from member order by indate limit ?, ?";

			pt = con.prepareStatement(sql);
			pt.setInt(1, (currentpage - 1) * memberPerPage);
			pt.setInt(2, memberPerPage);
			rs = pt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString("id"), rs.getString("name"), rs.getString("indate"));
				// dao에 생성자 생성
				dto.setPw(rs.getString("pw")); // 원래 문장은 너무 기니까 as 붙여줘서 가져오기&생성자에 pw추가하기 귀찮으니 set으로 넘기기
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}

		return list;
	} // getMemberList

	public MemberDTO getMember(String id, String pw) {
		ResultSet rs = null;
		PreparedStatement pt = null;
		Connection con = null;
		MemberDTO dto = null;

		int cnt = 0;
		try {
			Context initContext = new InitialContext(); //context.xml 읽을 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); //자바와 연관된 설정을 찾아라
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			con = ds.getConnection(); //pool con빌려온다.

			String sql = "select * from member where id=?";

			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			// 강사님 코드
			if (rs.next()) { //id 존재한다면
				String dbpw = rs.getString("pw");
				if (pw.equals(dbpw)) {// pw일치할때
					// 생성자에 넣기
					dto = new MemberDTO(rs.getString("id"), rs.getString("pw"), rs.getString("name"),
							rs.getString("email"), rs.getString("address"), rs.getString("phone"),
							rs.getString("indate"));
				} else {// id존재, 암호 불일치할때
					dto = new MemberDTO();
					dto.setId(rs.getString("id"));
					System.out.println("암호가 맞지 않습니다. 4번 입력해서 다시 조회하세요.");
				}
			} else { //id가 존재하지않으면
				System.out.println("1번 회원가입부터 하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}
		return dto;
	}

	public void updateMember(HashMap<String, String> updateMap) {
		PreparedStatement pt = null;
		Connection con = null;

		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD);

			StringBuffer sql = new StringBuffer(); // 뒤에 추가추가해야하니까 StringBuffer로 생성하기/동적크기
			sql.append("update member set ");

			Set<String> keys = updateMap.keySet(); // key값만 읽어옴

			for (String k : keys) {
				if (!k.equals("id")) {
					sql.append(k + "='" + updateMap.get(k) + "', ");
				}
			}
			sql.deleteCharAt(sql.lastIndexOf(",")); // 마지막에 등장한 , 없애기
			sql.append(" where id=?");
			System.out.println(sql); // 쿼리 확인 용도
			pt = con.prepareStatement(sql.toString());
			pt.setString(1, updateMap.get("id"));
			pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// pt.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}
	}

	public MemberDTO updateMember(String pw, String name, String email, String phone, String address) {
		MemberDTO dto = null;
		PreparedStatement pt = null;
		Connection con = null;
		int cnt = 0;
		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD);

			String sql = "update member set pw=? and name=? and email=? and phone=? and address=?";
			pt = con.prepareStatement(sql);

			cnt = pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}
		return dto;
	}
//
//	public void insertDeleteMember(MemberDTO dto) {
//		PreparedStatement pt = null;
//		Connection con = null;
//
//		try {
//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
//					ConnectionInform.PASSWORD);
//
//			String sql = "insert into deletedmember values(?,?,?,?,?,?,?)";
//			pt = con.prepareStatement(sql);
//
//			pt.setString(1, dto.getId());
//			pt.setString(2, dto.getPw());
//			pt.setString(3, dto.getName());
//			pt.setString(4, dto.getPhone());
//			pt.setString(5, dto.getEmail());
//			pt.setString(6, dto.getAddress());
//			pt.setString(7, dto.getIndate());
//
//			pt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pt.close();
//				con.close();
//			} catch (SQLException e) {
//				// 비워두기
//			}
//		}
//
//	}// insertDeleteMember

	public void deleteMember(String id) {
		PreparedStatement pt = null;
		Connection con = null;

		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD);
			
			con.setAutoCommit(false); //수동으로 트랜잭션 설정 변경
			
			String sql1 = "insert into deletedmember select * from member where id=?"; //서브쿼리
			String sql2 = "delete from member where id = ?";
			//////////////////////////////////////////////////
			pt = con.prepareStatement(sql1);
			pt.setString(1, id);
			int insertCount = pt.executeUpdate();
			//////////////////////////////////////////////////
			pt = con.prepareStatement(sql2);
			pt.setString(1, id);
			int deleteCount = pt.executeUpdate();
			//////////////////////////////////////////////////
			con.commit(); //두 쿼리 모두 성공하면 커밋해라.
			System.out.println("회원 탈퇴 처리 완료");
		} catch (Exception e) {
			System.out.println("회원탈퇴 처리 중 문제 발생 - 취소");
			try {
				con.rollback();				
			}catch(Exception e2){
				
			}
//			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				// 비워두기
			}
		}

	}

}
