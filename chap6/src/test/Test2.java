package test;

class Member{
	String id;
	int pw;
	String name;
	int age; 
	
	//회원가입
	void insert(String id, int pw, String name, int age) {
		System.out.println("------------------------------------");
		System.out.println("아이디: "+id+"\n이름: "+name+"\n나이: "+age);
		System.out.println("가입 완료되었습니다.");
		System.out.println("------------------------------------"); 
//		System.out.println(id+pw+name+age);
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.age=age;
	}
	//로그인
	void login(String id, int pw) {
		if(id.equals(this.id)&&pw==this.pw) {
			System.out.println("------------------------------------");
			System.out.println("로그인되었습니다.");
			System.out.println("------------------------------------");
		}else {
			System.out.println("------------------------------------");
			System.out.println("로그인 정보를 확인하세요.");
			System.out.println("------------------------------------");
		}
	} 
	//암호 변경
	void setPassword(int pw) {
		this.pw=pw;
		System.out.println("------------------------------------");
		System.out.println("암호를 변경하셨습니다.");
		System.out.println("------------------------------------");
	}
	//자기 정보 조회
	void getMyInfo() {
		System.out.println("------------------------------------");
		System.out.println("아이디 : "+id+" 회원님 정보는 다음과 같습니다.\n"+"암호 : "+pw+"\n이름 : "+name+"\n나이 : "+age);
		System.out.println("------------------------------------");
	}
	//로그아웃
	String logout() {
		System.out.println("------------------------------------");
		System.out.println("로그아웃되었습니다.");
		System.out.println("------------------------------------");
		id = null;
		pw=-1;
		name=null;
		age=-1;
		return id;
	}
	
}



public class Test2 {
	public static void main(String[] args) {
		Member mem = new Member();
		
		mem.insert("test", 1234, "이자바", 25);
		
		mem.login("test", 4321);
		
		mem.login("test", 1234);
		
		mem.setPassword(1111);
		
		mem.getMyInfo();
		
		String id  = mem.logout(); //리턴값 id변수에 저자하기
		
		if(id == null){
		 System.out.println("다시 로그인하셔야 합니다.");
		}
		
		
		
		
		
	}
}




















































