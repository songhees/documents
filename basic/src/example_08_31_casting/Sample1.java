package example_08_31_casting;

public class Sample1 {
	public static void main(String[] args) {
		/*
		 * 자동형변환
		 * 프로그램 실행시 JVM이 자동으로 처리한다.
		 * 크기가 더 큰 자료형의 변수에 저장될 때 자동형변환이 일어난다.
		 */
		int num = 100;			 // 
		double value1 = num;	 // double value1 = 100 -> double value1 = 100.0
								 // 		double	int			double		double
							 	 // 100이 먼저 double형으로 바뀌고(casting) value1에 담아진다.
		System.out.println(num);
		System.out.println(value1);
		
		/*
		 * 연산을 수행하기 전에 같은 데이터타입으로 변환한 다음 연산이 수행된다.
		 * 연산에 참여한 값의 테이터타입들 중에서 정밀도가 높거나 크기가 더 큰 자료형으로 자동형변환이 일어난다.
		 */
		System.out.println(3/10);		// 정수/정수			3/10 			   = 0
										// 좌우가 타입이 같으므로 형변환이 필요없다.	
		System.out.println(3/10.0);		// 정수/실수 			3/10.0 -> 3.0/10.0 = 0.3
										// 정밀도가 높은 실수로 자동으로 변환한다. 정수로 바꾸면 데이터 손실이 발생하므로 변환하지 않는다.
		
		System.out.println(3.0/10);		// 실수/정수			3.0/10 -> 3.0/10.0 = 0.3
		System.out.println(3.0/10.0);	// 실수/실수			3.0/10.0		   = 0.3
		
	}
}
