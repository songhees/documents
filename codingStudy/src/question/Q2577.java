package question;

import java.util.Scanner;

public class Q2577 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		int[] nums = new int[10];
		
//		1锅掳 规过
		String[] target = String.valueOf(num1*num2*num3).split("");
		for (String tar : target) {
			nums[Integer.parseInt(tar)]++;
		}

//		2锅掳 规过
//		int d = num1*num2*num3;
//		while (d!=0) {
//			nums[d%10]++;
//			d/=10;
//		}
		
		for (int num : nums) {
			System.out.println(num);
		}
		scan.close();
	}
}
