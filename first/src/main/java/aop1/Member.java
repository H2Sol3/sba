package aop1;

public class Member {
	void login(String id) {
		System.out.println(id + " 회원님 로그인하셨습니다.");
	}
	public void logout() {
		System.out.println("로그아웃하셨습니다.");
	}
	void insert(String id, int pw) {
		System.out.println(id + ":" + pw + "로 회원가입하셨습니다.");
	}
}
