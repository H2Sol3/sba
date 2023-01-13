package aop2;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Board {
	public void insert(int seq) {
		System.out.println(seq + " 번째 게시물을 저장합니다.");
	}

	public ArrayList<String> getList() {
		ArrayList<String> list = new ArrayList();
		list.add("게시물1");
		list.add("게시물2");
		list.add("게시물3");
		list.add("게시물4");
		list.add("게시물5");
		return list;
	}
}
//aop1패키지 모든 클래스의 모든 메서드 실행 이전에 a메서드 나오게 구성해보기 - spring한테 시키기=> xml / @
//<bean id="common" class="aop1.Common" />
//<aop:config>
//	<aop:pointcut expression="(public aop1.*.*(..))" id="pc" />
//	<aop:aspect id="aopaspect". ref="common" />
//	<aop:before method="a" pointcut-ref="pc" />
//</aop:config>
