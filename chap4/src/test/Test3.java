package test;
//12명의 학생에서 xx권을 나누어줍니다.
//남은 책은 xx권입니다.(남은 책이 있으면 출력. 없으면 출력 안함)

public class Test3 {

	public static void main(String[] args) {
		int books=100;// 도서 수
		int cntOfSut=12;//학생 수
		int share = 0;

		share = books/cntOfSut;
		if(books%cntOfSut>0) {
			System.out.println("12명의 학생에게 "+share+"권을 나누어줍니다. 남은 책은 "+books%cntOfSut+"권입니다.");
		}else {
			System.out.println("12명의 학생에게 "+share+"권을 나누어줍니다.");
		}
		
	}

}
