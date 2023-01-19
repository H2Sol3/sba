package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("member/member.xml");
		MemberDAO dao = factory.getBean("dao", MemberDAO.class);
		boolean isLogin = dao.selectMember();
		if(isLogin) {
			System.out.println(dao.dto.getId()+" 회원님 정상 로그인되셨습니다.");
		}else {
			dao.insertMember();
		}
//		MemberDTO dto1 = factory.getBean("dto1", MemberDTO.class);
//		dao.setDto(dto1);
		
//		MemberDTO dto2 = new MemberDTO();
//		MemberDTO dto3 = new MemberDTO();
	}
}