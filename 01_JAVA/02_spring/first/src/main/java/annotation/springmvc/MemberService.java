package annotation.springmvc;

public interface MemberService {
//회원과 관련된 기능별로 메서드 선언해주기
	void registerMember();
	String registerMember(MemberDTO dto);
	String end(int age);
}
