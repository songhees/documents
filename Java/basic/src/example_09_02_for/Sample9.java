package example_09_02_for;

import java.util.Scanner;

public class Sample9 {
	public static void main(String[] args) {
		//숫자 3개를 입력받아서 가장 큰 수를 출력하는 프로그램
		//과제
		Scanner scan = new Scanner(System.in);
		
		int max = 0;
		for (int i = 0; i < 3; i++) {
			System.out.print((i + 1) + "번째 숫자 입력: ");
			int num = scan.nextInt();
	
			if (num > max) {
				max = num;
			}
		}		
		System.out.println("가장 큰 수: " + max);
		scan.close();
	}
}

