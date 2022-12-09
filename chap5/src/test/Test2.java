package test;

public class Test2 {

	public static void main(String[] args) {
		// 입력변수 최소5개~ 최대 10개
		// 45 89 100 23 234 567 
		// 오름차순 정렬
		
		System.out.println("1. 랜덤 숫자 오름차순 정렬");
		System.out.println();
		int[] arr = new int[args.length];
		System.out.print("출력 내용: ");
		if(args.length>=5 && args.length<=10) {
			for (int i = 0; i < arr.length; i++) { // 랜덤 생성
				arr[i] = (int) (Math.random() * 50) + 1;
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <i; j++) {
					// 12 8 24 3 5
					if (arr[i] < arr[j]) {
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}//j
				
			}//i
			System.out.print("정렬 내용: ");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i] + " ");
			} //출력 for
					
			 
			System.out.println();
			System.out.println("\n2. args 숫자 오름차순 정렬");
			
			System.out.print("출력 내용: ");
			for (int i = 0; i < arr.length; i++) { // 랜덤 생성
				arr[i] = Integer.parseInt(args[i]);
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <i; j++) {
					// 12 8 24 3 5
					if (arr[i] < arr[j]) {
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}//j
				
			}//i
			System.out.print("정렬 내용: ");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i] + " ");
			} //출력 for
			
		}else{
			System.out.println("조건이 맞지 않음");
		}
		
		
		
		

	}//main
}//class
