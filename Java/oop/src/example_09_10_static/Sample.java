package example_09_10_static;

public class Sample {
	
	static int x;			// 정적변수, 클래스변수
	int y;					// 멤버변수, 인스턴스변수
	
	// 정적 메소드는 정적변수/메소드는 사용가능하다.
	static void staticMethod() {		// 정적 메소드, 클래스 메소드
		System.out.println(Sample.x);	// 정적변수 사용가능
		//System.out.println(y);			// 오류, 멤버변수 사용불가
	}

	void instanceMethod() {				// 멤버 메소드, 인스턴스 메소드
		System.out.println(Sample.x);	// 정적변수 사용가능
		System.out.println(y);			// 멤버변수 사용가능
		
	}
	
	static void staticMethod2() {		// 정적 메소드, 클래스 메소드
		Sample.staticMethod();			// 다른 정적 메소드 사용가능	같은 클래스이므로 Sample.이 생략가능
		//instanceMethod();				// 오류, 멤버 메소드 사용불가
	}
	
	void instanceMethod2() {			// 멤버 메소드, 인스턴스 메소드
		Sample.staticMethod();			// 정적 메소드 사용가능
		instanceMethod();				// 다른 멤버 메소드 사용가능
		
	}
	
	
	

}
