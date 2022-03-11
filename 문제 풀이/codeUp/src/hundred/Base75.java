package hundred;

import java.io.*;

/**
 * [기초-반복실행구조] 정수 1개 입력받아 카운트다운 출력하기2
 * @author song
 *
 */
public class Base75 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		
		do {
			--num;
			System.out.println(num);
		} while (num != 0);
	}
}
