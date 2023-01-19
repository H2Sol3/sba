package academy; //B클래스 저장 폴더 설정(무조건 첫 문장이어야함)

import java.util.*;

// sba패키지의 모든 클래스를 의미(*)
//1. B클래스처럼 같은 패키지에 속한 클래스의 경우 자동 import
//2. java.lang.패키지에 속한 클래스는 자동import
// 이 외에는 모두 import필요!!!!!!!!!
import sba.A;

public class B {
	public static void main(String[] args) {
//		sba.A a1 = new sba.A(); //A라는 생성자는 sba패키지에 있는 A야 라고 알려주는 방법1. 
		
		A a1 = new A(); //사용자 정의 클래스
		Date now=new Date(); //라이브러리제공클래스
	}

}
