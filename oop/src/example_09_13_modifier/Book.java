package example_09_13_modifier;

import java.util.Date;

public class Book {
	
	//멤버 변수 -  완전 비공개
	private int no;
	private String title;
	private String writer;
	private String publisher;
	private int price;
	private int discountPrice;
	private int stock;
	private Date pubDate;
	
	// 기본 생성자 - 완전 공개
	public Book() {}

	public int getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPrice() {
		return price;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public int getStock() {
		return stock;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	//public Book(int no, String title, String writer, String publisher, int price)
	

	
}
