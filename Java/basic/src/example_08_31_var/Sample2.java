package example_08_31_var;

public class Sample2 {
	public static void main(String[] args) {
		/*
		 * 상품가격 구매수량 적립포인트를 계산해서 출력하기
		 * 상품가격은 35000원이다.
		 * 구매수량은 3이다.
		 * 포인트적립률은 총구매 금액의 3%다.
		 * 
		 * 화면에 상품가격, 구매수량, 총구매금액, 적립포인트를 출력하기
		 */
		
		int price = 35000;
		int amount = 3;
		int totalPrice = price * amount;
		double point = 0.03;
		double totalPoint = totalPrice * point;
		
		System.out.println("상품가격, 구매수량");
		System.out.println(price);
		System.out.println(amount);
		
		System.out.println("총구매 금액, 적립포인트");
		System.out.println(totalPrice);
		System.out.println(totalPoint);
		
		
	}
}
