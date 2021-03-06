package example_09_02_for;

public class Sample7 {
	public static void main(String[] args) {
		/*
		 * continue로 남아있는 수행문을 실행을 취소하고 다음 번 반복을 위해서 증감식으로 이동시키기
		 * 
		 */
		
		for (int i = 1; i <= 10; i++) {
			// i의 값이 3, 6, 9인 경우 continue가 실행됨
			// continue는 남아있는 수행문을 실행하지 않고, 즉시 반복문의 증감식으로 이동함
			if (i%3 ==0) {
				continue;
			}
			System.out.println("i값:" + i);		//continue를 만날때 실행하지 않음
		}
	}
}
