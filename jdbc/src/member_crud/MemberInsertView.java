package member_crud;

import java.util.Scanner;

public class MemberInsertView implements View {

	@Override
	public void input() {
		Scanner key = new Scanner(System.in);
		System.out.print("아이디 입력: ");
		String id = key.next();
		System.out.print("암호 입력: ");
		String pw = key.next();
		System.out.print("이름 입력: ");
		String name = key.next();
		System.out.print("이메일 입력: ");
		String email = key.next();
		System.out.print("폰번호 입력: ");
		String phone = key.next(); 
		key.nextLine(); // 폰번호입력:xxxx(엔터) 엔터 무시? => 이거 있어야 주소까지 칠 수 있음
		System.out.print("주소 입력: ");
		String address = key.nextLine();
		// MemberDTO타입으로 만들어서 MemberDao로 전달해야 함.
		// MemberDTO가 Member테이블 컬럼들을 변수로 만들어줌
		MemberDTO dto = new MemberDTO();
		dto.setId(id); //setter메서드에 값 넣기
		dto.setPw(pw);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setAddress(address);
//		System.out.println(dto);
		MemberDAO dao = new MemberDAO(); //DAO 객체 생성
		int result = dao.insertMember(dto); //DAO객체에 dto매개변수로 넣기
		System.out.println(result+"명의 회원정보 입력 완료");
	}

}
