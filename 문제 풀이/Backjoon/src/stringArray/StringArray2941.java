package stringArray;

import java.util.Scanner;

public class StringArray2941 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String al = scan.nextLine();
		scan.close();
		
		String[] nums = {"c=", "c-", "dz=", 
				"d-", "lj", "nj", "s=", "z="};
		
		for (String num : nums) {
			al = al.replace(num, "*");
		}
		System.out.println(al.length());
	}
}
