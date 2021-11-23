package example_10_01_wrapper;

public class WrapperApp2 {
	public static void main(String[] args) {
		// 오토박싱, 오토언박싱 (자바 5버전부터 지원하는 기능)
		// 기본자료형 -> Wrapper 클래스드타입의 객체로
		// Wrapper 클래스타입의 객체 -> 기본자료형값으로 변경을 자동으로 처리하는 것
		
		// 오토박싱	// 박스에 값을 담는다.
		// 변수의 타입의 Wrapper 클래스 타입이고 저장할 값의 타입이 기본자료형일 때
		// 자동으로 변수의 타입과 일치하는 Wrapper 객체를 생성해서 기본자료형값을 저장한 다음
		// 그 객체를 참조변수에 대입하는 것
		Integer a1 = 10; 			// = new Integer(10); 숫자10을 포함하는 Integer객체의 주소값	실제로 실행되는 코드
		Long a2 = 100000000000L; 	// = new Long(100000000000L);	실제로 실행되는 코드
		Double a3 = 3.14;			// = new Double(3.14);			실제로 실행되는 코드
		
		Object b1 = 10;				// = new Integer(10); b1참조변수는 Integer객체의 내부에 있는 Object를 참조중이다.
		Object b2 = 100000000000L;	// = new Long(100000000000L);
		Object b3 = 3.14;			// = new Double(3.14);
		// Object or 데이터객체 or Number객체 가능
		String str = "안녕";			//
	
		// 오토언박싱 // 박스를 개봉해서 값을 꺼냄
		// Wrapper 클래스 타입의 객체에 저장된 값은
		// 기본 자료형 타입의 변수에 대입하면 자동으로 해당 Wrapper객체가 가지고 있는 기본자료형 값이 대입된다.
		Integer c1 = 1000;			// Integer c1 = new Integer(1000);
		int c2 = c1;				// int c2 = c1.intValue(); <= Intger객체의 intValue()를 샐행해서 정수값을 꺼내서 변수 c2에 저장한다. 자동으로 일어남
		
		
		// 오토박싱과 오토언박싱이 지원되기 때문에 Wrapper객쳉와 기본자료형 간의 사칙연산도 가능하다.
		Integer d1 = 20;
		Integer d2 = 30;
		int d3 = 40;
		
		// 기본잘형타입 변수 = 객체 + 객체 + 정수
		int sum = d1 + d2 + d3;	// int sum = d1.inValue() + d2.inValue() + d3;
		System.out.println("합계:" + sum);
	}
}
