package aop.animal2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnimalAspect {
		
	public void around(ProceedingJoinPoint p) {
		System.out.println("오늘은 뭐 먹을거예요");		
		try {
			String target = (String)p.getTarget();
			String[] names = target.split("@")[0].split("\\.");
			String classname = names[names.length-1];
			
			Object o = p.proceed();
			
			System.out.println(classname + "-" + o + "먹었군요.");			
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
				
	}
	
//	@Around("pc()")
//	public void a(ProceedingJoinPoint joinpoint) {
//		try {
////			Dog dog = new Dog();
////			dog.lunch();
//		}catch (Throwable e) {
//			e.printStackTrace();
//		}
//	}
}



















