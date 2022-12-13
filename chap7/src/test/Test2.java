package test;

class Information {
	String id;
	String name;

	Information(String id, String name) {
		this.id = id;
		this.name = name;
	}

	String print() {
		return id + ":" + name;
	}
	
	public Information() {
	
	}
}

class Product extends Information {
	int price;// 상품 가격

	public Product(String id, String name, int price) {
		super(id, name);
		this.price = price;
	}

	@Override
	String print() {
		return id + ":" + name + ":" + price;
	}

}

class Board extends Information {
	String contents;// 게시물 내용
	int viewCount;// 조회수

	public Board(String id, String name, String contents, int viewCount) {
		super(id, name);
		this.contents = contents;
		this.viewCount = viewCount;
	}

	@Override
	String print() {
		return id + ":" + name + ":" + contents + ":" + viewCount;
	}
}

class Member extends Information {
	String email; // 이메일
	String phone; // 폰번호

	public Member(String id, String name, String email, String phone) {
		super(id, name);
		this.email = email;
		this.phone = phone;
	}

	@Override
	String print() {
		return id + ":" + name + ":" + email + ":" + phone;
	}
}

class InformationList extends Information {

	Information[] in; // 입력 수만큼 배열 객체 생성
	
	
	
	
	
	
	
	
	
	int cnt=0;

	public InformationList(String length) { // 명령행
		this.in = new Information[Integer.parseInt(length)];
	}

	void add(Information inform) { //객체 저장
		
		if(cnt >= in.length) {
			System.out.println("오류");
		} else {
			in[cnt]=inform;
			cnt++;
		}
		
	}

	
	void read() {// 내용 출력
		for (int i = 0; i < cnt; i++) {
			System.out.println(in[i].print());
		}
	}

}

public class Test2 {
	public static void main(String[] args) {

		InformationList list = new InformationList(args[0]);//
		list.add(new Board("1", "게시물1", "현재 조회수 10입니다", 10));
		list.add(new Product("100", "웅진비데", 300000));
		list.add(new Member("hong", "홍길동", "hong@a.com", "010-222-2222"));
		list.add(new Board("2", "게시물2", "새로운 게시물 추가합니다", 0));
		list.add(new Product("200", "웅진정수기", 1000000));
		list.add(new Member("lee", "이철수", "chul@b.com", "010-333-3333"));
		list.read();

	}

}
