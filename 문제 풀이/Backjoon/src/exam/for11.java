package exam;

import java.util.Scanner;

public class for11 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int X = scan.nextInt();
		int[] sequence = new int[N];
		
		for (int i = 0; i < N; i++) {
			sequence[i] = scan.nextInt();
		}
		
		for (int i = 0; i < N; i++)
			if ( sequence[i] < X ) {
				System.out.print(sequence[i] + " ");
		}
		
		scan.close();
	}
}
