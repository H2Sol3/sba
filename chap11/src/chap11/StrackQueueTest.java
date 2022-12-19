package chap11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StrackQueueTest {

	public static void main(String[] args) {

		
		Stack st = new Stack();//동적크기. 중복저장, 마지마구 저장 데이터를 우선 조회
		
		st.push(1);
		st.push(2);
		st.push(3);
	
		while(!st.isEmpty()) {//st가 비어있지않으면 반복적으로 삭제 필요하니꺄ㅏ while
			System.out.println(st.pop()); //곡대기 조회 후 삭제
//			System.out.println(st.peek()); //꼭대기 조회
		}
		
//		System.out.println(st.pop());//조회 후 삭제
//		System.out.println(st.pop());
//		System.out.println(st.pop());//1(stack x)
//		System.out.println(st.pop());//오류. 삭제할 내용 없음
		
		
		Queue qu = new LinkedList(); //동적크기. 중복저장, 가장 처음 저장 데이터를 우선 조회
		qu.offer(1);
		qu.offer(2);
		qu.offer(3);
		while(!qu.isEmpty()) {
			System.out.println(qu.poll()); //큐에서 데이터 조회 후 삭제
		}
	}

}
