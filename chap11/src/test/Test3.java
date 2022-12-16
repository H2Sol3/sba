package test;

//3. 
//main
//String data = "지금 저는 ㅋㅋㅋ 수업중입니다. 정말요? 과제물도 ㅎㅎㅎ 하고 있구요.";
//String delResult2 = deleteChar(data, new String[]{".", "ㅋ", "ㅎ","?", " "});
//System.out.println("===> " + delResult2);
//===> 지금저는수업중입니다정말요과제물도하고있구요
//
//deleteChar 구현메소드

public class Test3 {

	public static void main(String[] args) {
		String data = "지금 저는 ㅋㅋㅋ 수업중입니다. 정말요? 과제물도 ㅎㅎㅎ 하고 있구요.";
		String delResult2 = deleteChar(data, new String[] { ".", "ㅋ", "ㅎ", "?", " " });
		System.out.println("===> " + delResult2);
	}

	// replace
	static String deleteChar(String data, String[] strings) {// ???????????????????????????
		for (String s : strings) {
			data = data.replace(s, "");
		}
		return data;
	}
}