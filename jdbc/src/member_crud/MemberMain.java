package member_crud;

import java.util.Scanner;

public class MemberMain {
	public static void main(String[] args) {
		while (true) {
			System.out.println("\n===회원 관리 프로그램===");
			System.out.println("1. 회원정보 입력");
			System.out.println("2. 회원정보 수정");
			System.out.println("3. 회원탈퇴");
			System.out.println("4. 회원 정보 조회"); // id,pq입력하면 이름-주소 조회
			System.out.println("5. 전체 회원 조회"); // 모든 회원 id, 이름 조회
			System.out.println("6. 종료");
			System.out.print("번호 입력: ");
			Scanner key = new Scanner(System.in);
			int menu = key.nextInt();
			if (menu == 6) {// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (menu == 1) {
				new MemberInsertView().input(); // MemberInsertView객체 생성 후 호출
			} else if (menu == 5) {// 전체 회원 조회
				// 페이징 처리
				// 10명 이상 입력되었다고 가정 후 1페이지 당 3명만 보이게 하기
				new TotalSelectView().input();
			} else if (menu == 4) {// id, pw 입력하면 이름,주소같은 내 정보만 조회
				new OneSelectView().input();
			}

		} // while

	}// main

}
