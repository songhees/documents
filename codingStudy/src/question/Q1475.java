package question;

import java.io.*;
import java.util.Arrays;

public class Q1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(bf.readLine());
		int[] nums = new int[9];
		
		while (target != 0) {
			int insert = target%10;
			if (insert == 6 || insert == 9) {
				nums[6]++;
			} else {
				nums[insert]++;
			}
			target/=10;
		}
		nums[6] = (int)Math.ceil(nums[6]/2.0);
		System.out.println(Arrays.stream(nums).max().getAsInt());
	}
}
