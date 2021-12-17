package stringArray;

import java.util.Scanner;

public class StringArray02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = 0;
		
		String input = scan.next();
		String[] nums = input.split("");
		for(String num : nums) {
			total += Integer.parseInt(num);
		}
		System.out.println(total);
		scan.close();
	}
}
