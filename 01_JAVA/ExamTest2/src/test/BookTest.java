package test;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BookDTO dto = new BookDTO();
		System.out.println("1. 추가 2. 조회  선택하세요.");
		int num = scan.nextInt();
		if (num == 1) { //insert
			System.out.println("도서 정보 입력: 도서번호-도서명-저자-출판년도-가격-출판사");
			String no = scan.next();
			String title = scan.next();
			String author = scan.next();
			String time = scan.next();
			int price = scan.nextInt();
			String pulisher = scan.next();
			
			dto.setBookNo(no);
			dto.setBookTitle(title);
			dto.setBookAuthor(author);
			dto.setBookTime(time);
			dto.setBookPrice(price);
			dto.setBookPublisher(pulisher);
			
			new BookDAO().insertBook(dto);
		} else { //select
			new BookDAO().selectBook();
		}
	}

}
