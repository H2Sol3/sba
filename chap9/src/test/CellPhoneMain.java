package test;

/*<<CellPhoneMain 실행결과>>
충전 시간 : 20분
남은 배터리 양 : 60.0
통화 시간 : 300분
남은 배터리 양 : 0.0
충전 시간 : 50분
남은 배터리 양 : 100.0
통화 시간 : 40분
남은 배터리 양 : 80.0
통화시간입력오류
동일 모델입니다. 
*/

class CellPhone {
	String model; 
	double battery;

	CellPhone(String model) {
		this.model = model;
	}

	// 메서드1

	void call(int min) throws IllegalArgumentException {
			if (min < 0) {
				throw new IllegalArgumentException("통화시간입력오류"); //예외처리
			}
			
			System.out.println("통화 시간 : " + min + "분"); //예외가 발생하면 이 문장부터는 실행X, 예외 없으니 실행됨. 조건문 필요없다!!!
			battery = battery - min * 0.5; // 배터리 감소	

			if(battery<0) { //배터리 -일때 0으로
				battery=0;
			}
	}
 
	// 메서드2
	void charge(int time) throws IllegalArgumentException{ //time : 충전시간
			if(time < 0) { //충전시간이 0보다 작을때
				throw new IllegalArgumentException("충전시간입력오류"); //예외처리		
			}
			
			System.out.println("충전 시간 : "+time +"분");
			battery+=time*3;
			
			if(battery>=100) {
				battery=100;
			}
	}

	// 메서드3
	void printBattery() { //배터리 양 출력만. 초기화 등등은 다른 함수에서 처리
			System.out.println("남은 배터리 양 : " + battery);
	}

	// 메서드4
	boolean isSame(CellPhone other) {
		//model과 other를 비교하는건 model-GALAXY와 CellPhone 객체 전체를 비교하는 것. 북북북 처럼 CellPhone객체의 어떤 것을 가져와서
		//비교해야하는지 정확하게ㅐ 찝어주기. model과 other.model 비교!!!!!!!!!!!!!!!!!
		if(model.equalsIgnoreCase(String.valueOf(other.model))) {  
			return true;
		}else {
			return false;
		}
	}
} 

public class CellPhoneMain {
	public static void main(String[] args) {

		CellPhone myPhone = new CellPhone("GALAXY-7");
		//CellPhone클래스에서 예외를 던졌으니 main에서 예외처리해주기
		try {
			myPhone.charge(20); // 20분간 충전을 한다.
			myPhone.printBattery();
			myPhone.call(300); // 300분간 통화를 한다.
			myPhone.printBattery();
			myPhone.charge(50); // 50분간 충전을 한다.
			myPhone.printBattery();
			myPhone.call(40); // 40분간 통화를 한다.
			myPhone.printBattery();
			myPhone.call(-20); // 통화시간입력오류			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage()); //오류생기면 메세지 출력
		}
		CellPhone yourPhone = new CellPhone("galaxy-7");
		if (myPhone.isSame(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}
	}
}