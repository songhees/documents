package example_09_16_casting;

import java.util.Scanner;

public class CarApp2 {
	public static void main(String[] args) {
		/*
		 * 클래스 형변환 활용하기
		 * 
		 * 		+ 부모타입의 참조변수로 모든 자식타입객체를 참조할 수 있다.
		 */
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.SUV	 2.레이싱카	 3.펠리세이드");
			System.out.println("----------------------------------------------------------");
			
			System.out.print("구매할 차종을 선택하세요: ");
			int carType = scan.nextInt();
			
	//		SUV car1 = null;
	//		RacingCar car2 = null;
	//		Palisade car3 = null;
			// 이렇게 쓰면 차가 늘어날때 마다 변수를 설정해야하므로 개수가 늘어나게 된다.
			Car car = null;
			// 모든차의 부모가 Car이므로 모든차의 객체는 Car 참조변수에 담을 수 있다.
			if (carType == 1 ) {
				car = new SUV();
			} else if (carType == 2) {
				car = new RacingCar();
				
			} else if (carType == 3) {
				car = new Palisade();
				
			} else {
				System.out.println("### 지원하기 않는 차종입니다.");
				continue;
			}
			
			System.out.println("구매한 차의 이름: " + car.getClass().getName());
			
			scan.close();
			break;
		}
	}
}
