package chap11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

	public static void main(String[] args) {
		String[] animals = {"0-lion","cat",":dog","snake","tiger"};
		//사전순서
		//숫자 > 특수문자일부 > 대문자 > 소문자 > 한글 -> 오름차순
		Arrays.sort(animals);
		System.out.println(Arrays.toString(animals));
		
		//내림차순
		class MyComparator implements Comparator{

			@Override
			public int compare(Object o1, Object o2) {
				if(!(o1 instanceof String && o2 instanceof String)) {
					return -1;					
				}
				String s1 = (String)o1;
				String s2 = (String)o2;
				return s1.compareTo(s2)*-1;
			}
			
		}
		MyComparator mc = new MyComparator();
//		System.out.println(mc.compare("abc","def"));//음수
//		System.out.println(mc.compare("def","abc"));//양수
//		System.out.println(mc.compare("abc","abc"));//0
		Arrays.sort(animals, mc);
		System.out.println(Arrays.toString(animals));
		
		
		
	}

}
