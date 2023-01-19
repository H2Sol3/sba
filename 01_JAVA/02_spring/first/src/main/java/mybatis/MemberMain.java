package mybatis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {
	public static void main(String[] args) throws IOException {
		//mybatis/mybatis-config	.xml 읽어와야 함.
		//1. mybatis설정파일 읽을 객체 준비
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//2. mybatis-config.xml 설정대로 연결
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		//3. db connection 생성
		SqlSession session = factory.openSession(true); // => db connection & true=> autocommit을 true로 변경해줌. 기본값 false
//		//4. sql-mapping.xml id=memberlist 정의한 sql 호출
//		List<MemberDTO> memberlist = session.selectList("member.memberlist");
//		//5. 조회
//		for(MemberDTO m : memberlist) {
//			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName());
//		}

		MemberDAO dao = new MemberDAO();
		dao.setSession(session);
		
		MemberService service = new MemberServiceImpl();
		((MemberServiceImpl)service).setDao(dao);
		
		/////////////////////////////////////////////////////////////////////////////
		//main은 service한테 시키면 된다!!!!!
// test1 => 리스트 조회하기
//		List<MemberDTO> list = service.memberlist();
//		for(MemberDTO m : list) {
//			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName());
//		}
//		
//		System.out.println("///////////////////////////////////////////////////////////////////////////////////");
// test2 => int 조회
//		System.out.println("전체 회원 수= "+service.membercount()+"명");
//		
//		System.out.println("///////////////////////////////////////////////////////////////////////////////////");
// test3 => 조회(입력 파라미터 존재, 결과는 MemberDTO 타입)
//		MemberDTO m = service.onemember("coca89");
//		if(m != null) {
//			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName());			
//		}else {
//			System.out.println("id 이상해서 값 없어!!!!!!!!!!");
//		}
//		

		//test4 => 페이징처리 리스트 조회
		int[] limit = {0,3};//배열로 넘기기
		List<MemberDTO> list = service.paginglist(limit);
		for(MemberDTO m : list) {
			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName());		
		}
		
		
		//test5
//		MemberDTO insertdto = new MemberDTO();
//		insertdto.setId("mybatis");
//		insertdto.setPw("mybatis");
//		insertdto.setName("박대한");
//		insertdto.setPhone("01012345678");
//		insertdto.setEmail("A@b.com");
//		insertdto.setAddress("용산시 용산구");
//		service.insertmember(insertdto);
		
		
		//test6
		//id=mybatis, name="박한국" phone=01087654321 email=mybatis@b.com
		//updatemember sql실행
//		MemberDTO updatedto = service.onemember("mybatis");
//		updatedto.setName("박한국");
//		updatedto.setPhone("01087654321");																																					
//		updatedto.setEmail("mybatis@b.com");
//		service.updatemember(updatedto);
//		
		
		
		//test7
		//id=mybatis 삭제
//		MemberDTO deletedto = service.onemember("mybatis");
//		service.deletemember(deletedto);
		
		
		//test8-map
//		HashMap<String, String> map = new HashMap();
//		map.put("colname", "indate");
//		map.put("colvalue", "2023%");
//		//select * from member where ${colname} like ${colvalue}
//		List<MemberDTO> searchlist = service.searchmember(map);
//		
//		for(MemberDTO m:searchlist) {
//			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName()+":"+m.getIndate());		
//		}
		
		
		
		
//		test9
		//select from member with where address in('서울시 용산구', '제주시 용산구', '부산시 xxx');
//		<foreach collection="list" item="addr" open="
//		
//		ArrayList<String> addresslist = new ArrayList();
//		addresslist.add("서울시 용산구");
//		addresslist.add("제주시 용산구");
//		addresslist.add("서울시 중구");
//		List<MemberDTO> resultlist = service.addresssearch(addresslist);
//		for(MemberDTO m :resultlist) {
//			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName()+":"+m.getIndate());		
//		}
		
		
		//test10
//		MemberDTO dto = new MemberDTO();
//		dto.setName("박한국");
//		dto.setEmail("mybatis@b.com");
//		List<MemberDTO> resultlist = dao.combination(dto);
//		
//		for(MemberDTO m :resultlist) {
//			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName()+":"+m.getIndate());		
//		}
		
		
//		-- maria 회원이 작성한 글 정보조회
//		-- id, 이름, 글제목, 글내용, 작성시간 조회
		
		//test11 - join시 resultmap
		List<HashMap<String, String>> boardlist = service.memberboard("maria");
		for(HashMap map : boardlist) {
			Set<String> keys = map.keySet(); //map에 들어가는 key 만 모아둠
			for(String s : keys) {
				System.out.println(s+" : "+map.get(s));
			}
			System.out.println();
		}
		
		
		//1. id 회원이 작성글이 있는지 검사
		//2. 글이 있으면 사용자 탈퇴전에 글도 삭제하시겠습니까? y/n만 입력
		//3-1. 사용자 탈퇴
		//3-2. 탈퇴 취소
		Scanner scan = new Scanner(System.in);
		MemberDTO dto = new MemberDTO();
		
		List<HashMap<String, String>> boardlist2 = service.memberboard("mysql");
		if(boardlist2 != null) {
			System.out.println("사용자 탈퇴 전에 글도 삭제하시겠습니까?");
			String answer = scan.nextLine();
			if(answer.equals("y")) {
//				service.deletBoard("mysql");
				service.deletemember("mysql");
			}else if(answer.equals("n")) {
				System.out.println("탈퇴 취소");
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
}
