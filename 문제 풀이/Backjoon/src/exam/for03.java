package exam;

import java.util.Scanner;

public class for03 {
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= n ; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		int sum2 = n*(n+1)/2;
		System.out.println(sum2);
		scan.close();
	}
}
