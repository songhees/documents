package example_09_02_array;

import java.util.Scanner;

public class Sample6_1 {
	public static void main(String[] args) {
		/*
		 * 학생이름, 국어점수, 영어점수, 수학점수를 입력받아서 배열에 저장하고,
		 * 학생별 총점, 평균을 계산해서 출력하시오.
		 * 출력예) 	김유신	100		100		100		300		100
		 *  		강감찬	80		70		80		230		75
		 */
		
		Scanner scan = new Scanner(System.in);
		
		// 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 배열을 정의하기
		String[] names = new String[5];
		int[] korScores = new int[5];
		int[] engScores = new int[5];
		int[] mathScores =  new int[5];
	
		for (int i = 0; i < names.length; i++) {
			System.out.print("이름입력: ");
			names[i] = scan.next();
			System.out.print("국어성적 입력: ");
			korScores[i] = scan.nextInt();
			System.out.print("영어성적 입력: ");
			engScores[i] = scan.nextInt();
			System.out.print("수학성적 입력: ");
			mathScores[i] = scan.nextInt();
			
		}
		
		for (int i = 0 ; i < names.length ; i ++) {
			String name = names[i];
			int korScore = korScores[i];
			int engScore = engScores[i];
			int mathScore = mathScores[i];
			int totalScore = korScore + engScore + mathScore;
			int average = totalScore/3;
			System.out.println(name + "\t" + korScore + "\t" + engScore + "\t" + mathScore + "\t" + totalScore + "\t" + average);
			
		}
		
		scan.close();
	}
}
