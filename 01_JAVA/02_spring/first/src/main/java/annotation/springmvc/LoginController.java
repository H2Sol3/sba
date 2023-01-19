package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("login")
	public String loginform() {
		return "loginform";
	}

//	@PostMapping("login")
//	public ModelAndView loginprocess(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		ModelAndView mv = new ModelAndView();
//		// db로그인정상 확인
//		LoginDTO dto = new LoginDTO();
//		dto.setId(id);
//		dto.setPw(pw);
//		mv.addObject("loginresult", dto);
//		mv.setViewName("loginsuccess");
//		return mv;
//	}

//	@PostMapping("login")
//	public ModelAndView loginprocess(@RequestParam(value = "id2", required = false, defaultValue = "아이디") String id,
//			int pw) {
////		String id = request.getParameter("id");
////		String pw = request.getParameter("pw");
//		ModelAndView mv = new ModelAndView();
//		// db로그인정상 확인
//		LoginDTO dto = new LoginDTO();
//		dto.setId(id);
//		dto.setPw(String.valueOf(pw));
//		mv.addObject("loginresult", dto);
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
//	
	
	@PostMapping("login")
	public String loginprocess(@ModelAttribute("loginresult") LoginDTO dto) {
		return "loginsuccess";
	}
	
	@ModelAttribute("all")
	public String all() {
		return "모든 뷰에서 사용 가능합니다.";
	}
	
	
	

}












































