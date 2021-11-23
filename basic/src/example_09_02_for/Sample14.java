package example_09_02_for;

import java.util.Scanner;

public class Sample14 {
	public static void main(String[] args) {
		/*
		 * 숫자를 입력받아서 해당 숫자에 대한 구구단을 출력하는 프로그램
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자입력: ");
		int number = scan.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d \n", number, i, number*i);
			
			System.out.println(number + " * " + i + " = " + (number*i));
		}
		scan.close();
	}
}
