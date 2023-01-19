package chap12;

class Apple {
	String origin;

	public Apple(String origin) {
		super();
		this.origin = origin;
	}

}

class Paper {
	String size;

	public Paper(String size) {
		this.size = size;
	}

}

class Box {
	Object contents;

	public Box(Object contents) {
		this.contents = contents;
	}

	public Object getContents() {
		return contents;
	}

	public void setContents(Object contents) {
		this.contents = contents;
	}

}

public class NonGenericTest {
	public static void main(String[] args) {
		Apple a = new Apple("대구");
		Paper p = new Paper("A4");
		Box aBox = new Box(a);
		Box pBox = new Box(p);

		System.out.println(((Apple) aBox.contents).origin); // contents까지는 Object니까 origin쓰려면 형변환 필요
		System.out.println(((Paper) pBox.contents).size);

	}

}
