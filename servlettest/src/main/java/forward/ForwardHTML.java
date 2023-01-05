package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForwardHTML")
public class ForwardHTML extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FORWARD시 서버 내부 같은 어플리케이션 내부 파일 이동
		System.out.println("클라이언트는 "+request.getRequestURI()+" 호출하셨습니다.");
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}
