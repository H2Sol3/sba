package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("memberdao")
public class MemberDAO {
	@Autowired //dto1, dto2,dto3
	@Qualifier("dto2") //spring, 1111
	MemberDTO dto;

//<property name="dto" ref="dto 정의 bean id" />		
//	public void setDto(MemberDTO dto) {
//		this.dto = dto;
//	}
	
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
