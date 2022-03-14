package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base83 {
	public static void main(String[] args) throws IOException {
		
		// 숫자에 3, 6, 9가 붙어 있으면 X로 표시
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		for (int i=1; i<=num; i++) {
			String no = String.valueOf(i);
			if (no.contains("3")) {
				System.out.print("X ");
			} else if (no.contains("6")) {
				System.out.print("X ");
			} else if (no.contains("9")) {
				System.out.print("X ");
			} else {
				System.out.print(no + " ");
			}
		}
	}
}
