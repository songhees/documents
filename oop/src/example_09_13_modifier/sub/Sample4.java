package example_09_13_modifier.sub;

import example_09_13_modifier.Sample1;

// Sampel4는 Sample1의 자식 클래스다.
public class Sample4 extends Sample1{
	public void method() {
		
		a = 10;
		b = 10;
//		c = 10;		// 사용불가 같은 패키지에서만 접근 가능
//		d = 10;		// 사용불가 s
		
		Sample1 s1 = new Sample1();				// 사용가능	- 다른 패키지에서는 완전 공개된 것만 사용가능하다.
//		Sample1 s2 = new Sample1(10);			// 사용가능	// protected Sample1(int a){}					- 패키지 공개 + 자식에게 공개
//		Sample1 s3 = new Sample1(10, 20);		// 사용불가능	// Sample1(int a, int b){}						- 패키지 공개
//		Sample1 s4 = new Sample1(10, 20, 30);	// 사용불가능	// private Sample1(int a, int b, int c){}		- 완전 비공개
//	
		
		
	}
	
	
	
}
