package example_09_08_method;

public class Movie {
	public static void main(String[] args) {
		
		Sample1 sample = new Sample1();
		//Sample1클래스를 통해 Sample1객체를 형성한 다음 sample참조변수에 주소값을 넣는다.
		
		sample.displayCurrentDate();
		//참조변수 sample를 통해 객체 Sample1에 있는 기능 displayCurrentDate를 실행시킨다.
		
		int value =  sample.getNumber();
		//참조변수sample을 통해 객체 Sample1에 있는 기능 getNumber();의 반환값 100을 int 타입 변수 value에 대입한다.
		System.out.println("반환받은 값: " + value);
		
		
		for (int i=0; i < 6; i++) {
			int value1 = sample.getRandomNumber();	//참조변수 sample을 통해 객체 Sample1에 있는 기능 getRandomNumber()의 랜덤 주사위 반환값을 int타입 변수value1에 대입한다.
			System.out.println(value1); //반복문으로 인하여 6개의 랜덤 주사위 숫자가 나오게 된다.
		}
		
		int total = sample.getTotalScore(100, 90, 80); //참조변수 sampel을 통해 객체 Sample1에 있는 기능 getTotalsore()에 국어 영어 수학 값을 매개변수로 넣어 나오는 총점을 변수 total에 대입한다.
		System.out.println("총점: " + total);
		
		double average = sample.getAverage(100, 90, 80); //참조변수 sample을 통해 객체 Sample1에 있는 getAverage()에 국어 영어 수학 값을 매개변수로 넣어 평균값을 반환시켜 double형 변수 average에 대입한다.
		
		
	}

}
