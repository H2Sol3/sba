package dto;

public class MemberDTO {

	// html form(parameter명) 입력 ---- dto(변수명) ---- db table(컬럼명)
	String id, pw, name, email, address, phone, indate; // memberinsertview에서 생성한 변수 선언해주기
	// 자바 - int, double, date, String
	// 마리아db - int, double, datetime, char/varchar
	// hire_date의 양식을 그대로 가져오기보단 "%Y"로 년도만 가져오거나 날짜만 가져오는 경우가 많음.

	// 변수에 public이 있으니(생략) 같은 패키지 내에서는 아무나 사용 가능. 그렇지만 다른 패키지에서는 사용 불가.
	// getter,settet생성. 다른 패키지에서도 사용할 수 있게!!
	
	//생성자
	public MemberDTO() { // insertView를 위한 생성자		
	}
	
	public MemberDTO(String id, String name, String indate) { //totalselectview-DAO를 위해 생성
		super();
		this.id = id;
		this.name = name;
		this.indate = indate;
	}
	//OneSelectView위해 생성
	public MemberDTO(String id, String pw, String name, String email, String address, String phone, String indate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.indate = indate;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}


	//view에서 memberDTO객체 넘겼는데 잘 넘어왔는지 확인위해서
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email 
				+ ", phone=" + phone + ", address=" + address + ", indate=" + indate+"]";
	}
	
	
}
