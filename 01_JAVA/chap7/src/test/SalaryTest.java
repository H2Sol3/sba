package test;

class Employee {
	int num;
	String name;
	int bong; //본봉
	int generalFee; //사원수당
	int totalSalary;

	Employee(int num, String name, int bong, int generalFee) {
		this.num = num;
		this.name = name;
		this.bong = bong;
		this.generalFee = generalFee;
	}

	void calcSalary() {
		totalSalary = bong + generalFee;
	}
}

class Manager extends Employee {
	int ceoSalary; //간부수당

	Manager(int num, String name, int bong, int generalFee, int ceoSalary) {
		super(num, name, bong, generalFee);
		this.ceoSalary = ceoSalary;
	}
	@Override
	void calcSalary() {
//		totalSalary = bong + generalFee + ceoPrice;
		super.calcSalary();
		totalSalary+=ceoSalary;
		
	}
}

class Engineer extends Employee{
	int j;
	int techFee;
	
	Engineer(int num, String name, int bong, int generalFee, int j,int techFee) {
		super(num, name, bong, generalFee);
		this.j=j;
		this.techFee=techFee;
	}
	@Override
	void calcSalary() {
//		totalSalary = bong + generalFee + j+techFee;
		super.calcSalary();
		totalSalary+=techFee+j;
	}
}


class Secretary extends Employee{
	int sudang;
	
	Secretary(int num, String name, int bong, int generalFee,int sudang) {
		super(num, name, bong, generalFee);
		this.sudang=sudang;
	}
	@Override
	void calcSalary() {
//		totalSalary = bong + generalFee + sudang;
		super.calcSalary();
		totalSalary+=sudang;
	}
}


public class SalaryTest {
	public static void main(String[] args) {

		Employee e[] = new Employee[4];
		// 1.상속 2.생성자(타입 순서 갯수....)
		e[0] = new Employee(1000, "이사원", 10000, 5000);
		e[1] = new Manager(2000, "김간부", 20000, 10000, 10000);
		e[2] = new Engineer(3000, "박기술", 15000, 7500, 5000, 5000);
		e[3] = new Secretary(4000, "최비서", 15000, 7000, 10000);
		
		System.out.println("사번 : 이름 : 본봉 : 총급여");
		for(int i=0;i<e.length;i++) {
			e[i].calcSalary();//4개의 객체 오버라이딩
			System.err.println(e[i].num+":"+e[i].name+":"+e[i].bong+":"+e[i].totalSalary);
			if(e[i] instanceof Engineer) {
				System.out.println("기술직사원의 경우 : "+((Engineer)e[i]).techFee+" , "+((Engineer)e[i]).j); //techFee,j는 Engineer객체변수니까 형변환 해줘야함
			}
		}
		/* 배열 내의 각 객체의
		 급여계산메소드 호출하고
		사번, 이름, 총급여 출력
		 단, 기술직 사원은 기술수당, 자격수당도 출력
		사번:이름:본봉:총급여
		1000:이사원:10000:xxxxx
		2000:김간부:20000:xxxxx
		3000:박기술:15000:xxxxx
		기술직사원의 경우 : 기술수당 자격수당
		4000:최비서:15000:xxxxx
		*/ 
	}
}