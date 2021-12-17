package array;

import java.util.Scanner;

public class array07 {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);

		int C = scan.nextInt();
		int[][] scores = new int[C][];
		double[] counts = new double[C];
		int studentNumber = 0;
		
		for (int i = 0; i < C; i++) {
			int totalScore = 0;
			double average = 0;
			int count = 0;
			studentNumber = scan.nextInt();
			scores[i] = new int[studentNumber];
			int[] score = scores[i];
			for (int j = 0; j < studentNumber; j++) {
				score[j] = scan.nextInt();
				totalScore += score[j];
			}
			
			average = (double)totalScore/studentNumber;
			for (int j=0 ; j<studentNumber; j++) {
				if (score[j] > average) {
					count++;
				}
			}
			counts[i] = (double)count/studentNumber*100;
				
		}
		for (int i = 0; i < C; i++) {
			
			System.out.printf("%.3f%%\n", counts[i]);
		}
		scan.close();
	}
}
