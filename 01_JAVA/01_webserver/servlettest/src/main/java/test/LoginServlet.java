package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginprocess")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// login.html(id,pw)
		
		String id = request.getParameter("id"); // 클라이언트가 보낸 정보 읽어오기
		
		if(id != null &&id.equals("")) {
			System.out.println(id.equals("servlet"));//근데 왜 servler????		
		}
		
		String pw = request.getParameter("pw");

		// select multiple 속성이 true일때, input타입이 checkbox일때!!!!!!!!
		String title[] = request.getParameterValues("title"); // getParameterValues: 배열

		// id,pw( -> member테이블에서 확인)

		response.setContentType("text/html;charset=utf-8"); // 인코딩 필요
		PrintWriter out = response.getWriter();
		out.println("<h1>" + id + " 회원님 환영합니다.</h1>");
		out.println("<h1>" + pw + " 암호를 입력하셨습니다.</h1>");
		for (String t : title) { // 배열이니까
			out.println("<h1>" + t + "을 선택하셨습니다.</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println("POST");
		request.setCharacterEncoding("utf-8"); // post방식일때만 필요!!!get일때는 필요 없음
		doGet(request,response);
	}
}