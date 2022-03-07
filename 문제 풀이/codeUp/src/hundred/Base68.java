package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base68 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(bf.readLine());
		
		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 70) {
			System.out.println("B");
		} else if (score >= 40) {
			System.out.println("C");
		} else {
			System.out.println("D");
		}
	}
}
