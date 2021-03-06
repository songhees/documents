package example_09_02_for;

// JRE가 제공하는 라이브러리 중에서 java.util 패키지에 포함되어있는 Scanner를 Sample5에서 import 시킨다.
import java.util.Scanner;

public class Sample5 {
	public static void main(String[] args) {
		/*
		 * 숫자를 입력받아서 1부터 그 숫자까지의 합계를 구하기
		 * 
		 * System.in(표준입력장치, 키보드)으로 부터 입력값을 읽어오는 Scanner객체를 생성함
		 */
		Scanner scan = new Scanner(System.in);
		
		//nextInt()는 키보드로 입력된 값을 정수(int타입)로 읽어온다.
		System.out.print("숫자입력: ");
		int number = scan.nextInt();
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			sum += i;
		}
		System.out.println("1 ~ " + number + " 합계: " + sum);
		
		scan.close();
	}
}
