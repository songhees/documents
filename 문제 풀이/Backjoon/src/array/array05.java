package array;

import java.util.Scanner;

public class array05 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		int[] scores = new int[input];
		int max = 0;
		double totalScore = 0;
		
		for (int i=0;i<scores.length;i++) {
			scores[i] = scan.nextInt();
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		
		for (int score : scores) {
			totalScore += (double) score/max*100;		//변수 유형 : 정수/정수 = 0이 나옴을 주의 ★★★
		}
		
		double average = totalScore/scores.length;
		System.out.println(average);
		scan.close();
	}
}
