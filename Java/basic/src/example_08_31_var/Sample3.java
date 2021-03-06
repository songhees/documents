package example_08_31_var;

public class Sample3 {
	public static void main(String[] args) {
		/*
		 *  
		 *  
		 * byte, short, int, long 타입의 변수에 값을 저장할 때 유의사항
		 * 
		 * byte, short 타입의 변수는 사용하는 경우가 극히 제한적이다.
		 * byte는 바이너리 데이터를 다루거나, 입출력 등의 작업에서만 제한적으로 사용된다.
		 * 국어점수, 수학점수 등의 값이 0~100 사이의 값이기 때문에 byte 타입의 범위(-128 ~ 127)
		 * 내에 속하지만 절대로 byte 타입의 변수를 사용해서 국어점수, 수학점수를 저장하지 말자
		 * short는 정보시스템용 애플리케이션에서 거의 사용되지 않는다.
		 * int는 정수를 저장하는 변수의 타입으로 가장 적절하다.
		 * long은 int의 범위를 초과하는 정수를 다룰 때만 선택한다.
		 */
		
		//int가 정수형의 기본타입이기 때문에 정수값을 표현할 때는 언제나 int타입의 범위에 해당하는 정수값만 표현할 수 있다.
		//int의 범위를 초과하는 정수를 표현할 때는 숫자 뒤에 L이나 ㅣ를 붙인다.
		long value1 = 1_000_000_000; //10억
		//long value2 = 10000000000는 int범위를 넘어서 오류가 남
		long value2 = 10000000000L; //100억
		
		/*
		 * float, double 타입의 변수에 값을 저장할 때 유의사항
		 * float는 정보시스템용 애플리케이션에서 거의 사용되지 않는다.
		 */
		
		// double이 실수형의 기본타입이기 때문에 실수값을 표현하면 언제나 double형의 실수값이라고 판단한다.
		// float의 크기는 4byte, double의 크기는 8byte이기 때문에 double형의 실수값을 float형의 변수에 저장할 수 없다.
		// float형의 실수값으로 판단하도록 숫자 뒤에 F나 f를 붙인다.
		float value3 = 1.0f;
		float value4 = 3.14f;
		float value5 = -1000.45f;
		
		// 정수값을 표현하는 방법
		
		int value6 = 1000;			// 정수 1000
		int value7 = 100_000_000;	// 자릿수가 표시된 정수 100000000
		int value8 = 012;			// 8진수 12 : 1*8^1 + 2*8^0 = 10
		int value9 = 0x12;			// 16진수 12 : 1*16^1 + 2*16^0 = 16+2 = 18
		
		//여러가지 형식으로 표현된 정수값 출력하기
		System.out.println(value6);
		System.out.println(value7);
		System.out.println(value8);
		System.out.println(value9);
	}
}
