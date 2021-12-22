package math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		
		int x = 0;
		int y = 1;
		while (!(6*x+1 < num && num <= 6*(x+y)+1)) {
			x += y;
			y++;
		}
		
		if (num == 1) {
			y = 0;
		}
		System.out.println(y+1);
	}
}
