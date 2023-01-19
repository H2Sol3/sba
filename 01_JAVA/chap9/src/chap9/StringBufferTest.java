package chap9;

public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer("초기값");
		StringBuffer sb3=new StringBuffer(100);
		
		System.out.println("sb1의 용량 = " +sb1.capacity()); //16
		System.out.println("sb2의 용량 = " +sb2.capacity()); // 3 + 16 = 19
		System.out.println("sb3의 용량 = " +sb3.capacity()); //100
		
		System.out.println("sb1의 문자열 갯수"+sb1.length()); //		sb1의 문자열 갯수0
		System.out.println("sb2의 문자열 갯수"+sb2.length()); //		sb2의 문자열 갯수3
		System.out.println("sb3의 문자열 갯수"+sb3.length()); //		sb3의 문자열 갯수0
		sb2.append("추가한 값");
		sb2.append("추가한 값");
		sb2.append("추가한 값");
		sb2.append("추가한 값");
		sb2.append("추가한 값");
		System.out.println("sb2의 문자열 갯수"+sb2.capacity()); //		sb2의 용량 40
		
//		System.out.println("sb2의 문자열 갯수"+sb2.length()); //		sb2의 문자열 갯수8
		
//		String s2 = new String("초기값");
//		System.out.println(s2.length());
//		System.out.println(s2+" 추가한 값");
//		System.out.println(s2.length());
		
		
		System.out.println("삭제 전 sb2의 문자열 갯수"+sb2.length());
		sb2.delete(0, 10);//0번부터 10전까지 인덱스 삭제(0-9)
		System.out.println("삭제 후 sb2의 문자열 갯수"+sb2.length());
		
		
		
		System.out.println(sb2.reverse());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
