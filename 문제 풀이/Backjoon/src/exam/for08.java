package exam;

import java.util.Scanner;

public class for08 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for (int i=0;i<T;i++) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();

			System.out.printf("Case #%d: %d + %d = %d\n", i+1, num1, num2, num1+num2);
		}
		scan.close();
	}
}
