package test;
//서블릿+MemberDAO+MemberDTO+JSP
//
//1. 서블릿 요청한다?id=admin&menu=memberlist&page=1
//2. id=admin이고 menu=memberlist이면 
//  
//  db member테이블의 1페이지 회원 정보를 가져온다.
//  
//3. jsp파일에서 회원정보리스트를 출력한다.
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/listservlet")
public class InputServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		String id = request.getParameter("id");
		String menu = request.getParameter("menu");
		int pageNum = Integer.parseInt(request.getParameter("page"));
		
		if(id.equals("admin")&&menu.equals("memberlist")) {
			ArrayList<MemberDTO> arr = dao.getMemberList(pageNum, 3);
			RequestDispatcher rd = request.getRequestDispatcher("memberList.jsp");
			request.setAttribute("arr", arr);
			rd.forward(request, response);
		}
		
		
	}

}