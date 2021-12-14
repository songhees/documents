package example_09_02_array;

import java.util.Scanner;

public class Sample6_2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);		
		
		String[] names = new String[2];
		int[][] scores = new int[2][5];
		int totalScore = 0;
		
		for(int i=0; i<names.length; i++) {
			System.out.print("이름을 입력하세요: ");
			names[i] = scan.next();
			int[] score = scores[i];
			for(int j=0; j<3; j++) {
				System.out.print("점수를 입력하세요: ");
				score[j] = scan.nextInt();
				totalScore += score[j];
			}
			score[3] = totalScore;
			score[4] = totalScore/3;
		}
		
		for (int i=0; i<2; i++) {
			System.out.print(names[i]);
			int[] score = scores[i];
			for (int temp : score) {
				System.out.print("\t" + temp);
			}
			System.out.println("");
		}
		scan.close();
	}
}
