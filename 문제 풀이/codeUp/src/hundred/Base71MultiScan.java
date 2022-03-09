package hundred;

import java.util.Scanner;

public class Base71MultiScan {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력된 값을 연속적으로 처리하기
		int num = scan.nextInt();
		while (num != 0) {
			System.out.println(num);
			num = scan.nextInt();
		}
		scan.close();
	}
}
