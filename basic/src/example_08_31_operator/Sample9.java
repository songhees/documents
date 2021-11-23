package example_08_31_operator;

public class Sample9 {
	public static void main(String[] args) {
		/*
		 * 조건 연산자(3항 연산자)
		 * 조건식 ? 값1 : 값2
		 * 조건식 ? 연산식1 : 연산식2
		 * 
		 * 조건식의 연산결과는 boolean 값이어야 한다.
		 * 값1과 값2의 타입이 동일해야 한다.
		 * 조건식의 연산결과가 true면 조건연산자의 최종 연산결과는 값1이다.
		 * 조건식의 연산결과가 false면 조건연산자의 최종 연산결과는 값2다.
		 * 
		 * 점수가 60점 이상이면 "합격"을, 60점 미만이면 "불합격" 판정을 내린다.
		 */
		int score = 75;
		
		String result = score >= 60 ? "합격" : "불합격";
		System.out.println("실험결과: " + result);			//합격
		
		//구매금액이 100만원을 초과하면 구매금액은 5%를 적립하고, 100만원 이하면 2%를 적립한다.
		int orderPrice = 700_000;
		int point = orderPrice > 1_000_000 ? (int)(orderPrice*0.05) : (int)(orderPrice*0.02);
		System.out.println("적립포인트: " + point);			//14000
		
	}
}
