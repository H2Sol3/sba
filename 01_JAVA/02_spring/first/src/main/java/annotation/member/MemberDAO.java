package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dao")
public class MemberDAO {
	@Autowired //2개. dto,dto2
//	@Qualifier("dto2")
	MemberDTO dto;

//	1. MemberDTO 타입 객체를 찾는다. - 1개 자동주입
//	2. 여러개 찾는다. - 변수명 일치하는 객체를 찾는다. - 1개 자동주입
//	3. 객체 여러개 찾는다. - 이름이 일치하지 않는다.(이런 경우 Qualifier필요)
	
	public boolean selectMember() {
		//MemberDTO - id가 spring이고 pw가 1111이면 정상 로그인
		if(dto.getId().equals("spring") && dto.getPw().equals("1111")) {
			 return true;
		}else {
			return false;
		}
		
	}
	
	public void insertMember() {
		System.out.println(dto.getId()+" 님 회원가입되셨습니다. ");
	}
	
}
