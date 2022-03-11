package hundred;

import java.io.*;

/**
 * [기초-반복실행구조] 정수 1개 입력받아 그 수까지 출력하기
 * @author song
 *
 */
public class Base77 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int base = -1;
		
		do {
			System.out.println(++base);
		} while (num != base);
	}
}
