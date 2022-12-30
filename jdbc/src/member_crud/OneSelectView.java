package member_crud;

import java.util.ArrayList;
import java.util.Scanner;

public class OneSelectView implements View {

	@Override
	public void input() {// 4.내 정보 조회
		MemberDAO dao = new MemberDAO(); // DAO 객체 생성

		Scanner key = new Scanner(System.in);
		System.out.print("아이디 입력: ");
		String id = key.nextLine();
		System.out.print("암호 입력: ");
		String pw = key.next();

		// 1개만 조회하는거니까 list는 필요없음.
		MemberDTO dto = dao.getMember(id, pw); //입력한 id, pw전달
		// id,pw 일치 -> 정보 리턴
		// id 일치, pw불일치 -> "4번 암호 맞지 않습니다." (id만 저장하고 암호 저장x)
		// id 불일치, pw불일치 -> "1번 회원가입부터 하세요" (dto null로 리턴)
		
		if(dto != null && dto.getPw() != null) {
			System.out.println(dto);			
		}
		//System.out.println("이름: "+dto.getName()+"  주소: "+dto.getAddress());
	}

}
