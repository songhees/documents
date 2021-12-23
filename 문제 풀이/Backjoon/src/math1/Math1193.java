package math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		String result = null;
		
		int x = 0;
		int y = 1;
		while(!(x < num && num <= x+y)) {
			x += y;
			y++;
		}
		int standard = y+1;
		int start = num - x;
		int z = 0;
		
		// Â¦¼ö
		if (y%2 == 0) {
			for (int i=1; i<= start; i++) {
				z++;
				result = z + "/" + (standard-z);
			}
		} else {
			for (int i=1; i<= start; i++) {
				z++;
				result = (standard-z) + "/" + z;
			}
		}
		System.out.println(result);
	}
}