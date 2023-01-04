package test;

class Book {
	String bookNo;
	String bookTitle;
	String bookAuthor;
	int bookYear;
	int bookPrice;
	String bookPublisher;

	public Book(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice, String bookPublisher) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
	}


	@Override
	public String toString() {
		return bookNo + "    " + bookTitle + "  " + bookAuthor + "  " + bookYear + "     " + bookPrice + "    " + bookPublisher;
	} 
}

class Magazine extends Book {
	String month;
//
	public Magazine(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice,
			String bookPublisher, String month) {
		super(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
		this.month = month;
	}


	@Override
	public String toString() {
		return bookNo + "    " + bookTitle + "     " + bookAuthor + "  " + bookYear + "     " + bookPrice + "    "
				+ bookPublisher + "    " + month;
	}
}

public class BookEx {
	public static void main(String[] args) {
		Magazine[] mag = new Magazine[6];

		mag[0] = new Magazine("B001", "자바프로그래밍", "홍길동", 2021, 30000, "서울출판사"," ");
		mag[1] = new Magazine("B002", "데이터베이스", "이몽룡", 2020, 25000, "대한출판사"," ");
		mag[2] = new Magazine("B003", "HTML/CSS", "성춘향", 2022, 18000, "민국출판사"," ");
		mag[3] = new Magazine("M001", "자바 월드", "홍길동", 2021, 3000, "서울출판사","5");
		mag[4] = new Magazine("M002", "웹 월드", "이몽룡", 2021, 2500, "서울출판사","7");
		mag[5] = new Magazine("M003", "게임 월드", "성춘향", 2022, 1800, "서울출판사","9");

		System.out.println("도서번호  도서명        저자    출판년도     가격       출판사    발행월");
		System.out.println("--------------------------------------------------------------------");

		for(Magazine a : mag) {
			System.out.println(a);
		}
		

	}

}
