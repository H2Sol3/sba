package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward1")
public class ForwardTest1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("upperid", id.toUpperCase()); //추가할 정보가 있으면 사용
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.println("<h1>forwardtest1 클래스입니다</h1>"); 
//		out.println("<h1>" + request.getAttribute("upperid") + "회원님 반갑습니다.</h1>");
		
		RequestDispatcher rd = request.getRequestDispatcher("/forward2");
		rd.forward(request, response);
		out.println("<h1>forwardtest1 클래스입니다</h1>"); 
	}
}




