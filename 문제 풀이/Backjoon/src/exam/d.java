package exam;

import java.util.Scanner;

public class d {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int N = scan.nextInt();
			int M = N;
			int countNumber = 0;
			while (true) {
				N = ((N%10)*10)+((N/10)+(N%10))%10;
				countNumber++;
				if (N == M) {
					break;
				}
			}
			System.out.println(countNumber);
			scan.close();
		}	
	}
}

