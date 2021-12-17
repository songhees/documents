package exam;

import java.util.Scanner;

public class for10 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for (int i=0;i<n;i++) {
			for (int j = 0 ;j < n - i- 1;j++) {
				System.out.print(" ");
			}
			for (int j = 0 ;j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
		scan.close();
	}
}
