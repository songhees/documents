package exam;

import java.util.Scanner;

public class while03 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
			
		int N = scan.nextInt();
		int M = 0;
		int countNumber = 0;
		
		if (N < 10) {
			N *= 10;
		}
		
		int A = N/10;
		int B = N%10;
		
		while (true) {
			if ( A + B >= 10 ) {
				M = B*10 + (A+B)%10;
			} else {
				M = B*10 + (A+B);
			}
			countNumber++;
			
			if ( N != M ) {
				A = M/10;
				B = M%10;
			} else if ( N == M) {
				System.out.println(countNumber);
				break;
			}
		}
		scan.close();
	}
}

