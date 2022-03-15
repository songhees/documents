package question;

import java.util.Scanner;

public class Q3273 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int[] arr = new int[num];
		
		for (int i=0; i<num; i++) {
			arr[i] = scan.nextInt();
		}
		int sum = scan.nextInt();
		int[] nums = new int[sum-1];
		
		int total = 0;
		for (int ar : arr) {
			if (sum <= ar) {
				continue;
			}
			
			if (nums[sum-ar-1] == 0) {
				nums[ar-1]++;
			} else {
				total++;
			}
		}
		System.out.println(total);
		scan.close();
	}
}
