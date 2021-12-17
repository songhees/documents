package exam;

import java.util.Scanner;

public class while01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			
			if ( B == 0 ) {
				break;
			}
			System.out.println(A + B);
		}
		scan.close();
	}
}
