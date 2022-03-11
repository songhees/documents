package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base80 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int total = 0;
		int result = 0;
		
		for (int i = 1; i<=num; i++) {
			total += i;
			if (total >= num) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
