package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("service2")
	MemberService service; //MemberBasicService 객체
	
	@GetMapping("/register")
	String insertMember(){
		return "member/register"; // member/register.jsp(7개 데이터 읽어오기)
	}
	
	@PostMapping("/register")
	ModelAndView insertMember(@ModelAttribute("dto") MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		// 1. dto 내부에 입력된 id와 pw 확인 / spring 1111인지 검사
		// 2-1. 맞으면 이전 가입된 적이 있습니다. spring회원님은 정상 로그인되셨습ㄴㅣ다. (=모델)
		// 2-2. 아니면 dto 모든 변수값 출력. 회원가입되셨습니다. (=모델)
		// 3. 
		String result = service.registerMember(dto);
		mv.addObject("result", result);
//		mv.addObject("dto",dto);
		mv.setViewName("member/registersuccess");			
		return mv; 
	}
	
	@GetMapping("/member")
	String start() {
		return "member/memberhobby";
	}
	
	@PostMapping("/member")
	ModelAndView start(String id, int password, int age, String[] hobby) {
		ModelAndView mv = new ModelAndView();
		String result = service.end(age);
		mv.addObject("result", result);
		mv.addObject("id",id);
		mv.addObject("age",age);
		mv.addObject("hobby",hobby);
		mv.setViewName("member/memberhobbyresult");
		return mv;
	}
	
}










