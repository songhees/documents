package hundred;

import java.util.*;

public class Base65 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		scan.close();
		
		// yes or no의 모든 경우에 나올값이 정해져 있는 경우 사용
		System.out.println(num1%2 == 0? "even" : "odd");
		System.out.println(num2%2 == 0? "even" : "odd");
		System.out.println(num3%2 == 0? "even" : "odd");
	}
}
