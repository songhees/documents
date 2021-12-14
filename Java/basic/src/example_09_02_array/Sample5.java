package example_09_02_array;

import java.util.Scanner;

public class Sample5 {
	public static void main(String[] args) {
		/*
		 * 10명의 학생 성적을 저장하는 배열을 생성한다. int[] scores = new int[10];
		 * Scanner를 이용해서 성적을 10번 입력받아서 배열에 순서대로 저장한다.
		 * 출력: 입력된 점수를 순서대로 출력한다.
		 * 		총점, 평균을 계산해서 출력한다.
		 */
		
		Scanner scan = new Scanner(System.in);
		int[] scores = new int[10];
		int studentCount = scores.length;
		
		// 반복문을 사용해서 학생 성적을 10번 입력받아서 배열에 저장한다.
		
		for (int i=0;i<studentCount;i++ ) {
			System.out.print("성적입력: ");
			scores[i] = scan.nextInt();
			
		}
			
		for (int i=0;i<studentCount;i++ ) {
			System.out.print("성적입력: ");
			scores[i] = scan.nextInt();
			
		}
			
		// 향상된 for문을 사용해서 학생들의 성적을 출력한다.
		// 사용해서 총점, 평균을 계산하고 출력한다.
		
		int totalScore = 0;
		int average = 0;
		for (int score : scores) {
			System.out.println("성적: " + score);
			totalScore += score;
		}
		average = totalScore/studentCount;
		
		System.out.println("총점: " + totalScore);
		System.out.println("평균: " + average);
		
		scan.close();
	}
}
