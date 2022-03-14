package hundred;

import java.util.Scanner;

public class Base89 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start = scan.nextInt();
		int d = scan.nextInt();
		int n = scan.nextInt();
		
		System.out.println((long)(start*Math.pow(d, n-1)));
		scan.close();
	}
}
