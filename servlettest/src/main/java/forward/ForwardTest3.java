package forward;

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

@WebServlet("/forward3")
public class ForwardTest3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward3?menu=memberlist&page=3 -> html form
		//forward3?menu=login
		String menu = request.getParameter("menu");
		if(menu.equals("memberlist")) {
			// 한 페이지당 출력 멤버수 = 4명
			//MemberDAO객체 생성
			//getMemberList() 호출-결과 리턴 (페이지 수도 넘기기)
			//forward4 속성으로 전달
			//forward4로 이동
			MemberDAO dao = new MemberDAO();
			RequestDispatcher rd = request.getRequestDispatcher("/forward4");
			ArrayList<MemberDTO> list = dao.getMemberList(Integer.parseInt(request.getParameter("page")),4);
			
			request.setAttribute("memberlist", list);
			
			rd.forward(request, response);
			
		}
		
		
	}
}