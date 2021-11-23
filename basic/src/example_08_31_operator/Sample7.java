package example_08_31_operator;

public class Sample7 {
	public static void main(String[] args) {
		/*
		 * 논리연산자
		 * &&	||	!
		 * 논리연산자의 연산결과는 언제나 boolean 값이다.
		 * 논리연산에 참여하는 값은 boolean 타입의 값이거나, 혹은 연산결과가 boolean값인 연산식만 가능하다.
		 * 참여값 boolean 결과도 boolean
		 * 
		 * && 연산자는 좌항의 값이 false면 우항의 값을 확인하지 않고 논리식의 연산결과를 false로 판정한다.
		 * || 연산자는 좌항의 값이 true면 우항의 값을 확인하지 않고 논리식의 연산결과를 true로 판정한다.
		 * 따라서 아래와 같은 코드는 잘못된 코드다.
		 * 
		 * boolean result = a > b || x > ++y; 
		 * int num = z + y;		
		 * 
		 * a>b의 true false에 따라 우항이 연산여부가 결정되므로
		 * a > b의 연산결과가 true인 경우 y값을 1증가시키는 동작이 실행되지 않는다.
		 * a > b의 연산결과가 false인 경우에만 y값이 1증가된다.
		 * 따라서, num의 결과는 논리식에서 a > b의 연산결과에 따라서 다른 값이  산출될 수 있다.
		 * 
		 * 위의 코드는 아래와 같이 변경해야 한다.
		 * ++y;
		 * boolean result = a > b || x > y;
		 * int num = z + y;
		 * 해야 num이 항상 같은 값을 갖는다.
		 */
		
		String name = "홍길동";
		//System.out.println(!name);	불가능 참여값인 name이 boolean이 아님
		
		System.out.println(true && true);	//true
		System.out.println(true && false);	//false
		System.out.println(false && false);	//false
		
		System.out.println(true || true);	//true
		System.out.println(true || false);	//true
		System.out.println(false || false);	//false
		
		System.out.println(!true);
		System.out.println(!false);
		
	}
}
