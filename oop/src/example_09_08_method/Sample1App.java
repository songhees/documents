package example_09_08_method;

public class Sample1App {
	public static void main(String[] args) {
		/*
		 * Sample1 설계도로 객체 생성하기
		 */
		Sample1 sample1 = new Sample1();
		//Sample1클래스를 통해 Sample1객체를 형성한 다음 sample참조변수에 주소값을 넣는다.
		
		
		// 반환값X, 매개변수X 메소드 실행
		//참조변수.메소드명();
		// 반환값O, 매개변수X 메소드 실행
		// 반환타입 변수 = 참조변수.메소드();
		// 반환값O, 매개변수O 메소드 실행
		// 반환타입 변수 = 참조변수.메소드(입력값
		
		
		// 생성된 객체의 기능 실행하기
		sample1.displayCurrentDate();
		//참조변수 sample를 통해 객체 Sample1에 있는 기능 displayCurrentDate를 실행시킨다.

		int value = sample1.getNumber();
		//참조변수sample을 통해 객체 Sample1에 있는 기능 getNumber()의 반환값 100을 int 타입 변수 value에 대입한다.
		System.out.println("반환받은 값: " + value);
		
		
		
		// 주사위를 랜덤하게 반환하는 기능 실행하기
		for (int i = 0; i < 10; i++) {
			int value1 = sample1.getRandomNumber();
			//참조변수 sample을 통해 객체 Sample1에 있는 기능 getRandomNumber()의 랜덤 주사위 반환값을 int타입 변수value1에 대입한다.
			System.out.println("주사위 숫자: " + value1); //반복문으로 인하여 6개의 랜덤 주사위 숫자가 나오게 된다.
		}
		// 국어/영어/수학점수를 입력으로 받아서 총점을 반환하는 기능 실행하기
		int totalScore = sample1.getTotalScore(100, 80, 70);
		//참조변수 sample을 통해 객체 Sample1에 있는 기능 getTotalsore()에 국어 영어 수학 값을 매개변수로 넣어 나오는 총점을 int변수 total에 대입한다.
		System.out.println("총점: " + totalScore);
		
		totalScore = sample1.getTotalScore(100, 90, 75);
		System.out.println("총점: " + totalScore);
		
		totalScore = sample1.getTotalScore(70, 60, 55);
		System.out.println("총점: " + totalScore);
		
		totalScore = sample1.getTotalScore(40, 70, 95);
		System.out.println("총점: " + totalScore);
		
		totalScore = sample1.getTotalScore(60, 70, 45);
		System.out.println("총점: " + totalScore);
		
		// 국어/영어/수학점수를 입력으로 전달해서 평균점수를 반환하는 기능 실행하기
		double average = sample1.getAverage(80, 70, 45);
		//참조변수 sample을 통해 객체 Sample1에 있는 getAverage()에 국어 영어 수학 값을 매개변수로 넣어 평균값을 반환시켜 double형 변수 average에 대입한다.
		System.out.printf("평균점수: %.2f", average);
	}
}
