package hundred;

import java.util.Scanner;

public class Base55 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 3�� ������
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		System.out.println(n1==0 && n2==0 ? 1 : 0);
		scan.close();
	}
}
