package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		TV tv = (TV)factory.getBean("tv2");
		TV tv1 = (TV)factory.getBean("tv2");
		TV tv2 = (TV)factory.getBean("tv2");
		tv.powerOn();
		tv.soundUp(10);
		tv.soundDown(4);
		tv.powerOff();

	}
}
