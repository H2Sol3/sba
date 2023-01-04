package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/a")
public class AServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		System.out.println("최초의 서블릿 실행"); //서버 콘솔에 출력되는 형태
		PrintWriter out = resp.getWriter(); 
		resp.getWriter().println("<h1>hello output</h1>"); // 클라이언트 브라우저 출력
	} //서블릿은 HttpServlet을 꼭 상속받아야 함.
}
