package example_09_02_array;

import java.util.Scanner;

public class Sample8_1 {
	public static void main(String[] args) {
		/*
		 * 학생들의, 이름, 국어, 영어, 수학 점수를 배열에 저장하고, 성적정보를 출력하시오.
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		
		String[] names = new String[3];			
		int[][] scores = new int[3][];	
		String[] scoreNames = {"국어점수", "영어점수", "수학점수", "종합점수", "평균점수"};
		int savePosition = 0;
		
		while (true) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.조회	2.입력	3.변경.	0.종료");
			System.out.println("---------------------------------------------------");
			System.out.println("메뉴번호를 입력하세요.");
			int menu = scan.nextInt();
			
			if (menu == 1) {
				System.out.println("[성적정보 조회]");
				
				for (int i = 0 ; i <3; i++) {
					System.out.println("학생이름: " + names[i]);
					int[] score = scores[i];
					for(int j =0; j <5; j++)
						System.out.println(scoreNames[j] + ": " + score[j]);
					System.out.println("------------------------------------");
				}
				
			} else if (menu == 2) {
				System.out.println("[성적정보 입력]");
				
				if (savePosition<3) {
					System.out.print("학생이름을 입력하세요.");
					String name = scan.next();
					System.out.print("국어점수를 입력하세요.");
					int korScore = scan.nextInt();
					System.out.print("영어점수를 입력하세요.");
					int engScore = scan.nextInt();
					System.out.print("수학점수를 입력하세요.");
					int mathScore = scan.nextInt();
					
					names[savePosition] = name;

					int score[] = new int[5];
					score[0] = korScore;
					score[1] = engScore;
					score[2] = mathScore;
					score[3] = korScore + engScore + mathScore;
					score[4] = score[3]/3;
					scores[savePosition] = score;
					
					savePosition ++;
					System.out.println("### 입력이 완료되었습니다.");
				} else {
					System.out.println("### 더 이상 입력할 수 없습니다.");
				}
			} else if (menu == 2) {
				System.out.println("[성적정보 변경]");
				
			} else if (menu == 0) {
				System.out.println("[프로그램 종료]");
				System.exit(1);	
			}	
			scan.close();
		}
	}
}
