package example_09_15_super;

public class Book extends Product {
	
	private String genre;
	private String title;
	private String writer;
	private String publisher;
	
	public Book() {
		// 모든 하위클래스의 생성자에는 부모의 기본 생성자 메소드를 호출하는 super();가 자동으로 추가된다.
		// 단, super()외의 다른 super(값, 값, ...) 메소드를 추가하면 super()가 자동으로 추가되지 않는다.
		super(); //가 생략되어 있다. 안적으면 자동으로 추가됨
	}
	
	public Book(int no, String genre, String title, String writer, String publisher, int price) {
		super(no, price);
		this.title = title;
		this.genre = genre;
		this.writer = writer;
		this.publisher = publisher;
	}
	public Book(int no, String genre, String title, String writer, String publisher, int price, int discoutnPrice) {
		// Product 객체의 Product(int, int, int)생성자를 호출한다.
		// super() 메소드는 언제나 생성자 메소드의 첫번째 수행문이어야 한다.
		// super() 메소드가 첫번째 수행문이어야 하는 이유은 언제나 상위 객체가 먼저 초기화되어야 하기 때문이다.
		// 이 생성자 메소드도 원래는 super(); 자동으로 추가되지만,
		// super(no, price, discoutnPrice);가 추가되었기 때문에 super();는 추가되지 않았다.
		super(no, price, discoutnPrice);
		this.title = title;
		this.genre = genre;
		this.writer = writer;
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public void printInfo() {
//		System.out.println("번  호: " + getNo());				// Product의 공개된(상속받은) getNo()로 번호 조회
		super.printInfo();
		System.out.println("장  르: " + genre);
		System.out.println("제  목: " + title);
		System.out.println("저  자: " + writer);
		System.out.println("출 판 사: " + publisher);
//		System.out.println("가  격: " + getPrice());				// Product의 공개된(상속받은) getPrice()로 가격 조회
//		System.out.println("할인가격: " + getDiscountPrice());	// Product의 공개된(상속받은) getDiscountPrice()로 할인가격 조회
		System.out.println();
	}
	
}
