package chap4;

public class ForTest {
	public static void main(String[] args) {
		
		char star='*';
		char blank =' ';
		//1~20난수
		int count = (int)(Math.random()*20)+1;
		//count만큼 한줄 * 반복 출력 갯수. 1~20사이 난수임
		
		
		int lines = (int)(Math.random()*10)+1;
		//출력줄 갯수 1-10난수
		
		System.out.println(lines + "줄 만큼 출력합니다.");
//		System.out.println(count + "만큼 출력합니다.");
///////////////////////////////////////////////////////////
/*		for(int j=1;j<=lines;j++) {
			for(int i=1;i<=count;i++) {
				System.out.print(star);
			}
			System.out.println(); 
		}*/
///////////////////////////////////////////////////////////
		
		for(int j=1;j<=lines;j++) {
			for(int i=1;i<=j;i++) {
				System.out.print(star);
			}
			System.out.println();
		}
		 
		
///5개 찍어라
		/*
		 
	 &&&&* 
	 &&&*** 
	 &&***** 
	 &******* 
	 ********* 
		 
		 * */
		//피라미드
		for(int i=1;i<=lines;i++) { //lines번째 줄일때
			for(int j=1;j<=lines-i;j++) { //공백
				System.out.print(blank); 
			}
			for(int k=1;k<=i*2-1;k++) { //별 
				System.out.print(star);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
