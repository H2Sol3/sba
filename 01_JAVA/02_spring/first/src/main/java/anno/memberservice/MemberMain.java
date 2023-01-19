package anno.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("anno/memberservice/member.xml");
		MemberJanService service = factory.getBean("service1", MemberJanService.class);
		
		service.registerMember();

//		System.out.println("=======================================================");
//		String[] beanNames = factory.getBeanDefinitionNames();
//		for (String name : beanNames) {
//			System.out.println(name);
//		}
	}
}


