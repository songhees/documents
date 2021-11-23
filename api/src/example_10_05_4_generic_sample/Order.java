package example_10_05_4_generic_sample;

import java.util.Date;

public class Order {
	
	private int no;				// 주문번호
	private String userId;		// 주문자 아이디
	private String productType;	// 주문 상품 구분("도서", "티켓")
	private int productNo;		// 주문 상품번호(책번호, 혹은 티켓번호)
	private int amount;			// 주문 수량
	private String status;		// 주문 상태(결재완료, 취소)
	private Date orderDate; 	// 주문 날짜
	private Date cancelDate; 	// 취소 날짜
	
	public Order() {}

	public Order(int no, String userId, String productType, int productNo, int amount, String status) {
		super();
		this.no = no;
		this.userId = userId;
		this.productType = productType;
		this.productNo = productNo;
		this.amount = amount;
		this.status = status;
		this.orderDate = new Date();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
}
