package member_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionInform;

public class MemberDAO {
	int insertMember(MemberDTO dto) {
		// dto 전달 내용을 member 테이블에 입력
		// 회원가입일은 now()로 설정
		PreparedStatement pt = null;
		Connection con = null;
		int cnt = 0;
		MemberDTO selecteddto = getMember(dto.getId(), dto.getPw()); // 알아서 연결해주고 끝나면 해제해줌
		
		if(selecteddto != null) {
			System.out.println("아이디 중복입니다. 다른 아이디를 입력하세요.");
			return 0; //메서드 중단하겠다는 의미
		}else {
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

	ArrayList<MemberDTO> getMemberList(int currentpage, int memberPerPage) { // 클릭한 페이지에 저장된 회원 목록 조회
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

	MemberDTO getMember(String id, String pw) {
		ResultSet rs = null;
		PreparedStatement pt = null;
		Connection con = null;
		MemberDTO dto = null;

		int cnt = 0;
		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME,
					ConnectionInform.PASSWORD);

			String sql = "select * from member where id=?";

			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			// rs.next() : 데이터를 읽을 수 있다!!!!!!!!!
			// rs.next()의 기본은 true!!!!!!!!
//			if(rs.next()) { //데이터를 읽을 수 있다는건 조회한 쿼리가 있다는 거니까! 
//				
//					if(pw.equals(rs.getString("pw"))) {
//						// 둘 다
//						dto.setId(rs.getString("id")); 
//						dto.setName(rs.getString("name"));
//						dto.setPw(rs.getString("pw"));
//						dto.setAddress(rs.getString("address"));
//					}else {
//						System.out.println("4번 암호 맞지 않습니다.");
//						// id만
//						dto.setName(rs.getString("name"));
//						dto.setId(rs.getString("id"));	
//				}
//			}else {//조회할 수 있는 내용이 없으니 확인 불가~~~!
//				System.out.println("1번 회원가입부터 하세요.");
//				//null
//			}

			// 강사님 코드
			if (rs.next()) {
				String dbpw = rs.getString("pw");
				if (pw.equals(dbpw)) {// id,pw일치할때
					// 생성자에 넣기
					dto = new MemberDTO(rs.getString("id"), rs.getString("pw"), rs.getString("name"),
							rs.getString("email"), rs.getString("phone"), rs.getString("address"),
							rs.getString("indate"));
				} else {// 암호가 다를때
					dto = new MemberDTO();
					dto.setId(rs.getString("id"));
					System.out.println("암호가 맞지 않습니다. 4번 입력해서 다시 조회하세요.");
				}

			} else {
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
}
