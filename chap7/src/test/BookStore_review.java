package test;

class Book1 {
	String title;
	int price;

	Book1(String title, int price) {
		this.title = title;
		this.price = price;
	}

	// 기본생성자
	Book1() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

class BookMgr1{
	//Book객체만 가질 수 있는 배열 선언
	Book1[] booklist;
	BookMgr1(Book1[] booklist2) {
		this.booklist=booklist2;
	}
	
	void printBooklist() {
		for(int i=0;i<booklist.length;i++) {
		//	booklist b=booklist[i];
			System.out.println(booklist[i].getTitle()+":"+booklist[i].getPrice());;
		}
	}
	
	void printTotalPrice() {
		int totalPrice=0;//지역변수 초기화
		for(int i=0;i<booklist.length;i++) {
				totalPrice+=booklist[i].getPrice();
			}
		System.out.println("전체 책 가격의 합 : "+totalPrice);;
	}
	
}

public class BookStore_review {
	public static void main(String[] args) {
		Book1 booklist[] = new Book1[5];

		Book1 book1 = new Book1("Java Program", 25000);
		Book1 book2 = new Book1("JSP Program", 15000);
		Book1 book3 = new Book1("SQL Fundamentals", 30000);
		Book1 book4 = new Book1("JDBC Program", 28000);
		Book1 book5 = new Book1();

		book5.setTitle("EJB Program");
		book5.setPrice(34000);

		booklist[0] = book1;
		booklist[1] = book2;
		booklist[2] = book3;
		booklist[3] = book4;
		booklist[4] = book5;

		BookMgr1 mgr = new BookMgr1(booklist);

		System.out.println("=== 책 목록 ===");

		mgr.printBooklist();

		System.out.println("");
		System.out.println("=== 책 가격의 총합 ===");

		mgr.printTotalPrice();
	}

}
