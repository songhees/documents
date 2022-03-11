package hundred;

import java.util.*;

public class Base73 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while(num != 0) {
			System.out.println(num);
			num = scan.nextInt();
		}
		scan.close();
	}
}
