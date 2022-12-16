package test;
//1.

//StringComparator 클래스의 

//int compare(String str1, String str2, boolean isLength) 
//메소드를 완성하십시오. 
//
//compare 메소드는 String 타입의 문자열을 2개 입력받아 
//조건에 맞는 문자열의 문자 개수를 리턴합니다. 
//isLength 값이 true 이면 문자열의 길이가 긴 문자열의 
//문자 개수를 리턴하고, false 이면 문자‘a’의 개수가 
//많은 문자열의 문자 개수를 리턴합니다. 
//
//
//int compare(String str1, String str2, boolean isLength)
//-isLength 값이 true 이면 문자열의 길이가 긴 문자열의 문자 개수를 리턴한다.
//-isLength 값이 false 이면 문자 ‘a’가 많은 문자열의 문자 개수를 리턴한다.
//
//
//<<처리 결과>>
//예) compare(“javaprogram”, “oracle”, true)   ☞  11   
//예) compare(“javaprogram”, “oracledatabase”, false)  ☞  14
//
//주의 사항 :
//１)	테스트 목적으로 스스로 main을 구현할 수 있습니다. 
//２)	주어진 메서드의 signature는 변경하지 않습니다.

public class StringComparator {

	public static void main(String[] args) {

		int num1 = compare("javaprogram", "oracle", true);
		int num2 = compare("javaprogram", "oracledatabase", false);

		System.out.println(num1);
		System.out.println(num2);
	}

	static int compare(String str1, String str2, boolean isLength) {
		int cnt1 = 0;
		int cnt2 = 0;
		if (isLength == true) {
			return str1.length() > str2.length() ? str1.length() : str2.length();
		} else {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == 'a') {
					cnt1++;
				}
				if (str2.charAt(i) == 'a') {
					cnt2++;
				}

			} // for

		} // else끝
		return cnt1 > cnt2 ? str1.length() : str2.length();
	}// compare
}
