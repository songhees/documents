package example_09_02_for;

import java.util.Scanner;

public class Sample13 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("1번째 숫자 입력: ");
		int num1 = scan.nextInt();
		
		System.out.print("2번째 숫자 입력: ");
		int num2 = scan.nextInt();
		int numbersCount = (num2 - num1) + 1;	
		
//		if (num1 > num2) {
//			numbersCount = (num1 - num2) + 1;
//		} else if (num2 > num1) {
//			numbersCount = (num2 - num1) + 1;
//		}
		// 첫번째 숫자가 더 큰 경우.
		if (num1 > num2) {				//두 수의 위치를 교환할 때
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		int median1 = (num1 + num2)/2;
		int median2 = median1 + 1;
		
		if( numbersCount%2 == 0 ) {
			System.out.println("중간값: " + median1 + "\t" + median2);
		} else {
			System.out.println("중간값: " + median1);
		}
		scan.close();
	}
}
