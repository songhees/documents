package hundred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  [기초-반복실행구조] 문자 1개 입력받아 알파벳 출력하기
 * @author song
 *
 */
public class Base76 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char al = bf.readLine().charAt(0);
		char a = 'a'-1;
		
		// 엔터키로 값을 나눠서 출력시
		// 계산한 값을 출력하고 싶을 때 %를 사용한다.
		do {
			System.out.printf("%c ", ++a);
		} while (a != al);
	}
}
