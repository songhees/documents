package example_09_02_for;

public class Sample3 {
	public static void main(String[] args) {
		/*
		 * 정수 1부터 500까지의 합을 구해서 화면에 출력하기
		 */
		
//		sum += 1;
//		sum += 2;
//		sum += 3;
//		sum += 4;
//		sum += 5;
		
		int sum = 0;
		for (int i = 0; i < 500; i++) {
			sum += (i+1);
		}
		
		System.out.println("합계: " + sum);
	}
}
