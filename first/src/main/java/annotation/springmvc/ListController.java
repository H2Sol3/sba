package annotation.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> list = new ArrayList();
		ModelAndView mv = new ModelAndView();
		ListDTO dto = new ListDTO();
		list.add("홍길동");
		list.add("김길동");
		list.add("박길동");
		list.add("이길동");
		list.add("장길동");
		dto.setList(list);
		
//		mv.addObject("memberlist", list);
		mv.addObject("model", dto); //request.setAttribute("model", dto); 같은 의미
		mv.setViewName("list"); //뷰 이름만 전달해주기
		return mv;
		
		//request.setAttribute("model", dto);	
	}
	
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		//model설정
//		HelloDTO dto = new HelloDTO();
//		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
//		request.setAttribute("model", dto);
//		
//		//view설정
//		return "hello.jsp"; //${model.message}
//	}

}
