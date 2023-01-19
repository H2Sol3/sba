package board;

//board 패키지 내에서만 사용 가능
class OneBoard { // 게시물 1개 정보 저장 객체
	private int seq;
	private String title;
	private String contents;
	private String writer;
	private int viewcount;
	
	//변수는 private, getter,setter는 public
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	//setter(저장 수정)/getter(조회)
//	public void setSeq(int seq) {
//		this.seq = seq; // 구현 외부오픈X
//	}
//
//	public int getSeq() {
//		return seq * 10;// 구현 외부오픈X
//	}

	
	
	
}

