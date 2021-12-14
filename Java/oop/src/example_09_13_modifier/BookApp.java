package example_09_13_modifier;

import java.util.Date;

public class BookApp {
	public static void main(String[] args) {
		Book book1 = new Book();
		
		// book1참조변수가 참조하는 객체의 no, title, writer, publisher, price, discountPrice, stock, pubDate변경하기
//		book1.no = 100;						// 멤버변수 완전 비공개 -  접근 불가
//		book1.title = "자바의 정석";
		
		// book1참조변수가 참조하는 객체의 setter 메소드를 사용해서 객체의 멤버변수 값 변경하기
		book1.setNo(100);
		book1.setTitle("자바");
		book1.setWriter("남궁성");
		book1.setPublisher("동원");
		book1.setPrice(30000);
		book1.setDiscountPrice(28000);
		book1.setStock(10);
	
		Date date = new Date();
		book1.setPubDate(date);
		
		
		System.out.println(book1.getNo());
		System.out.println(book1.getTitle());
		System.out.println(book1.getWriter());
		System.out.println(book1.getPublisher());
		System.out.println(book1.getPrice());
		System.out.println(book1.getDiscountPrice());
		System.out.println(book1.getStock());
		System.out.println(book1.getPubDate());
		
		
	
	
	}
}
