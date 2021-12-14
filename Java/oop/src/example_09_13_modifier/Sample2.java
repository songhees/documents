package example_09_13_modifier;

public class Sample2 {
	public static void main(String[] args) {
		// 같은 패키지
		
		Sample1 s1 = new Sample1();				// 사용가능	// public Sample1() {}							- 완전 공개
		Sample1 s2 = new Sample1(10);			// 사용가능	// protected Sample1(int a){}					- 패키지 공개 + 자식에게 공개
		Sample1 s3 = new Sample1(10, 20);		// 사용가능	// Sample1(int a, int b){}						- 패키지 공개
//		Sample1 s4 = new Sample1(10, 20, 30);	// 사용불가	// private Sample1(int a, int b, int c){}		- 완전 비공개
		
		s1.a = 10;	// 사용가능		public int a
		s1.b = 10;	// 사용가능		protected int b
		s1.c = 10;	// 사용가능		int c
//		s1.d = 10;	// 사용불가능		private int d
	
		s1.method1();	// 사용가능	public method1() {...} 
		s1.method2();	// 사용가능	protected method2() {...}
		s1.method3();	// 사용가능	method3() {...}
//		s1.method4();	// 사용불가능	private method4() {...}
		
	}
}
