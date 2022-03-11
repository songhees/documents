package hundred;

import java.io.*;
/**
 * [기초-반복실행구조] 정수 1개 입력받아 카운트다운 출력하기1
 * @author song
 *
 */
public class Base74 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		
		while(num != 0) {
			System.out.println(num);
			--num;
		}
	}
}
