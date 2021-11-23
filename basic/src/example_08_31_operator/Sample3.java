package example_08_31_operator;

public class Sample3 {
	public static void main(String[] args) {
		/*
		 * 대입연산자
		 * =	 +=		 -=		 *=		 /=		 %=
		 * 연산자 우선순위가 가장 낮은 연산자다.
		 * 
		 * = 은 변수에 값을 대입한다. == 변수의 값을 새로운 값으로 변경한다.
		 */
		int num = 10; 
		System.out.println("num의 값: "+num);	//10
		
		num = 5;
		System.out.println("num의 값: "+num);	//5
		
		// +=은 변수의 값을 지정된 값만큼 증가시킨다.
		num += 20;	// num = num + 20; 과 동일하다.
		System.out.println("num의 값: "+num);	// 25
		
		// -=은 변수의 값을 지정된 값만큼 감소시킨다.
		num -= 10;	// num = num - 10; 와 동일하다.
		System.out.println("num의 값: "+num);	// 15
		
		// *=은 변수의 값을 지정된 값만큼 곱한값을 변수에 대입한다.
		num *= 3;	// num = num*3; 와 동일하다.	// 45
		System.out.println("num의 값: "+num);
		
		// /=은 변수의 값을 지정된 값으로 나눈값을 변수에 대입한다.
		num /= 9;	//
		System.out.println("num의 값: "+num);	// 5
		
		// %=은 변수의 값을 지정된 값으로 나눈 후 나머지를 변수에 대입한다.
		num %= 3;
		System.out.println("num의 값: "+num);	// 2
		

		
		
	}
}
