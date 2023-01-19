package annotation.springmvc;

import org.slf4j.Logger;//로그와 관련된
import org.slf4j.LoggerFactory;  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogTestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/test")
	public void test() {
		logger.trace("trace 레벨 테스트");//1.  trace: 오류가 나든 안나든 계쏙 추적해줘
		logger.debug("debug 레벨 테스트");//2.
		logger.info("info 레벨 테스트");//3.
		logger.warn("warn 레벨 테스트");//4.
		logger.error("error 레벨 테스트");//5.
	}
	
}
