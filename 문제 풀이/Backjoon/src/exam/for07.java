package exam;

import java.util.Scanner;

public class for07 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for (int i=0;i<T;i++) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			System.out.println("Case #" + (i+1) + ": " + (num1+num2));
		}
		scan.close();
	}
}
