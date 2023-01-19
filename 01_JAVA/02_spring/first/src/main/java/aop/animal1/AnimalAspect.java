package aop.animal1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnimalAspect {
	@Pointcut("execution (public String aop.animal2.*.lunch()) ")
	public void a() { }
	
	@Around("a()")
	public void around(ProceedingJoinPoint p) {
		System.out.println("오늘은 뭐 먹을거예요");
		try {
			String target = p.getTarget().toString();
			String[] names = target.split("@")[0].split("\\.");
			String classname = names[names.length - 1];

			Object o = p.proceed();

			System.out.println(classname + "-" + o + "먹었군요.");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

//	@Around("pc()")
//	public void a(ProceedingJoinPoint joinpoint) {
//		try {
//			Dog dog = new Dog();
//			dog.lunch();
//		}catch (Throwable e) {
//			e.printStackTrace();
//		}
//	}
}
