package array;

import java.util.Scanner;

public class array06 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		String[] oxQuizes = new String[N];
		
		for (int i = 0; i < oxQuizes.length; i++) {
			oxQuizes[i] = scan.next();
		}
		
		for (int i = 0; i < oxQuizes.length; i++) {
			String[] array = oxQuizes[i].split("");
			int count = 0;
			int score = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[j].equals("O")) {
					score += 1;
					count += score;
				} else if (array[j].equals("X")) {
					score = 0;
				}
			}
			System.out.println(count);
			}
		scan.close();
	}
}
