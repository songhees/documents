package array;

import java.util.Scanner;

public class array01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] number = new int[N];
		int max = -1000000;
		int min = 1000000;
		for (int i = 0; i < N; i++) {
			number[i] = scan.nextInt();
			
			if (number[i] >= max) {
				max = number[i];
			}
			if (number[i] <= min) {
				min = number[i];			
			}
		}
		System.out.println(min + " " + max);
		
		scan.close();	
	}
}
