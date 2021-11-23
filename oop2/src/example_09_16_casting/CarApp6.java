package example_09_16_casting;

public class CarApp6 {
	public static void main(String[] args) {
		/*
		 * 클래스 형변환 활용하기
		 * 
		 * 		+ 생성된 객체가 클래스형변환 되어서 관리되고 있지만,
		 * 		  그 객체를 사용할 때는 그 객체의 모든 기능을 사용할 수 있다.
		 */
		// 배열에 SUV, RacingCar, Palisade객체가 순서없이 저장되어 있다.
		// 배열에 저장된 모든 객체는 배열의 각 칸에 Car타입 객체의 주소값이 저장되어 있고, 클래스형변환되어 있는 상태다.
		// 배열에 저장된 객체를 순서대로 뽑아서 각 객체의 고유한 기능을 실행하라.
		
		Car[] cars = new Car[5];
		cars[0] = new Palisade();
		cars[1] = new SUV();
		cars[2] = new RacingCar();
		cars[3] = new Palisade();
		cars[4] = new RacingCar();
		
		for (Car car : cars) {
			if (car instanceof Palisade) {			// palisade를 먼저안하면 SUV도 참이기 때문에 걸려버린다.
				Palisade palisade = (Palisade)car;	// car가 참조하는 실제 객체가 Palisade일 때 true다.
				palisade.changeDriveMode();
			} else if (car instanceof SUV) {		// car가 참조하는 실제 객체가 SUV일 때 true다. 	
				SUV suv = (SUV)car;					// car가 참조하는 실제 객체가 Palisade일 떄도 true로 판정될 수 있다.	
				suv.driveOffLoad();					// 그래서, Palisade인지 여부를 먼저 확인해서 Palisade인 경우 이 부분은 실행되지 않는다.
			} else if (car instanceof RacingCar) {	// car가 참조하는 실제 객체가 RacingCar일 때 true다.
				RacingCar racingCar = (RacingCar) car;
				racingCar.race();
			} 
		}
	}
}
