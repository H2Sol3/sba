package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/insertdb")
public class InsertDBServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();

		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		dto.setAddress(request.getParameter("address"));

//		if (dto.getId().equals("")) {
//			out.println("id를 입력하세요");
//		} else if (dto.getPw().equals("")) {
//			out.println("pw를 입력하세요");
//		} else {
			MemberDTO dto2 = dao.getMember(request.getParameter("id"), request.getParameter("pw"));
			if (dto2 == null) {
				int result = dao.insertMember(dto);
				out.println(result + "명 저장 완료");
			} else if (dto.getId().equals(dto2.getId())) {
				out.println("id 중복");
			}

		}

	}
//
//}
