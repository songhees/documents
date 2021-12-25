package sample3;

public class Product {
	private int no;
	private String name;
	private String company;
	private int price;
	private int discountPrice;
	private boolean isOnSell;
	
	public Product() {}

	public Product(int no, String name, String company, int price, int discountPrice, boolean isOnSell) {
		super();
		this.no = no;
		this.name = name;
		this.company = company;
		this.price = price;
		this.discountPrice = discountPrice;
		this.isOnSell = isOnSell;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public boolean isOnSell() {
		return isOnSell;
	}

	public void setOnSell(boolean isOnSell) {
		this.isOnSell = isOnSell;
	}
}
