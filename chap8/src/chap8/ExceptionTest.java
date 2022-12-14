package chap8;

public class ExceptionTest {
	public static void main(String[] args) {
		// 2개 이상의 명령행 매개변수 입력 필요, 정수 변경 가능한 값, 0은 아닌 값 입력
		// 100 100 => 예외발생X. 정상 수행
		// 100 => ArrayIndexOutOfBoundsException - 중단 -예외처리코드 추가 후 catch블록 실행 - 끝 종료
		// 100 0 => ArithmeticException - 중단
		// 백 백 => NumberFormatException - 중단
		int k = 0;
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			k = i / j;
			
		}catch(ArithmeticException e) { //자식예외처리 우선
			System.out.println("0을 입력하실 수 없습니다.");
		}catch(Exception e) { //부모예외처리 나중
			System.out.println("예외 종류에 상관없이 동일 처리");
		}//catch(AException || BException) 이렇게 or처리도 가능~!
		finally {
			System.out.println("항상 출력됩니다.");
		}
		
//		}catch (/*예외종류*/ArithmeticException e) { //try구문 실행하다가 ArithmeticException발생하면 아래 내용 실행
//		//	예외발생시 대체할 문장
//			System.out.println("0을 입력하실 수 없습니다.");
//		}catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("2개 이상의 값을 입력하셔야 합니다.");
////			e.printStackTrace(); //오류발생원 추척 출력
//		}catch (NumberFormatException e) {
//			System.out.println("정수로 변경이 가능한 값을 입력하세요.");
//		}
		System.out.println("나누기 결과: " + k);
		System.out.println("main 종료");
		
	}

}
