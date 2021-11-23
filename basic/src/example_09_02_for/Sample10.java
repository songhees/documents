package example_09_02_for;

import java.util.Scanner;

public class Sample10 {
	public static void main(String[] args) {
		/*
		 * 과제
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("원하는 숫자입력: ");
		int n = scan.nextInt();
		
		int max = Integer.MIN_VALUE;	// max에 int타입의 최소값을 대입한다.
		for (int i = 0; i < n; i++) {		
			System.out.print((i + 1) + "번째 숫자 입력: ");	
			int num = scan.nextInt();
	
			if (num > max) {
				max = num;
			}
		}		
		System.out.println("가장 큰 숫자: " + max);
		
		scan.close();
	}
}
