package hundred;

import java.util.Scanner;

public class Base62 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		scan.close();
		/*
		 * 3 5
		 *   0011
		 * ^ 0101
		 * 	 0110 = 6
		 */
		System.out.println(num1 ^ num2);
	}
}
