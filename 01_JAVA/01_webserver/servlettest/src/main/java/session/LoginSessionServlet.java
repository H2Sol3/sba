package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginsession")
//@WebServlet("/login/*") ⇒ http://ip:port/servlettest/login/#$@#%$^#$
//@WebServlet("/*") //
public class LoginSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		//요청을 보낸 브라우저 내부에 세션이 있는지 확인(최초 요청이니? 두번째 이후 요청이니?)
		// true => 이전에 생성된 session정보 대체
		// false => 최초 요청이니 새로 session 만둘어주기
		HttpSession session =  request.getSession();
		
		session.setAttribute("sessionid", id);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(id!=null&&pw!=null) {
			out.println("<h1>로그인 하셨습니다.</h1>");
			out.println("<h1>사용 가능한 메뉴는 다음과 같습니다.</h1>");
			out.println("<h1><a href='bank'> 은행 업무 보기</a></h1>");
			out.println("<h1><a href='mypage'> 내 정보 보러 가기 </a></h1>"); 
			out.println("<h1><a href='boardwriting'> 글 쓰러 가기</a></h1>");
			out.println("<h1><a href='logout'> 로그아웃하러 가기</a></h1>");
			out.println("<h1>로그인 정보 유효 시간은"+session.getMaxInactiveInterval()+"초 입니다.</h1>");
		}else {
			out.println("<h1>로그인한 적이 없습니다.</h1>");			
		}
		
		
	} 

}
