package array;

import java.util.Scanner;

public class array02 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] number = new int[9];
		int count = 0;
		int max = 0;
		
		for (int i=0; i < number.length; i++) {
			number[i] = scan.nextInt();
			if ( number[i] > max ) {
				max = number[i];
				count = i+1;
			}
		}
		System.out.println(max);
		System.out.println(count);
		scan.close();
	}
}
