package chap5;

public class ArrayTest {

	public static void main(String[] args) {
		int[] arr = new int[5];
//		System.out.println("arr배열의 길이= " + arr.length);
//		System.out.println("정수배열의 자동초기화값");
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//
//		System.out.println();
//		arr[0] = 10;
//		arr[1] = 20;
//		System.out.println("정수 배열의 사용자 저장값");
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (i + 1) * 10;
//			System.out.print(arr[i] + " ");
//		}
//
//		// 1-50까지 난수
//		System.out.println();
//		arr[0] = 10;
//		arr[1] = 20;
//		System.out.println("랜덤 정수 배열의 사용자 저장값");
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 50) + 1;
//			System.out.print(arr[i] + " ");
//		}
//
//		//최소값 찾기
//		System.out.println();
//		int min = 1000;
//		//ar==>[23, 49, 50, 1,5]
//		//=> min에 23저장 후 49와 비교 => [1000, 49, 50, 23, 5]/min=1이 됨
//	
//		for(int i=0;i<arr.length;i++) {
//			if(min>arr[i]) {//min과 arr[i]바꾸기
//				int temp =arr[i];
//				arr[i] =min; 
//				min = temp;
//			}
//			System.out.println(i+"번째 데이터 반복 후"+min);
//		}
//		System.out.println("최소값= "+min);
//	
//		
//		
//		//최소값 찾아서 배열 자리 바꾸기
//				System.out.println();
//				//ar==>[23, 49, 50, 1,5]
//				//=> min에 23저장 후 49와 비교 => [1000, 49, 50, 23, 5]/min=1이 됨
//			
//				for(int i=1;i<arr.length;i++) {
//					if(arr[0]>arr[i]) {//min과 arr[i]바꾸기
//						int temp =arr[0];
//						arr[0] = arr[i];
//						arr[i] =temp; 
//						min = temp;
//					}
//					System.out.println(arr[i]);
//				}
//				System.out.println("최소값= "+arr[0]);

//두번째 과제
//최소값 찾아서 오름차순 정렬 1 5 14 23 32				

		System.out.println();

		int min = 1000;
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
			}

		}
		for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i] + " ");
	}
	}
}
