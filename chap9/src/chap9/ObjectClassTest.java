package chap9;

public class ObjectClassTest {
	public static void main(String[] args) {
		MyObject o1 = new MyObject("myobject");
		MyObject o2 = new MyObject("myobject");
		
		
		//getClass().getName() + '@' + Integer.toHexString(hashCode())
		//패키지명.클래스명@16진수(해쉬코드)
//		System.out.println(o1/*.toString 출력문에 자동으로 toString 호출 되어있다고 함. 아래 o1.toString과 o1은 같은 내요임*/);
		System.out.println(o1.toString()); //java.lang.Object@58ceff1 
		System.out.println(o2.toString()); //java.lang.Object@7c30a502
		
		System.out.println(o1 == o2); //false
		System.out.println(o1.equals(o2)); //false
		
		String o3=new String();

	}

}


class MyObject/*extends Object*/{
	String message;
	MyObject(String message){
		this.message=message;
	}
	//toString + equals + .... Object클래스결과 동ㅇ릴

	//toString 오버라이딩
	@Override
	public String toString() {
		return this.message;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = this.message.equals(((MyObject)obj).message);
		return result;
		
	}
	
	//equals 오버라이딩
	
	
}



