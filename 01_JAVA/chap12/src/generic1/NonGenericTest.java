package generic1;

class Apple {
	String origin;

	public Apple(String origin) {
		this.origin = origin;
	}

}

class Paper {
	String size;

	public Paper(String size) {
		this.size = size;
	}

}

//T는 클래스명 아니고 전달받는 type이라는 의미 - type매개변수
//Box - 원시타입
class Box<T> {
//	Object contents;
	T contents;

	public Box(T contents) {
		this.contents = contents;
	}

	public T getContents() {
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}

}

public class NonGenericTest {
	public static void main(String[] args) {
		Apple a = new Apple("대구");
		Paper p = new Paper("A4");
		Box<Apple> aBox = new Box(a);
		Box<Paper> pBox = new Box(p);

		System.out.println(aBox.contents.origin); // contents까지는 Object니까 origin쓰려면 형변환 필요
		System.out.println(pBox.contents.size);
//		Box xBox = new Box(new Wine("로제와인"));
	}

}
