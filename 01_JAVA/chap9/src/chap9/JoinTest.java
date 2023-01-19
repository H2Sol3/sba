package chap9;

import java.util.StringJoiner;

public class JoinTest {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };
		String arr2[] = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr2[i] = String.valueOf(arr[i]); // int배열을 String으로 변환. join은 String만 가능해서
			// String -> int => Integer.parseInt("")
			// int -> String => String.valueOf(1)
		}
		System.out.println();

		// 방법1
		System.out.println(String.join(" - ", arr2));

		// 방법2
		StringJoiner sj = new StringJoiner(" - ", "(", ")");
		for (int i = 0; i < arr.length; i++) {
			sj.add(String.valueOf(arr[i]));// 1 - 2 - 3 - 4 - 5 - 6
		}
		System.out.println(sj.toString());

	}

}
