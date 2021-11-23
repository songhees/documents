package example_09_02_for;

import java.util.Scanner;

public class Sampl12 {
	public static void main(String[] args) {
		/*
		 * 과제
		 * 숫자 n개를 입력받아서 모든 수의 총합과 평균을 출력하는 프로그램
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("입력할 숫자의 갯수 입력: ");
		int n = scan.nextInt();
		
		int sum = 0;
		int average = 0;
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + "번째 숫자 입력: ");
			int number = scan.nextInt();
			sum += number;
		}
		
		average = sum/n;
		System.out.println("모든 수의 총합: " + sum);
		System.out.println("모든 수의 평균: " + average);
		
		scan.close();
	}
}
