package math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Math2839 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		
		List<Integer> nums = new ArrayList<Integer>();
		for (int i=0; i<=k/3; i++) {
			for (int j=0; j<=k/5; j++) {
				if (i*3 + j*5 == k) {
					nums.add(i+j);
				}
			}
		}
		
		int small = k;
		for(int num : nums) {
			if (num != -1 && num <= small) {
				small = num;
			}
		}
		
		if (nums.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(small);
		}
	}
}
