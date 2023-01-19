package test;

import java.util.Arrays;

//2. url을 입력받아서 아래 출력결과처럼 분리 출력
//String url = 
//"http://www.kitri.re.kr:8080/java/test";
//
//--출력결과---
//www
//kitri
//re
//kr
//8080
//java
//test
public class Test2 {
	public static void main(String[] args) {
		String url = "http://www.kitri.re.kr:8080/java/test";

		String[] str = url.split("[\\.:/]");
		for (int i = 3; i < str.length; i++) {
			System.out.println(str[i]);
		}

	}

}
