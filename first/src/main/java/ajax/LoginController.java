package ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mybatis.MemberDTO;
import spring.mybatis.MemberService;

@Controller
public class LoginController {
	@Autowired
	MemberService service;
	
	@GetMapping("/loginajax")
	public String loginajax() {
		return "ajax/loginform";
	}

	@ResponseBody
	@PostMapping(value = "/loginajax", produces = { "application/json;charset=utf-8" })
	public String loginajax2(String id, String pw) {
		String result = null;
		if (id.equals("ajax") && pw.equals("1234")) {
			result = "login성공";
		} else {
			result = "login실패";
		}
		return "{ \"process\" : \"" + result + "\" }";
	}
	
	@ResponseBody
	@PostMapping(value = "/myinformajax", produces = {"application/json;charset=utf-8"})
	public MemberDTO myinfromajax(String id,String pw){
		MemberDTO dto = service.onemember(id);
		if(dto.getPw().equals(pw)) {
			return dto;			
		}else {
			return new MemberDTO();
		}
	}
	
//	@ResponseBody
//	@GetMapping(value = "/memberlistajax", produces = {"application/json;charset=utf-8"})
//	public List<MemberDTO> memberlistajax(String id,String pw){
//		List<MemberDTO> list = service.memberlist();
//		return list;
//	}
	
	@GetMapping(value = "/memberlistajax", produces = {"application/json;charset=utf-8"})
	public @ResponseBody List<MemberDTO> memberlistajax(String id,String pw){
		List<MemberDTO> list = service.memberlist();
		return list;
	}
	
	@GetMapping(value = "/paginglistajax/{page}", produces = {"application/json;charset=utf-8"})
	public @ResponseBody List<MemberDTO> paginglistajax(@PathVariable("page") int page){
		//page변수 1/2/3
		// select .. limit 0/3/6, 3
		int limit = (page - 1)*3;
		int[] limitarr = new int[] {limit, 3};
		List<MemberDTO> list = service.paginglist(limitarr);
		return list;
	}
}
























