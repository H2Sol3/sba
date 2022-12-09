package test;

public class Test1 {

	public static void main(String[] args) {
		char star='*';
		char blank =' ';
		
		int lines = (int)(Math.random()*10)+1;
		
		System.out.println("1. 랜덤 별찍기");
		for(int i=1;i<=lines;i++) { //lines번째 줄일때
			for(int j=1;j<=lines-i;j++) { //공백
				System.out.print(blank); 
			}
			for(int k=1;k<=i*2-1;k++) { //별 
				System.out.print(star);
			}
			System.out.println();
		}
		
		
		int num = 0;
		for(int i=0;i<args.length;i++) {
			num=Integer.parseInt(args[i]);
		}
		System.out.println();
		System.out.println("2. args 별찍기");
		for(int i=1;i<=num;i++) { //lines번째 줄일때
			for(int j=1;j<=num-i;j++) { //공백
				System.out.print(blank); 
			}
			for(int k=1;k<=i*2-1;k++) { //별 
				System.out.print(star);
			} 
			System.out.println();
		}
	
	}

}
