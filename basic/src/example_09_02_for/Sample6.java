package example_09_02_for;

import java.util.Scanner;

public class Sample6 {
	public static void main(String[] args) {
		/*
		 * 반복을 중단시키기, 다음 번 반복으로 넘어가기
		 * break continue - 반복내에서만 사용할 수 있다. (단, break는 switch문에서도 사용가능) 
		 * 
		 * 숫자를 입력받아서 그 숫자들의 합을 계산한다. - 반복, 횟수가 정해지지 않음
		 * 0을 입력하면 입력을 중단하고, 합계를 출력한다. - 제어
		 */
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		while (true) {
			System.out.println("숫자 입력(0을 입력하면 종료됩니다.): ");
			
			int number = scan.nextInt();
			if (number == 0) {
				break;					//while문 탈출
			}
			sum += number;
		}
		
		System.out.println("합계:" + sum);
		
		scan.close();
	}
}
