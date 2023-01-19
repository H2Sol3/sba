package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	@RequestMapping("/hello")
	public ModelAndView a() {
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); //request.setAttribute("model", dto); 같은 의미
		mv.setViewName("hello"); //뷰 이름만 전달해주기
		return mv;
		
		//request.setAttribute("model", dto);	
	}
	
	
	@RequestMapping("/hello2")
	public String b() { //매핑메서드리턴타입 String--model없고 -jsp이름
		return "hello"; // WEB-INF/views/?.jsp
	}
	
	@RequestMapping("/hello3")
	public void c() {//매핑메서드리턴타입 String--model없고 -jsp이름 자동url 동일. hello3.jsp
		
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
