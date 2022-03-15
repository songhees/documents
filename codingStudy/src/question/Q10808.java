package question;

import java.io.*;

public class Q10808 {
	public static void main(String[] args) throws IOException {
//		String[] al = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int[] nums = new int[26];
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] target = bf.readLine().split("");
		
//		for (int i=0; i<target.length; i++) {
//			for (int j=0; j<al.length; j++) {
//				if (target[i].equals(al[j])) {
//					nums[j]++;
//				}
//			}
//		}
		
		for (char i='a'; i<='z'; i++) {
			for (int j=0; j<target.length; j++) {
				if (i == target[j].charAt(0)) {
					nums[i-'a']++;
				}
			}
		}

		for (int i=0; i<nums.length; i++) {
			System.out.printf("%d ", nums[i]);
		}
	}
}
