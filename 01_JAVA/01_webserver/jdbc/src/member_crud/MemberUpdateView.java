package member_crud;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MemberUpdateView implements View {

	@Override
	public void input() {
		OneSelectView view = new OneSelectView();
		view.input();
		MemberDTO dto = view.getDto(); // 멤버변수로 빼둔 dto값 가져오기

		Scanner key = new Scanner(System.in);
		System.out.println("수정항목 입력(암호-이름-메일-폰-주소 순서와 양식에 맞게 입력하세요)");
		String updateValue = key.nextLine(); // 공백이 나오면 읽기 중단.

		String[] updateArr = updateValue.split("-");
		String[] updateColumn = { "pw", "name", "email", "phone", "address" };

		HashMap<String, String> updateMap = new HashMap<String, String>();

		for (int i = 0; i < updateArr.length; i++) {
			if (!updateArr[i].equals(" ")) {
				updateMap.put(updateColumn[i], updateArr[i]); //수정할 항목 전달
			}
		}

		// 잘 들어갔는지 확인 용도
//		Set<String> keys = updateMap.keySet(); // key값만 읽어옴
//		for (String k : keys) {
//			System.out.println(k + ":" + updateMap.get(k)); map은 순서가 없음.
//		}
		
		if(dto == null || dto.getPw() == null) {
			return; //메서드 끝내기
		}
		updateMap.put("id",dto.getId()); //수정한 항목이 누구꺼인지 전달
		MemberDAO dao = new MemberDAO();
		dao.updateMember(updateMap);
		
	}

}
