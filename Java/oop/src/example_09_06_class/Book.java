package example_09_06_class;

import java.util.Date;

public class Book {
	/*
	 * 필드정의하기
	 * Book객체의 고유한 속성은 책번호, 장르, 제목, 저자, 출판사, 가격, 재고, 출판일이다.
	 */
	int bookNumber;
	String genre;
	String title;
	String author;
	String publisher;
	int price;
	int stock;
	Date pubDate;		//날짜를 나타낼때 쓰는 데이터
}
