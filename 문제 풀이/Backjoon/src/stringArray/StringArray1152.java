package stringArray;

import java.util.Scanner;

public class StringArray1152 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine().trim();
		String[] strs = str.split(" ");
		
		if (str.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(strs.length);
		}
		scan.close();
	}
}
