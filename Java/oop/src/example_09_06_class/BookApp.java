package example_09_06_class;

import java.util.Date;
public class BookApp {
	public static void main(String[] args) {
			
		/*
		 * Book 클래스(설계도)로 객체 생성하기
		 * 1. Book 클래스로 생성된 객체의 주소값을 담는 참조변수를 정의한다.
		 * 2. Book 클래스로 객체를 생성해서 참조변수에 주소값을 대입한다.
		 * 3. 주소값을 가지고 있는 참조변수를 이용해서 생성된 객체의 필드에 접근한다.
		 */
		
		// Book 클래스로 생성된 객체의 주소값을 저장하는 참조변수 정의
		Book book1;			//Book클래스로 부터 생성된 Book객체의 참조값을 받는 참조변수 book1을 생성
		Book book2;
		Book book3;
		
		// new 키워드를 사용해서 Book객체를 생성하고, 각각의 참조변수에 객체의 주소값을 저장하기
		book1 = new Book();			// new연산자로 부터 Book객체가 생성되고 객체의 주소값을 book1에 대입
		book2 = new Book();
		book3 = new Book();
		
		// 각각의 참조변수에 저장되어 있는 주소값 확인하기
		System.out.println("첫번째 책" + book1);		//example_09_06_class.Book@396f6598 가 출력됨
		System.out.println("두번째 책" + book2);		//example_09_06_class.Book@394e1a0f 가 출력됨
		System.out.println("세번째 책" + book3);		//example_09_06_class.Book@27a5f880 가 출력됨
		
		// 각각의 참조변수로 객체 사용하기
		book1.bookNumber = 100;					//참조변수 book1의 주소값이 가르키는 객체 Book에 있는 멤버변수field bookNumber에 100을 대입
		book1.genre = "컴퓨터";
		book1.title = "자바의 정석";
		book1.author = "남궁성";
		book1.publisher = "도우출판사";
		book1.price = 35000;
		book1.stock = 5;
		book1.pubDate = new Date();				// 참조변수 book1의 주소값이 가르키는 객체 Book에 있는 멤버변수field pubDate에 Date객체의 주소값을 대입
		
		book2.bookNumber = 200;
		book2.genre = "소설";
		book2.title = "수도원 기행";
		book2.author = "공지영";
		book2.publisher = "청우";
		book2.price = 15000;
		book2.stock = 2;
		book2.pubDate = new Date();
		
		book3.bookNumber = 300;
		book3.genre = "외국어";
		book3.title = "토익 기출문제";
		book3.author = "시사영어사";
		book3.publisher = "시사영어사";
		book3.price = 20000;
		book3.stock = 1000;
		book3.pubDate = new Date();
		
		// 참조변수로 객체의 필드에 저장된 값을 조회해서 출력해보기
		System.out.println(book1.title);			// 참조변수 book1의 주소값이 가르키는 객체 Book에 있는 멤버변수 title에 들어있는 값인 "자바의 정석"을 출력
		System.out.println(book2.title);
		System.out.println(book3.title);
	}
}
