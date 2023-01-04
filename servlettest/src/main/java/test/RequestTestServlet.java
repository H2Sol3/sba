package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/servlettest/request
@WebServlet("/request")
public class RequestTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath()); // 현재 서블릿이 동작하고있는 웹프로젝트 이름 /servlettest
		System.out.println(request.getMethod()); // 서블릿의 메서드 GET
		System.out.println(request.getRequestURI()); // 서버ip와 포트번호를 제외한 나머지 /servlettest/request
		System.out.println(request.getServletPath()); // 설정했던 서블릿 매핑 이름 /request
		System.out.println(request.getRemoteAddr()); // ip v6방식 0:0:0:0:0:0:0:1
		
		
		//응답
		response.setContentType("text/html;charset=utf-8"); //이 내용은 html태그를 포함하고 있는 텍스트 라는 의미
		PrintWriter out = response.getWriter(); //응답 가능 
		out.println("<h1>hello output</h1>");
		out.println("<h1>안녕 클라이언트</h1>");
		out.println("<script src='/"+
				request.getContextPath()+"/jquery-3.6.1.min.js'>hello output2</script>"); 
		// 경로 앞에 /시작하면 포트번호까지 알려줌. 대신 현재 프로젝트 이름이 아리까리한 경우 저렇게 request.getContextPath() 넣어줌
		
		
		
		
	}

}
