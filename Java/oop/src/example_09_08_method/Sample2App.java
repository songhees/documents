package example_09_08_method;

public class Sample2App {
	public static void main(String[] args) {
		
		// 각각 객체를 형성하고 주소값을 참조변수에 대입 
		Sample2 s1 = new Sample2();
		Sample2 s2 = new Sample2();
		Sample2 s3 = new Sample2();
		
		// 각 객체의 멤버 변수를 초기화
		s1.balance = 10000;
		s1.password = 1111;
		
		s2.balance = 1_000_000;
		s2.password = 1234;
		
		s3.balance = 250_000;
		s3.password = 1212;
		
		// 각 객체의 잔액을 조회해서 화면에 출력학기
		long value1 = s1.getCurrentBalance();
		// s1참조변수를 통해 객체 Sample2의 기능인 getCurrentBalance통해 balance값을 반환하여 long타입의 변수 value1에 대입한다.
		long value2 = s2.getCurrentBalance();
		long value3 = s3.getCurrentBalance();
		
		System.out.println("첫번째 통창의 현재 잔액: " + value1);
		System.out.println("두번째 통창의 현재 잔액: " + value2);
		System.out.println("세번째 통창의 현재 잔액: " + value3);
		
		// 각 객체의 잔액을 전부 합친 총 자산을 계산해서 화면에 출력하기
		long totalBalance = value1 + value2 + value3;
		System.out.println("총 자산: " + totalBalance);
		
		// 각 객체의 잔액을 변경하기
		s1.updateBalance(300_000);
		s2.updateBalance(500_000);
		s3.updateBalance(700_000);
		
		// 각 객체의 잔액이 변경된 후 잔액을 조회해서 화면에 출력하기
		value1 = s1.getCurrentBalance();
		value2 = s2.getCurrentBalance();
		value3 = s3.getCurrentBalance();
		
		System.out.println("잔액변경 후 첫번째 통창의 현재 잔액: " + value1);
		System.out.println("잔액변경 후 두번째 통창의 현재 잔액: " + value2);
		System.out.println("잔액변경 후 세번째 통창의 현재 잔액: " + value3);
		
		
	}
}
