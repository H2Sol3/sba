package member_crud;

public class MemberDeleteView implements View {

	@Override
	public void input() {
		MemberDAO dao = new MemberDAO();
		OneSelectView view = new OneSelectView();
		view.input();
		MemberDTO dto = view.getDto(); // 입력한 dto값 가져오기

		if (dto == null || dto.getPw() == null) {
			return;
		}

//		dao.insertDeleteMember(dto);
		dao.deleteMember(dto.getId());
		System.out.println(dto.getId() + "탈퇴 완료");

	}

}
