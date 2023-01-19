package chap11;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4};
		int[][] arr2= {{1,2},{3,4,5},{6,7,8,9}};
		
		//배열 조회
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr2));

		
//		int[] arr_copy=Arrays.copyOf(arr,3);
		int[] arr_copy=Arrays.copyOfRange(arr,2,2);//2번인겍스ㅔ어서 2번까지
		System.out.println(Arrays.toString(arr_copy));
		System.out.println(Arrays.toString(arr));
		
		int[] arr10= {0,1,2,3,4};
		int[] arr20= {0,1,2,3,4};
		System.out.println(Arrays.equals(arr10, arr20));
		
		
		
		
	}

}
