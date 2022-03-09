package hundred;

import java.util.Scanner;

public class Base72 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		while (count != 0) {
			System.out.println(scan.nextInt());
			--count;
		}
		scan.close();
	}
}
