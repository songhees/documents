package hundred;

import java.util.Scanner;

public class Base14 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		char a = scan.next().charAt(0);
		char b = scan.next().charAt(0);
		System.out.printf("%c %c", b, a);
	}
}
