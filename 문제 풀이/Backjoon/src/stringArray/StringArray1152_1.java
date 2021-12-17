package stringArray;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringArray1152_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		StringTokenizer strs = new StringTokenizer(str, " ");
		System.out.println(strs.countTokens());
	}	
}
