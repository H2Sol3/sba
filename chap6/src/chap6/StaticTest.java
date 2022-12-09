package chap6;

class Person{
	String name;
	int age;
	static String nation="대한민국"; //한국만 생성하려고 초기화해줌. Person객체 공유. 1개 메모리만 할당되어도 됨. 왜냐면 모든 객체 공동값이니까..?
	//static붙임. 변수 앞에 붙여두면 모든 객체가 이 값을 공유할 예정이라는 의미. 모두 공유할거니까 2개이 없이 1개만 있어도 되니까.
	//static은 지역변수에 붙이지 않음. 멤버변수에만 붙임(클래스 변수)
}
public class StaticTest {
	public static void main(String[] args) {
		System.out.println("모든 사람들의 국적은 "+Person.nation+"입니다.");
		
		Person p1=new Person();
		p1.name="홍길동";
		p1.age=22;
//		p1.nation="한국"; static으로 고정해두었기때문에 넣어줄 필요 없음.
		System.out.println(p1.name+":"+p1.age+":"+p1.nation);
		
		System.out.println(p1.name+":"+p1.age+":"+Person.nation); //p1대신 Person도 가능
		
		
		Person p2=new Person();
		p2.name="이철수";
		p2.age=32;
//		p2.nation="한국"; static으로 고정해두었기때문에 넣어줄 필요 없음. 
		System.out.println(p2.name+":"+p2.age+":"+p2.nation);
		
	}

}
