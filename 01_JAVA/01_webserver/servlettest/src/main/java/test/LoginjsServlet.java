package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginjs")
public class LoginjsServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // post방식일때만 필요!!!
		String id = request.getParameter("id"); 
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		String output ="";
		
		if(id==null||id.equals("")) { //로그인 안 한 경우
			id="손님";
		}
		
		if(role.equals("admin")) {
			output="<h1>" + id + " 관리자님 환영합니다.</h1>";
		}else { //user
			output="<h1>" + id + " 회원님 환영합니다.</h1>";
		} 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(output);
		out.println("<a href='delete_db.html?id="+id+"'>회원탈퇴</a>");
		
	}
} 