package example_09_06_class;

public class ProductApp {
	public static void main(String[] args) {
		// 상품정보를 여러 개 관리하기 위한 배열 생성하기
		Product[] products = new Product[3];
		
		Product item1 = new Product();
		item1.number = 10;
		item1.name = "apple watch 6";
		item1.make = "apple";
		item1.price = 539_000;
		item1.sale = 500_000;
		item1.stock = 10;
		
		Product item2 = new Product();
		item2.number = 20;
		item2.name = "갤럭시워치 4";
		item2.make = "삼성전자";
		item2.price = 399_000;
		item2.sale = 350_000;
		item2.stock = 30;
		
		Product item3 = new Product();
		item3.number = 30;
		item3.name = "가민포러너 945";
		item3.make = "가민";
		item3.price = 749_000;
		item3.sale = 720_000;
		item3.stock = 5;
		
		// 배열에 상품정보 저장하기
		products[0] = item1;
		products[1] = item2;
		products[2] = item3;
		
		// 모든 상품정보를 화면에 출력하기		
		int totalStock = 0;
		int totalStockPrice = 0;
		System.out.println("배열에 저장된 모든 상품정보를 출력");
		for (Product product : products) {
			System.out.print(product.number + "\t");
			System.out.print(product.name + "\t");
			System.out.print(product.make + "\t");
			System.out.print(product.price + "\t");
			System.out.print(product.stock + "\t");
			System.out.println(product.sale);
		}
		
		System.out.println("배열에 저장된 모든 상품정보의 재고현황을 출력");
		for (Product product : products) {
			System.out.print(product.number + "\t");
			System.out.print(product.name + "\t");
			System.out.print(product.make + "\t");
			System.out.print(product.price + "\t");
			System.out.print(product.stock + "\t");
			System.out.println(product.stock*product.price);
			
			totalStock += product.stock;
			totalStockPrice += product.stock*product.price;
		}
		System.out.println("배열에 저장된 모든 상품정보의 총 상품수량, 총 재고가격을 출력");
		System.out.println("총 상품수량: " + totalStock);
		System.out.println("총 재고가격: " + totalStockPrice);
	}
}
