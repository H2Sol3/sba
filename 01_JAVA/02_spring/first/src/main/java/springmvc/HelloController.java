package springmvc;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); //request.setAttribute("model", dto); 같은 의미
		mv.setViewName("hello"); //뷰 이름만 전달해주기
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
