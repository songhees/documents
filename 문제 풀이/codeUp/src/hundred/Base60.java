package hundred;

import java.util.*;

public class Base60 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		scan.close();
		System.out.println(num1 & num2);
	}
}
