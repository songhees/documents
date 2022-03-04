package hundred;

import java.util.Scanner;

public class Base48 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		System.out.println(n1 << n2);
		// 비트 연산자 n1를 2^n2만큼 값을 늘린다.
		// 3, 1 일때 0011 << 1 이면 0110 => 3*2=6
		// 3, 2 일때 0011 << 2 이면 1100 => 3*4=12
		scan.close();
	}
}
