package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base82Hex {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String a = bf.readLine();
		for (int i = 1; i <= 15; i++) {
			int result = Integer.parseInt(a, 16)*i;
			// Intger.toHexString(i) 10Áø¼ö¸¦ 16Áø¼ö·Î ¹Ù²ãÁÜ
			// Integer.parseInt(j, 16) 16Áø¼ö¸¦ 10Áø¼ö·Î ¹Ù²ãÁÜ
			System.out.printf("%s*%s=%s\n", a, Integer.toHexString(i).toUpperCase(), Integer.toHexString(result).toUpperCase());
		}
	}
}
