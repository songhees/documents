package stringArray;

import java.util.Scanner;

public class StringArray04 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		String[] strs = new String[T];
		
		for (int i = 0; i < T; i++) {
			String a = "";
			int R = scan.nextInt();
			String S = scan.next();
			String[] s = S.split("");
			for (int j = 0; j < s.length; j++) {
				a += s[j].repeat(R);
			}
			strs[i] = a;
		}
		
		for (String str : strs) {
			System.out.println(str.toString());
		}
		scan.close();
	}
}

