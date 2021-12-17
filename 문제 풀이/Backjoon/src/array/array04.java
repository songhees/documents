package array;

import java.util.Scanner;

public class array04 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] numbers = new int[10];
		int[] rests = new int[42];
		int count = 0;
		
		for (int i=0; i<numbers.length; i++) {
			numbers[i] = scan.nextInt();
			numbers[i] %= 42;
			rests[numbers[i]] += 1;
		}
		
		for (int i=0; i<rests.length; i++) {
			if (rests[i] != 0) {
				count += 1;
			}	
		}
		
		System.out.println(count);
		scan.close();
	}
}
