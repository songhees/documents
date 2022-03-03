package hundred;

import java.io.*;

public class Base33 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String num = bf.readLine();
		// Integer.parseInt( , 기수(8진수면 8, 16진수면 16진수); 해당 기수값을 설정하면 그 값으로 변환 기본값은 10진수
		System.out.printf("%d", Integer.parseInt(num, 16));
	}
}
