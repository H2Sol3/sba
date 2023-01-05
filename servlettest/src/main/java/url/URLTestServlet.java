package url;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URLTestServlet는 홈페이지 시작화면으로 사용할 것. 어떤 url이든 모두 URLTestServlet을 거쳐가야함!!!!!!!!!!!
@WebServlet("/*")
public class URLTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://ip:port/servlettest/board-> boardwriting 
		// http://ip:port/servlettest/member -> forward4
		// http://ip:port/servlettest/product -> 없습니다.

//		System.out.println(request.getRequestURI());
//		URL: Uniform Resource locaion 주소 전체를 다 포함하고 있는 것**
//		URI :   해당 서버 내부의 경로만 포함**
		String uri = request.getRequestURI();
		String uri_arr[] = uri.split("/");
		String forward_uri = uri_arr[uri_arr.length-1];
		System.out.println(forward_uri);

		if (forward_uri.equals("board")) {
			forward_uri = "boardwriting";
			RequestDispatcher rd = request.getRequestDispatcher(forward_uri);
			rd.forward(request, response);
			
		} else if (forward_uri.equals("member")) {
			forward_uri = "forward4";
			RequestDispatcher rd = request.getRequestDispatcher(forward_uri);
			rd.forward(request, response);
			
		} else {
			System.out.println("이동 url이 없습니다.");
		}
		
	}

}
