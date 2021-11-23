package example_09_13_modifier;

public class BookApp2 {
	public static void main(String[] args) {
		// Book객체의 주소값을 3개 저장할 수 있는 배열을 생성한다.
		Book[] books = new Book[3];
		
		// 아래의 코드 3회 반복, for문 사용하지 말고 그냥 3번 코딩하세요
		// Book객체를 생성하고, setter 메소드를 사용해서 멤버변수에 책정보를 저장한다.
		
		Book b1 = new Book();
		b1.setTitle("이것이 자바다");
		b1.setWriter("남궁성");
		b1.setPublisher("도우출판사");
		b1.setPrice(30000);
		b1.setDiscountPrice(27000);
		
		Book b2 = new Book();
		b2.setTitle("이것이 자바다");
		b2.setWriter("신용권");
		b2.setPublisher("한빛미디어");
		b2.setPrice(35000);
		b2.setDiscountPrice(32000);

		Book b3 = new Book();
		b3.setTitle("맵리듀스 디자인패턴");
		b3.setWriter("도널드 마이너");
		b3.setPublisher("한빛미디어");
		b3.setPrice(28000);
		b3.setDiscountPrice(25600);
		
		// 생성된 Book객체의 주소값을 배열의 n번째에 저장한다.
		books[0] = b1;		// b1에 저장되어 있는 객체 Book의 주소값을 books[0]에 복사한다.
		books[1] = b2;
		books[2] = b3;
		
		// 향상된 for문을 사용해서 배열에 저장된 책정보를 콘솔에 출력한다.
		// 제목, 저자, 출판사, 가격, 할인정보를 출력한다.
		for (Book book : books) {			//book 참조변수에 books가 참조하는 배열객체에 있는 각각의 Book객체의 주소값을 복사대입받는는다.
			System.out.println(book.getTitle());	//주소값에 있는 Book객체의 getTitle메소드의 반환값인 title에 있는 값을 출력한다.
			System.out.println(book.getWriter());
			System.out.println(book.getPublisher());
			System.out.println(book.getPrice());
			System.out.println(book.getDiscountPrice());
			System.out.println();
		}	
	// 배열의 0번째칸이 참조하고 있는 Book객체의 책 제목을 변경하기
		b1.setTitle("자바의 정석 2판");
		books[0].setTitle("자바의 정석2판");
		
		Book book = books[0];
		book.setTitle("자바의 정석 2판");
	// 배열의 0번째칸이 참조하고 있는 Book객체의 할인가격을 변경하기
		b1.setDiscountPrice(25000);
		books[0].setDiscountPrice(25000);
		book.setDiscountPrice(25000);
		
		// 배열의 0번째칸이 참조하고 있는 Book객체의 변경된 값 출력하기
		System.out.println("### 배열의 0번째칸이 참조하고 있는 Book객체의 변경된 값 출력하기");
		System.out.println(b1.getTitle());
		System.out.println(books[0].getTitle());
		System.out.println(book.getTitle());
		
		// 결론 b1, books[0], book은 같은 주소값을 가지고 있다.
		System.out.println(b1);
		System.out.println(books[0]);
		System.out.println(book);
		// 일련번호 보기 (주소값이 아님)
		
	}
}
