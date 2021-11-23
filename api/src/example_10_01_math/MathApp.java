package example_10_01_math;

public class MathApp {
	public static void main(String[] args) {
		
		// Math 클래스는 수학계산과 관련된 기능을 제공하는 클래스다.
		// Math 클래스의 모든 메소드는 정적 메소드다.
		
		// 난수 얻기 double random()은 0.0보다 크거나 같고 1.0보다 작은 임의의 실수를 반환한다.
		System.out.println("### 난수 얻기");
		double value1 = Math.random();
		System.out.println("난수: " + value1);
		
		// 1 ~ 6 사이의 값을 난수로 얻기
		int value2 = (int)(Math.random()*6) + 1;
		System.out.println("주사위: " + value2);
		
		// 반올림된 값 얻기 : long round(double value)는 반올림된 값을 반환한다.
		System.out.println("### 반올림된 값 얻기");
		long value3 = Math.round(123.4);
		long value4 = Math.round(123.6);
		System.out.println("123.4의 반올림된 값: " + value3);
		System.out.println("123.6의 반올림된 값: " + value4);
		
		// 천장값 얻기 : double ceil(double value)는 천장값을 반환한다.
		// 반환값이 정수라고 가정하면 값이 실수값일 때 자신보다 큰 정수 중에서 가장 작은 정수값을 반환한다.
		System.out.println("### 천장값 얻기");
		double value5 = Math.ceil(3.0);
		int value6 = (int)Math.ceil(3.3);
		int value7 = (int)Math.ceil(3.6);
		double value8 = Math.ceil(3.9);
		double value9 = Math.ceil(4.0);
		
		System.out.println("3.0의 천장값: " + value5);	// 3.0
		System.out.println("3.3의 천장값: " + value6);	// 4.0
		System.out.println("3.6의 천장값: " + value7);	// 4.0
		System.out.println("3.9의 천장값: " + value8);	// 4.0
		System.out.println("4.0의 천장값: " + value9);	// 4.0
		// 웹페이지에서 웹페이지에 한화면에 20개만 들어 갈 수 있다면 25개의 대상이 있을 때
		// double (25/20) 는 1.25이므로 페이지는 1.25가 안되고 1페이지만 만들수 없으므로
		//ceil을 사용해서 2값 즉 2페이지를 형성한다.
		
		// 바닥값 얻기 : double floor(double value)는 바닥값을 반환한다.
		// 반환값이 정수라고 가정하면 값이 실수값일 때 자신보다 작은 정수 중에서 가장 큰 정수값을 반환한다.
		System.out.println("### 바닥값 얻기");
		double value10 = Math.floor(3.0);
		int value11 = (int)Math.floor(3.3);
		int value12 = (int)Math.floor(3.6);
		double value13 = Math.floor(3.9);
		double value14 = Math.floor(4.0);
		System.out.println("3.0의 천장값: " + value10);	// 3.0
		System.out.println("3.3의 천장값: " + value11);	// 3.0
		System.out.println("3.6의 천장값: " + value12);	// 3.0
		System.out.println("3.9의 천장값: " + value13);	// 3.0
		System.out.println("4.0의 천장값: " + value14);	// 4.0
	}
}
