package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		위 3문장은 항상 작성하기
		
		// 1. 요청 정보 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id == null || pw == null) {
			out.println("필요 정보를 모두 입력하세요");
			out.close();
		}
		// 2. 로그인 처리-jdbc
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id,pw); //getmember랑 패키지가 달라서 오류. dao 메서드에 public 붙여주면 해결됨.
		out.println(dto);
		// 3. 정상 로그인 / 암호 재입력 / 회원가입 대상
//		dto id,pw 저장 완료
//		dto id저장, pw null
//		dto null
		String result ="";
		if(dto != null && dto.getPw()!=null) {
			result = id + "회원님 정상 로그인되셨습니다.";
		}else if(dto != null && dto.getPw() == null){ //회원이긴한데 암호를 잘못 입력한 경우
			result = id+"회원님으로서 인증되지 않았습니다.<a href='login_db.html'>다시 로그인하러 가기";
		}else if(dto == null){
			result = id+"회원가입되지않았습니다.<a href='insert_db.html'>회원가입 하러 가기</a>";
		}
		
		out.println(result);
		
	}

}
