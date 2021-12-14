package example_09_02_for;

import java.util.Scanner;

public class Sample11 {
	public static void main(String[] args) {
		/*
		 * 과제
		 */
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		int average = 0;
		for (int i = 0; i < 2; i++) {
			System.out.println((i + 1) + "번째 숫자 입력: ");
			int number = scan.nextInt();
			sum += number;
		}
		
		average = sum/2;
		System.out.println("모든 수의 총합: " + sum);
		System.out.println("모든 수의 평균: " + average);	
		
		scan.close();
	}
}
