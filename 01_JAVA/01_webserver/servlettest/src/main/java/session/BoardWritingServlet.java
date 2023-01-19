package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardwriting")
public class BoardWritingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청을 보낸 브라우저 내부에 세션이 있는지 확인(최초 요청이니? 두번째 이후 요청이니?)
		// true (두번째 이후 요청)이면 이전 생성 session 공유
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 로그인id 공유
		if (session.getAttribute("sessionid") != null) {
			String output = "<h1>글쓰기폼</h1>";
			output += "<table border=3>";
			output += "<tr><td>제목</td><td><input type=text name=title></td></tr>";
			output += "<tr><td>내용</td><td><textarea name=contents rows=5 cols=50></textarea></td></tr>";
			output += "<tr><td>작성자</td><td><input type=text name=writer readonly " + "value="
					+ session.getAttribute("sessionid") + "></td></tr>";
			output += "</table>";
			out.println(output);
		} else {
			out.println("<h1><a href='loginsession?id=test&pw=1111'>로그인</a> 먼저 하세요. 그래야 글쓰기 가능합니다.</h1>");
		}

	}
}