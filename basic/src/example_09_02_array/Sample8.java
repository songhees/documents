package example_09_02_array;

import java.util.Scanner;

public class Sample8 {
	public static void main(String[] args) {
		/*
		 * 학생들의, 이름, 국어, 영어, 수학 점수를 배열에 저장하고, 성적정보를 출력하시오.
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		
		String[] names = new String[3];			//{"이순신", "김유신", "강감찬"}
		int[][] scores = new int[3][];			//{100, 100, 100, 300, 100}, {80, 80, 100, 260, 86}, 
		String[] scoreNames = {"국어점수", "영어점수", "수학점수", "종합점수", "평균점수"};
		
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
				
				for(int i = 0; i <3; i++) {
					System.out.print("학생이름을 입력하세요.");
					String name = scan.next();
					System.out.print("국어점수를 입력하세요.");
					int korScore = scan.nextInt();
					System.out.print("영어점수를 입력하세요.");
					int engScore = scan.nextInt();
					System.out.print("수학점수를 입력하세요.");
					int mathScore = scan.nextInt();
					
					//학생이름을 names배열에 저장한다.
					names[i] = name;
					//과목별 점수, 총점, 평균을 저장하는 배열을 형성한다.
					int score[] = new int[5];
	
					//생성된 배열에 과목별 점수, 총점, 평균을 순서대로 저장한다.
					score[0] = korScore;
					score[1] = engScore;
					score[2] = mathScore;
					score[3] = korScore + engScore + mathScore;
					score[4] = score[3]/3;
					//생성된 배열을 2차원 배열에 연결시킨다.
					// for문의 수행문 블록이 실행될 때마다 scores배열의 0번째 1번째 2번재 새로 생성한 배열이 연결(저장된다.
					scores[i] = score;
				}
				System.out.println("### 입력이 완료되었습니다.");
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
