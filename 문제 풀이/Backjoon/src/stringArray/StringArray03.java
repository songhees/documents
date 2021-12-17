package stringArray;

import java.util.Scanner;

public class StringArray03 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		for (int i = 0; i <26; i++) {
			System.out.print(s.indexOf((i+97)) + " ");
		}
		scan.close();
	}
}
