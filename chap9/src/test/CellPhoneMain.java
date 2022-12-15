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
				throw new IllegalArgumentException("통화시간입력오류");
			}
			
			System.out.println("통화 시간 : " + min + "분");
			battery = battery - min * 0.5; // 배터리 감소	

			if(battery<0) {
				battery=0;
			}
	}

	// 메서드2
	void charge(int time) throws IllegalArgumentException{ //time : 충전시간
			if(time < 0) { //충전시간이 0보다 작을때
				throw new IllegalArgumentException("충전시간입력오류");				
			}
			System.out.println("충전 시간 : "+time +"분");
			battery+=time*3;
			
			if(battery>=100) {
				battery=100;
			}
	}

	// 메서드3
	void printBattery() {
			System.out.println("남은 배터리 양 : " + battery);
	}

	// 메서드4
	boolean isSame(CellPhone other) {
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
			System.out.println(e.getMessage());
		}
		CellPhone yourPhone = new CellPhone("galaxy-7");
		if (myPhone.isSame(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}
	}
}