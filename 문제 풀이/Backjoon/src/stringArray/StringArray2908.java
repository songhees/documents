package stringArray;

import java.util.Scanner;

public class StringArray2908 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String first = getReveresNum(scan.next());
		String last = getReveresNum(scan.next());
		
		scan.close();
		
		int firstNum = Integer.parseInt(first);
		int lastNum = Integer.parseInt(last);
		
		int result = firstNum>lastNum ? firstNum : lastNum;
		System.out.println(result);
	}
	public static String getReveresNum(String num) {
		String[] nums = num.split("");
		
		String reverseNum = "";
		for (int i = (nums.length-1); i >= 0; i--) {
			reverseNum += nums[i];
		}
		return reverseNum;
	}
}
