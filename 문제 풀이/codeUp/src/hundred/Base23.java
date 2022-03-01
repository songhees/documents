package hundred;

import java.io.*;

public class Base23 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String number = bf.readLine();
		// .은 정규식에서 모든 문자를 의미하므로 \\.로 사용해야 된다.
		String[] num = number.split("\\.");
		System.out.println(num[0]);
		System.out.println(num[1]);
	}
}
