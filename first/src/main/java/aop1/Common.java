package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	long start = 0;
	public void a() {
		start = System.currentTimeMillis();
		System.out.println("===> a메서드는 핵심관심 이전에 호출: " + new Date(start));
	}
	public void b() {
		System.out.println("===> b메서드는 핵심관심 이후에 호출: " + (System.currentTimeMillis() - start) + " 소요시간(1/1000초)");
	}
	//이전+타켓클래스정보+이후 모두
	public void c(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("===> c메서드는 핵심관심 이전에 호출: ");
			System.out.println("타겟클래스객체 = " + joinpoint.getTarget());
			System.out.println("타겟메서드 = " + joinpoint.toLongString());
			Object [] args = joinpoint.getArgs();
			for(Object o : args) {
				System.out.println("매개변수 = " + o);
			}
			Object returnVal = joinpoint.proceed();
			if(returnVal != null) {
				System.out.println("리턴값 = " + returnVal);				
			}
			System.out.println("===> c메서드는 핵심관심 이후에 호출: ");
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
