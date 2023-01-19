package member_crud;

import java.util.ArrayList;
import java.util.Scanner;

public class TotalSelectView implements View {

	@Override
	public void input() {
		// 1페이지 당 3명만 보여주기
		// member테이블 전체데이터갯수 조회
		// select count(*) from member
		// 1-4페이지 중 입력 가능합니다. => 보여주기
		Scanner key = new Scanner(System.in);
		MemberDAO dao = new MemberDAO(); //DAO 객체 생성
		int total = dao.getTotalMember();
		int pagenum = 0; //페이지번호
		int memberPerPage = 3; //한 페이지에 3개만 보이게
		
		if(total %3 == 0) { 
			pagenum = total/memberPerPage;
		}else {
			pagenum = total/memberPerPage+1;
		}
		
		System.out.println("1 - " + total + " 페이지까지 입력 가능합니다.");
		System.out.println("페이지번호 입력: ");
		int currentpage = key.nextInt();
	

		ArrayList<MemberDTO> list = dao.getMemberList(currentpage, memberPerPage); 
		for(MemberDTO d :list) {
			System.out.println(d);
		}
		
	}

}














